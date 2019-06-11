package com.aisino.invoice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类描述：
 *
 * @Auther: hbHao
 * @ClassName OcxController
 * @Date: 2019-05-13 09:06
 * @Version 1.0
 */
@Controller
@RequestMapping("ocx")
public class OcxController {

    @RequestMapping("demo")
    public String demo(){



        return "ocx/demo.html";
    }


    @RequestMapping("toOcxPage")
    public String toOcxPage(){



        return "ocx/toOcx.html";
    }

    @RequestMapping("test")
    public String test(){


        return "ocx/test.html";
    }
}
