package com.example.demo.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Panier")
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idPanier;

    public String nom_item;

    public int price;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Panier_lignecommande",
            joinColumns = {@JoinColumn(name = "idPanier")},
            inverseJoinColumns = {@JoinColumn(name = "idLigne_Commande")}
    )
    public Set<Ligne_Commande> ligne_commandes=new HashSet<>();

    public Panier(int idPanier, String nom_item, int price, Set<Ligne_Commande> ligne_commandes) {
        this.idPanier = idPanier;
        this.nom_item = nom_item;
        this.price = price;
        this.ligne_commandes = ligne_commandes;
    }


    public void setIdPanier(int idPanier) {
        this.idPanier = idPanier;
    }

    public String getNom_item() {
        return nom_item;
    }

    public void setNom_item(String nom_item) {
        this.nom_item = nom_item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Set<Ligne_Commande> getLigne_commandes() {
        return ligne_commandes;
    }

    public void setLigne_commandes(Set<Ligne_Commande> ligne_commandes) {
        this.ligne_commandes = ligne_commandes;
    }

    @Override
    public String toString() {
        return "Panier{" +
                "idPanier=" + idPanier +
                ", nom_item='" + nom_item + '\'' +
                ", price=" + price +
                ", ligne_commandes=" + ligne_commandes +
                '}';
    }

    public Panier() {
        super();
    }
}
