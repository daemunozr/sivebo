package com.example.ms_sucursales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_sucursales.model.Region;
import com.example.ms_sucursales.repository.RegionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegionService {

        @Autowired
        private RegionRepository repository;

        public List<Region> findAll() {
                return repository.findAll();
        }

        public Region findById(Integer id) {
                return repository.findById(id);
        }

        public Region findByNombre(String nombre) {
                return repository.findByNombre(nombre);
        }

        public Region save(Region region) {
                return repository.save(region);
        }

        public void deleteById(Long id) {
                repository.deleteById(id);
        }
}
