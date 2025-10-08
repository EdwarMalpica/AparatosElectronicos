
package com.uptc.frw.aparatoselectronicos.repository;

import com.uptc.frw.aparatoselectronicos.model.ComponentChange;
import com.uptc.frw.aparatoselectronicos.model.ComponentChangeID;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Repositorio JPA para la entidad ComponentChange.
 * Permite realizar operaciones CRUD sobre ComponentChange utilizando como clave primaria el id compuesto (ComponentChangeID).
 * Extiende JpaRepository para aprovechar métodos estándar de acceso a datos.
 */
public interface ComponentChangeRepository extends JpaRepository<ComponentChange, ComponentChangeID> {
}
