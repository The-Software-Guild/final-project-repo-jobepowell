/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobep.Mixer.service;

import com.jobep.Mixer.data.DrinkDao;
import com.jobep.Mixer.models.Cocktails;
import com.jobep.Mixer.models.Drink;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author powel
 */
@Component
public class ServiceDB implements ServiceLayer {
    
    @Value("${api.key}")
    private String API_KEY;

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    DrinkDao dao;

    @Override
    public Drink addDrink(Drink drink) {
        return dao.addDrink(drink);
    }

    @Override
    public void removeDrink(int id) {
        dao.removeDrinkById(id);
    }

    @Override
    public Drink getDrink(int id) {
        Drink drink = dao.getDrinkById(id);
        if(drink == null){
            String uri = "https://www.thecocktaildb.com/api/json/v2/" + API_KEY + "/lookup.php?i="+id;
            Cocktails ct = restTemplate.getForObject(uri, Cocktails.class);
            drink = ct.getDrinks().get(0);
        }
        return drink;
    }

    @Override
    public List<Drink> getAllDrinks() {    
        return dao.getAllDrinks();
    }

    @Override
    public void editDrink(Drink drink) {
        dao.updateDrink(drink);
    }

    @Override
    public List<Drink> getRandomDrinks() {
        String uri = "https://www.thecocktaildb.com/api/json/v2/" + API_KEY + "/randomselection.php";
        Cocktails random = restTemplate.getForObject(uri, Cocktails.class);
        return random.getDrinks();
    }

    @Override
    public List<Drink> getPopularDrinks() {
        String uri = "https://www.thecocktaildb.com/api/json/v2/" + API_KEY + "/popular.php";
        Cocktails popular = restTemplate.getForObject(uri, Cocktails.class);
        return popular.getDrinks();
    }

    @Override
    public List<Drink> getSearchResults(String search) {
        String uri = "https://www.thecocktaildb.com/api/json/v2/" + API_KEY + "/search.php?s=" + search;
        Cocktails results = restTemplate.getForObject(uri, Cocktails.class);
        if(results.getDrinks() != null){
            ArrayList<Drink> drinks = new ArrayList<>(results.getDrinks());
            ArrayList<Drink> customs = new ArrayList<>(dao.searchDrinks(search));
            customs.addAll(drinks);
            return customs;
        }
        
        List<Drink> customsOnly = dao.searchDrinks(search);
        return customsOnly;
    }
    
    @Override
    public List<Drink> generateRecipe(List<String> ingredients){
        List<Drink> retDrink = new ArrayList<>();
        String uri = "https://www.thecocktaildb.com/api/json/v2/" + API_KEY + "/filter.php?i=";
        for(String s : ingredients)
            uri += s + ",";
        uri = uri.substring(0, uri.length() - 1);
        
        Cocktails results = restTemplate.getForObject(uri, Cocktails.class);
        
        for(Drink drink : results.getDrinks())
            retDrink.add(getDrink(drink.getIdDrink()));
                
        return retDrink;
    }
    
    @Override
    public List<String> getTagsForDrink(Drink drink) {
        String[] tags = drink.getStrTags().split(",");
        return Arrays.asList(tags);
    }

    @Override
    public List<String> getFormattedIngredients(Drink drink) {
        return drink.formattedIngredients();
    }
    
    @Override
    public List<Drink> getAllDrinksAPI(){
        String uri = "https://www.thecocktaildb.com/api/json/v2/" + API_KEY + "/search.php?s=";
        Cocktails results = restTemplate.getForObject(uri, Cocktails.class);
        return results.getDrinks();
    }

    @Override
    public List<String> getAllIngredients() {
        String uri = "https://www.thecocktaildb.com/api/json/v2/" + API_KEY + "/list.php?i=list";
        Cocktails drinksIngredients = restTemplate.getForObject(uri, Cocktails.class);
        List<String> ingredients = drinksIngredients.getDrinks().stream().map(x -> x.getStrIngredient1()).collect(Collectors.toList());
        return ingredients;
    }

    @Override
    public List<String> getAllGlasses() {
        String uri = "https://www.thecocktaildb.com/api/json/v2/" + API_KEY + "/list.php?g=list";
        Cocktails drinksGlasses = restTemplate.getForObject(uri, Cocktails.class);
        List<String> glasses = drinksGlasses.getDrinks().stream().map(x -> x.getStrGlass()).collect(Collectors.toList());
        return glasses;
    }

    @Override
    public List<String> getAllCategories() {
        String uri = "https://www.thecocktaildb.com/api/json/v2/" + API_KEY + "/list.php?c=list";
        Cocktails drinksCategories = restTemplate.getForObject(uri, Cocktails.class);
        List<String> categories = drinksCategories.getDrinks().stream().map(x -> x.getStrCategory()).collect(Collectors.toList());
        return categories;
    }
}
