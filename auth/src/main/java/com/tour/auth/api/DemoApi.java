package com.tour.auth.api;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface DemoApi {

    public JSONObject getById(String id);

}
