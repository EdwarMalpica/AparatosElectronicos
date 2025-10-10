package com.uptc.frw.aparatoselectronicos.resolver;

import com.uptc.frw.aparatoselectronicos.model.ComponentChange;
import com.uptc.frw.aparatoselectronicos.model.ComponentChangeID;
import com.uptc.frw.aparatoselectronicos.service.ComponentChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Resolver GraphQL para la entidad ComponentChange.
 * Permite realizar operaciones CRUD a través de queries y mutations GraphQL.
 */
@Controller
public class ComponentChangeDataFetcher {

    private static final Logger logger = LoggerFactory.getLogger(ComponentChangeDataFetcher.class);

    @Autowired
    private ComponentChangeService service;

    /**
     * Obtiene un ComponentChange por su ID compuesto.
     */
    @QueryMapping
    public ComponentChange getComponentChangeById(@Argument ComponentChangeID id) {
        ComponentChange result = service.findComponentChangeById(id);
        if (result == null) {
            logger.warn("ComponentChange not found for id: {}", id);
            result = new ComponentChange();
        } else {
            result.setId(id);
        }
        return result;
    }

    /**
     * Obtiene todos los ComponentChanges.
     */
    @QueryMapping
    public List<ComponentChange> getAllComponentChanges() {
        try {
            return service.findAllComponentChange();
        } catch (Exception e) {
            logger.error("Error getting all ComponentChanges: {}", e.getMessage());
            return null;
        }
    }

    /**
     * Crea un nuevo ComponentChange.
     */
    @MutationMapping
    public ComponentChange createComponentChange(@Argument Long componentId, @Argument Long repairId, @Argument int quantity) {
        ComponentChangeID id = new ComponentChangeID(componentId, repairId);
        ComponentChange cc = new ComponentChange();
        
        if (service.findComponentChangeById(id) == null) {
            cc.setId(id);
            cc.setQuantity(quantity);
            return service.saveComponentChange(cc);
        } else {
            logger.error("ComponentChange already exists for id: {}", id);
            return cc;
        }
    }

    /**
     * Actualiza un ComponentChange existente.
     */
    @MutationMapping
    public ComponentChange updateComponentChange(@Argument Long componentId, @Argument Long repairId, @Argument Integer quantity) {
        ComponentChangeID id = new ComponentChangeID(componentId, repairId);
        ComponentChange existing = service.findComponentChangeById(id);
        
        if (existing == null) {
            logger.error("ComponentChange not found for id: {}", id);
            return new ComponentChange();
        }
        
        if (quantity != null) {
            existing.setQuantity(quantity);
        }
        
        return service.updateComponentChange(existing);
    }

    /**
     * Elimina un ComponentChange por su ID compuesto.
     */
    @MutationMapping
    public Boolean deleteComponentChange(@Argument Long componentId, @Argument Long repairId) {
        ComponentChangeID id = new ComponentChangeID(componentId, repairId);
        
        if (service.findComponentChangeById(id) == null) {
            logger.error("ComponentChange not found for id: {}", id);
            return false;
        } else {
            service.deleteComponentChange(id);
            return true;
        }
    }
}
