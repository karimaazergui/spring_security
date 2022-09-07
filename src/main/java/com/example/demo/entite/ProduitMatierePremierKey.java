package com.example.demo.entite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ProduitMatierePremierKey implements Serializable {
    @Column(name = "reference_produit")
    Long idProduit;

    @Column(name = "reference_matiere")
    Long idMatierePremiere;
}
