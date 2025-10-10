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
}
