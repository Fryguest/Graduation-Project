package com.wlmiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xinxin.chen on 2018.1.6.
 */
@Controller
public class FrontController {

    @RequestMapping({"/", "/index"})
    public String index() {
        return "index";
    }

}
