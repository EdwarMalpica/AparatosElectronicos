package com.uptc.frw.aparatoselectronicos.model;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Entidad que representa la relación entre un aparato y un componente.
 * Utiliza un identificador compuesto (ComponentApparatusID) como clave primaria.
 * Incluye información sobre la cantidad, el precio y el fabricante del componente asociado al aparato.
 */
@Entity
@Table(name = "APARATO_COMPONENTE")
public class ComponentApparatus {

    @EmbeddedId
    private ComponentApparatusID id;
    @Column(name = "CANTIDAD")
    private int quantity;
    @Column(name = "PRECIO")
    private double price;

    public ComponentApparatus() {
    }

    public ComponentApparatusID getId() {
        return id;
    }

    public void setId(ComponentApparatusID id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ComponentApparatus{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
