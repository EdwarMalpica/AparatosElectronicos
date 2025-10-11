package com.uptc.frw.aparatoselectronicos.service;

import com.uptc.frw.aparatoselectronicos.model.ApplianceType;

import com.uptc.frw.aparatoselectronicos.repository.ApplianceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApplianceTypeService {
    @Autowired
    private ApplianceTypeRepository appliancetypeRepository;

    public List<ApplianceType> findAllApplianceTypes() {
        return appliancetypeRepository.findAll();
    }

    public ApplianceType findApplianceTypeById (Long id) {
        return appliancetypeRepository.findById(id).orElse(null);
    }

    public ApplianceType saveApplianceType (ApplianceType applianceType) {
        return appliancetypeRepository.save(applianceType);
    }

    public ApplianceType updateApplianceType (ApplianceType applianceType) {
        ApplianceType newApplianceType = findApplianceTypeById(applianceType.getId());
        if(newApplianceType != null){
            newApplianceType.setName(applianceType.getName());
            return appliancetypeRepository.save(newApplianceType);
        }else {
            throw new RuntimeException("No se encontró el registro a editar");
        }
    }

    public void deleteApplianceType (Long id) {
        appliancetypeRepository.deleteById(id);
    }
}
