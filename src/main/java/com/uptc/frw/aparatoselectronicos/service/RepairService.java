package com.uptc.frw.aparatoselectronicos.service;

import com.uptc.frw.aparatoselectronicos.model.Repair;
import com.uptc.frw.aparatoselectronicos.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairService {

    @Autowired
    private RepairRepository  repairRepository;

    public List<Repair> findAllRepairs () {
        return repairRepository.findAll();
    }

    public Repair findRepairById (Long id) {
        return repairRepository.findById(id).orElse(null);
    }

    public Repair saveRepair (Repair repair) {
        return repairRepository.save(repair);
    }

    public Repair updateRepair (Repair repair) {
        Repair newRepair = findRepairById(repair.getId());
        if(newRepair != null){
            newRepair.setDate(repair.getDate());
            newRepair.setDescription(repair.getDescription());
            newRepair.setClientId(repair.getClientId());
            newRepair.setApparatusId(repair.getApparatusId());
            return repairRepository.save(newRepair);
        }else {
            throw new RuntimeException("No se encontró el registro a editar");
        }
    }

    public void deleteReapir (Long id) {
        repairRepository.deleteById(id);
    }

}
