package com.example.ms_sucursales.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "regiones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Region {

        @Id
        @GeneratedValue
        private Long id;

        @NotBlank(message="Nombre de region es obligatorio")
        @Size(max=20, message="Nombre de region no puede exceder los 20 caracteres")
        @Column(unique=true, length=20, nullable=false)
        private String nombre;  
        
}
