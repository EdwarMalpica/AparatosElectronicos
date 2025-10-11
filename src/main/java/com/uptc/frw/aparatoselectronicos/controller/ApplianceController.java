package com.uptc.frw.aparatoselectronicos.controller;

import com.uptc.frw.aparatoselectronicos.model.Appliance;

import com.uptc.frw.aparatoselectronicos.service.ApplianceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Appliance getApplianceById(@PathVariable Long id) {
        return applianceService.findApplianceById(id);
    }

    @PostMapping
    public Appliance createAppliance(@RequestBody Appliance appliance) {
        return applianceService.saveAppliance(appliance);
    }

    @PutMapping("/{id}")
    public Appliance updateAppliance(@PathVariable long id, @RequestBody Appliance appliance) {
        return applianceService.updateAppliance(id, appliance);
    }

    @DeleteMapping("/{id}")
    public void deleteAppliance(@PathVariable Long id) {
        applianceService.deleteAppliance(id);
    }
}
