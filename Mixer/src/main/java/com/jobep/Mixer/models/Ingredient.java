/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobep.Mixer.models;

import java.util.Objects;

/**
 *
 * @author powel
 */
public class Ingredient {
    private int idIngredient;
    private String strIngredient;
    private String strDescription;
    private String strType;
    private String strAlcohol;
    private String strABV;

    public int getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }

    public String getStrIngredient() {
        return strIngredient;
    }

    public void setStrIngredient(String strIngredient) {
        this.strIngredient = strIngredient;
    }

    public String getStrDescription() {
        return strDescription;
    }

    public void setStrDescription(String strDescription) {
        this.strDescription = strDescription;
    }

    public String getStrType() {
        return strType;
    }

    public void setStrType(String strType) {
        this.strType = strType;
    }

    public String getStrAlcohol() {
        return strAlcohol;
    }

    public void setStrAlcohol(String strAlcohol) {
        this.strAlcohol = strAlcohol;
    }

    public String getStrABV() {
        return strABV;
    }

    public void setStrABV(String strABV) {
        this.strABV = strABV;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.idIngredient;
        hash = 37 * hash + Objects.hashCode(this.strIngredient);
        hash = 37 * hash + Objects.hashCode(this.strDescription);
        hash = 37 * hash + Objects.hashCode(this.strType);
        hash = 37 * hash + Objects.hashCode(this.strAlcohol);
        hash = 37 * hash + Objects.hashCode(this.strABV);
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
        final Ingredient other = (Ingredient) obj;
        if (this.idIngredient != other.idIngredient) {
            return false;
        }
        if (!Objects.equals(this.strIngredient, other.strIngredient)) {
            return false;
        }
        if (!Objects.equals(this.strDescription, other.strDescription)) {
            return false;
        }
        if (!Objects.equals(this.strType, other.strType)) {
            return false;
        }
        if (!Objects.equals(this.strAlcohol, other.strAlcohol)) {
            return false;
        }
        if (!Objects.equals(this.strABV, other.strABV)) {
            return false;
        }
        return true;
    }
    
    
}
