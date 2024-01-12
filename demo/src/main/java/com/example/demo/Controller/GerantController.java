package com.example.demo.Controller;
import com.example.demo.entities.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller


public class GerantController {

    /* -----obtenir la liste de toutes les commandes-----*/
    @Autowired
    private CommandeRepository commandeRepo;

    @GetMapping(path = "/Commande")
    public String commande(Model model) {
        List<Commande> commande = commandeRepo.findAll();
        model.addAttribute("listCommande", commande);
        return "commandelist";
    }

    /* -----obtenir la liste de tous les Serveurs-----*/
    @Autowired
    private ServeurRepository serveurRepo;

    @GetMapping(path = "/serveur")
    public String serveurs(Model model) {
        List<Serveur> serveurs = serveurRepo.findAll();
        model.addAttribute("listServeur", serveurs);
        return "serveurlist";
    }


    /* -----obtenir la liste de tous les Cordon_bleus-----*/
    @Autowired
    private Cordon_bleuRepository cordRepo;

    @GetMapping(path = "/cordons")
    public String cordons(Model model) {
        List<Cordon_bleus> cordons = cordRepo.findAll();
        model.addAttribute("listCordons", cordons);
        return "cordonlist";
    }

    /* -----obtenir la liste de toutes les factures-----*/
    @Autowired
    private FactureRepository factureRepo;

    @GetMapping(path = "/facture")
    public String factures(Model model) {
        List<Facture> factures = factureRepo.findAll();
        model.addAttribute("listFactures", factures);
        return "factureslist";

    }

    /* -----obtenir la liste de toutes les menus-----*/
    @Autowired
    private MenuRepository menuRepo;

    @GetMapping(path = "/Menu")
    public String menus(Model model) {
        List<Menu> menus = menuRepo.findAll();
        model.addAttribute("listMenus", menus);
        return "menulist";

    }

    /* -----obtenir la liste de toutes les items-----*/
    @Autowired
    private ItemRepository itemRepo;

    @GetMapping(path = "/Item")
    public String items(Model model) {
        List<Item> items = itemRepo.findAll();
        itemRepo.flush();
        System.out.println(items);
        model.addAttribute("itemsMenus", items);
        return "items_gerant";
    }

    @GetMapping(path = "/Item{id}")
    public String item1(Integer id, Model model) {
        Optional<Item> item = itemRepo.findById(id);
        model.addAttribute("item", item);
        return "item";
    }

    /* -----obtenir la liste de toutes les ingrefdients-----*/
    @Autowired
    private IngredientRepository ingredientRepo;

    @GetMapping(path = "/Ingredient")
    public String ingredients(Model model) {
        List<Ingredients> ingredients = ingredientRepo.findAll();
        model.addAttribute("ingredientsMenus", ingredients);
        return "listeIngredient";
    }

    /* -----obtenir la liste de toutes les accompagnements-----*/
    @Autowired
    private AccompagnementRepository accompagementRepo;

    @GetMapping(path = "/Accompagnement")
    public String accompagements(Model model) {
        List<Accompagnement> accompagements = accompagementRepo.findAll();
        model.addAttribute("accompagnementlist", accompagements);
        return "accompagementslist";
    }

    //    /* -----Supprimer une commande-----*/
    @GetMapping(path = "/delete")
    public String deletecom(Integer idCommande) {
        commandeRepo.deleteById(idCommande);
        return "redirect:/commandelist";

    }

    /* -----Supprimer un serveur-----*/
    @DeleteMapping(path = "/delet")
    public String delete(Integer id) {
        serveurRepo.deleteById(id);
        return "redirect:/serveur";

    }
//
//    @GetMapping(path="/delet")
//    public String delete(Integer id) {
//        serveurRepo.deleteById(id);
//        return "redirect:/serveur";
//
//    }

    /* -----Supprimer un Cordon_bleu-----*/
    @GetMapping(path = "/dele")
    public String deleteCordon_bleus(Integer id) {
        cordRepo.deleteById(id);
        return "redirect:/cordons";

    }

    /* -----Supprimer un menus-----*/
    @GetMapping(path = "/delete3")
    public String deletemenus(Integer idMenu) {
        menuRepo.deleteById(idMenu);
        return "redirect:/menulist";
    }

    /* -----Supprimer un items-----*/
    @GetMapping(path = "/deleteItem")
    public String deleteItems(Integer id) {
        itemRepo.deleteById(id);
        return "redirect:/items_gerant";
    }

    /* -----Supprimer un ingredient-----*/
    @GetMapping(path = "/delete5")
    public String deleteidingredient(Integer id) {
        ingredientRepo.deleteById(id);
        return "redirect:/ingredientslist";
    }

