
package com.uptc.frw.aparatoselectronicos.controller;

import com.uptc.frw.aparatoselectronicos.model.ComponentChange;
import com.uptc.frw.aparatoselectronicos.model.ComponentChangeID;
import com.uptc.frw.aparatoselectronicos.service.ComponentChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Controlador REST para gestionar operaciones CRUD sobre la entidad ComponentChange.
 * Proporciona endpoints para listar, buscar, crear, actualizar y eliminar cambios de componentes,
 * manejando correctamente el identificador compuesto y devolviendo los códigos HTTP adecuados.
 */
@RestController
@RequestMapping("/componentchange")
public class ComponentChangeController {

    @Autowired
    private ComponentChangeService componentChangeService;

    public ComponentChangeController(ComponentChangeService componentChangeService) {
        this.componentChangeService = componentChangeService;
    }

    /**
     * Obtiene todos los cambios de componentes.
     */
    @GetMapping("/")
    public ResponseEntity<List<ComponentChange>> findAllComponentChange() {
        List<ComponentChange> list = componentChangeService.findAllComponentChange();
        return ResponseEntity.ok(list);
    }

    /**
     * Obtiene un cambio de componente por su ID compuesto.
     */
    @GetMapping("/{componentId}/{repairId}")
    public ResponseEntity<ComponentChange> findComponentChangeById(@PathVariable Long componentId, @PathVariable Long repairId) {
        ComponentChangeID id = new ComponentChangeID(componentId, repairId);
        ComponentChange change = componentChangeService.findComponentChangeById(id);
        if (change == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(change);
    }

    /**
     * Crea un nuevo cambio de componente.
     */
    @PostMapping("/")
    public ResponseEntity<ComponentChange> createComponentChange(@RequestBody ComponentChange componentChange) {
        try {
            if (componentChangeService.findComponentChangeById(componentChange.getId()) != null) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
            ComponentChange created = componentChangeService.saveComponentChange(componentChange);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Actualiza un cambio de componente existente por su ID compuesto.
     */
    @PutMapping("/{componentId}/{repairId}")
    public ResponseEntity<ComponentChange> updateComponentChange(@PathVariable Long componentId, @PathVariable Long repairId, @RequestBody ComponentChange componentChange) {
        ComponentChangeID id = new ComponentChangeID(componentId, repairId);
        ComponentChange existing = componentChangeService.findComponentChangeById(id);
        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        try {
            componentChange.setId(id);
            ComponentChange updated = componentChangeService.updateComponentChange(componentChange);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Elimina un cambio de componente por su ID compuesto.
     */
    @DeleteMapping("/{componentId}/{repairId}")
    public ResponseEntity<Void> deleteComponentChange(@PathVariable Long componentId, @PathVariable Long repairId) {
        ComponentChangeID id = new ComponentChangeID(componentId, repairId);
        ComponentChange existing = componentChangeService.findComponentChangeById(id);
        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        componentChangeService.deleteComponentChange(id);
        return ResponseEntity.noContent().build();
    }
}


