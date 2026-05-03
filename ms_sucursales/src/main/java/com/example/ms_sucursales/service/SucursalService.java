package com.example.ms_sucursales.service;

import java.util.List;
import java.util.Optional;

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

        public Optional<Sucursal> findById(Long id) {
                return repository.findById(id);
        }

        public List<Sucursal> findByComunaId(Long comunaId) {
                return repository.findByComunaId(comunaId);
        }

        public Sucursal findByNombre(String nombre) {
                return repository.findByNombreContainingIgnoreCase(nombre);
        }

        public Sucursal save(Sucursal sucursal) {
                return repository.save(sucursal);
        }

        public void deleteById(Long id) {
                repository.deleteById(id);
        }

}
