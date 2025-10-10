package com.uptc.frw.aparatoselectronicos.resolver;

import com.uptc.frw.aparatoselectronicos.model.ComponentApparatus;
import com.uptc.frw.aparatoselectronicos.model.ComponentApparatusID;
import com.uptc.frw.aparatoselectronicos.service.ComponentApparatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Resolver GraphQL para la entidad ComponentApparatus.
 * Permite realizar operaciones CRUD a través de queries y mutations GraphQL.
 */
@Controller
public class ComponentApparatusDataFetcher {

    @Autowired
    private ComponentApparatusService service;

    /**
     * Obtiene un ComponentApparatus por su ID compuesto.
     */
    @QueryMapping
    public ComponentApparatus getComponentApparatusById(@Argument ComponentApparatusID id) {
        System.out.println("[GraphQL] getComponentApparatusById - " + id);
        ComponentApparatus result = service.findComponentApparatusById(id);
        result.setId(id);
        System.out.println("[GraphQL] getComponentApparatusById - result: " + result);
        return result;
    }

    /**
     * Obtiene todos los ComponentApparatus.
     */
    @QueryMapping
    public List<ComponentApparatus> getAllComponentApparatus() {
        return service.findAllComponentApparatus();
    }

    /**
     * Crea un nuevo ComponentApparatus.
     */
    @MutationMapping
    public ComponentApparatus createComponentApparatus(@Argument Long apparatusId,@Argument Long componentId,@Argument int quantity,@Argument double price,@Argument Long manufacturerId) {
        ComponentApparatusID id = new ComponentApparatusID(componentId, apparatusId);
        ComponentApparatus ca = new ComponentApparatus();
        ca.setId(id);
        ca.setQuantity(quantity);
        ca.setPrice(price);
        ca.setManufacturerId(manufacturerId);
        return service.createComponentApparatus(ca);
    }

    /**
     * Actualiza un ComponentApparatus existente.
     */
    @MutationMapping
    public ComponentApparatus updateComponentApparatus(Long apparatusId, Long componentId, Integer quantity, Double price, Long manufacturerId) {
        ComponentApparatusID id = new ComponentApparatusID(componentId, apparatusId);
        return service.updateComponentApparatus(id, quantity, price, manufacturerId);
    }

    /**
     * Elimina un ComponentApparatus por su ID compuesto.
     */
    @MutationMapping
    public void deleteComponentApparatus(Long apparatusId, Long componentId) {
        ComponentApparatusID id = new ComponentApparatusID(componentId, apparatusId);
        service.deleteComponentApparatus(id);
    }

}
