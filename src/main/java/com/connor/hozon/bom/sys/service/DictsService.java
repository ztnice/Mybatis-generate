package com.connor.hozon.bom.sys.service;

import com.connor.hozon.bom.common.base.dao.GenericDao;
import com.connor.hozon.bom.common.base.service.GenericService;
import com.connor.hozon.bom.sys.dao.DictsDao;
import com.connor.hozon.bom.sys.entity.Dicts;
import com.connor.hozon.bom.sys.entity.QueryDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;



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