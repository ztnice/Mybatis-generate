package com.connor.hozon.bom.sys.controller;

import javax.inject.Inject;

import com.connor.hozon.bom.common.base.controller.GenericController;
import com.connor.hozon.bom.common.base.service.GenericService;
import com.connor.hozon.bom.sys.entity.Dict;
import com.connor.hozon.bom.sys.entity.QueryDict;
import com.connor.hozon.bom.sys.service.DictService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



import share.bean.RedisBomBean;

/**
 * @author linzf
 **/
@Controller
@RequestMapping("/dict")
public class DictController extends GenericController<Dict, QueryDict> {
	@Inject
	private DictService dictService;

	@Override
	protected GenericService<Dict, QueryDict> getService() {
		return dictService;
	}

	@RequestMapping(value = "/load/loadBomBeans")
	public RedisBomBean loadBomBeans() {
		RedisBomBean bean = new RedisBomBean();
		bean.setHasChildren(true);
		bean.setIndex("1");
		bean.setParentUid("1212");
		bean.setUid("456561");
		return bean;
	}
}