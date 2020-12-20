package com.tour.auth.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.tour.auth.api.DemoApi;
import com.tour.auth.dao.DemoDAO;
import com.tour.config.dataSource.Read;
import com.tour.config.dataSource.Write;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoApiImpl implements DemoApi {

    @Autowired
    private DemoDAO demoDAO;

    @Read
    @Override
    public JSONObject getById(String id) {
        return demoDAO.getById(id);
    }

    @Write
    public void insert() {
        demoDAO.insert();
    }
}
