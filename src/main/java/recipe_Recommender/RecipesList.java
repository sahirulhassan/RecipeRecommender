package recipe_Recommender;

import tech.tablesaw.api.*;

import java.util.LinkedList;
import java.util.List;

public class RecipesList {
    private final List<Row> recipes;
    private final int maxSize;

    public RecipesList(int maxSize) {
        recipes = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public void add(Row recipe) {
        if (recipes.size() == maxSize) { // Remove the last recipe if the history is full
            recipes.removeLast();
        }
        if (recipes.contains(recipe)) { // Remove the recipe if it already exists in the history
            recipes.remove(recipe);
        }

        recipes.addFirst(recipe); // Add the recipe to the beginning of the list
    }

    public void viewList() {
        if (recipes.isEmpty()) {
            System.out.println(View.centerAlign("No recipes yet.\n", 100));
            return;
        }
        View.recipesList(recipes);
    }

    public void viewRecipe(int index) {
        Row recipe = recipes.get(index);
        View.fullRecipe(recipe);
    }

    public boolean isEmpty() {
        return recipes.isEmpty();
    }
}
