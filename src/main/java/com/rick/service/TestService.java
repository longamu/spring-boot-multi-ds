package com.rick.service;


import com.rick.config.datasource.dynamic.TargetDataSource;
import com.rick.dao.TestDao;
import com.rick.entiry.Demo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {

    @Resource
    private TestDao testDao;

    /**
     * 不指定数据源使用默认数据源
     * @return
     */
    public List<Demo> getList(){
        return testDao.getList();
    }

    /**
     * 指定数据源
     * @return
     */
    @TargetDataSource("ds")
    public List<Demo> getListByDs1(){
        return testDao.getListByDs1();
    }

}
