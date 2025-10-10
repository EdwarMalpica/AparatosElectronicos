package com.uptc.frw.aparatoselectronicos.controller;



import com.uptc.frw.aparatoselectronicos.model.ApplianceType;


import com.uptc.frw.aparatoselectronicos.service.ApplianceTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping (path = "appliancetypes")
public class ApplienceTypeController {
    @Autowired
    private ApplianceTypeService appliancetypeService;

    @GetMapping
    public List<ApplianceType> getApplianceTypes() {
        return appliancetypeService.findAllApplianceTypes();
}
}
