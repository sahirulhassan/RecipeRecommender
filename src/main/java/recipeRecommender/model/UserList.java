package recipeRecommender.model;

import recipeRecommender.view.Input;
import tech.tablesaw.api.*;

import java.util.LinkedList;
import java.util.List;

public class UserList {
    private final List<Row> recipes;
    private final int maxSize;

    public UserList(int maxSize) {
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

    public void view() {
        int idx = 0;
        for (Row recipe : recipes) {
            System.out.printf("%3d %s %n", idx, recipe.getText("name").trim());
            idx++;
            if (idx > 20) {
                if (Input.stringInput("View more recipes? (y/n)").equalsIgnoreCase("n")) {
                    break;
                }
            }
        }
    }

    public Row getRecipe(int index) {
         return recipes.get(index);
    }

    public void delete(int index) {
        recipes.remove(index);
        System.out.println("Recipe" + index + " deleted.");
    }

    public void deleteAll() {
        recipes.clear();
        System.out.println("All recipes deleted.");
    }

    public int getSize() {
        return maxSize;
    }

    public boolean isEmpty() {
        return recipes.isEmpty();
    }
}
