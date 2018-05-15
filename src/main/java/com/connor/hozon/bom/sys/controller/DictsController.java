package com.connor.hozon.bom.sys.controller;

import javax.inject.Inject;

import com.connor.hozon.bom.common.base.controller.GenericController;
import com.connor.hozon.bom.common.base.service.GenericService;
import com.connor.hozon.bom.sys.entity.Dicts;
import com.connor.hozon.bom.sys.entity.QueryDict;
import com.connor.hozon.bom.sys.service.DictsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


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