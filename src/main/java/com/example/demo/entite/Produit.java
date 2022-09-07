package com.example.demo.entite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reference_produit")
    private Long reference_produit;

    @Column(name="libelle")
    private String libelle;

    @Column(name="prix")
    private double prix;

    @Column(name="description")
    private String description;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "produit",
            cascade = {CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.PERSIST})
    List<ProduitMatierePremierAsso> produitMatieresPremierAsso=new ArrayList<>();

    @ManyToMany
    @JoinTable( name = "produitCategorieAsso",
            joinColumns = @JoinColumn( name = "reference_produit" ),
            inverseJoinColumns = @JoinColumn( name = "id_categorie" ) )
    List<Category> categorieList=new ArrayList<>();


    public Long getReference_produit() {
        return reference_produit;
    }

    public void setReference_produit(Long reference_produit) {
        this.reference_produit = reference_produit;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
