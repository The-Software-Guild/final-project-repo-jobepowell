/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobep.Mixer.service;

import com.jobep.Mixer.models.Drink;
import java.util.List;

/**
 *
 * @author powel
 */
public interface ServiceLayer {
    public Drink addDrink(Drink drink);
    public void removeDrink(int id);
    public Drink getDrink(int id);
    public List<Drink> getAllDrinks();
    public void editDrink(Drink drink);
    public List<String> getAllIngredients();
    public List<String> getAllGlasses();
    public List<String> getAllCategories();
    List<Drink> generateRecipe(List<String> ingredients);
    
    public List<Drink> getRandomDrinks();
    public List<Drink> getPopularDrinks();
    public List<Drink> getSearchResults(String search);
    public List<String> getTagsForDrink(Drink drink);
    public List<String> getFormattedIngredients(Drink drink);
    public List<Drink> getAllDrinksAPI();
    
}
