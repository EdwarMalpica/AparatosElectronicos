package com.uptc.frw.aparatoselectronicos.model;

import jakarta.persistence.*;
@Entity
@Table (name = "TIPO_ELECTRODOMESTICO")
public class ApplianceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID_TIPO", insertable = false, updatable = false)
    private  Long id;
    @Column (name = "NOMBRE")
    private String name;
    @Column (name = "CARACTERISTICAS")
    private String characteristics;

    @Column (name = "ID_TIPO_PADRE")
    private Long idtype;

    public ApplianceType() {
    }

    public ApplianceType(Long id, String name, String characteristics, long idtype) {
        this.id = id;
        this.name = name;
        this.characteristics = characteristics;
        this.idtype = idtype;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public Long getIdtype() {
        return idtype;
    }

    public void setIdtype(Long idtype) {
        this.idtype = idtype;
    }

    @Override
    public String toString() {
        return "ApplianceType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", characteristics='" + characteristics + '\'' +
                ", idtype=" + idtype +
                '}';
    }
}
