package com.uptc.frw.aparatoselectronicos.controller;

import com.uptc.frw.aparatoselectronicos.model.Repair;
import com.uptc.frw.aparatoselectronicos.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "repairs")
public class RepairController {

    @Autowired
    private RepairService repairService;

    @GetMapping
    public List<Repair> getRepairs() {
        return repairService.findAllRepairs();
    }

    @GetMapping ("/{id}")
    public  Repair getRepair(@PathVariable Long id) {
        return repairService.findRepairById(id);
    }

    @PostMapping
    public Repair createRepair(@RequestBody Repair repair) {
        return repairService.saveRepair(repair);
    }

    @PutMapping
    public Repair updateRepair(@RequestBody Repair repair) {
        return repairService.updateRepair(repair);
    }

    @DeleteMapping ("/{id}")
    public void deleteRepair(@PathVariable Long id) {
        repairService.deleteReapir(id);
    }
}
