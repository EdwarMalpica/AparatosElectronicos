
package com.uptc.frw.aparatoselectronicos.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

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