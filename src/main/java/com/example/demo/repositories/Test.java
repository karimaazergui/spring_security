package com.example.demo.repositories;

;
import com.example.demo.entite.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Test extends JpaRepository<Region,Long> {
}
