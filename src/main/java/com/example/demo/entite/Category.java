package com.example.demo.entite;

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
public class Category {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id_categorie")
 private Long id_categorie;
    @Column(name = "libelle")
 private String libelle;


    @ManyToMany
    @JoinTable( name = "produitCategorieAsso",
            joinColumns = @JoinColumn( name = "id_categorie" ),
            inverseJoinColumns = @JoinColumn( name = "reference_produit" ) )
     List<Produit> produitList = new ArrayList<>();


    public Long getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(Long id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
