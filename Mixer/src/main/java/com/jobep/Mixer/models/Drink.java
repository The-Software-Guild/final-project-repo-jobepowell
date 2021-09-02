/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobep.Mixer.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author powel
 */
public class Drink {
    private int idDrink;
    //Name of the drink
    @NotBlank(message="Drink must have a name")
    @Size(max=100,message="Name must not exceed 100 characters")
    private String strDrink;
    private String strDrinkAlternate;
    //Tags for drink
    private String strTags;
    private String strVideo;
    private String strCategory;
    private String strIBA;
    private String strAlcoholic;
    private String strGlass;
    @NotBlank(message="Drink must have instructions (How else are we gonna make it?)")
    @Size(max=1000,message="Instructions must not exceed 1000 characters")
    private String strInstructions;
    //Thumbnail for the drink
    private String strDrinkThumb;
    
    @NotBlank(message="Drinks must have at least 1 ingredient")
    private String strIngredient1;
    private String strIngredient2;
    private String strIngredient3;
    private String strIngredient4;
    private String strIngredient5;
    private String strIngredient6;
    private String strIngredient7;
    private String strIngredient8;
    private String strIngredient9;
    private String strIngredient10;
    private String strIngredient11;
    private String strIngredient12;
    private String strIngredient13;
    private String strIngredient14;
    private String strIngredient15;
    
    private String strMeasure1;
    private String strMeasure2;
    private String strMeasure3;
    private String strMeasure4;
    private String strMeasure5;
    private String strMeasure6;
    private String strMeasure7;
    private String strMeasure8;
    private String strMeasure9;
    private String strMeasure10;
    private String strMeasure11;
    private String strMeasure12;
    private String strMeasure13;
    private String strMeasure14;
    private String strMeasure15;
    
    public List<String> formattedIngredients(){
        List<String> ingredients = new ArrayList<>();
        checkNullIngredients(ingredients,strIngredient1,strMeasure1);
        checkNullIngredients(ingredients,strIngredient2,strMeasure2);
        checkNullIngredients(ingredients,strIngredient3,strMeasure3);
        checkNullIngredients(ingredients,strIngredient4,strMeasure4);
        checkNullIngredients(ingredients,strIngredient5,strMeasure5);
        checkNullIngredients(ingredients,strIngredient6,strMeasure6);
        checkNullIngredients(ingredients,strIngredient7,strMeasure7);
        checkNullIngredients(ingredients,strIngredient8,strMeasure8);
        checkNullIngredients(ingredients,strIngredient9,strMeasure9);
        checkNullIngredients(ingredients,strIngredient10,strMeasure10);
        checkNullIngredients(ingredients,strIngredient11,strMeasure11);
        checkNullIngredients(ingredients,strIngredient12,strMeasure12);
        checkNullIngredients(ingredients,strIngredient13,strMeasure13);
        checkNullIngredients(ingredients,strIngredient14,strMeasure14);
        checkNullIngredients(ingredients,strIngredient15,strMeasure15);
        
        return ingredients;
        
    }
    
    public void checkNullIngredients(List<String> list,String i, String m){
        if(i==null)
            return;
        else if(m==null)
            list.add(i);
        else
            list.add(i + " : " + m);
    }
    
    public List<String> allIngredientsToList(){
        List<String> ingredients = new ArrayList<>();
        if(strIngredient1 != null)
            ingredients.add(strIngredient1);
        if(strIngredient2 != null)
            ingredients.add(strIngredient2);
        if(strIngredient3 != null)
            ingredients.add(strIngredient3);
        if(strIngredient4 != null)
            ingredients.add(strIngredient4);
        if(strIngredient5 != null)
            ingredients.add(strIngredient5);
        if(strIngredient6 != null)
            ingredients.add(strIngredient6);
        if(strIngredient7 != null)
            ingredients.add(strIngredient7);
        if(strIngredient8 != null)
            ingredients.add(strIngredient8);
        if(strIngredient9 != null)
            ingredients.add(strIngredient9);
        if(strIngredient10 != null)
            ingredients.add(strIngredient10);
        if(strIngredient11 != null)
            ingredients.add(strIngredient11);
        if(strIngredient12 != null)
            ingredients.add(strIngredient12);
        if(strIngredient13 != null)           
            ingredients.add(strIngredient13);
        if(strIngredient14 != null)
            ingredients.add(strIngredient14);
        if(strIngredient15 != null)
            ingredients.add(strIngredient15);
        
        return ingredients;
    }
    
