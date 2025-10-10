package com.uptc.frw.aparatoselectronicos.service;

import com.uptc.frw.aparatoselectronicos.model.Component;
import com.uptc.frw.aparatoselectronicos.model.Manufacturer;
import com.uptc.frw.aparatoselectronicos.repository.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentService {
    @Autowired
    ComponentRepository componentRepository;

    @Autowired
    ManufacturerService manufacturerService;

    public List<Component> findAllComponents() { return componentRepository.findAll(); }

    public Component findComponentById(long id){ return componentRepository.findById(id).orElse(null); }

    public Component saveComponent(Component component){
        Manufacturer manufacturer = manufacturerService.findManufacturerById(component.getManufacturerId());
        component.setManufacturer(manufacturer);
        return componentRepository.save(component);}

    public Component updateComponent(Component component){
        Component componentToUpdate = findComponentById(component.getId());
        if(componentToUpdate == null) throw new RuntimeException("Registro no encontrado");

        componentToUpdate.setName(component.getName());
        componentToUpdate.setSpecs(component.getSpecs());
        return saveComponent(componentToUpdate);
    }

    public void deleteComponent(long id){ componentRepository.deleteById(id); }
}
