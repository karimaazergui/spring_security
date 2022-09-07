package com.example.demo.entite;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ProduitMatierePremierAsso {
    @EmbeddedId
    ProduitMatierePremierKey id=new ProduitMatierePremierKey();
    @ManyToOne(cascade = {CascadeType.ALL } )
    @JsonIgnore
    @MapsId("idProduit")
    @JoinColumn(name = "reference_produit")
      Produit produit;



    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.ALL } )
    @MapsId("idMatierePremiere")
    @JoinColumn(name = "reference_matiere" )
    MatierePremiere matierePremiere;


    @JsonIgnore
    private int quantite;

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public MatierePremiere getMatierePremiere() {
        return matierePremiere;
    }

    public void setMatierePremiere(MatierePremiere matierePremiere) {
        this.matierePremiere = matierePremiere;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
