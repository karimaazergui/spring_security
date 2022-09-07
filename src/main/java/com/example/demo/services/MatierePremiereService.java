package com.example.demo.services;

import com.example.demo.entite.MatierePremiere;
import com.example.demo.entite.Produit;
import com.example.demo.entite.Region;

import java.util.List;
import java.util.Optional;

public interface MatierePremiereService {
    List<Region> getListRegionsParMatierePremiere(Long idmat);

    long saveMatierePremiere(MatierePremiere matierePremiere);

    List<Produit> getListProduitsParMatierePremiere(Long idmat);

    void updateMatierepremiere(MatierePremiere matierePremiere);

    void deleteMatierepremiere(Long idmat);

    Iterable<MatierePremiere> getAllMatierePremiere();

    Optional<MatierePremiere> getMatierePremiere(Long idmat);
}
