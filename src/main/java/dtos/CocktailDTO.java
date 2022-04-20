package dtos;

import entities.Cocktails;
import java.util.ArrayList;
import java.util.List;

public class CocktailDTO {
    private long id;
    private String ingredient1;
    private String ingredient2;
    private String ingredient3;

    public CocktailDTO(String ingredient1, String ingredient2, String ingredient3) {
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
    }

    public CocktailDTO(Cocktails cocktail) {
        if (cocktail.getId() != null) {
            this.id = cocktail.getId();
        }
        this.ingredient1 = cocktail.getIngredient1();
        this.ingredient2 = cocktail.getIngredient2();
        this.ingredient3 = cocktail.getIngredient3();
    }

    public static List<CocktailDTO> getDtos(List<Cocktails> cocktailsList) {
        List<CocktailDTO> cocktailDTOs = new ArrayList<>();
        cocktailsList.forEach(cocktails -> cocktailDTOs.add(new CocktailDTO(cocktails)));
        return cocktailDTOs;
    }

    public String getIngredient1() {
        return ingredient1;
    }

    public void setIngredient1(String ingredient1) {
        this.ingredient1 = ingredient1;
    }

    public String getIngredient2() {
        return ingredient2;
    }

    public void setIngredient2(String ingredient2) {
        this.ingredient2 = ingredient2;
    }

    public String getIngredient3() {
        return ingredient3;
    }

    public void setIngredient3(String ingredient3) {
        this.ingredient3 = ingredient3;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CocktailDTO{" +
                "id=" + id +
                ", ingredient1='" + ingredient1 + '\'' +
                ", ingredient2='" + ingredient2 + '\'' +
                ", ingredient3='" + ingredient3 + '\'' +
                '}';
    }
}
