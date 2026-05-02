package com.example.ms_sucursales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ms_sucursales.model.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long>{

    Sucursal findById(Integer id);

    List<Sucursal> findByIdComuna(Integer id_comuna);

    Sucursal findByNombre(String nombre);

    /*
    TODO Queries
    */


}
