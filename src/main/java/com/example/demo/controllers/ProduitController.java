package com.example.demo.controllers;


import com.example.demo.entite.MatierePremiere;
import com.example.demo.entite.Produit;
import com.example.demo.entite.ProduitMatierePremierAsso;
import com.example.demo.repositories.ProduitMatiereAssoRepo;
import com.example.demo.repositories.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produit")
public class ProduitController {
    @Autowired
    ProduitRepo produitRepo;

    @Autowired
    ProduitMatiereAssoRepo assoRepo;

    @GetMapping("/{id}")

    public Optional<Produit> getproduit(@PathVariable Long id ){
        return produitRepo.findById(id);
    }

    @GetMapping("/all")
    public Iterable<Produit> getAllProduit(){
        return produitRepo.findAll();
    }

    @PostMapping("/add")

    public void addProduit(@RequestBody Produit produit){
        produitRepo.save( produit);
    }

    @GetMapping("/delete/{id}")
    public void deleteProduit(@PathVariable long id){

        //produitRepo.deleteAllById(Collections.singleton(id));

        produitRepo.deleteById(id);
    }

    @PostMapping ("/update")
    public void updateProduit(@RequestBody Produit produit){
        produitRepo.save(produit);
    }

    @GetMapping("/{id}/mp")
    public List<MatierePremiere> getMP(@PathVariable long id){
        //return assoRepo.findByProduit(produitRepo.findById(id).get());
        List<ProduitMatierePremierAsso> assos = produitRepo.findById(id).get().getProduitMatieresPremierAsso();
        //return asso.getMatierePremiere();
        List<MatierePremiere> matierePremieres = new ArrayList<>();
        for (ProduitMatierePremierAsso mpa: assos) {
            matierePremieres.add(mpa.getMatierePremiere());
        }

        return matierePremieres;
    }
}
