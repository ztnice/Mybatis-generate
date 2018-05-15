package com.csdn.demo.common.config.init;


import com.csdn.demo.sys.dao.DictDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/*
 *
 * @auther linzf
 * @create 2017/8/24 0024
 */
@Component
@Order(value = 1)
public class InitDictCache implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(InitDictCache.class);

    @Inject
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private DictDao dictDao;

    @Override
    public void run(String... strings) throws Exception {
        // 初始化数据字典
        //List<Dict> dictList = dictDao.loadAll();
        //DictCache.load(dictList);
        logger.warn("------可以开始了------");
    }
}
