package com.uptc.frw.aparatoselectronicos.resolver;

import com.uptc.frw.aparatoselectronicos.model.ApplianceType;
import com.uptc.frw.aparatoselectronicos.service.ApplianceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ApplianceTypeDataFetcher {

    @Autowired
    private ApplianceTypeService applianceTypeService;

    @QueryMapping
    public List<ApplianceType> getApplianceTypes() {
        return applianceTypeService.findAllApplianceTypes();
    }

    @QueryMapping
    public ApplianceType getApplianceTypeById(@Argument Long id) {
        return applianceTypeService.findApplianceTypeById(id);
    }

    @MutationMapping
    public ApplianceType createApplianceType(@Argument String name, @Argument String characteristics, @Argument Long idtype) {
        ApplianceType applianceType = new ApplianceType();
        applianceType.setName(name);
        applianceType.setCharacteristics(characteristics);
        if (idtype != null) {
            applianceType.setIdtype(idtype);
        }
        return applianceTypeService.saveApplianceType(applianceType);
    }

    @MutationMapping
    public ApplianceType updateApplianceType(@Argument Long id, @Argument String name, @Argument String characteristics, @Argument Long idtype) {
        ApplianceType applianceType = new ApplianceType();
        applianceType.setId(id);
        applianceType.setName(name);
        applianceType.setCharacteristics(characteristics);
        if (idtype != null) {
            applianceType.setIdtype(idtype);
        }
        return applianceTypeService.updateApplianceType(applianceType);
    }

    @MutationMapping
    public boolean deleteApplianceType(@Argument Long id) {
        applianceTypeService.deleteApplianceType(id);
        return true;
    }
}
