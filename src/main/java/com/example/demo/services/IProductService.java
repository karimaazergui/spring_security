package com.example.demo.services;


import com.example.demo.entite.Produit;

import java.util.List;

public interface IProductService {
    public void updateProduct(String nomp,String nomc);
    public List<Produit> findAll();
    public Produit findById(Long id);
    public Produit save(Produit product);
    public Produit upProduct(Long id,Produit product);
    public void deleteById(Long id);
    public void productCat(String nomp,String nomc);
}
