package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Gerant")
public class Gerant {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public int id_user;

    public String username;

    public String Email;

    public String Adress;

    public int tel;


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Gerant_Menu",
            joinColumns = {@JoinColumn(name = "id_user")},
            inverseJoinColumns = {@JoinColumn(name = "idMenu")}
    )
    public Set<Menu> menus = new HashSet<>();

    @OneToMany(mappedBy = "gerant")
    public List<Commande> commandes;


    @OneToMany(mappedBy = "gerant")
    public List<Facture> factures;

    public Gerant(int id_user, String username, String email, String adress, int tel, Set<Menu> menus, List<Commande> commandes, List<Facture> factures) {
        this.id_user = id_user;
        this.username = username;
        Email = email;
        Adress = adress;
        this.tel = tel;
        this.menus = menus;
        this.commandes = commandes;
        this.factures = factures;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public List<Facture> getFactures() {
        return factures;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }

    @Override
    public String toString() {
        return "Gerant{" +
                "id_user=" + id_user +
                ", username='" + username + '\'' +
                ", Email='" + Email + '\'' +
                ", Adress='" + Adress + '\'' +
                ", tel=" + tel +
                ", menus=" + menus +
                ", commandes=" + commandes +
                ", factures=" + factures +
                '}';
    }

    public Gerant() {
        super();
    }
}
