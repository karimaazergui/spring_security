package com.example.demo.entite;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    private Long code;
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy="region")
    private Set<Cooperative> listCooperatives;
    @ManyToMany
    @JoinTable( name = "matierePremiereRegionAsso",
            joinColumns = @JoinColumn( name = "code" ),
            inverseJoinColumns = @JoinColumn( name = "reference_matiere" ) )
    List<MatierePremiere> matierePremiereList=new ArrayList<>();

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
