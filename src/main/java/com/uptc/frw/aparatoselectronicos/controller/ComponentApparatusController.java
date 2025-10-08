package com.uptc.frw.aparatoselectronicos.controller;

import com.uptc.frw.aparatoselectronicos.model.ComponentApparatus;
import com.uptc.frw.aparatoselectronicos.model.ComponentApparatusID;
import com.uptc.frw.aparatoselectronicos.service.ComponentApparatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar operaciones CRUD sobre la entidad ComponentApparatus.
 * Proporciona endpoints para listar, buscar, crear, actualizar y eliminar componentes de aparatos,
 * manejando correctamente el identificador compuesto y devolviendo los códigos HTTP adecuados.
 */
@RestController
@RequestMapping("/componentapparatus")
public class ComponentApparatusController {

    @Autowired
    private ComponentApparatusService componentApparatusService;

    public ComponentApparatusController(ComponentApparatusService componentApparatusService) {
        this.componentApparatusService = componentApparatusService;
    }

    /**
     * Obtiene todos los componentes de aparatos.
     */
    @GetMapping("/")
    public ResponseEntity<List<ComponentApparatus>> findAllComponentApparatus() {
        List<ComponentApparatus> list = componentApparatusService.findAllComponentApparatus();
        return ResponseEntity.ok(list);
    }

    /**
     * Obtiene un componente de aparato por su ID compuesto.
     */
    @GetMapping("/{apparatusId}/{componentId}")
    public ResponseEntity<ComponentApparatus> findComponentApparatusById(@PathVariable Long apparatusId, @PathVariable Long componentId) {
        ComponentApparatusID id = new ComponentApparatusID(apparatusId, componentId);
        ComponentApparatus component = componentApparatusService.findComponentApparatusById(id);
        if (component == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(component);
    }

    /**
     * Crea un nuevo componente de aparato.
     */
    @PostMapping("/")
    public ResponseEntity<ComponentApparatus> createComponentApparatus(@RequestBody ComponentApparatus componentApparatus) {
        try {
            if (componentApparatusService.findComponentApparatusById(componentApparatus.getId()) != null) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
            ComponentApparatus created = componentApparatusService.saveComponentApparatus(componentApparatus);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Actualiza un componente de aparato existente por su ID compuesto.
     */
    @PutMapping("/{apparatusId}/{componentId}")
    public ResponseEntity<ComponentApparatus> updateComponentApparatus(@PathVariable Long apparatusId, @PathVariable Long componentId, @RequestBody ComponentApparatus componentApparatus) {
        ComponentApparatusID id = new ComponentApparatusID(apparatusId, componentId);
        ComponentApparatus existing = componentApparatusService.findComponentApparatusById(id);
        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        try {
            componentApparatus.setId(id);
            ComponentApparatus updated = componentApparatusService.updateComponentApparatus(componentApparatus);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Elimina un componente de aparato por su ID compuesto.
     */
    @DeleteMapping("/{apparatusId}/{componentId}")
    public ResponseEntity<Void> deleteComponentApparatus(@PathVariable Long apparatusId, @PathVariable Long componentId) {
        ComponentApparatusID id = new ComponentApparatusID(apparatusId, componentId);
        ComponentApparatus existing = componentApparatusService.findComponentApparatusById(id);
        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        componentApparatusService.deleteComponentApparatus(id);
        return ResponseEntity.noContent().build();
    }
}
