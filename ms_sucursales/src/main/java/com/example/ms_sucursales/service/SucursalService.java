package com.example.ms_sucursales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_sucursales.model.Sucursal;
import com.example.ms_sucursales.repository.SucursalRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SucursalService {

        @Autowired
        private SucursalRepository repository;

        public List<Sucursal> findAll() {
                return repository.findAll();
        }

        public Sucursal findById(Integer id) {
                return repository.findById(id);
        }

        public Sucursal findByNombre(String nombre) {
                return repository.findByNombre(nombre);
        }

        public List<Sucursal> findByIdComuna(Integer id_comuna) {
                return repository.findbyIdComuna(id_comuna);
        }

        public Sucursal save(Sucursal sucursal) {
                return repository.save(sucursal);
        }

        public void deleteById(Long id) {
                repository.deleteById(id);
        }
}
