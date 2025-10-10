package com.uptc.frw.aparatoselectronicos.controller;

import com.uptc.frw.aparatoselectronicos.model.Manufacturer;
import com.uptc.frw.aparatoselectronicos.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("manufacturers")
public class ManufacturerController {
    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerService.findAllManufacturers();
    }

    @GetMapping ("/{id}")
    public  Manufacturer getManufacturer(@PathVariable Long id) {
        return manufacturerService.findManufacturerById(id);
    }

    @PostMapping
    public Manufacturer createManufacturer(@RequestBody Manufacturer manufacturer) {
        return manufacturerService.saveManufacturer(manufacturer);
    }

    @PutMapping
    public Manufacturer updateManufacturer(@RequestBody Manufacturer manufacturer) {
        return manufacturerService.updateManufacturer(manufacturer);
    }

    @DeleteMapping ("/{id}")
    public void deleteManufacturer(@PathVariable Long id) {
        manufacturerService.deleteManufacturer(id);
    }
}
