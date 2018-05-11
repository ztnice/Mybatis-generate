package com.csdn.demo.sys.controller.cfg;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sql.BaseSQLUtil;
import sql.IBaseSQLUtil;
import sql.pojo.cfg.HzCfg0ColorSet;

import java.util.List;

@Controller
@RequestMapping("/colorSet")
public class ColorSetController {
    IBaseSQLUtil baseSQLUtil;

    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    @ResponseBody
    public JSONArray queryAll() {
        if (baseSQLUtil == null) {
            baseSQLUtil = new BaseSQLUtil();
        }
        JSONArray result = new JSONArray();
        String[] orgName = new String[]{"colorOfSet", "colorName", "colorCode", "comment", "hide"};
        String[] localName = new String[]{"色系", "颜色名称", "颜色代码", "备注", "hide"};
        result.add(0, orgName);
        result.add(1, localName);

        List<HzCfg0ColorSet> colorSet = baseSQLUtil.executeQuery(new HzCfg0ColorSet(), "sql.mapper.cfg.i.HzCfg0ColorSetMapper.selectAll");

        colorSet.forEach((set) -> {
            JSONObject object = new JSONObject();
            object.put(orgName[0], set.getpColorOfSet());
            object.put(orgName[1], set.getpColorName());
            object.put(orgName[2], set.getpColorCode());
            object.put(orgName[3], set.getpColorComment());
            object.put("hide", set.getPuid());
            result.add(object);
        });
        return result;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(Model model) {
        HzCfg0ColorSet set = new HzCfg0ColorSet();
        set.setPuid("puid");
        set.setpColorCode("颜色代号");
        set.setpColorName("颜色名称");
        set.setpColorOfSet("色系");
        set.setpColorComment("备注");
        model.addAttribute("entity", set);
        return "cfg/color/colorUpdate";
    }

    @RequestMapping(value = "/updateWithEntity", method = RequestMethod.POST)
    @ResponseBody
    public String update(@RequestBody HzCfg0ColorSet set) {
        System.out.println(set.getPuid());
        return "ok";
    }

    public static void main(String[] args) {
        ColorSetController controller = new ColorSetController();
        controller.queryAll();
    }
}
