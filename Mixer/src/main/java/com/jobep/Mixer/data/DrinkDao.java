/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobep.Mixer.data;

import com.jobep.Mixer.models.Drink;
import java.util.List;

/**
 *
 * @author powel
 */
public interface DrinkDao {
    Drink getDrinkById(int id);
    List<Drink> getAllDrinks();
    Drink addDrink(Drink drink);
    void removeDrinkById(int id);
    void updateDrink(Drink drink);
    List<Drink> searchDrinks(String pattern);
}
