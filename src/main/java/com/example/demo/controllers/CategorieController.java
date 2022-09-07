package com.example.demo.controllers;


import com.example.demo.entite.Category;
import com.example.demo.entite.Produit;
import com.example.demo.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorie")
public class CategorieController {
    @Autowired
    CategorieService categorieService;

    @GetMapping("/{id}")
    public Optional<Category> getCategorie(@PathVariable Long id) {
        return categorieService.getCategorie(id);
    }

    @GetMapping("/all")
    public Iterable<Category> getAllCategorie() {
        return categorieService.getAllCategories();
    }

    @PostMapping("/add")
    public void addCategorie(@RequestBody Category cat) {
        categorieService.addCategorie(cat);
    }

    @GetMapping("/delete/{id}")
    public void deleteCategorie(@PathVariable long id) {
        categorieService.deleteCategorie(id);
    }

    @PostMapping("/update")
    public void updateCategorie(@RequestBody Category cat) {
        categorieService.updateCategorie(cat);
    }

    @GetMapping("/productOfCategorie/{id}")

    public List<Produit> getProduitParCategorie(@PathVariable Long id) {
        return categorieService.getListProduitsParCategorie(id);
    }
}
