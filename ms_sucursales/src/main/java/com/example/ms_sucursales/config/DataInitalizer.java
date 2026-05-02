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

        Region regionMetropolitana;

        if(regionRepository.count() > 0){

            log.info(">>> ms_sucursales: Tabla regiones no esta vacia. Se omite carga inicial.");
            regionMetropolitana = regionRepository.findById((long)1)
                .orElseThrow(() -> new RuntimeException("Region Metropolitana no encontrada en la base de datos."));
        }else{
            regionMetropolitana = regionRepository.save(new Region(
            null,
            "Metropolitana"
            ));

            log.info("ms_sucursales: {} regiones insertadas.", regionRepository.count());
        }

        Comuna nunoa;
        Comuna providencia;

        if(comunaRepository.count() > 0){
            log.info(">>> ms_sucursales: Tabla comunas no esta vacia. Se omite carga inicial.");
            
            nunoa = comunaRepository.findById((long)1)
                .orElseThrow(() -> new RuntimeException("Comuna Ñuñoa no encontrada en la base de datos."));
            
            providencia = comunaRepository.findById((long)2)
                .orElseThrow(() -> new RuntimeException("Comuna Providencia no encontrada en la base de datos."));

        }else{
            nunoa = comunaRepository.save(new Comuna(
            null,
            "Ñuñoa",
            regionMetropolitana
            ));

            providencia = comunaRepository.save(new Comuna(
            null,
            "Providencia",
            regionMetropolitana
            ));

            log.info("ms_sucursales: {} comunas insertadas.", comunaRepository.count());
        }

        if(sucursalRepository.count() > 0){
            log.info(">>> ms_sucursales: Tabla sucursales no esta vacia. Se omite carga inicial.");
            return;
        }

        log.info(">>> DataInitializer: Base de datos vacia, insertando datos de prueba...");

        

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
