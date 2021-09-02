DROP DATABASE IF EXISTS mixerdb;
CREATE DATABASE mixerdb;
USE mixerdb;

CREATE TABLE ingredient(
	idIngredient INT AUTO_INCREMENT NOT NULL,
    strIngredient VARCHAR(100) NOT NULL,
    strDescription VARCHAR(500) NOT NULL,
    strType VARCHAR(100) NOT NULL,
    strAlcohol VARCHAR(10),
    strABV VARCHAR (10),
    PRIMARY KEY (idIngredient));
    
CREATE TABLE drink(
	idDrink INT AUTO_INCREMENT NOT NULL,
    PRIMARY KEY (idDrink),
    strDrink VARCHAR(100) NOT NULL,
    strDrinkAlternate VARCHAR(100),
    strTags VARCHAR(200),
    strVideo VARCHAR(100),
    strCategory VARCHAR(100),
    strIBA VARCHAR(100),
    strAlcoholic VARCHAR(15),
    strGlass VARCHAR(100),
    strInstructions VARCHAR(1000) NOT NULL,
    strDrinkThumb VARCHAR(150),
    strIngredient1 VARCHAR(50) NOT NULL,
    strIngredient2 VARCHAR(50),
    strIngredient3 VARCHAR(50),
    strIngredient4 VARCHAR(50),
    strIngredient5 VARCHAR(50),
    strIngredient6 VARCHAR(50),
    strIngredient7 VARCHAR(50),
    strIngredient8 VARCHAR(50),
    strIngredient9 VARCHAR(50),
    strIngredient10 VARCHAR(50),
    strIngredient11 VARCHAR(50),
    strIngredient12 VARCHAR(50),
    strIngredient13 VARCHAR(50),
    strIngredient14 VARCHAR(50),
    strIngredient15 VARCHAR(50),
    
    strMeasure1 VARCHAR(10) NOT NULL,
    strMeasure2 VARCHAR(10),
    strMeasure3 VARCHAR(10),
    strMeasure4 VARCHAR(10),
    strMeasure5 VARCHAR(10),
    strMeasure6 VARCHAR(10),
    strMeasure7 VARCHAR(10),
    strMeasure8 VARCHAR(10),
    strMeasure9 VARCHAR(10),
    strMeasure10 VARCHAR(10),
    strMeasure11 VARCHAR(10),
    strMeasure12 VARCHAR(10),
    strMeasure13 VARCHAR(10),
    strMeasure14 VARCHAR(10),
    strMeasure15 VARCHAR(10)
);