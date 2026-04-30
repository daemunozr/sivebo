package com.example.ms_sucursales.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "sucursal")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sucursal {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true, length=20, nullable=false)
    private String nombre; 
    
    @Column(unique=true, nullable=false)
    private Integer id_comuna;
    
    @Column(unique=true, nullable=false)
    private String direccion_fisica; 

    @Column(unique=true, nullable=true)
    private Integer telefono_contacto;
}
