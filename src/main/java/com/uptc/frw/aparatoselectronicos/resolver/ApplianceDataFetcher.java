package com.uptc.frw.aparatoselectronicos.resolver;

import com.uptc.frw.aparatoselectronicos.model.Appliance;
import com.uptc.frw.aparatoselectronicos.service.ApplianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ApplianceDataFetcher {

    @Autowired
    private ApplianceService applianceService;

    @QueryMapping
    public List<Appliance> getAppliances() {
        return applianceService.findAllAppliances();
    }

    @QueryMapping
    public Appliance getApplianceById(@Argument Long id) {
        return applianceService.findApplianceById(id);
    }

    @MutationMapping
    public Appliance createAppliance(@Argument long code, @Argument String description, @Argument long idtype) {
        Appliance appliance = new Appliance();
        appliance.setCode(code);
        appliance.setDescription(description);
        appliance.setIdtype(idtype);
        return applianceService.saveAppliance(appliance);
    }

    @MutationMapping
    public Appliance updateAppliance(@Argument Long id, @Argument long code, @Argument String description, @Argument long idtype) {
        Appliance appliance = new Appliance();
        appliance.setId(id);
        appliance.setCode(code);
        appliance.setDescription(description);
        appliance.setIdtype(idtype);
        return applianceService.updateAppliance(id, appliance);
    }

    @MutationMapping
    public boolean deleteAppliance(@Argument Long id) {
        applianceService.deleteAppliance(id);
        return true;
    }
}
