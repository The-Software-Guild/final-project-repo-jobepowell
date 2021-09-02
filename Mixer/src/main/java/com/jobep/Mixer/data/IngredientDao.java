/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobep.Mixer.data;

import com.jobep.Mixer.models.Ingredient;
import java.util.List;

/**
 *
 * @author powel
 */
public interface IngredientDao {
    Ingredient getIngredientById(int id);
    List<Ingredient> getAllIngredients();
    Ingredient addIngredient(Ingredient ingredient);
    void removeIngredientById(int id);
    void updateIngredient(Ingredient ingredient);
}
