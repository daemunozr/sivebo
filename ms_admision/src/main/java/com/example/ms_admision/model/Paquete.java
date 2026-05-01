package com.example.ms_admision.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "paquetes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paquete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descripcion;

    private Double peso; // en kilogramos

    private String dimensiones; // ej: "30x20x15 cm"

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EstadoTracking estado;

    @Column(nullable = false)
    private Long clienteId;
}
