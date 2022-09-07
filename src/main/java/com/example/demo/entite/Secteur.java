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
public class Secteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_secteur")
    private Long id_secteur;
    @Column(name = "libelle")
    private  String libelle;

    @ManyToMany
    @JoinTable( name = "cooperativeSecterurAsso",
            joinColumns = @JoinColumn( name = "id_secteur" ),
            inverseJoinColumns = @JoinColumn( name = "id_cooperative" ) )
    List<Cooperative> cooperativeList=new ArrayList<>();

    public Long getId_secteur() {
        return id_secteur;
    }

    public void setId_secteur(Long id_secteur) {
        this.id_secteur = id_secteur;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
