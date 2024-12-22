package recipe_Recommender.menus;

import recipe_Recommender.Search;
import tech.tablesaw.api.Row;

import static recipe_Recommender.View.*;
import static recipe_Recommender.Input.*;

public class Menu {
    private static final int WIDTH = 100;
    private static final Search search = new Search(datasetReader("src/main/resources/dataset.csv"));

    public static void mainMenu() {
        while (true) {
            printHeader("Recipe Recommender", "Main Menu");
            System.out.println("""
                    1. Search Recipes
                    2. Surprise me
                    3. Recently Viewed
                    4. View Saved Recipes
                    5. Exit
                    """);
            int selection = intInput("Select from the menu:");
            switch (selection) {
                case 1 -> new SearchMenu(search).display();
                case 2 -> surpriseMe();
                case 3 -> new ListMenu(history, "HISTORY").display();
                case 4 -> new ListMenu(saved, "SAVED RECIPES").display();
                case 5 -> exitApplication();
                default -> System.out.println(centerAlign("Invalid selection. Please try again.", WIDTH));
            }
        }
    }

    private static void surpriseMe() {
        Row surprise = search.surpriseMe();
        fullRecipe(surprise);
    }

    private static void exitApplication() {
        System.out.println(centerAlign("Goodbye! Exiting...", WIDTH));
        System.exit(0);
    }

    private static void printHeader(String title, String subtitle) {
        System.out.println(centerAlign(title, WIDTH));
        System.out.println(centerAlign(subtitle, WIDTH));
    }
}
