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
