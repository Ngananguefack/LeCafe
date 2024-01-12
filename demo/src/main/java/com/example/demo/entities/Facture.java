package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Facture")
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int numFacture;

    @ManyToOne
    public Gerant gerant;

    @OneToMany(mappedBy = "facture")
    public List<Commande> commandes;

    public Facture(int numFacture, Gerant gerant, List<Commande> commandes) {
        this.numFacture = numFacture;
        this.gerant = gerant;
        this.commandes = commandes;
    }

    public int getNumFacture() {
        return numFacture;
    }

    public void setNumFacture(int numFacture) {
        this.numFacture = numFacture;
    }

    public Gerant getGerant() {
        return gerant;
    }

    public void setGerant(Gerant gerant) {
        this.gerant = gerant;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    @Override
    public String toString() {
        return "Facture{" +
                "numFacture=" + numFacture +
                ", gerant=" + gerant +
                ", commandes=" + commandes +
                '}';
    }

    public Facture() {
        super();
    }
}
