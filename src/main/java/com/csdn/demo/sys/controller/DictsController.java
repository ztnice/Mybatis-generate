package com.csdn.demo.sys.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import com.csdn.demo.common.base.controller.GenericController;
import com.csdn.demo.common.base.service.GenericService;

import com.csdn.demo.sys.entity.Dicts;
import com.csdn.demo.sys.entity.QueryDict;
import com.csdn.demo.sys.service.DictsService;

/**
 *@author linzf
 **/
@Controller
@RequestMapping("/dicts")
public class DictsController extends GenericController<Dicts, QueryDict> {
	@Inject
	private DictsService dictsService;
	@Override
	protected GenericService<Dicts, QueryDict> getService() {
		return dictsService;
	}
}