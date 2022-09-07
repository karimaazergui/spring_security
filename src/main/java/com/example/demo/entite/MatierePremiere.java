package com.example.demo.entite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class MatierePremiere implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reference_matiere")
    private Long reference_matiere;
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "prix")
    private double prix;
    @Column(name = "description")
    private String description;

    @ManyToMany
    @JsonIgnore
    @JoinTable( name = "matierePremiereRegionAsso",
            joinColumns = @JoinColumn( name = "reference_matiere" ),
            inverseJoinColumns = @JoinColumn( name = "code" ) )
    List<Region> regionList=new ArrayList<>();


    @OneToMany(mappedBy = "matierePremiere",cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    List<ProduitMatierePremierAsso> produitMatieresPremierAsso=new ArrayList<>();


    public Long getReference_matiere() {
        return reference_matiere;
    }

    public void setReference_matiere(Long reference_matiere) {
        this.reference_matiere = reference_matiere;
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
