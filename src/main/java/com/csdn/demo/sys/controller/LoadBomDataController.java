package com.csdn.demo.sys.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import share.bean.PreferenceSetting;
import share.bean.RedisBomBean;
import sql.BaseSQLUtil;
import sql.IBaseSQLUtil;
import sql.pojo.HzBomLineRecord;
import sql.pojo.HzPreferenceSetting;
import sql.redis.SerializeUtil;

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
                array.add(0, trueName);
                array.add(1, localName);
            }
            for (HzBomLineRecord hbr : result) {
                JSONObject object = new JSONObject();
                object.put("index", hbr.getIndex());
                object.put("on", hbr.getOrderNum());
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

    @RequestMapping(value = "/loadByID2", method = RequestMethod.GET)
    // 是返回值，否则会返回一个网页
    @ResponseBody
    public JSONObject getLineRecord_2(@RequestParam String bdf) {
        System.out.println("------开始-----");
        if (baseSQLUtil == null) {
            baseSQLUtil = new BaseSQLUtil();
        }
        List<HzBomLineRecord> result = null;
        HzBomLineRecord bomLineRecord = new HzBomLineRecord();
        bomLineRecord.setBomDigifaxId(bdf.trim()/* "d050cb5e-2f54-4782-92dc-6cf750e0b066" */);
        result = baseSQLUtil.executeQuery(bomLineRecord, "sql.mapper.i.HzBomLineRecordMapper.selectByBomDigifaxId");
        System.out.println("----成功----");
        JSONArray array = new JSONArray();
        // if (result.size() == 0) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key", "map");
        return jsonObject;
        // }
        // for (HzBomLineRecord hbr : result) {
        // array.add(hbr.getIndex());
        // }
        // return null;
    }

    @RequestMapping(value = "/loadByID3", method = RequestMethod.GET)
    // 是返回值，否则会返回一个网页
    public String getLineRecord_3() {
        System.out.println("------开始-----");
        return "treegrid";
    }

    // 是返回值，否则会返回一个网页
    @RequestMapping(value = "/loadByID4", method = RequestMethod.GET)
    @ResponseBody
    public JSONArray getLineRecord_4() {
        System.out.println("----loadByID4开始-----");
        JSONObject result = new JSONObject();
        JSONArray array = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 1);
        jsonObject.put("pid", 0);
        jsonObject.put("name", "系统管理");
        jsonObject.put("referred", "管理");
        array.add(jsonObject);
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("id", 2);
        jsonObject2.put("pid", 0);
        jsonObject2.put("name", "字典管理");
        jsonObject2.put("referred", "字典");
        array.add(jsonObject2);
        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("id", 20);
        jsonObject3.put("pid", 1);
        jsonObject3.put("name", "新增系统");
        jsonObject3.put("referred", "新增");
        array.add(jsonObject3);
        JSONObject jsonObject4 = new JSONObject();
        jsonObject4.put("id", 21);
        jsonObject4.put("pid", 1);
        jsonObject4.put("name", "编辑系统");
        jsonObject4.put("referred", "编辑");
        array.add(jsonObject4);
        JSONObject jsonObject5 = new JSONObject();
        jsonObject5.put("id", 22);
        jsonObject5.put("pid", 1);
        jsonObject5.put("name", "删除系统");
        jsonObject5.put("referred", "删除");
        array.add(jsonObject5);

        JSONObject jsonObject6 = new JSONObject();
        jsonObject6.put("id", 33);
        jsonObject6.put("pid", 2);
        jsonObject6.put("name", "系统环境");
        jsonObject6.put("referred", "环境");
        array.add(jsonObject6);
        JSONObject jsonObject7 = new JSONObject();
        jsonObject7.put("id", 333);
        jsonObject7.put("pid", 33);
        jsonObject7.put("name", "新增环境");
        jsonObject7.put("referred", "新增");
        array.add(jsonObject7);
        JSONObject jsonObject8 = new JSONObject();
        jsonObject8.put("id", 3333);
        jsonObject8.put("pid", 33);
        jsonObject8.put("name", "编辑环境");
        jsonObject8.put("referred", "编辑");
        array.add(jsonObject8);
        JSONObject jsonObject9 = new JSONObject();
        jsonObject9.put("id", 233332);
        jsonObject9.put("pid", 33);
        jsonObject9.put("name", "删除环境");
        jsonObject9.put("referred", "删除");
        array.add(jsonObject9);
        System.out.println("----loadByID4结束-----");
        result.put("rows", array);
        return array;
    }

//	public static void main(String[] args) {
//		LoadBomDataController bomDataController = new LoadBomDataController();
//		HzBomLineRecord bomLineRecord = new HzBomLineRecord();
//		bomLineRecord.setBomDigifaxId("d050cb5e-2f54-4782-92dc-6cf750e0b066");
//		// List<HzBomLineRecord> result =
//		// bomDataController.getLineRecords(/*bomLineRecord.getBomDigifaxId()*/);
//		// for (HzBomLineRecord hzBomLineRecord : result) {
//		// System.out.println(hzBomLineRecord.getIndex());
//		// }
//	}
}
