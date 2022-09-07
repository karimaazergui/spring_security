package com.example.demo.services;


import com.example.demo.entite.Category;
import com.example.demo.entite.Produit;
import com.example.demo.repositories.CategorieRepo;
import com.example.demo.repositories.ProduitRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    ProduitRepo productRepository;

    @Autowired
    CategorieRepo categoryRepository;

    @Override
    public void updateProduct(String nomp, String nomc) {

    }

    public List<Produit> findAll(){
        return (List<Produit>) productRepository.findAll();
    }

    public Produit findById(Long id){
        return productRepository.findById(id).get();
    }

    @Override
    public Produit save(Produit product) {
        return productRepository.save(product);
    }

    @Override
    public Produit upProduct(Long id, Produit product) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void productCat(String nomp, String nomc) {

    }

   /* @Override
    public Produit upProduct(Long id, Produit product) {
        Produit pr = productRepository.findById(id).get();
        pr.setPrix(product.getPrix());
        return productRepository.save(pr);
    }



    @Override
    public void productCat(String nomp, String nomc) {
        Produit pr = productRepository.findByName(nomp);
        Category cat = categoryRepository.findByName(nomc);
        pr.setCategory(cat);
        productRepository.save(pr);
    }

    @Override
    public void updateProduct(String nomp, String nomc) {
        Produit product = productRepository.findByName(nomp);
        Category category = categoryRepository.findByName(nomc);
        product.setCategory(category);
        productRepository.save(product);
    }
*/
}
