package com.tour.auth.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.tour.auth.api.DemoApi;
import com.tour.auth.dao.DemoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoApiImpl implements DemoApi {

    @Autowired
    private DemoDAO demoDAO;

    @Override
    public JSONObject getById(String id) {
        return demoDAO.getById(id);
    }
}
