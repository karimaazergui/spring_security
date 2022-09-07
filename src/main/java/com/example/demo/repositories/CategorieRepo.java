package com.example.demo.repositories;


import com.example.demo.entite.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategorieRepo extends CrudRepository<Category,Long> {
}
