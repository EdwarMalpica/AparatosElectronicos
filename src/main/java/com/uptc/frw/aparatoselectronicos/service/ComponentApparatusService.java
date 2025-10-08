package com.uptc.frw.aparatoselectronicos.service;

/**
 * Servicio para gestionar operaciones CRUD sobre la entidad ComponentApparatus.
 * Proporciona métodos para listar, buscar, guardar, eliminar y actualizar componentes de aparatos.
 */
import com.uptc.frw.aparatoselectronicos.model.ComponentApparatus;
import com.uptc.frw.aparatoselectronicos.model.ComponentApparatusID;
import com.uptc.frw.aparatoselectronicos.repository.ComponentApparatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentApparatusService {
    /**
     * Repositorio para acceder a los datos de ComponentApparatus.
     */
    @Autowired
    private ComponentApparatusRepository componentApparatusRepository;

    /**
     * Obtiene todos los componentes de aparatos.
     * @return lista de ComponentApparatus
     */
    public List<ComponentApparatus> findAllComponentApparatus() {
        return componentApparatusRepository.findAll();
    }

    /**
     * Busca un componente de aparato por su ID compuesto.
     * @param id identificador compuesto del componente
     * @return el ComponentApparatus encontrado o null si no existe
     */
    public ComponentApparatus findComponentApparatusById(ComponentApparatusID id) {
        return componentApparatusRepository.findById(id).orElse(null);
    }

    /**
     * Guarda un nuevo componente de aparato o actualiza uno existente.
     * @param componentApparatus entidad a guardar
     * @return el ComponentApparatus guardado
     */
    public ComponentApparatus saveComponentApparatus(ComponentApparatus componentApparatus) {
        return componentApparatusRepository.save(componentApparatus);
    }

    /**
     * Elimina un componente de aparato por su ID compuesto.
     * @param id identificador compuesto del componente a eliminar
     */
    public void deleteComponentApparatus(ComponentApparatusID id) {
        componentApparatusRepository.deleteById(id);
    }

    /**
     * Actualiza un componente de aparato existente.
     * @param componentApparatus entidad a actualizar
     * @return el ComponentApparatus actualizado
     */
    public ComponentApparatus updateComponentApparatus(ComponentApparatus componentApparatus) {
        return componentApparatusRepository.save(componentApparatus);
    }
}
