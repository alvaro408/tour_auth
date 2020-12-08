package com.tour.auth.web;

import com.alibaba.fastjson.JSONObject;
import com.tour.auth.api.DemoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController1 {

    @Autowired
    private DemoApi demoApi;

    @RequestMapping("/getById")
    public JSONObject getById(@RequestParam("id") String id) {
        return demoApi.getById(id);
    }

    @RequestMapping(value = "/ok", method = RequestMethod.GET)
    public String test() {
        return "ok";
    }
}
