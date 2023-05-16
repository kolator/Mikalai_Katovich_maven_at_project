package classwork.day14052023;

import java.util.List;

public class Recipe {
    private String recipename;
    private List<Ingredient> ingredlist;
    private int preptime;

     public Recipe(String recipeName, List<Ingredient> ingredientList, int prepTime) {
        this.recipename = recipeName;
        this.ingredlist = ingredientList;
        this.preptime = prepTime;
    }

    public String getRecipeName() {
        return recipename;
    }

    public void setRecipeName(String recipeName) {
        this.recipename = recipeName;
    }

    public List<Ingredient> getIngredientList() {
        return ingredlist;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredlist = ingredientList;
    }

    public int getPreptime() {
        return preptime;
    }

    public void setPreptime(int preptime) {
        this.preptime = preptime;
    }
}
