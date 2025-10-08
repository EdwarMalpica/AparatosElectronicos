package com.uptc.frw.aparatoselectronicos.repository;

import com.uptc.frw.aparatoselectronicos.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
