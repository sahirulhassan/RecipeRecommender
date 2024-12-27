package recipeRecommender.menus;

import recipeRecommender.*;
import tech.tablesaw.api.Row;

import static recipeRecommender.RecipeRecommender.*;
import static recipeRecommender.Input.intInput;
import static recipeRecommender.View.viewRecipe;

public class RecipePage {
    private final Row recipe;

    public RecipePage(Row recipe) {
        this.recipe = recipe;
    }

    public void display() {
        viewRecipe(recipe);
        history.add(recipe);
        while (true) {
            int selection = intInput("""
                    
                    Select the recipe no. to view it,
                    or select an action:
                    
                    1. Add to Saved Recipes.
                    2. Add a Review.
                    3. View Reviews.
                    4. Back.
                    """);

            switch (selection) {
                case 1 -> {
                    saved.add(recipe);
                    System.out.println("Recipe saved.");
                }
                case 2 -> {
                    int rating = intInput("Rate this recipe (1-5):");
                    String review = Input.stringInput("Write a review for this recipe:");
                    reviews.addReview(username, recipe.getInt("id"), review, rating);
                    System.out.println("Review added successfully!\n");
                }
                case 3 -> reviews.displayReview(recipe.getInt("id"));
                case 4 -> {
                    System.out.println("Returning to the list.");
                    return;
                }
                default -> System.out.println("Error: Invalid selection.");
            }
        }
    }
}