package com.aisino.invoice.controller;

import com.aisino.invoice.service.DealDataService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DealDataController {

    @Autowired
    private DealDataService dealDataService;

    @RequestMapping("test")
    public Object get(){
        return this.dealDataService.get();
    }

    @RequestMapping("insertRole")
    public Object insertRole(){
        return this.dealDataService.insertRole();
    }
}
