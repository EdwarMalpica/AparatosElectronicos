package com.uptc.frw.aparatoselectronicos.repository;
import com.uptc.frw.aparatoselectronicos.model.Appliance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplianceRepository extends JpaRepository<Appliance, Long> {

}
