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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Resolver GraphQL para la entidad ComponentApparatus.
 * Permite realizar operaciones CRUD a través de queries y mutations GraphQL.
 */
@Controller
public class ComponentApparatusDataFetcher {

    private static final Logger logger = LoggerFactory.getLogger(ComponentApparatusDataFetcher.class);

    @Autowired
    private ComponentApparatusService service;

    /**
     * Obtiene un ComponentApparatus por su ID compuesto.
     */
    @QueryMapping
    public ComponentApparatus getComponentApparatusById(@Argument ComponentApparatusID id) {
        ComponentApparatus result = service.findComponentApparatusById(id);
        if (result == null) {
            logger.warn("ComponentApparatus not found for id: {}", id);
            result = new ComponentApparatus();
        }else {
            result.setId(id);
        }
        return result;
    }

    /**
     * Obtiene todos los ComponentApparatus.
     */
    @QueryMapping
    public List<ComponentApparatus> getAllComponentApparatus() {
        try {
            return service.findAllComponentApparatus();
        } catch (Exception e) {
            logger.error("Error getting all ComponentApparatus: {}", e.getMessage());
            return null;
        }
    }

    /**
     * Crea un nuevo ComponentApparatus.
     */
    @MutationMapping
    public ComponentApparatus createComponentApparatus(@Argument Long apparatusId,@Argument Long componentId,@Argument int quantity,@Argument double price) {
        ComponentApparatusID id = new ComponentApparatusID(componentId, apparatusId);
        ComponentApparatus ca = new ComponentApparatus();
        if (service.getComponentApparatusById(id) == null) {
            ca.setId(id);
            ca.setQuantity(quantity);
            ca.setPrice(price);
        }else {
            logger.error("ComponentApparatus already exists for id: {}", id);
        }
        return service.createComponentApparatus(ca);
    }

    /**
     * Actualiza un ComponentApparatus existente.
     */
    @MutationMapping
    public ComponentApparatus updateComponentApparatus(@Argument Long apparatusId,@Argument Long componentId,@Argument Integer quantity,@Argument Double price) {
            ComponentApparatusID id = new ComponentApparatusID(componentId, apparatusId);
            if (service.getComponentApparatusById(id) == null) {
                logger.error("ComponentApparatus not found for id: {}", id);
                return new ComponentApparatus();
            }
            return service.updateComponentApparatus(id, quantity, price);
    }

    /**
     * Elimina un ComponentApparatus por su ID compuesto.
     */
    @MutationMapping
    public Boolean deleteComponentApparatus(@Argument Long apparatusId,@Argument Long componentId) {
            ComponentApparatusID id = new ComponentApparatusID(componentId, apparatusId);
            if (service.getComponentApparatusById(id) == null) {
                logger.error("ComponentApparatus not found for id: {}", id);
            } else {
                service.deleteComponentApparatus(id);
                return true;
            }
            return false;
    }

}
