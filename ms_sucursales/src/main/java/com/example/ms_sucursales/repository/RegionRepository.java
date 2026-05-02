package com.example.ms_sucursales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ms_sucursales.model.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

    Region findById(Integer id);

    Region findByNombre(String nombre);

    /*
    TODO Queries
    */
        
}
