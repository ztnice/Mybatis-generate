package com.csdn.demo.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.csdn.demo.common.base.service.GenericService;
import com.csdn.demo.common.base.dao.GenericDao;

import com.csdn.demo.sys.entity.Dicts;
import com.csdn.demo.sys.entity.QueryDict;
import com.csdn.demo.sys.dao.DictsDao;

/**
 *@author linzf
 **/
@Service("dictsService")
@Transactional(rollbackFor={IllegalArgumentException.class})
public class DictsService extends GenericService<Dicts, QueryDict> {
	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private DictsDao dictsDao;
	@Override
	protected GenericDao<Dicts, QueryDict> getDao() {
		return dictsDao;
	}
}