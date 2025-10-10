package com.uptc.frw.aparatoselectronicos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "FABRICANTES")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column ( name = "ID_FABRICANTE")
    private Long id;

    @Column ( name = "RIF")
    private String rif;

    @Column ( name = "DOMICILIO_FISCAL")
    private String tax_domicile;

    @JsonIgnore
    @OneToMany(mappedBy = "manufacturer")
    private List<Component> components;

    public Manufacturer() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRif() {
        return rif;
    }

    public void setRif(String rif) {
        this.rif = rif;
    }

    public String getTax_domicile() {
        return tax_domicile;
    }

    public void setTax_domicile(String tax_domicile) {
        this.tax_domicile = tax_domicile;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", rif='" + rif + '\'' +
                ", tax_domicile='" + tax_domicile + '\'' +
                '}';
    }
}
