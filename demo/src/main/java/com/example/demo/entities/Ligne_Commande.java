package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Ligne_commande")
public class Ligne_Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idLigne_Commande;
    public String nameItem;
    public int nbreItem;
    public int Prix_unit;

    @OneToMany(mappedBy = "ligne_commande")
    public List<Item> items;

    @OneToMany(mappedBy = "ligne_commandes")
    public List<Commande> commandes;

    @ManyToMany(mappedBy = "ligne_commandes")
    public Set<Panier> paniers= new HashSet<>();

    public Ligne_Commande(int idLigne_Commande, String nameItem, int nbreItem, int prix_unit, List<Item> items, List<Commande> commandes, Set<Panier> paniers) {
        this.idLigne_Commande = idLigne_Commande;
        this.nameItem = nameItem;
        this.nbreItem = nbreItem;
        this.Prix_unit = prix_unit;
        this.items = items;
        this.commandes = commandes;
        this.paniers = paniers;
    }

    public Ligne_Commande(String nameItem, int nbreItem, int prix_unit) {
    }

    public void setIdLigne_Commande(int idLigne_Commande) {
        this.idLigne_Commande = idLigne_Commande;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public int getNbreItem() {
        return nbreItem;
    }

    public void setNbreItem(int nbreItem) {
        this.nbreItem = nbreItem;
    }

    public int getPrix_unit() {
        return Prix_unit;
    }

    public void setPrix_unit(int prix_unit) {
        Prix_unit = prix_unit;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public Set<Panier> getPaniers() {
        return paniers;
    }

    public void setPaniers(Set<Panier> paniers) {
        this.paniers = paniers;
    }

    @Override
    public String toString() {
        return "Ligne_Commande{" +
                "idLigne_Commande=" + idLigne_Commande +
                ", nameItem='" + nameItem + '\'' +
                ", nbreItem=" + nbreItem +
                ", Prix_unit=" + Prix_unit +
                ", items=" + items +
                ", commandes=" + commandes +
                ", paniers=" + paniers +
                '}';
    }

    public Ligne_Commande() {
        super();
    }
}