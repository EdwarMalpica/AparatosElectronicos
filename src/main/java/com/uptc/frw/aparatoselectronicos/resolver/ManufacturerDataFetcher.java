package com.uptc.frw.aparatoselectronicos.resolver;

import com.uptc.frw.aparatoselectronicos.model.Manufacturer;
import com.uptc.frw.aparatoselectronicos.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ManufacturerDataFetcher {

    @Autowired
    private ManufacturerService manufacturerService;

    @QueryMapping
    public List<Manufacturer> getManufacturers() {
        return manufacturerService.findAllManufacturers();
    }

    @QueryMapping
    public Manufacturer getManufacturerById(@Argument Long id) {
        return manufacturerService.findManufacturerById(id);
    }

    @MutationMapping
    public Manufacturer createManufacturer(@Argument CreateManufacturerInput input) {
        Manufacturer m = new Manufacturer();
        m.setRif(input.rif);
        m.setTax_domicile(input.tax_domicile);
        return manufacturerService.saveManufacturer(m);
    }

    @MutationMapping
    public Manufacturer updateManufacturer(@Argument UpdateManufacturerInput input) {
        Manufacturer m = new Manufacturer();
        m.setId(input.id);
        m.setRif(input.rif);
        m.setTax_domicile(input.tax_domicile);
        return manufacturerService.updateManufacturer(m);
    }

    @MutationMapping
    public boolean deleteManufacturer(@Argument Long id) {
        manufacturerService.deleteManufacturer(id);
        return true;
    }

    record CreateManufacturerInput(String rif, String tax_domicile) {}
    record UpdateManufacturerInput(Long id, String rif, String tax_domicile) {}
}
