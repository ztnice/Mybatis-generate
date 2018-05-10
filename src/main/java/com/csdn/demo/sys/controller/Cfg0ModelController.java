package com.csdn.demo.sys.controller;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sql.BaseSQLUtil;
import sql.IBaseSQLUtil;
import sql.pojo.cfg.HzCfg0ModelDetail;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Controller
@RequestMapping("/model")
public class Cfg0ModelController {
    IBaseSQLUtil baseSQLUtil;

    @RequestMapping(value = "/saveModelData", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject saveModelData(@RequestBody HzCfg0ModelDetail detail) {
        if (baseSQLUtil == null) {
            baseSQLUtil = new BaseSQLUtil();
        }
        JSONObject result = new JSONObject();
        if (detail == null || (detail.getpModelPuid() == null || "".equals(detail.getpModelPuid()))) {
            result.put("state", false);
            result.put("msg", "没有找到对应的车型模型数据，请重新确认");
            return result;
        }
        HzCfg0ModelDetail fromDBDetail = baseSQLUtil.executeQueryById(detail, "sql.mapper.cfg.i.HzCfg0ModelDetailMapper.selectByModelId");
        StringBuilder sb = new StringBuilder();
        if (fromDBDetail != null) {
            detail.setpModelPuid(fromDBDetail.getpModelPuid());
            detail.setPuid(fromDBDetail.getPuid());
            baseSQLUtil.executeUpdate(detail, "sql.mapper.cfg.i.HzCfg0ModelDetailMapper.update");
            sb.append("更新");
        } else {
            detail.setPuid(UUID.randomUUID().toString());
            baseSQLUtil.executeInsert(detail, "sql.mapper.cfg.i.HzCfg0ModelDetailMapper.insert");
            sb.append("设置");
        }
        result.put("msg", sb + detail.getpModelName() + "信息成功");
        result.put("state", true);
        return result;
    }


    private static void saveModelDetailToDB(@NotNull Cfg0ModelController controller) {
        HzCfg0ModelDetail detail = new HzCfg0ModelDetail();
        detail.setpModelPuid("046adedc-09b2-43ca-a49c-a99d47c9fa3e");
        detail.setpModelName("模型名称");
        detail.setpModelDesc("模型描述");
        detail.setpModelSaleArea("销售的地区");
        detail.setpModelBrand("品牌");
        detail.setpModelVehicle("车辆");
        detail.setpModelPlatform("平台");
        detail.setpModelMod("车型");
        detail.setpModelAnnual("年型");
        detail.setpModelVersion("版型");
        detail.setpModelTransform("变型");
        detail.setpModelDriverPosition("驾驶位置");
        detail.setpModelMembers("成员数");
        detail.setpModelShape("车身外形");
        detail.setpModelAnnouncement("公告");
        detail.setpModelPowers("动力总成");
        detail.setpModelCfgVersion("配置版型");
        detail.setpModelCfgDesc("配置描述");
        detail.setpModelTrailNum("试制号S00-0001-00001");
        detail.setpModelGoodsNum("商品号");
        controller.saveModelData(detail);
        System.out.println();
    }

    @Deprecated
    public static void main(String[] args) {
        Cfg0ModelController controller = new Cfg0ModelController();
        saveModelDetailToDB(controller);
    }
}
