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
public class Cooperative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cooperative")
    private Long id_cooperative;
    @Column(name = "nom")
    private String nom;
    @Column(name = "tele")
    private int tele;
    @Column(name = "address")
    private String address;
    @ManyToOne
    @JoinColumn(name="code", nullable=false)
    private Region region;

    @ManyToMany
    @JoinTable( name = "cooperativeSecterurAsso",
            joinColumns = @JoinColumn( name = "id_cooperative" ),
            inverseJoinColumns = @JoinColumn( name = "id_secteur" ) )
    List<Secteur> secteurList=new ArrayList<>();

    public Long getId_cooperative() {
        return id_cooperative;
    }

    public void setId_cooperative(Long id_cooperative) {
        this.id_cooperative = id_cooperative;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTele() {
        return tele;
    }

    public void setTele(int tele) {
        this.tele = tele;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