    /* -----Supprimer un accompagnements-----*/
    @GetMapping(path = "/delete6")
    public String deleteaccompagnements(Integer id) {
        accompagementRepo.deleteById(id);
        return "redirect:/accompagementslist";
    }

    /* -----Supprimer un Menu-----*/
    @GetMapping(path = "/deleteMenu")
    public String deleteMenus(Integer id) {
        menuRepo.deleteById(id);
        return "redirect:/menu_ger";
    }


    @PostMapping("/Menu")
    public String processusAjoutMenu(Menu menu) {
        menuRepo.save(menu);
        return "redirect:/menulist";
    }

    @PostMapping("/Item")
    public String processusAjoutItem(Item item) {
        itemRepo.save(item);
        return "redirect:/itemslist";
    }

    @PostMapping("/Ingredient")
    public String processusAjoutIngredient(Ingredients ingredient) {
        ingredientRepo.save(ingredient);
        return "redirect:/ingredientslist";
    }

    @PostMapping("/Cordon_bleus")
    public String processusAjoutCordon_bleus(Cordon_bleus cordons) {
        cordRepo.save(cordons);
        return "redirect:/cordonlist";
    }

    @PostMapping("/Commande")
    public String processusAjoutCommande(Commande commande) {
        commandeRepo.save(commande);
        Date date = new Date();
        String dateToStr = date.toInstant()
                .atOffset(ZoneOffset.UTC)
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        return "redirect:/commandelist";
    }

    @PostMapping("/Accompagnement")
    public String processusAjoutAccompagnement(Accompagnement accompagnement) {
        accompagementRepo.save(accompagnement);
        return "redirect:/accompagementslist";
    }

    @PostMapping("/Facture")
    public String processusAjoutFacture(Facture facture) {
        factureRepo.save(facture);
        return "redirect:/factureslist";
    }


    /*----------REDIRECTION-----------*/
    @GetMapping(path = "/")
    public String home() {
        return "index";
    }

    @GetMapping(path = "/ajoutServeur")
    public String serveradd() {
        return "redirect:/addServeur";
    }

    @GetMapping(path = "/Itemadd")
    public String itemsadd() {
        return "redirect:/addItem";
    }

    @GetMapping(path = "/ajoutaccompagnement")
    public String accompagnementadd() {
        return "redirect:/addAccompagnement";
    }

    @GetMapping(path = "/ajoutItem")
    public String itemadd() {
        return "redirect:/addItem";
    }

    @GetMapping(path = "/ajoutcommande")
    public String commandeadd() {
        return "redirect:/addCommande";
    }

    @GetMapping(path = "/ajoutcordon")
    public String cordonadd() {
        return "redirect:/addCordon";
    }

    @GetMapping(path = "/ajoutfacture")
    public String facturenadd() {
        return "redirect:/addFacture";
    }

    @GetMapping(path = "/ajoutingredient")
    public String ingredientadd() {
        return "redirect:/addIngredient";
    }

    @GetMapping(path = "/ajoutmenu")
    public String menuadd() {
        return "redirect:/addMenu";
    }

    @GetMapping(path = "/menus")
    public String menulist() {
        return "redirect:/index";
    }

    @GetMapping(path = "/ingredient")
    public String ingredientlist() {
        return "redirect:/listeIngredient";
    }

    @GetMapping(path = "/accueil")
    public String index() {
        return "redirect:/index";
    }

    @GetMapping(path = "/Achat")
    public String Achat() {
        return "redirect:/confirmationAchat";
    }

    @GetMapping(path = "/itemlist")
    public String itemsa(Model model) {
        List<Item> items= itemRepo.findAll();
        model.addAttribute("itemsMenuss", items);
        return "item";
    }

//    @GetMapping(path = "/itemlist")
//    public String itemlist() {
//        return "items";

    @GetMapping(path = "/list")
    public String menu() {
        return "menu";
    }


    @GetMapping(path = "/menu_ger")
    public String menu_ger(Model model) {
        List<Menu> menus = menuRepo.findAll();
        model.addAttribute("menus", menus);
        return "menu_gerant";
    }

    @GetMapping(path = "/item_ger")
    public String item_ger(Model model) {
        List<Item> items = itemRepo.findAll();
        //System.out.println(items);
        model.addAttribute("itemsMenus", items);
        return "items_gerant";
    }

    @GetMapping(path = "/commander")
    public String commander(Model model) {
        List<Item> items = itemRepo.findAll();
        //System.out.println(items);
        model.addAttribute("itemsMenus", items);
        return "commande";
    }

    @GetMapping(path = "/items")
    public String itemss(Model model) {
        List<Item> items= itemRepo.findAll();
        model.addAttribute("itemsMenuss", items);
        return "final_item";
    }

}