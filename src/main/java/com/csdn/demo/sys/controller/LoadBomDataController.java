package com.csdn.demo.sys.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import share.bean.PreferenceSetting;
import share.bean.RedisBomBean;
import sql.BaseSQLUtil;
import sql.IBaseSQLUtil;
import sql.pojo.HzBomLineRecord;
import sql.pojo.HzPreferenceSetting;
import sql.redis.SerializeUtil;

import java.util.List;

@Controller
@RequestMapping("/loadBom")
public class LoadBomDataController {

    IBaseSQLUtil baseSQLUtil;

    @RequestMapping(value = "/loadByID", method = RequestMethod.GET)
    @ResponseBody
    public JSONArray getLineRecords(@RequestParam String bdf) {
        /*
         * d050cb5e-2f54-4782-92dc-6cf750e0b066
         */
        int appendCount = 5;
        System.out.println("------开始-----");
        if (baseSQLUtil == null) {
            baseSQLUtil = new BaseSQLUtil();
        }
        List<HzBomLineRecord> result = null;
        HzBomLineRecord bomLineRecord = new HzBomLineRecord();
        HzPreferenceSetting setting = new HzPreferenceSetting();
        setting.setSettingName("Hz_ExportBomPreferenceRedis");
        bomLineRecord.setBomDigifaxId(bdf.trim());
        result = baseSQLUtil.executeQuery(bomLineRecord, "sql.mapper.i.HzBomLineRecordMapper.selectByBomDigifaxId");

        System.out.println("----成功----");
        JSONArray array = new JSONArray();
        if (result.size() > 0) {
            HzBomLineRecord hbrForSetting = result.get(0);
            setting.setBomMainRecordPuid(hbrForSetting.getBomDigifaxId());
            setting = baseSQLUtil.executeQueryById(setting,
                    "sql.mapper.i.HzPreferenceSettingMapper.selectSettingByNameWithMainRecord");
            byte[] btOfSetting = setting.getPreferencesettingblock();
            Object objOfSetting = SerializeUtil.unserialize(btOfSetting);
            if (objOfSetting instanceof PreferenceSetting) {
                String[] localName = ((PreferenceSetting) objOfSetting).getPreferenceLocal();
                String[] trueName = ((PreferenceSetting) objOfSetting).getPreferences();
                String[] appendLocalName = new String[localName.length + appendCount];
                String[] appendTrueName = new String[trueName.length + appendCount];

//                appendLocalName[0] = "序号";
//                appendLocalName[1] = "顺序号";
//                appendLocalName[2] = "ID";
//                appendLocalName[3] = "父层ID";
//                appendLocalName[4] = "是否是2Y层";
//
//                appendTrueName[0] = "index";
//                appendTrueName[1] = "on";
//                appendTrueName[2] = "id";
//                appendTrueName[3] = "pid";
//                appendTrueName[4] = "is2Y";
//
//                System.arraycopy(localName, 0, appendLocalName, appendCount, localName.length);
//                System.arraycopy(trueName, 0, appendTrueName, appendCount, trueName.length);
//
//                array.add(0, appendTrueName);
//                array.add(1, appendLocalName);

                array.add(0, trueName);
                array.add(1, localName);
            }
            for (HzBomLineRecord hbr : result) {
                JSONObject object = new JSONObject();
                object.put("index", hbr.getIndex());
                object.put("on", hbr.getOrderNum());
                object.put("id", hbr.getPuid());
                object.put("is2Y", hbr.getIs2Y());
                if (hbr.getIs2Y() == 0) {
                    object.put("pid", hbr.getParentUid());
                }

                byte[] xx = hbr.getBomLineBlock();
                Object obj = SerializeUtil.unserialize(xx);
                if (obj instanceof RedisBomBean) {
                    List<String> pSets = ((RedisBomBean) obj).getpSets();
                    List<String> pValues = ((RedisBomBean) obj).getpValues();
                    if (pSets != null && pSets.size() > 0) {
                        for (int i = 0; i < pSets.size(); i++) {
                            object.put(pSets.get(i), pValues.get(i));
                        }
                    }
                    array.add(object);
                }
            }
        }
        return array;
    }
}
