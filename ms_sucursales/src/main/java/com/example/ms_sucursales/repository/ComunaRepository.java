package com.example.ms_sucursales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ms_sucursales.model.Comuna;

@Repository
public interface  ComunaRepository extends JpaRepository<Comuna, Long> {

    Comuna findById(Integer id);

    Comuna findByNombre(String nombre);

    List<Comuna> findByIdRegion(Integer id_region);

    /*
    TODO Queries
    */
        
}
