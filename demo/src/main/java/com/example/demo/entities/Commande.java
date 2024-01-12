package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idCommande;
    public String dateCommande;
    public String heureCommande;
    public  String statut;

    @ManyToOne
    public Cordon_bleus cordon_bleus;

    @ManyToOne
    public Gerant gerant;

    @ManyToOne
    public Serveur serveur;

    @ManyToOne
    public Facture facture;

    @ManyToOne
    public Ligne_Commande ligne_commandes;

    public Commande() {
        super();
    }

    @Override
    public String toString() {
        return "Commande{" +
                "idCommande=" + idCommande +
                ", dateCommande='" + dateCommande + '\'' +
                ", heureCommande='" + heureCommande + '\'' +
                ", statut='" + statut + '\'' +
                ", cordon_bleus=" + cordon_bleus +
                ", gerant=" + gerant +
                ", serveur=" + serveur +
                ", facture=" + facture +
                ", ligne_commandes=" + ligne_commandes +
                '}';
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getHeureCommande() {
        return heureCommande;
    }

    public void setHeureCommande(String heureCommande) {
        this.heureCommande = heureCommande;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Cordon_bleus getCordon_bleus() {
        return cordon_bleus;
    }

    public void setCordon_bleus(Cordon_bleus cordon_bleus) {
        this.cordon_bleus = cordon_bleus;
    }

    public Gerant getGerant() {
        return gerant;
    }

    public void setGerant(Gerant gerant) {
        this.gerant = gerant;
    }

    public Serveur getServeur() {
        return serveur;
    }

    public void setServeur(Serveur serveur) {
        this.serveur = serveur;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Ligne_Commande getLigne_commandes() {
        return ligne_commandes;
    }

    public void setLigne_commandes(Ligne_Commande ligne_commandes) {
        this.ligne_commandes = ligne_commandes;
    }

    public Commande(int idCommande, String dateCommande, String heureCommande, String statut, Cordon_bleus cordon_bleus, Gerant gerant, Serveur serveur, Facture facture, Ligne_Commande ligne_commandes) {
        this.idCommande = idCommande;
        this.dateCommande = dateCommande;
        this.heureCommande = heureCommande;
        this.statut = statut;
        this.cordon_bleus = cordon_bleus;
        this.gerant = gerant;
        this.serveur = serveur;
        this.facture = facture;
        this.ligne_commandes = ligne_commandes;
    }
}
