package com.example.demo.services;


import com.example.demo.entite.MatierePremiere;
import com.example.demo.entite.Produit;
import com.example.demo.entite.ProduitMatierePremierAsso;
import com.example.demo.entite.Region;
import com.example.demo.repositories.MatierePremiereRepo;
import com.example.demo.repositories.ProduitMatiereAssoRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MatierePremiereServiceClass implements MatierePremiereService{

    @Autowired
    MatierePremiereRepo matierePremiereRepo;
    @Autowired
    ProduitMatiereAssoRepo produitMatiereAssoRepo;

    @Override
    public List<Region> getListRegionsParMatierePremiere(Long idmat) {
        List<Region> regionList=new ArrayList<>();
        Optional<MatierePremiere> matierePremiere=matierePremiereRepo.findById(idmat);
        regionList=matierePremiere.get().getRegionList();
        return regionList;
    }

    @Override
    public long saveMatierePremiere(MatierePremiere matierePremiere) {
         matierePremiereRepo.save(matierePremiere);
        return matierePremiere.getReference_matiere();
    }

    @Override
    public List<Produit> getListProduitsParMatierePremiere(Long idmat) {
        List<Produit> produitList=new ArrayList<>();
        List<ProduitMatierePremierAsso> assos = matierePremiereRepo.findById(idmat).get().getProduitMatieresPremierAsso();
        for (ProduitMatierePremierAsso mprd: assos) {
            produitList.add(mprd.getProduit());
        }

        return produitList;
    }

    @Override
    public void updateMatierepremiere(MatierePremiere matierePremiere) {
        matierePremiereRepo.save(matierePremiere);
    }

    @Override
    public void deleteMatierepremiere(Long idmat) {
        matierePremiereRepo.deleteById(idmat);
    }

    @Override
    public Iterable<MatierePremiere> getAllMatierePremiere() {
        return matierePremiereRepo.findAll();
    }

    @Override
    public Optional<MatierePremiere> getMatierePremiere(Long idmat) {
        return matierePremiereRepo.findById(idmat);
    }
}
