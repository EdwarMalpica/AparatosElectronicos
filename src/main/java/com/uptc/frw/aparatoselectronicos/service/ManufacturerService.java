package com.uptc.frw.aparatoselectronicos.service;

import com.uptc.frw.aparatoselectronicos.model.Manufacturer;
import com.uptc.frw.aparatoselectronicos.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> findAllManufacturers(){ return manufacturerRepository.findAll(); }

    public Manufacturer findManufacturerById(long id){ return  manufacturerRepository.findById(id).orElse(null); }

    public Manufacturer saveManufacturer(Manufacturer manufacturer){ return manufacturerRepository.save(manufacturer); }

    public Manufacturer updateManufacturer(Manufacturer manufacturer){
        Manufacturer manufacturerToUpdate = findManufacturerById(manufacturer.getId());
        if(manufacturerToUpdate == null) throw new RuntimeException("Registro no encontrado");

        manufacturerToUpdate.setRif(manufacturer.getRif());
        manufacturerToUpdate.setTax_domicile(manufacturer.getTax_domicile());
        return saveManufacturer(manufacturerToUpdate);
    }

    public void deleteManufacturer(long id){ manufacturerRepository.deleteById(id);}
}
