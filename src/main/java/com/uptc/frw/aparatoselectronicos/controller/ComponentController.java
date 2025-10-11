package com.uptc.frw.aparatoselectronicos.controller;

import com.uptc.frw.aparatoselectronicos.model.Component;
import com.uptc.frw.aparatoselectronicos.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("components")
public class ComponentController {
    @Autowired
    private ComponentService componentService;

    @GetMapping
    public List<Component> getAllComponents() {
        return componentService.findAllComponents();
    }

    @GetMapping ("/{id}")
    public  Component getComponent(@PathVariable Long id) {
        return componentService.findComponentById(id);
    }

    @PostMapping
    public Component createComponent(@RequestBody Component component) {
        return componentService.saveComponent(component);
    }

    @PutMapping()
    public Component updateComponent(@RequestBody Component component) {
        return componentService.updateComponent(component);
    }

    @DeleteMapping ("/{id}")
    public void deleteComponent(@PathVariable Long id) {
        componentService.deleteComponent(id);
    }
}
