/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobep.Mixer.data;

import com.jobep.Mixer.models.Ingredient;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author powel
 */
@Repository
public class IngredientDaoDB implements IngredientDao{
    
    @Autowired
    JdbcTemplate jdbc;
    
    @Override
    public Ingredient getIngredientById(int id) {
        try{
            final String GET_INGREDIENT_BY_ID = "SELECT * FROM ingredient WHERE idIngredient = ?";
            return jdbc.queryForObject(GET_INGREDIENT_BY_ID, new IngredientMapper(), id);
        } catch(DataAccessException ex){
            return null;
        }
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        final String GET_ALL_INGREDIENTS = "SELECT * FROM ingredient";
        return jdbc.query(GET_ALL_INGREDIENTS, new IngredientMapper());
    }

    @Override
    @Transactional
    public Ingredient addIngredient(Ingredient ingredient) {
        Integer id = ingredient.getIdIngredient();
        String INSERT_INGREDIENT;
        
        //For ingredients that already have ID's
        if(id != null){
            INSERT_INGREDIENT = "INSERT INTO ingredient VALUES(?,?,?,?,?,?)";
            jdbc.update(INSERT_INGREDIENT,
                    ingredient.getIdIngredient(),
                    ingredient.getStrIngredient(),
                    ingredient.getStrDescription(),
                    ingredient.getStrType(),
                    ingredient.getStrAlcohol(),
                    ingredient.getStrABV());
        }//For ingredients that dont already have ID's
        else{
            INSERT_INGREDIENT = "INSERT INTO ingredient(strIngredient,strDescription,strType,strAlcohol,strABV)"
                + " VALUES(?,?,?,?,?)";
            jdbc.update(INSERT_INGREDIENT,
                    ingredient.getStrIngredient(),
                    ingredient.getStrDescription(),
                    ingredient.getStrType(),
                    ingredient.getStrAlcohol(),
                    ingredient.getStrABV());
        }
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        ingredient.setIdIngredient(newId);
        return ingredient;
    }

    @Override
    @Transactional
    public void removeIngredientById(int id) {
        final String DELETE_INGREDIENT = "DELETE FROM ingredient WHERE idIngredient = ?";
        jdbc.update(DELETE_INGREDIENT,id);
    }

    @Override
    public void updateIngredient(Ingredient ingredient) {
        final String UPDATE_INGREDIENT = "UPDATE ingredient SET strIngredient = ?, strDescription = ?, "
                + "strType = ?, strAlcohol = ?, strABV = ? WHERE idIngredient = ?";
        jdbc.update(UPDATE_INGREDIENT,
            ingredient.getStrIngredient(),
            ingredient.getStrDescription(),
            ingredient.getStrType(),
            ingredient.getStrAlcohol(),
            ingredient.getStrABV(),
            ingredient.getIdIngredient());
        
    }
    
    public static final class IngredientMapper implements RowMapper<Ingredient>{
        
        @Override
        public Ingredient mapRow(ResultSet rs, int index) throws SQLException{
            Ingredient ig = new Ingredient();
            ig.setIdIngredient(rs.getInt("idIngredient"));
            ig.setStrABV(rs.getString("strABV"));
            ig.setStrAlcohol(rs.getString("strAlcohol"));
            ig.setStrIngredient(rs.getString("strIngredient"));
            ig.setStrDescription(rs.getString("strDescription"));
            ig.setStrType(rs.getString("strType"));
            
            return ig;
       
        }
    }
    
}
