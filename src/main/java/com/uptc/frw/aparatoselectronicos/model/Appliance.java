package com.uptc.frw.aparatoselectronicos.model;
import jakarta.persistence.*;
@Entity
@Table (name = "APARATOS")
public class Appliance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID_APARATO", insertable = false, updatable = false)
    private  Long id;
    @Column (name = "CODE")
    private long code;
    @Column (name = "DESCRIPCION")
    private String description;
    @Column (name = "ID_TIPO")
    private long idtype;

    public Appliance() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getIdtype() {
        return idtype;
    }

    public void setIdtype(long idtype) {
        this.idtype = idtype;
    }

    @Override
    public String toString() {
        return "Appliance{" +
                "id=" + id +
                ", code=" + code +
                ", description='" + description + '\'' +
                ", idtype=" + idtype +
                '}';
    }
}
