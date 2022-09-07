package com.example.demo.repositories;


import com.example.demo.entite.Produit;
import com.example.demo.entite.ProduitMatierePremierAsso;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ProduitMatiereAssoRepo extends CrudRepository<ProduitMatierePremierAsso, Long> {
    public Collection<ProduitMatierePremierAsso> findByProduit(Produit produit);

}
