package com.example.ms_sucursales.repository;

import javax.swing.plaf.synth.Region;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

    Region findById(Integer id);

    Region findByNombre(String nombre);

    /*
    TODO Queries
    */
        
}
