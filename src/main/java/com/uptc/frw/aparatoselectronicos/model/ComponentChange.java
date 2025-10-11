
package com.uptc.frw.aparatoselectronicos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

/**
 * Entidad que representa el cambio de un componente en una reparación.
 * Utiliza un identificador compuesto (ComponentChangeID) como clave primaria.
 * Incluye información sobre la cantidad de componentes cambiados.
 */
@Entity
@Table(name = "CAMBIO_COMPONENTE")
public class ComponentChange {

    @EmbeddedId
    private ComponentChangeID id;

    @Column(name = "CANTIDAD")
    private int quantity;

    @JsonIgnore
    @ManyToOne
    @MapsId("componentId")
    @JoinColumn(name = "ID_COMPONENTE")
    private Component component;

    @JsonIgnore
    @ManyToOne
    @MapsId("repairId")
    @JoinColumn(name = "ID_REPARACION")
    private Repair repair;

    public ComponentChange() {}

    public ComponentChangeID getId() {
        return id;
    }

    public void setId(ComponentChangeID id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ComponentChange{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}