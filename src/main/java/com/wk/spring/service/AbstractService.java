package com.wk.spring.service;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import javax.annotation.Resource;

/**
 * PackageName com.wk.spring.service
 * Created by wangkang on 2018/1/15.
 */
public abstract class AbstractService extends SqlSessionDaoSupport{
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

}
