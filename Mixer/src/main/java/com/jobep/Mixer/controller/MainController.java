/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobep.Mixer.controller;

import com.jobep.Mixer.models.Drink;
import com.jobep.Mixer.service.ServiceLayer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author powel
 */
@Controller
public class MainController {
    
    @Autowired
    private ServiceLayer service;
    
    Set<ConstraintViolation<Drink>> violations = new HashSet<>();

    //https://www.thecocktaildb.com/api/json/v1/1/popular.php
    @GetMapping("home")
    public String getHome(Model model) {
        System.setProperty("https.protocols", "TLSv1.2,TLSv1.1,TLSv1");
        List<Drink> popular = service.getPopularDrinks();
        List<Drink> custom = service.getAllDrinks();
        model.addAttribute("custom",custom);
        model.addAttribute("popular", popular.subList(0, 10));
        return "home";
    }
    
    
    //https://www.thecocktaildb.com/api/json/v1/1/randomselection.php
    @GetMapping("random")
    public String getRandom(Model model) {
        List<Drink> random = service.getRandomDrinks();
        model.addAttribute("random", random);
        return "random";
    }
    
    //https://www.thecocktaildb.com/api/json/v1/1/search.php?s={searchid}
    @PostMapping("search")
    public String postSearch(Model model,HttpServletRequest request) {
        String search = request.getParameter("search");
        List<Drink> results = service.getSearchResults(search);
        model.addAttribute("results", results);
        return "search";
    }
    
    @GetMapping("generate")
    public String generate(Model model){
        List<String> allIngredients = service.getAllIngredients();
        java.util.Collections.sort(allIngredients);    
        model.addAttribute("allIngredients",allIngredients);
        return "generate";
    }
    
    @PostMapping("generateRecipes")
    public String generateRecipes(HttpServletRequest request, Model model){
        List<Drink> generatedDrinks = new ArrayList<>();
        String[] ingredients = request.getParameterValues("ingredients");
        if(ingredients != null){
            List<String> ownedIngredients = Arrays.asList(ingredients);
            generatedDrinks = service.generateRecipe(ownedIngredients);
        }
   
        model.addAttribute("drinks",generatedDrinks);
        return "generateDisplay";
    }
    
    @GetMapping("delete")
    public String deleteDrink(Integer id) {
        service.removeDrink(id);
        return "redirect:/home";
    }
    
    @GetMapping("detail")
    public String getDetail(String id, Model model){
        int idInt = Integer.parseInt(id);
        Drink drink = service.getDrink(idInt);
        List<String> ingredients = service.getFormattedIngredients(drink);
        List<String> tags = new ArrayList<>();
        model.addAttribute("drink",drink);
        if(drink.getStrTags() != null)
            tags = service.getTagsForDrink(drink);
        else
            tags.add("No Tags Found");
        model.addAttribute("tags", tags);
        model.addAttribute("ingredients",ingredients);
        return "detail";
    }
    
    @GetMapping("add")
    public String add(Model model){
        List<String> glasses = service.getAllGlasses();
        List<String> categories = service.getAllCategories();
        List<String> ingredients = service.getAllIngredients();
        
        model.addAttribute("glasses",glasses);
        model.addAttribute("categories", categories);
        model.addAttribute("ingredients",ingredients);
        model.addAttribute("errors",violations);
        
        return "add";
    }
    
