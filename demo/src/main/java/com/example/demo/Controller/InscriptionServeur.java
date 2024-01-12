package com.example.demo.Controller;

import com.example.demo.entities.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
public class InscriptionServeur {
    //
    @Autowired
    public ServeurRepository serveurRepository;

    @GetMapping(path = "/addServeur")
    public String newServeur(Model model) {
        model.addAttribute("serveur", new Serveur());
        return "addServeur";
    }

    @PostMapping(path = "/serveur")
    public String addServeur(@ModelAttribute("addServeur") @Validated Serveur serveur, BindingResult result)
            throws IOException {
        serveurRepository.save(serveur);
        return "redirect:/serveur";
    }

    @GetMapping(path = "/addItems")
    public String newItems(Model model) {
        model.addAttribute("item", new Item());
        return "ajoutItems";
    }

    @PostMapping(path = "/items")
    public String addItems(@ModelAttribute("addItem") @Validated Item item, BindingResult result)
            throws IOException {
        itemRepo.save(item);
        return "redirect:/item_ger";
    }


    @GetMapping(path = "/contact")
    public String newServeurs(Model models) {
        models.addAttribute("serveur", new Serveur());
        return "contact";
    }

    @PostMapping(path = "/contact")
    public String addServeusr(@ModelAttribute("addServeur") @Validated Serveur serveur, BindingResult result)
            throws IOException {
        serveurRepository.save(serveur);
        return "redirect:/serveur";
    }
    @Autowired
    public IngredientRepository ingredientRepo;
    @Autowired
    public ItemRepository itemRepo;
    @Autowired
    public Ligne_CommandeRepository ligne_commandeRepository;

    @GetMapping(path = "/comm")
    public String newcomm(Model model) {
        List<Item> items= itemRepo.findAll();
        List<Ingredients> ingredients = ingredientRepo.findAll();
        model.addAttribute("ingredientsMenus", ingredients);
        model.addAttribute("itemsMenus", items);
        model.addAttribute("ligne_commande", new Ligne_Commande());
        return "commande";
    }

        @PostMapping(path = "/ligne_commande")
    public String addligne_commande(@ModelAttribute("ligne_commande") @Validated Ligne_Commande ligne_commande, BindingResult result, @RequestParam("idItem") int idItem, @RequestParam("quantite") int quantite)
    {
        System.out.println(" L'identifiant de l'item est "+idItem);
        Optional<Item> item= itemRepo.findById(idItem);
        ligne_commande.setNameItem(item.get().getItem_name());
        ligne_commande.setPrix_unit(item.get().getItem_cost());
        ligne_commande.setNbreItem(quantite);
        ligne_commandeRepository.save(ligne_commande);
        return "/menu";
    }

//    @PostMapping(path = "/ligne_commande")
//    public String addligne_commande(@ModelAttribute("ligne_commande") @Validated Ligne_Commande ligne_commande, BindingResult result,
//                                    @RequestParam("idItem") int idItem,
//                                    @RequestParam("quantite") int quantite,
//                                    @RequestParam("prix") int prix)
//    {
//        System.out.println(" L'identifiant de l'item est "+idItem);
//        Optional<Item> item= itemRepo.findById(idItem);
//        prix=item.get().getItem_cost()*quantite;
//        ligne_commande.setNameItem(item.get().getItem_name());
//        ligne_commande.setPrix_unit(prix);
//        ligne_commande.setNbreItem(quantite);
//        ligne_commandeRepository.save(ligne_commande);
//        return "/menu";
//    }

    @Autowired
    public PanierRepository panierRepository;
    @GetMapping(path = "/panier")
    public String panier(Model model) {
        List<Ligne_Commande> ligne_commandes= ligne_commandeRepository.findAll();
        model.addAttribute("ligne_commande", ligne_commandes);
        model.addAttribute("panier", new Panier());
        model.addAttribute("commande", new Commande());
        int total=calculTotal(ligne_commandes);
        model.addAttribute("total", total);
        return "panier";
    }
    private int calculTotal(List<Ligne_Commande> ligne_commandes){
        int total=0;
        for (Ligne_Commande ligneCommandes: ligne_commandes){
            total+=ligneCommandes.getPrix_unit()*ligneCommandes.getNbreItem();
        }
        return total;
    }
    @PostMapping(path = "/panier")
    public String addPanier(@ModelAttribute("panier") @Validated Panier panier, BindingResult result)
    {

        return "/menu";
    }

    @GetMapping(path = "/addItem")
    public String newItem(Model model) {
        model.addAttribute("item", new Item());
        return "addItem";
    }

    @PostMapping(path = "/addItem")
    public String addItem(@ModelAttribute Item item,
                          @RequestParam("name") String name,
                          @RequestParam("description") String description,
                          @RequestParam("cout") int cout){

        item.setItem_name(name);
        item.setDescription(description);
        item.setItem_cost(cout);
        itemRepo.save(item);
        return "redirect:/item_ger";
    }

//    @GetMapping(path = "/commande")
//    public String newcommande(Model model) {
//        model.addAttribute("ligne_commande", new Ligne_Commande());
//        return "/final_item";
//    }
//    @PostMapping(path = "/commande")
//    public String addcommande(@ModelAttribute("ligne_commande") @Validated Ligne_Commande ligne_commande, BindingResult result, @RequestParam("idItem") int idItem, @RequestParam("quantite") int quantite)
//    {
//        System.out.println(" L'identifiant de l'item est "+idItem);
//        Optional<Item> item= itemRepo.findById(idItem);
//        ligne_commande.setNameItem(item.get().getItem_name());
//        ligne_commande.setPrix_unit(item.get().getItem_cost());
//        quantite=1;
//        ligne_commande.setNbreItem(quantite);
//        ligne_commandeRepository.save(ligne_commande);
//        System.out.println("Votre commande a été enregistré avec succès");
//        return "/menu";
//    }
//
//
//   @GetMapping(path = "/comm")
//    public String newcomm(@RequestParam("idItem") int idItem, Model model) {
//        Optional<Item> item=itemRepo.findById(idItem);
//        model.addAttribute("itemsMenus", item);
//        model.addAttribute("ligne_commande", new Ligne_Commande());
//        return "commande";
//    }
//
//    @PostMapping(path = "/ligne_commande")
//    public String addligne_commande(@ModelAttribute("ligne_commande") @Validated Ligne_Commande ligne_commande, BindingResult result, @RequestParam("idItem") int idItem, @RequestParam("quantite") int quantite)
//    {
//        System.out.println(" L'identifiant de l'item est "+idItem);
//        Optional<Item> item= itemRepo.findById(idItem);
//        ligne_commande.setNameItem(item.get().getItem_name());
//        ligne_commande.setPrix_unit(item.get().getItem_cost());
//        ligne_commande.setNbreItem(quantite);
//        ligne_commandeRepository.save(ligne_commande);
//        return "/menu";
//    }

//    @PostMapping(path = "/panier")
//    public String addpanier(@ModelAttribute("panier") @Validated Panier panier, BindingResult result, @RequestParam("idLigne_Commande") int idLigne_Commande, @RequestParam("price") int price)
//    {
//        System.out.println(" L'identifiant de l'item est "+idLigne_Commande);
//        Optional<Ligne_Commande> ligne_commande= ligne_commandeRepository.findById(idLigne_Commande);
//        ligne_commande.setNameItem(item.get().getItem_name());
//        ligne_commande.setPrix_unit(item.get().getItem_cost());
//        ligne_commande.setNbreItem(quantite);
//        p.save(ligne_commande);
//        return "/menu";
//    }

}