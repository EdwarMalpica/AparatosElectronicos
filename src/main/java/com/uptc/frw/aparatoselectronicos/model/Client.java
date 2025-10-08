package com.uptc.frw.aparatoselectronicos.model;

import jakarta.persistence.*;

@Entity
@Table (name = "CLIENTES")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID_CLIENTE", insertable = false, updatable = false)
    private  Long id;
    @Column (name = "DOCUMENTO")
    private String document;
    @Column (name = "DIRECCION")
    private String address;
    @Column (name = "TELEFONO")
    private String phoneNumber;
    @Column (name = "EMAIL")
    private String email;

    public Client() {
    }

    public Client(Long id, String document, String address, String phoneNumber, String email) {
        this.id = id;
        this.document = document;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", document='" + document + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
