package com.uptc.frw.aparatoselectronicos.resolver;

import com.uptc.frw.aparatoselectronicos.model.Component;
import com.uptc.frw.aparatoselectronicos.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ComponentDataFetcher {

    @Autowired
    private ComponentService componentService;

    @QueryMapping
    public List<Component> getComponents() {
        return componentService.findAllComponents();
    }

    @QueryMapping
    public Component getComponentById(@Argument Long id) {
        return componentService.findComponentById(id);
    }

    @MutationMapping
    public Component createComponent(@Argument CreateComponentInput input) {
        Component c = new Component();
        c.setName(input.name);
        c.setSpecs(input.specs);
        c.setManufacturerId(input.manufacturerId);
        return componentService.saveComponent(c);
    }

    @MutationMapping
    public Component updateComponent(@Argument UpdateComponentInput input) {
        Component c = new Component();
        c.setId(input.id);
        c.setName(input.name);
        c.setSpecs(input.specs);
        if (input.manufacturerId != null) {
            c.setManufacturerId(input.manufacturerId);
        }
        return componentService.updateComponent(c);
    }

    @MutationMapping
    public boolean deleteComponent(@Argument Long id) {
        componentService.deleteComponent(id);
        return true;
    }

    record CreateComponentInput(String name, String specs, Long manufacturerId) {}
    record UpdateComponentInput(Long id, String name, String specs, Long manufacturerId) {}
}
