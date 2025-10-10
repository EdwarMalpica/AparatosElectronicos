package com.uptc.frw.aparatoselectronicos.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table (name = "REPARACIONES")
public class Repair {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column ( name = "ID_REPARACION")
    private Long id;

    @Column ( name = "DESCRIPCION")
    private String description;

    @Column ( name = "FECHA")
    private Date date;

    @Column ( name = "ID_APARATO")
    private Long apparatusId;

    @Column ( name = "ID_CLIENTE", insertable = false, updatable = false)
    private Long clientId;

    @ManyToOne
    @JoinColumn (name = "ID_CLIENTE")
    private Client client;

    public Repair() {
    }

    public Repair(Long id, String description, Date date, Long apparatusId, Client client) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.apparatusId = apparatusId;
        this.client = client;
    }

    public Repair( String description, Date date, Long apparatusId, Client client) {
        this.description = description;
        this.date = date;
        this.apparatusId = apparatusId;
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getApparatusId() {
        return apparatusId;
    }

    public void setApparatusId(Long apparatusId) {
        this.apparatusId = apparatusId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", apparatusId=" + apparatusId +
                ", clientId=" + clientId +
                '}';
    }
}
