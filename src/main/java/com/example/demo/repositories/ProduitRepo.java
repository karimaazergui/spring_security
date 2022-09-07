package com.example.demo.repositories;

import com.example.demo.entite.Produit;
import org.springframework.data.repository.CrudRepository;

public interface ProduitRepo extends CrudRepository <Produit,Long> {


}
