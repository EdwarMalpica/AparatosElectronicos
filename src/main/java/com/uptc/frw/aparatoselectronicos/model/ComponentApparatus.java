package com.uptc.frw.aparatoselectronicos.model;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "APARATO_COMPONENTE")
public class ComponentApparatus {

    @EmbeddedId
    private ComponentApparatusID id;
    @Column(name = "CANTIDAD")
    private int quantity;
    @Column(name = "PRECIO")
    private double price;
    @Column(name = "ID_FABRICANTE")
    private long manufacturerId;

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

    public long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    @Override
    public String toString() {
        return "ComponentApparatus{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", manufacturerId=" + manufacturerId +
                '}';
    }
}
