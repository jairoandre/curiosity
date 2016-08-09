package com.fountainledge.curiosity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fountainledge.curiosity.model.MarsReport;
import com.fountainledge.curiosity.service.CuriosityService;

@RestController
public class MarsStatusController {
    
    @Autowired
    CuriosityService curiosityService;

    @RequestMapping("/api/mars/report")
    @CrossOrigin
    public MarsReport getMarsReport() {
        return curiosityService.getLatestMarsReport();
    }

}