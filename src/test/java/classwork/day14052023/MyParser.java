package classwork.day14052023;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class MyParser {
    private static final String JSON = "src/test/resources/recipe.json";

    public static void main(String[] args) throws IOException {
        MyParser myParser = new MyParser();
        myParser.parseGSON();
        myParser.printGSON();
    }

    public void parseGSON() throws IOException {
        Gson gson = new Gson();
        Recipe recipe = gson.fromJson(new JsonReader(new FileReader(JSON)), Recipe.class);
        System.out.println(recipe.getIngredientList());
        System.out.println(recipe.getPreptime());
        System.out.println(recipe.getRecipeName());
    }

    public void printGSON() {
        Gson gson = new Gson();
        Recipe recipe = new Recipe("Borsch2", List.of(new Ingredient("Meat", 1)), 33);
        System.out.println(gson.toJson(recipe));
    }

    public static String fromGSON(Search search){
        Gson gson = new Gson();
        return gson.toJson(search);
    }
}