    public int getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(int idDrink) {
        this.idDrink = idDrink;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public void setStrDrink(String strDrink) {
        this.strDrink = strDrink;
    }

    public String getStrDrinkAlternate() {
        return strDrinkAlternate;
    }

    public void setStrDrinkAlternate(String strDrinkAlternate) {
        this.strDrinkAlternate = strDrinkAlternate;
    }

    public String getStrTags() {
        return strTags;
    }

    public void setStrTags(String strTags) {
        this.strTags = strTags;
    }

    public String getStrVideo() {
        return strVideo;
    }

    public void setStrVideo(String strVideo) {
        this.strVideo = strVideo;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrIBA() {
        return strIBA;
    }

    public void setStrIBA(String strIBA) {
        this.strIBA = strIBA;
    }

    public String getStrAlcoholic() {
        return strAlcoholic;
    }

    public void setStrAlcoholic(String strAlcoholic) {
        this.strAlcoholic = strAlcoholic;
    }

    public String getStrGlass() {
        return strGlass;
    }

    public void setStrGlass(String strGlass) {
        this.strGlass = strGlass;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }

    public void setStrDrinkThumb(String strDrinkThumb) {
        this.strDrinkThumb = strDrinkThumb;
    }

    public String getStrIngredient1() {
        return strIngredient1;
    }

    public void setStrIngredient1(String strIngredient1) {
        this.strIngredient1 = strIngredient1;
    }

    public String getStrIngredient2() {
        return strIngredient2;
    }

    public void setStrIngredient2(String strIngredient2) {
        this.strIngredient2 = strIngredient2;
    }

    public String getStrIngredient3() {
        return strIngredient3;
    }

    public void setStrIngredient3(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }

    public String getStrIngredient4() {
        return strIngredient4;
    }

    public void setStrIngredient4(String strIngredient4) {
        this.strIngredient4 = strIngredient4;
    }

    public String getStrIngredient5() {
        return strIngredient5;
    }

    public void setStrIngredient5(String strIngredient5) {
        this.strIngredient5 = strIngredient5;
    }

    public String getStrMeasure1() {
        return strMeasure1;
    }

    public void setStrMeasure1(String strMeasure1) {
        this.strMeasure1 = strMeasure1;
    }

    public String getStrMeasure2() {
        return strMeasure2;
    }

    public void setStrMeasure2(String strMeasure2) {
        this.strMeasure2 = strMeasure2;
    }

    public String getStrMeasure3() {
        return strMeasure3;
    }

    public void setStrMeasure3(String strMeasure3) {
        this.strMeasure3 = strMeasure3;
    }

    public String getStrMeasure4() {
        return strMeasure4;
    }

    public void setStrMeasure4(String strMeasure4) {
        this.strMeasure4 = strMeasure4;
    }

    public String getStrMeasure5() {
        return strMeasure5;
    }

    public void setStrMeasure5(String strMeasure5) {
        this.strMeasure5 = strMeasure5;
    }

    public String getStrIngredient6() {
        return strIngredient6;
    }

    public void setStrIngredient6(String strIngredient6) {
        this.strIngredient6 = strIngredient6;
    }

    public String getStrIngredient7() {
        return strIngredient7;
    }

    public void setStrIngredient7(String strIngredient7) {
        this.strIngredient7 = strIngredient7;
    }

    public String getStrIngredient8() {
        return strIngredient8;
    }

    public void setStrIngredient8(String strIngredient8) {
        this.strIngredient8 = strIngredient8;
    }

    public String getStrIngredient9() {
        return strIngredient9;
    }

    public void setStrIngredient9(String strIngredient9) {
        this.strIngredient9 = strIngredient9;
    }

    public String getStrIngredient10() {
        return strIngredient10;
    }

    public void setStrIngredient10(String strIngredient10) {
        this.strIngredient10 = strIngredient10;
    }

    public String getStrIngredient11() {
        return strIngredient11;
    }

    public void setStrIngredient11(String strIngredient11) {
        this.strIngredient11 = strIngredient11;
    }

    public String getStrIngredient12() {
        return strIngredient12;
    }

    public void setStrIngredient12(String strIngredient12) {
        this.strIngredient12 = strIngredient12;
    }

    public String getStrIngredient13() {
        return strIngredient13;
    }

    public void setStrIngredient13(String strIngredient13) {
        this.strIngredient13 = strIngredient13;
    }

    public String getStrIngredient14() {
        return strIngredient14;
    }

    public void setStrIngredient14(String strIngredient14) {
        this.strIngredient14 = strIngredient14;
    }

    public String getStrIngredient15() {
        return strIngredient15;
    }

    public void setStrIngredient15(String strIngredient15) {
        this.strIngredient15 = strIngredient15;
    }

    public String getStrMeasure6() {
        return strMeasure6;
    }

    public void setStrMeasure6(String strMeasure6) {
        this.strMeasure6 = strMeasure6;
    }

    public String getStrMeasure7() {
        return strMeasure7;
    }

    public void setStrMeasure7(String strMeasure7) {
        this.strMeasure7 = strMeasure7;
    }

    public String getStrMeasure8() {
        return strMeasure8;
    }

    public void setStrMeasure8(String strMeasure8) {
        this.strMeasure8 = strMeasure8;
    }

    public String getStrMeasure9() {
        return strMeasure9;
    }

    public void setStrMeasure9(String strMeasure9) {
        this.strMeasure9 = strMeasure9;
    }

    public String getStrMeasure10() {
        return strMeasure10;
    }

    public void setStrMeasure10(String strMeasure10) {
        this.strMeasure10 = strMeasure10;
    }

    public String getStrMeasure11() {
        return strMeasure11;
    }

    public void setStrMeasure11(String strMeasure11) {
        this.strMeasure11 = strMeasure11;
    }

    public String getStrMeasure12() {
        return strMeasure12;
    }

    public void setStrMeasure12(String strMeasure12) {
        this.strMeasure12 = strMeasure12;
    }

    public String getStrMeasure13() {
        return strMeasure13;
    }

    public void setStrMeasure13(String strMeasure13) {
        this.strMeasure13 = strMeasure13;
    }

    public String getStrMeasure14() {
        return strMeasure14;
    }

    public void setStrMeasure14(String strMeasure14) {
        this.strMeasure14 = strMeasure14;
    }

    public String getStrMeasure15() {
        return strMeasure15;
    }

    public void setStrMeasure15(String strMeasure15) {
        this.strMeasure15 = strMeasure15;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.idDrink;
        hash = 41 * hash + Objects.hashCode(this.strDrink);
        hash = 41 * hash + Objects.hashCode(this.strDrinkAlternate);
        hash = 41 * hash + Objects.hashCode(this.strTags);
        hash = 41 * hash + Objects.hashCode(this.strVideo);
        hash = 41 * hash + Objects.hashCode(this.strCategory);
        hash = 41 * hash + Objects.hashCode(this.strIBA);
        hash = 41 * hash + Objects.hashCode(this.strAlcoholic);
        hash = 41 * hash + Objects.hashCode(this.strGlass);
        hash = 41 * hash + Objects.hashCode(this.strInstructions);
        hash = 41 * hash + Objects.hashCode(this.strDrinkThumb);
        hash = 41 * hash + Objects.hashCode(this.strIngredient1);
        hash = 41 * hash + Objects.hashCode(this.strIngredient2);
        hash = 41 * hash + Objects.hashCode(this.strIngredient3);
        hash = 41 * hash + Objects.hashCode(this.strIngredient4);
        hash = 41 * hash + Objects.hashCode(this.strIngredient5);
        hash = 41 * hash + Objects.hashCode(this.strIngredient6);
        hash = 41 * hash + Objects.hashCode(this.strIngredient7);
        hash = 41 * hash + Objects.hashCode(this.strIngredient8);
        hash = 41 * hash + Objects.hashCode(this.strIngredient9);
        hash = 41 * hash + Objects.hashCode(this.strIngredient10);
        hash = 41 * hash + Objects.hashCode(this.strIngredient11);
        hash = 41 * hash + Objects.hashCode(this.strIngredient12);
        hash = 41 * hash + Objects.hashCode(this.strIngredient13);
        hash = 41 * hash + Objects.hashCode(this.strIngredient14);
        hash = 41 * hash + Objects.hashCode(this.strIngredient15);
        hash = 41 * hash + Objects.hashCode(this.strMeasure1);
        hash = 41 * hash + Objects.hashCode(this.strMeasure2);
        hash = 41 * hash + Objects.hashCode(this.strMeasure3);
        hash = 41 * hash + Objects.hashCode(this.strMeasure4);
        hash = 41 * hash + Objects.hashCode(this.strMeasure5);
        hash = 41 * hash + Objects.hashCode(this.strMeasure6);
        hash = 41 * hash + Objects.hashCode(this.strMeasure7);
        hash = 41 * hash + Objects.hashCode(this.strMeasure8);
        hash = 41 * hash + Objects.hashCode(this.strMeasure9);
        hash = 41 * hash + Objects.hashCode(this.strMeasure10);
        hash = 41 * hash + Objects.hashCode(this.strMeasure11);
        hash = 41 * hash + Objects.hashCode(this.strMeasure12);
        hash = 41 * hash + Objects.hashCode(this.strMeasure13);
        hash = 41 * hash + Objects.hashCode(this.strMeasure14);
        hash = 41 * hash + Objects.hashCode(this.strMeasure15);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Drink other = (Drink) obj;
        if (this.idDrink != other.idDrink) {
            return false;
        }
        if (!Objects.equals(this.strDrink, other.strDrink)) {
            return false;
        }
        if (!Objects.equals(this.strDrinkAlternate, other.strDrinkAlternate)) {
            return false;
        }
        if (!Objects.equals(this.strTags, other.strTags)) {
            return false;
        }
        if (!Objects.equals(this.strVideo, other.strVideo)) {
            return false;
        }
        if (!Objects.equals(this.strCategory, other.strCategory)) {
            return false;
        }
        if (!Objects.equals(this.strIBA, other.strIBA)) {
            return false;
        }
        if (!Objects.equals(this.strAlcoholic, other.strAlcoholic)) {
            return false;
        }
        if (!Objects.equals(this.strGlass, other.strGlass)) {
            return false;
        }
        if (!Objects.equals(this.strInstructions, other.strInstructions)) {
            return false;
        }
        if (!Objects.equals(this.strDrinkThumb, other.strDrinkThumb)) {
            return false;
        }
        if (!Objects.equals(this.strIngredient1, other.strIngredient1)) {
            return false;
        }
        if (!Objects.equals(this.strIngredient2, other.strIngredient2)) {
            return false;
        }
        if (!Objects.equals(this.strIngredient3, other.strIngredient3)) {
            return false;
        }
        if (!Objects.equals(this.strIngredient4, other.strIngredient4)) {
            return false;
        }
        if (!Objects.equals(this.strIngredient5, other.strIngredient5)) {
            return false;
        }
        if (!Objects.equals(this.strIngredient6, other.strIngredient6)) {
            return false;
        }
        if (!Objects.equals(this.strIngredient7, other.strIngredient7)) {
            return false;
        }
        if (!Objects.equals(this.strIngredient8, other.strIngredient8)) {
            return false;
        }
        if (!Objects.equals(this.strIngredient9, other.strIngredient9)) {
            return false;
        }
        if (!Objects.equals(this.strIngredient10, other.strIngredient10)) {
            return false;
        }
        if (!Objects.equals(this.strIngredient11, other.strIngredient11)) {
            return false;
        }
        if (!Objects.equals(this.strIngredient12, other.strIngredient12)) {
            return false;
        }
        if (!Objects.equals(this.strIngredient13, other.strIngredient13)) {
            return false;
        }
        if (!Objects.equals(this.strIngredient14, other.strIngredient14)) {
            return false;
        }
        if (!Objects.equals(this.strIngredient15, other.strIngredient15)) {
            return false;
        }
        if (!Objects.equals(this.strMeasure1, other.strMeasure1)) {
            return false;
        }
        if (!Objects.equals(this.strMeasure2, other.strMeasure2)) {
            return false;
        }
        if (!Objects.equals(this.strMeasure3, other.strMeasure3)) {
            return false;
        }
        if (!Objects.equals(this.strMeasure4, other.strMeasure4)) {
            return false;
        }
        if (!Objects.equals(this.strMeasure5, other.strMeasure5)) {
            return false;
        }
        if (!Objects.equals(this.strMeasure6, other.strMeasure6)) {
            return false;
        }
        if (!Objects.equals(this.strMeasure7, other.strMeasure7)) {
            return false;
        }
        if (!Objects.equals(this.strMeasure8, other.strMeasure8)) {
            return false;
        }
        if (!Objects.equals(this.strMeasure9, other.strMeasure9)) {
            return false;
        }
        if (!Objects.equals(this.strMeasure10, other.strMeasure10)) {
            return false;
        }
        if (!Objects.equals(this.strMeasure11, other.strMeasure11)) {
            return false;
        }
        if (!Objects.equals(this.strMeasure12, other.strMeasure12)) {
            return false;
        }
        if (!Objects.equals(this.strMeasure13, other.strMeasure13)) {
            return false;
        }
        if (!Objects.equals(this.strMeasure14, other.strMeasure14)) {
            return false;
        }
        if (!Objects.equals(this.strMeasure15, other.strMeasure15)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