    @PostMapping("addCustomDrink")
    public String addCustomDrink(HttpServletRequest request, Model model){
        String name = request.getParameter("name");
        String glass = request.getParameter("glass");
        String tags = request.getParameter("tags");
        String instructions = request.getParameter("instructions");
        
        //Ingredients from html
        String strIngredient1 = request.getParameter("ingredient1");
        String strIngredient2 = request.getParameter("ingredient2");
        String strIngredient3 = request.getParameter("ingredient3");
        String strIngredient4 = request.getParameter("ingredient4");
        String strIngredient5 = request.getParameter("ingredient5");
        String strIngredient6 = request.getParameter("ingredient6");
        String strIngredient7 = request.getParameter("ingredient7");
        String strIngredient8 = request.getParameter("ingredient8");
        String strIngredient9 = request.getParameter("ingredient9");
        String strIngredient10 = request.getParameter("ingredient10");
        String strIngredient11 = request.getParameter("ingredient11");
        String strIngredient12 = request.getParameter("ingredient12");
        String strIngredient13 = request.getParameter("ingredient13");
        String strIngredient14 = request.getParameter("ingredient14");
        String strIngredient15 = request.getParameter("ingredient15");
        
        //Measurements from html
        String strMeasure1 = request.getParameter("measure1");
        String strMeasure2 = request.getParameter("measure2");
        String strMeasure3 = request.getParameter("measure3");
        String strMeasure4 = request.getParameter("measure4");
        String strMeasure5 = request.getParameter("measure5");
        String strMeasure6 = request.getParameter("measure6");
        String strMeasure7 = request.getParameter("measure7");
        String strMeasure8 = request.getParameter("measure8");
        String strMeasure9 = request.getParameter("measure9");
        String strMeasure10 = request.getParameter("measure10");
        String strMeasure11 = request.getParameter("measure11");
        String strMeasure12 = request.getParameter("measure12");
        String strMeasure13 = request.getParameter("measure13");
        String strMeasure14 = request.getParameter("measure14");
        String strMeasure15 = request.getParameter("measure15");
        
        Drink drink = new Drink();
        drink.setStrInstructions(instructions);
        System.out.println(drink.getStrInstructions());
        drink.setStrDrink(name);
        drink.setStrGlass(glass);
        drink.setStrTags("Custom Drink");
        drink.setStrDrinkThumb("https://dutchdrinksservice.com/wp-content/uploads/2020/08/default-product-image-300x300-1.gif");
        
        //Set of ingredients
        drink.setStrIngredient1(strIngredient1);
        drink.setStrIngredient2(strIngredient2);
        drink.setStrIngredient3(strIngredient3);
        drink.setStrIngredient4(strIngredient4);
        drink.setStrIngredient5(strIngredient5);
        drink.setStrIngredient6(strIngredient6);
        drink.setStrIngredient7(strIngredient7);
        drink.setStrIngredient8(strIngredient8);
        drink.setStrIngredient9(strIngredient9);
        drink.setStrIngredient10(strIngredient10);
        drink.setStrIngredient11(strIngredient11);
        drink.setStrIngredient12(strIngredient12);
        drink.setStrIngredient13(strIngredient13);
        drink.setStrIngredient14(strIngredient14);
        drink.setStrIngredient15(strIngredient15);
        
        //Set of Measurements
        drink.setStrMeasure1(strMeasure1);
        drink.setStrMeasure2(strMeasure2);
        drink.setStrMeasure3(strMeasure3);
        drink.setStrMeasure4(strMeasure4);
        drink.setStrMeasure5(strMeasure5);
        drink.setStrMeasure6(strMeasure6);
        drink.setStrMeasure7(strMeasure7);
        drink.setStrMeasure8(strMeasure8);
        drink.setStrMeasure9(strMeasure9);
        drink.setStrMeasure10(strMeasure10);
        drink.setStrMeasure11(strMeasure11);
        drink.setStrMeasure12(strMeasure12);
        drink.setStrMeasure13(strMeasure13);
        drink.setStrMeasure14(strMeasure14);
        drink.setStrMeasure15(strMeasure15);
        
        
        
        
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(drink);
        if(violations.isEmpty())
            service.addDrink(drink);
        else{
            model.addAttribute("glasses",service.getAllGlasses());
            model.addAttribute("categories", service.getAllCategories());
            model.addAttribute("ingredients",service.getAllIngredients());
            model.addAttribute("errors",violations);
            return "add";
                    
        }
        
        model.addAttribute("custom",service.getAllDrinks());
        model.addAttribute("popular", service.getAllDrinksAPI().subList(0, 10));
        
        return "home";
    }
    
    
}
