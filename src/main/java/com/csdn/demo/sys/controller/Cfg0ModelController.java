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
            result.put("msg", "û���ҵ���Ӧ�ĳ���ģ�����ݣ�������ȷ��");
            return result;
        }
        HzCfg0ModelDetail fromDBDetail = baseSQLUtil.executeQueryById(detail, "sql.mapper.cfg.i.HzCfg0ModelDetailMapper.selectByModelId");
        StringBuilder sb = new StringBuilder();
        if (fromDBDetail != null) {
            detail.setpModelPuid(fromDBDetail.getpModelPuid());
            detail.setPuid(fromDBDetail.getPuid());
            baseSQLUtil.executeUpdate(detail, "sql.mapper.cfg.i.HzCfg0ModelDetailMapper.update");
            sb.append("����");
        } else {
            detail.setPuid(UUID.randomUUID().toString());
            baseSQLUtil.executeInsert(detail, "sql.mapper.cfg.i.HzCfg0ModelDetailMapper.insert");
            sb.append("����");
        }
        result.put("msg", sb + detail.getpModelName() + "��Ϣ�ɹ�");
        result.put("state", true);
        return result;
    }


    private static void saveModelDetailToDB(@NotNull Cfg0ModelController controller) {
        HzCfg0ModelDetail detail = new HzCfg0ModelDetail();
        detail.setpModelPuid("046adedc-09b2-43ca-a49c-a99d47c9fa3e");
        detail.setpModelName("ģ������");
        detail.setpModelDesc("ģ������");
        detail.setpModelSaleArea("���۵ĵ���");
        detail.setpModelBrand("Ʒ��");
        detail.setpModelVehicle("����");
        detail.setpModelPlatform("ƽ̨");
        detail.setpModelMod("����");
        detail.setpModelAnnual("����");
        detail.setpModelVersion("����");
        detail.setpModelTransform("����");
        detail.setpModelDriverPosition("��ʻλ��");
        detail.setpModelMembers("��Ա��");
        detail.setpModelShape("��������");
        detail.setpModelAnnouncement("����");
        detail.setpModelPowers("�����ܳ�");
        detail.setpModelCfgVersion("���ð���");
        detail.setpModelCfgDesc("��������");
        detail.setpModelTrailNum("���ƺ�S00-0001-00001");
        detail.setpModelGoodsNum("��Ʒ��");
        controller.saveModelData(detail);
        System.out.println();
    }

    @Deprecated
    public static void main(String[] args) {
        Cfg0ModelController controller = new Cfg0ModelController();
        saveModelDetailToDB(controller);
    }
}
