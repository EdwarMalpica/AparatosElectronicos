package com.uptc.frw.aparatoselectronicos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "COMPONENTES")
public class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column ( name = "ID_COMPONENT")
    private Long id;

    @Column ( name = "NOMBRE")
    private String name;

    @Column( name = "ESPECIFICACIONES")
    private String specs;

    public Component() {}

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

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    @Override
    public String toString() {
        return "Component{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specs='" + specs + '\'' +
                '}';
    }
}
