package com.example.ms_sucursales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ms_sucursales.model.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long>{

    Sucursal findByNombreContainingIgnoreCase(String nombre);

    @Query("SELECT sucursal FROM Sucursal sucursal WHERE sucursal.comuna.id = :comunaId")
    List<Sucursal> findByComunaId(@Param("comunaId") Long comunaId);
}
