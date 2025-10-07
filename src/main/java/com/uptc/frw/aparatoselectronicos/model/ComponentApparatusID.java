package com.uptc.frw.aparatoselectronicos.model;

import jakarta.persistence.*;

import java.io.Serializable;
@Embeddable
public class ComponentApparatusID implements Serializable {

    @Column(name = "ID_COMPONENTE")
    private Long componentId;
    @Column(name = "ID_APARATO")
    private Long apparatusId;

    public ComponentApparatusID() {
    }

    public ComponentApparatusID(Long componentId, Long apparatusId) {
        this.componentId = componentId;
        this.apparatusId = apparatusId;
    }

    public Long getComponentId() {
        return componentId;
    }

    public void setComponentId(Long componentId) {
        this.componentId = componentId;
    }

    public Long getApparatusId() {
        return apparatusId;
    }

    public void setApparatusId(Long apparatusId) {
        this.apparatusId = apparatusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComponentApparatusID)) return false;
        ComponentApparatusID that = (ComponentApparatusID) o;
        return componentId.equals(that.componentId) && apparatusId.equals(that.apparatusId);
    }

    @Override
    public int hashCode() {
        return componentId.hashCode() + apparatusId.hashCode();
    }
}
