package com.uptc.frw.aparatoselectronicos.repository;

import com.uptc.frw.aparatoselectronicos.model.ComponentApparatus;
import com.uptc.frw.aparatoselectronicos.model.ComponentApparatusID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio JPA para la entidad ComponentApparatus.
 * Permite realizar operaciones CRUD sobre ComponentApparatus utilizando como clave primaria el id compuesto (ComponentApparatusID).
 * Extiende JpaRepository para aprovechar métodos estándar de acceso a datos.
 */

public interface ComponentApparatusRepository extends JpaRepository<ComponentApparatus, ComponentApparatusID> {
}
