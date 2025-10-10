package com.uptc.frw.aparatoselectronicos.model;

import jakarta.persistence.*;

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

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", rif='" + rif + '\'' +
                ", tax_domicile='" + tax_domicile + '\'' +
                '}';
    }
}
