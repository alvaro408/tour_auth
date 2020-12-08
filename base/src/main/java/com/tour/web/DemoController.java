package com.tour.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo11")
public class DemoController {


    @RequestMapping(value = "/ok", method = RequestMethod.GET)
    public String test() {
        return "ok";
    }
}
