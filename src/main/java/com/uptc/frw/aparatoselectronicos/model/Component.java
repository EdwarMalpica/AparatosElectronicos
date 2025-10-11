package com.uptc.frw.aparatoselectronicos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

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

    @Column(name = "ID_FABRICANTE", insertable = false, updatable = false)
    private long manufacturerId;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "ID_FABRICANTE")
    private Manufacturer manufacturer;

    @OneToMany(mappedBy = "component")
    @JsonIgnore
    private List<ComponentChange> componentChanges;


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

    public long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public List<ComponentChange> getComponentChanges() {
        return componentChanges;
    }

    public void setComponentChanges(List<ComponentChange> componentChanges) {
        this.componentChanges = componentChanges;
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
