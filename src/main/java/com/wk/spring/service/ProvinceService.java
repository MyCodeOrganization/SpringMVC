package com.wk.spring.service;

import com.wk.spring.entity.ProvinceEntity;
import com.wk.spring.repository.ProvinceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:
 * @Description：
 * @Date: Created in :10/12/2017 6:53 PM
 * @Modified by:
 */
@Service
public class ProvinceService {
    @Autowired
    private ProvinceMapper provinceMapper;
    public ProvinceEntity getEntityById(long id){
        return provinceMapper.selectByPrimaryKey(id);
    }

    public void insert(ProvinceEntity entity){
        provinceMapper.insert(entity);
    }

    public int getCount(){
        return provinceMapper.getCount();
    }



}
