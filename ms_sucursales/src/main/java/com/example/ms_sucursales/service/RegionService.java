package com.example.ms_sucursales.service;

import java.util.List;
import java.util.Optional;

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

        public Optional<Region> findById(Long id) {
                return repository.findById(id);
        }

        public List<Region> findAll() {
                return repository.findAll();
        }

        public Region save(Region region) {
                return repository.save(region);
        }

        public void deleteById(Long id) {
                repository.deleteById(id);
        }

}
