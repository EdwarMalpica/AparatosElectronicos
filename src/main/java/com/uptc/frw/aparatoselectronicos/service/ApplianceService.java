package com.uptc.frw.aparatoselectronicos.service;
import com.uptc.frw.aparatoselectronicos.model.Appliance;
import com.uptc.frw.aparatoselectronicos.repository.ApplianceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApplianceService {
    @Autowired
    private ApplianceRepository applianceRepository;

    public List<Appliance> findAllAppliances() {
        return applianceRepository.findAll();
    }

    public Appliance findApplianceById(Long id) {
        return applianceRepository.findById(id).orElse(null);
    }

    public Appliance saveAppliance(Appliance appliance) {
        return applianceRepository.save(appliance);
    }

    public Appliance updateAppliance(long id, Appliance appliance) {
        Appliance existingAppliance = findApplianceById(id);
        if (existingAppliance != null) {
            existingAppliance.setCode(appliance.getCode());
            existingAppliance.setDescription(appliance.getDescription());
            existingAppliance.setIdtype(appliance.getIdtype());
            return applianceRepository.save(existingAppliance);
        } else {
            throw new RuntimeException("No se encontró el registro a editar");
        }
    }

    public void deleteAppliance(Long id) {
        applianceRepository.deleteById(id);
    }

}
