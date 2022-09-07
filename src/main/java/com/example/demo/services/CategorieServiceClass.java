package com.example.demo.services;



import com.example.demo.entite.Category;
import com.example.demo.entite.Produit;
import com.example.demo.repositories.CategorieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceClass implements CategorieService {

   @Autowired
   CategorieRepo categorieRepo;


   @Override
   public void addCategorie(Category cat, Produit... listProduit) {

      cat.setProduitList(List.of(listProduit));
      categorieRepo.save(cat);

   }

   @Override
   public long saveCategorie(Category cat) {
      categorieRepo.save(cat);
      return  cat.getId_categorie();
   }

   @Override
   public List<Produit> getListProduitsParCategorie(Long idcat) {
       List<Produit> produitList;
      Optional<Category> categorie=categorieRepo.findById(idcat);
      produitList=categorie.get().getProduitList();
      return produitList;
   }

   @Override
   public void updateCategorie(Category cat) {
      categorieRepo.save(cat);
   }

   @Override
   public void deleteCategorie(Long idcat) {
       categorieRepo.deleteById(idcat);
   }

   @Override
   public Iterable<Category> getAllCategories() {
      return categorieRepo.findAll();
   }

   @Override
   public Optional<Category> getCategorie(Long idcat) {
      return categorieRepo.findById(idcat);
   }
}
