package com.uptc.frw.aparatoselectronicos.controller;

import com.uptc.frw.aparatoselectronicos.model.Appliance;

import com.uptc.frw.aparatoselectronicos.service.ApplianceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping (path = "appliances")
public class ApplianceController {
    @Autowired
    private ApplianceService applianceService;

    @GetMapping
    public List<Appliance> getAppliances() {
        return applianceService.findAllAppliances();

}
}
