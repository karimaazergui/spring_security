package com.example.demo.repositories;


import com.example.demo.entite.Region;
import org.springframework.data.repository.CrudRepository;

public interface RegionRepo extends CrudRepository<Region,Long> {
}
