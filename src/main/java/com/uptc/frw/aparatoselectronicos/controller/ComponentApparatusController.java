package com.uptc.frw.aparatoselectronicos.controller;

import com.uptc.frw.aparatoselectronicos.model.ComponentApparatus;
import com.uptc.frw.aparatoselectronicos.service.ComponentApparatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/componentapparatus")
public class ComponentApparatusController {
    @Autowired
    private ComponentApparatusService componentApparatusService;

    public ComponentApparatusController(ComponentApparatusService componentApparatusService) {
        this.componentApparatusService = componentApparatusService;
    }

    @GetMapping("/")
    public List<ComponentApparatus> findAllComponentApparatus() {
        return componentApparatusService.findAllComponentApparatus();
    }
}
