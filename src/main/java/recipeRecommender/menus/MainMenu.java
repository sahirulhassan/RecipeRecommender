package recipeRecommender.menus;

import recipeRecommender.Search;

import static recipeRecommender.View.*;
import static recipeRecommender.Input.*;

public class MainMenu {
    private static final int WIDTH = 100;
    private static final Search search = new Search(datasetReader("src/main/resources/dataset.csv"));

    public static void mainMenu() {
        while (true) {
            printHeader("Recipe Recommender", "Main Menu", WIDTH);
            System.out.println("""
                    1. Search Recipes
                    2. Surprise me
                    3. Recently Viewed
                    4. View Saved Recipes
                    5. View Ratings
                    6. View Reviews
                    7. Exit
                    """);
            int selection = intInput("Select from the menu:");
            switch (selection) {
                case 1 -> new SearchMenu(search).display();
                case 2 -> viewRecipe(search.surpriseMe());
                case 3 -> new ListMenu(history, "HISTORY").display();
                case 4 -> new ListMenu(saved, "SAVED RECIPES").display();
                case 5 -> {
                    System.out.println(centerAlign("Goodbye! Exiting...", WIDTH));
                    System.exit(0);
                }
                default -> System.out.println(centerAlign("Error: Invalid selection. Please try again.\n", WIDTH));
            }
        }
    }
}
