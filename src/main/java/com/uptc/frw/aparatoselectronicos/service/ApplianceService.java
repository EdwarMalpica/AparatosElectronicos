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

}
