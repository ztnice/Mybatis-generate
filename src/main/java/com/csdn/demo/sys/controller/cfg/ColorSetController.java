package com.csdn.demo.sys.controller.cfg;


import com.csdn.demo.sys.commen.Error;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    @RequestMapping(value = "/queryAll2", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> queryAll2() {
        if (baseSQLUtil == null) {
            baseSQLUtil = new BaseSQLUtil();
        }
        Map<String, Object> result = new HashMap<>();
        List<HzCfg0ColorSet> colorSet = baseSQLUtil.executeQuery(new HzCfg0ColorSet(), "sql.mapper.cfg.i.HzCfg0ColorSetMapper.selectAll");
        result.put("totalCount", colorSet.size());
        result.put("result", colorSet);
        return result;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(HzCfg0ColorSet entity, Model model) {
        entity = baseSQLUtil.executeQueryById(entity, "sql.mapper.cfg.i.HzCfg0ColorSetMapper.selectByPrimaryKey");
        if (entity == null) {
            Error error = new Error();
            error.setMsg("没有找到相关的颜色，请联系系统管理员");
            model.addAttribute("entity", error);
            return "error";
        } else {
            model.addAttribute("entity", entity);
            return "cfg/color/colorUpdate";
        }
    }

    @RequestMapping(value = "/addPage", method = RequestMethod.GET)
    public String addPage() {
        return "cfg/color/addColor";
    }

    @RequestMapping(value = "/updateWithEntity", method = RequestMethod.POST)
    @ResponseBody
    public String update(@RequestBody HzCfg0ColorSet set) {
        int result = baseSQLUtil.executeUpdate(set, "sql.mapper.cfg.i.HzCfg0ColorSetMapper.updateByPrimaryKey");
        if (result == 1)
            return "ok";
        else return "fail";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String add(@RequestBody HzCfg0ColorSet set) {
        int result = 0;
        if (set.getPuid() == null || "".equals(set.getPuid())) {
            set.setPuid(UUID.randomUUID().toString());
        }
        //查重插入
        while (true) {
            HzCfg0ColorSet entity = baseSQLUtil.executeQueryById(set, "sql.mapper.cfg.i.HzCfg0ColorSetMapper.selectByPrimaryKey");
            if (entity == null) {
                result = baseSQLUtil.executeUpdate(set, "sql.mapper.cfg.i.HzCfg0ColorSetMapper.insert");
                break;
            } else {
                set.setPuid(UUID.randomUUID().toString());
            }
        }
        if (result == 1)
            return "ok";
        else return "fail";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@RequestBody List<HzCfg0ColorSet> set) {
        int result = 0;
        if (result == 1)
            return "ok";
        else return "fail";
    }

    public static void main(String[] args) {
        ColorSetController controller = new ColorSetController();
        controller.queryAll();
    }
}
