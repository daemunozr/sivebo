package com.example.ms_sucursales.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "sucursales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sucursal {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Nombre de sucursal es obligatorio")
    @Size(max=20, message="Nombre de sucursal no puede exceder los 20 caracteres")
    @Column(unique=true, length=20, nullable=false)
    private String nombre; 
    
    @NotNull(message="Id de comuna es obligatorio")
    @ManyToOne
    @JoinColumn(name="id_comuna", nullable=false)
    private Comuna comuna;
    
    @NotBlank(message="Direccion fisica es obligatoria")
    @Column(unique=true, nullable=false)
    private String direccionFisica; 

    @NotNull(message="Telefono de contacto es obligatorio")
    @Size(min=9, max=9, message="Telefono de contacto debe tener 9 digitos")
    @Column(unique=true, precision=9, nullable=true)
    private Integer telefonoContacto;
}
