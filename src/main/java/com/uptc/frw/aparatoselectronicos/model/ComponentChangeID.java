
package com.uptc.frw.aparatoselectronicos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Clase embebible que representa la clave primaria compuesta para la entidad ComponentChange.
 * Contiene los identificadores de componente y reparación, y es utilizada como id compuesto en la relación débil.
 * Implementa Serializable y los métodos equals y hashCode para garantizar el correcto funcionamiento en JPA.
 */
@Embeddable
public class ComponentChangeID implements Serializable {
    @Column(name = "ID_COMPONENTE")
    private Long componentId;

    @Column(name = "ID_REPARACION")
    private Long repairId;

    public ComponentChangeID() {}

    public ComponentChangeID(Long componentId, Long repairId) {
        this.componentId = componentId;
        this.repairId = repairId;
    }

    public Long getComponentId() {
        return componentId;
    }

    public void setComponentId(Long componentId) {
        this.componentId = componentId;
    }

    public Long getRepairId() {
        return repairId;
    }

    public void setRepairId(Long repairId) {
        this.repairId = repairId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComponentChangeID)) return false;
        ComponentChangeID that = (ComponentChangeID) o;
        return Objects.equals(componentId, that.componentId) && Objects.equals(repairId, that.repairId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(componentId, repairId);
    }
}

