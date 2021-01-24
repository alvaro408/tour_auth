package com.tour.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo2")
public class DemoController {

    @Value("${server.port}")
    private String port;


    @RequestMapping(value = "/ok", method = RequestMethod.GET)
    public String test() {
        return "ok2:" + port;
    }
}
