package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idItem;
    public String Item_name;
    public String Description;
    public int Item_cost;
    @Lob()
    @Column(name="image", columnDefinition="BLOB")
    public byte[] image;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Item_Menu",
            joinColumns = {@JoinColumn(name = "idItem")},
            inverseJoinColumns = {@JoinColumn(name = "idMenu")}
    )
    public Set<Menu> menus = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Item_Ingredients",
            joinColumns = {@JoinColumn(name = "idItem")},
            inverseJoinColumns = {@JoinColumn(name = "id")}
    )
    public Set<Ingredients> ingredients = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Item_Accompagnement",
            joinColumns = {@JoinColumn(name = "idItem")},
            inverseJoinColumns = {@JoinColumn(name = "id")}
    )
    public Set<Accompagnement> accompagnements = new HashSet<>();

    @ManyToOne
    public Ligne_Commande ligne_commande;

    public Item(int idItem, String item_name, String description, int item_cost, byte[] image, Set<Menu> menus, Set<Ingredients> ingredients, Set<Accompagnement> accompagnements) {
        this.idItem = idItem;
        Item_name = item_name;
        Description = description;
        Item_cost = item_cost;
        this.image = image;
        this.menus = menus;
        this.ingredients = ingredients;
        this.accompagnements = accompagnements;
    }

    public int getIdItem() {
        return idItem;
    }

    public String getItem_name() {
        return Item_name;
    }

    public void setItem_name(String item_name) {
        Item_name = item_name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getItem_cost() {
        return Item_cost;
    }

    public void setItem_cost(int item_cost) {
        Item_cost = item_cost;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    public Set<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<Accompagnement> getAccompagnements() {
        return accompagnements;
    }

    public void setAccompagnements(Set<Accompagnement> accompagnements) {
        this.accompagnements = accompagnements;
    }

    @Override
    public String toString() {
        return "Item{" +
                "idItem=" + idItem +
                ", Item_name='" + Item_name + '\'' +
                ", Description='" + Description + '\'' +
                ", Item_cost=" + Item_cost +
                ", image=" + Arrays.toString(image) +
                ", menus=" + menus +
                ", ingredients=" + ingredients +
                ", accompagnements=" + accompagnements +
                '}';
    }

    public Item() {
        super();
    }
}
//<form th:object="${ligne_commande}" method="POST" enctype="multipart/form-data" th:action="@{/ligne_commande}" th:each="item:${itemsMenus}">
//<!--          <input type="hidden" th:field="*{itemId}" th:value="${item.idItem}"/>-->
//<p>Nom:<input th:text="${item.Item_name}"/></p>
//<p>Prix:<input th:text="${item.Item_cost}" th:field="*{Prix_unit}" th:value="${item.Item_cost}"></input></p>
//<label >Quantité:</label>
//<input type ="number" class="form-control" th:field="*{nbreItem}"/>
//<button  type ="submit" class="btn btn-primary">Ajouter</button>
//</form>