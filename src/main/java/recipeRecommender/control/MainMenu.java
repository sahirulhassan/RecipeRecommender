package recipeRecommender.control;

import recipeRecommender.model.Search;

import static recipeRecommender.Main.*;
import static recipeRecommender.view.View.*;
import static recipeRecommender.view.Input.*;

public class MainMenu {
    private static final Search search = new Search(datasetReader("src/main/resources/dataset.csv"));

    public static void mainMenu() {
        while (true) {
            printHeader("Recipe Recommender", "Main Menu");
            System.out.println("""
                    1. Search Recipes
                    2. Surprise me
                    3. Recently Viewed
                    4. View Saved Recipes
                    5. View User Reviews.
                    6. Exit
                    """);
            int selection = intInput("Select from the menu:");
            switch (selection) {
                case 1 -> new SearchMenu(search).display();
                case 2 -> new RecipePage(search.surpriseMe()).display();
                case 3 -> new ListMenu(history, "HISTORY").display();
                case 4 -> new ListMenu(saved, "SAVED RECIPES").display();
                case 5 -> reviews.displayReviews();
                case 6 -> {
                    System.out.println(centerAlign("Goodbye! Exiting..."));
                    System.exit(0);
                }
                default -> {
                    System.out.println(centerAlign("Error: Invalid selection. Please try again.\n"));
                    continue;
                }
            }
        }
    }
}
