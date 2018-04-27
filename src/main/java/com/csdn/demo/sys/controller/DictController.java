package com.csdn.demo.sys.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csdn.demo.common.base.controller.GenericController;
import com.csdn.demo.common.base.service.GenericService;
import com.csdn.demo.sys.entity.Dict;
import com.csdn.demo.sys.entity.QueryDict;
import com.csdn.demo.sys.service.DictService;

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