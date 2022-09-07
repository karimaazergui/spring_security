package com.example.demo.services;

import com.example.demo.entite.Category;
import com.example.demo.entite.Produit;

import java.util.List;
import java.util.Optional;

public interface CategorieService {
    void addCategorie(Category cat, Produit... listProduit);

    long saveCategorie(Category cat);

    List<Produit> getListProduitsParCategorie(Long idcat);

    void updateCategorie(Category cat);

    void deleteCategorie(Long idcat);

    Iterable<Category> getAllCategories();

    Optional<Category> getCategorie(Long idcat);
}
