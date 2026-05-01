package com.example.ms_sucursales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ms_sucursales.model.Sucursal;
import com.example.ms_sucursales.service.SucursalService;



@RestController
@RequestMapping("/api/v1/sucursales")
public class SucursalController {

        @Autowired
        private SucursalService service;

        @GetMapping
        public ResponseEntity<List<Sucursal>> listar() {
                List<Sucursal> sucursales = service.findAll();
                if(sucursales.isEmpty()) {
                        return ResponseEntity.noContent().build();
                }
                return ResponseEntity.ok(sucursales);
        }
        
        
}
