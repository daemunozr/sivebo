package com.example.ms_sucursales.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.ms_sucursales.model.Comuna;
import com.example.ms_sucursales.model.Region;
import com.example.ms_sucursales.model.Sucursal;
import com.example.ms_sucursales.repository.ComunaRepository;
import com.example.ms_sucursales.repository.RegionRepository;
import com.example.ms_sucursales.repository.SucursalRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitalizer implements CommandLineRunner{

    private final SucursalRepository sucursalRepository;
    private final ComunaRepository comunaRepository;
    private final RegionRepository regionRepository;

    @Override
    public void run(String... args){
        if(sucursalRepository.count() > 0){
            log.info(">>> ms_sucursales: Base de datos no esta vacia. Se omite carga inicial.");
            return;
        }

        log.info(">>> DataInitializer: Base de datos vacia, insertando datos de prueba...");

        Region regionMetropolitana = regionRepository.save(new Region(
            null,
            "Metropolitana"
        ));

        Comuna nunoa = comunaRepository.save(new Comuna(
            null,
            "Ñuñoa",
            regionMetropolitana
        ));

        Comuna providencia = comunaRepository.save(new Comuna(
            null,
            "Providencia",
            regionMetropolitana
        ));

        sucursalRepository.save(new Sucursal(
            null,
            "Vicuña Mackenna", 
            nunoa,
            "Av. Vicuña Mackenna 886",
            123456789
        ));

        sucursalRepository.save(new Sucursal(
            null,
            "Providencia",
            providencia,
            "Av. Providencia 2000",
            987654321
        ));

        log.info("ms_sucursales: {} sucursales insertadas.", sucursalRepository.count());
    }
}
