package com.uptc.frw.aparatoselectronicos.service;

import com.uptc.frw.aparatoselectronicos.model.ComponentApparatus;
import com.uptc.frw.aparatoselectronicos.repository.ComponentApparatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentApparatusService {
    @Autowired
    private ComponentApparatusRepository componentApparatusRepository;

    public List<ComponentApparatus> findAllComponentApparatus() {
        return componentApparatusRepository.findAll();
    }
}
