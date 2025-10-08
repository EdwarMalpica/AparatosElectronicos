
package com.uptc.frw.aparatoselectronicos.service;

import com.uptc.frw.aparatoselectronicos.model.ComponentChange;
import com.uptc.frw.aparatoselectronicos.model.ComponentChangeID;
import com.uptc.frw.aparatoselectronicos.repository.ComponentChangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Servicio para gestionar operaciones CRUD sobre la entidad ComponentChange.
 * Proporciona métodos para listar, buscar, guardar, eliminar y actualizar cambios de componentes.
 */
@Service
public class ComponentChangeService {
    @Autowired
    private ComponentChangeRepository componentChangeRepository;

    /**
     * Obtiene todos los cambios de componentes.
     * @return lista de ComponentChange
     */
    public List<ComponentChange> findAllComponentChange() {
        return componentChangeRepository.findAll();
    }

    /**
     * Busca un cambio de componente por su ID compuesto.
     * @param id identificador compuesto del cambio
     * @return el ComponentChange encontrado o null si no existe
     */
    public ComponentChange findComponentChangeById(ComponentChangeID id) {
        return componentChangeRepository.findById(id).orElse(null);
    }

    /**
     * Guarda un nuevo cambio de componente.
     * @param componentChange entidad a guardar
     * @return el ComponentChange guardado
     */
    public ComponentChange saveComponentChange(ComponentChange componentChange) {
        return componentChangeRepository.save(componentChange);
    }

    /**
     * Elimina un cambio de componente por su ID compuesto.
     * @param id identificador compuesto del cambio a eliminar
     */
    public void deleteComponentChange(ComponentChangeID id) {
        componentChangeRepository.deleteById(id);
    }

    /**
     * Actualiza un cambio de componente existente.
     * @param componentChange entidad a actualizar
     * @return el ComponentChange actualizado
     */
    public ComponentChange updateComponentChange(ComponentChange componentChange) {
        return componentChangeRepository.save(componentChange);
    }
}

