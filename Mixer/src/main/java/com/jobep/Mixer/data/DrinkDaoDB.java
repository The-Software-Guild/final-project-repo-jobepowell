/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobep.Mixer.data;

import com.jobep.Mixer.models.Drink;
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
public class DrinkDaoDB implements DrinkDao{

    @Autowired
    JdbcTemplate jdbc;
    
    @Override
    public Drink getDrinkById(int id) {
        try{
            final String GET_DRINK_BY_ID = "SELECT * FROM drink WHERE idDrink = ?";
            return jdbc.queryForObject(GET_DRINK_BY_ID,new DrinkMapper(),id);
        } catch(DataAccessException ex){
            return null;
        }    
    }

    @Override
    public List<Drink> getAllDrinks() {
        final String GET_ALL_DRINK = "SELECT * FROM drink";
        return jdbc.query(GET_ALL_DRINK, new DrinkMapper());
    }
    
    @Override
    public List<Drink> searchDrinks(String pattern){
        final String SEARCH_DRINK = "SELECT * FROM drink WHERE strDrink LIKE ?";
        return jdbc.query(SEARCH_DRINK, new DrinkMapper(), pattern);
    }
    
    @Override
    @Transactional
    public Drink addDrink(Drink drink) {
        final String INSERT_DRINK = "INSERT INTO drink(strDrink,strDrinkAlternate,strAlcoholic,strCategory"
                + ",strDrinkThumb,strGlass,strIBA,strTags,strVideo"
                + ",strIngredient1,strIngredient2,strIngredient3,strIngredient4,strIngredient5,strIngredient6,strIngredient7,strIngredient8,strIngredient9,strIngredient10,strIngredient11,strIngredient12,strIngredient13,strIngredient14,strIngredient15"
                + ",strMeasure1,strMeasure2,strMeasure3,strMeasure4,strMeasure5,strMeasure6,strMeasure7,strMeasure8,strMeasure9,strMeasure10,strMeasure11,strMeasure12,strMeasure13,strMeasure14,strMeasure15"
                + ",strInstructions)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        jdbc.update(INSERT_DRINK,
                drink.getStrDrink(),
                drink.getStrDrinkAlternate(),
                drink.getStrAlcoholic(),
                drink.getStrCategory(),
                drink.getStrDrinkThumb(),
                drink.getStrGlass(),
                drink.getStrIBA(),
                drink.getStrTags(),
                drink.getStrVideo(),
                drink.getStrIngredient1(),
                drink.getStrIngredient2(),
                drink.getStrIngredient3(),
                drink.getStrIngredient4(),
                drink.getStrIngredient5(),
                drink.getStrIngredient6(),
                drink.getStrIngredient7(),
                drink.getStrIngredient8(),
                drink.getStrIngredient9(),
                drink.getStrIngredient10(),
                drink.getStrIngredient11(),
                drink.getStrIngredient12(),
                drink.getStrIngredient13(),
                drink.getStrIngredient14(),
                drink.getStrIngredient15(),
                drink.getStrMeasure1(),
                drink.getStrMeasure2(),
                drink.getStrMeasure3(),
                drink.getStrMeasure4(),
                drink.getStrMeasure5(),
                drink.getStrMeasure6(),
                drink.getStrMeasure7(),
                drink.getStrMeasure8(),
                drink.getStrMeasure9(),
                drink.getStrMeasure10(),
                drink.getStrMeasure11(),
                drink.getStrMeasure12(),
                drink.getStrMeasure13(),
                drink.getStrMeasure14(),
                drink.getStrMeasure15(),
                drink.getStrInstructions());
        
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        drink.setIdDrink(newId);
        return drink;
    }

    @Override
    @Transactional
    public void removeDrinkById(int id) {
        final String DELETE_DRINK = "DELETE FROM drink WHERE idDrink = ?";
        jdbc.update(DELETE_DRINK,id);
    }

    @Override
    public void updateDrink(Drink drink) {
        final String UPDATE_DRINK = "UPDATE drink SET strDrink = ?,strDrinkAlternate = ?,strAlcoholic = ?,strCategory = ?"
                + ",strDrinkThumb = ?,strGlass = ?,strIBA = ?,strTags = ?,strVideo = ?"
                + ",strIngredient1 = ?,strIngredient2 = ?,strIngredient3 = ?,strIngredient4 = ?,strIngredient5 = ?,strIngredient6 = ?,strIngredient7 = ?,strIngredient8 = ?,strIngredient9 = ?,strIngredient10 = ?,strIngredient11 = ?,strIngredient12 = ?,strIngredient13 = ?,strIngredient14 = ?,strIngredient15 = ?"
                + ",strMeasure1 = ?,strMeasure2 = ?,strMeasure3 = ?,strMeasure4 = ?,strMeasure5 = ?,strMeasure6 = ?,strMeasure7 = ?,strMeasure8 = ?,strMeasure9 = ?,strMeasure10 = ?,strMeasure11 = ?,strMeasure12 = ?,strMeasure13 = ?,strMeasure14 = ?,strMeasure15 = ?, strInstructions = ?"
                + " WHERE idDrink = ?";
        jdbc.update(UPDATE_DRINK,
                drink.getStrDrink(),
                drink.getStrDrinkAlternate(),
                drink.getStrAlcoholic(),
                drink.getStrCategory(),
                drink.getStrDrinkThumb(),
                drink.getStrGlass(),
                drink.getStrIBA(),
                drink.getStrTags(),
                drink.getStrVideo(),
                drink.getStrIngredient1(),
                drink.getStrIngredient2(),
                drink.getStrIngredient3(),
                drink.getStrIngredient4(),
                drink.getStrIngredient5(),
                drink.getStrIngredient6(),
                drink.getStrIngredient7(),
                drink.getStrIngredient8(),
                drink.getStrIngredient9(),
                drink.getStrIngredient10(),
                drink.getStrIngredient11(),
                drink.getStrIngredient12(),
                drink.getStrIngredient13(),
                drink.getStrIngredient14(),
                drink.getStrIngredient15(),
                drink.getStrMeasure1(),
                drink.getStrMeasure2(),
                drink.getStrMeasure3(),
                drink.getStrMeasure4(),
                drink.getStrMeasure5(),
                drink.getStrMeasure6(),
                drink.getStrMeasure7(),
                drink.getStrMeasure8(),
                drink.getStrMeasure9(),
                drink.getStrMeasure10(),
                drink.getStrMeasure11(),
                drink.getStrMeasure12(),
                drink.getStrMeasure13(),
                drink.getStrMeasure14(),
                drink.getStrMeasure15(),
                drink.getStrInstructions(),
                drink.getIdDrink());
    }
    
    public static final class DrinkMapper implements RowMapper<Drink>{
        
        @Override
        public Drink mapRow(ResultSet rs, int index) throws SQLException{
            Drink drink = new Drink();
            drink.setIdDrink(rs.getInt("idDrink"));
            drink.setStrDrink(rs.getString("strDrink"));
            drink.setStrDrinkAlternate(rs.getString("strDrinkAlternate"));
            drink.setStrAlcoholic(rs.getString("strAlcoholic"));
            drink.setStrCategory(rs.getString("strCategory"));
            drink.setStrDrinkThumb(rs.getString("strDrinkThumb"));
            drink.setStrGlass(rs.getString("strGlass"));
            drink.setStrIBA(rs.getString("strIBA"));
            drink.setStrTags(rs.getString("strTags"));
            drink.setStrVideo(rs.getString("strVideo"));
            drink.setStrInstructions(rs.getString("strInstructions"));
            
            drink.setStrIngredient1(rs.getString("strIngredient1"));
            drink.setStrIngredient2(rs.getString("strIngredient2"));
            drink.setStrIngredient3(rs.getString("strIngredient3"));
            drink.setStrIngredient4(rs.getString("strIngredient4"));
            drink.setStrIngredient5(rs.getString("strIngredient5"));
            drink.setStrIngredient6(rs.getString("strIngredient6"));
            drink.setStrIngredient7(rs.getString("strIngredient7"));
            drink.setStrIngredient8(rs.getString("strIngredient8"));
            drink.setStrIngredient9(rs.getString("strIngredient9"));
            drink.setStrIngredient10(rs.getString("strIngredient10"));
            drink.setStrIngredient11(rs.getString("strIngredient11"));
            drink.setStrIngredient12(rs.getString("strIngredient12"));
            drink.setStrIngredient13(rs.getString("strIngredient13"));
            drink.setStrIngredient14(rs.getString("strIngredient14"));
            drink.setStrIngredient15(rs.getString("strIngredient15"));
            
            drink.setStrMeasure1(rs.getString("strMeasure1"));
            drink.setStrMeasure2(rs.getString("strMeasure2"));
            drink.setStrMeasure3(rs.getString("strMeasure3"));
            drink.setStrMeasure4(rs.getString("strMeasure4"));
            drink.setStrMeasure5(rs.getString("strMeasure5"));
            drink.setStrMeasure6(rs.getString("strMeasure6"));
            drink.setStrMeasure7(rs.getString("strMeasure7"));
            drink.setStrMeasure8(rs.getString("strMeasure8"));
            drink.setStrMeasure9(rs.getString("strMeasure9"));
            drink.setStrMeasure10(rs.getString("strMeasure10"));
            drink.setStrMeasure11(rs.getString("strMeasure11"));
            drink.setStrMeasure12(rs.getString("strMeasure12"));
            drink.setStrMeasure13(rs.getString("strMeasure13"));
            drink.setStrMeasure14(rs.getString("strMeasure14"));
            drink.setStrMeasure15(rs.getString("strMeasure15"));
            return drink;
        }
    }
    
}
