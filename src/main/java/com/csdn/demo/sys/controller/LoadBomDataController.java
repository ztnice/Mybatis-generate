package com.csdn.demo.sys.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csdn.demo.common.base.controller.GenericController;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import sql.BaseSQLUtil;
import sql.IBaseSQLUtil;
import sql.pojo.HzBomLineRecord;

@Controller
@RequestMapping("/loadBom")
public class LoadBomDataController {

	IBaseSQLUtil baseSQLUtil;

	@RequestMapping(value = "/loadByID", method = RequestMethod.GET)
	@ResponseBody
	public String getLineRecords(@RequestParam String bdf) {
		
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
		if (result.size() == 0)
			return "---";
		for (HzBomLineRecord hbr : result) {
			array.add(hbr.getIndex());
		}
		return "bom";
	}

	@RequestMapping(value = "/loadByID2", method = RequestMethod.GET)
	//是返回值，否则会返回一个网页
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

	public static void main(String[] args) {
		LoadBomDataController bomDataController = new LoadBomDataController();
		HzBomLineRecord bomLineRecord = new HzBomLineRecord();
		bomLineRecord.setBomDigifaxId("d050cb5e-2f54-4782-92dc-6cf750e0b066");
		// List<HzBomLineRecord> result =
		// bomDataController.getLineRecords(/*bomLineRecord.getBomDigifaxId()*/);
		// for (HzBomLineRecord hzBomLineRecord : result) {
		// System.out.println(hzBomLineRecord.getIndex());
		// }
	}
}
