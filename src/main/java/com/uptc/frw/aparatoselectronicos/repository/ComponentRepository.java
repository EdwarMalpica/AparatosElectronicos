package com.uptc.frw.aparatoselectronicos.repository;

import com.uptc.frw.aparatoselectronicos.model.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentRepository extends JpaRepository<Component, Long> {}
