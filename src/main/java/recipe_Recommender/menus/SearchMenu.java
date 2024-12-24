package recipe_Recommender.menus;

import recipe_Recommender.Search;
import tech.tablesaw.api.Table;

import static recipe_Recommender.Input.*;
import static recipe_Recommender.View.*;

public class SearchMenu {
    private static final int WIDTH = 100;
    private final Search search;

    public SearchMenu(Search search) {
        this.search = search;
    }

    public void display() {
        while (true) {
            printHeader("Search Menu", "Search for recipes", WIDTH);
            System.out.println("""
                    1. Search by Ingredients
                    2. Search by Recipe Names
                    3. Search by Keywords
                    4. Back
                    """);
            int selection = intInput("Select from the menu:");
            if (selection == 4) return;

            Table filteredDataset = searchSelector(selection);
            if (filteredDataset == null) continue; // skips the rest of the loop and restarts the loop.

            displayResults(filteredDataset);
        }
    }

    private Table searchSelector(int searchMethod) {
        return switch (searchMethod) {
            case 1 -> search.byIngredients();
            case 2 -> search.byName();
            case 3 -> search.byKeywords();
            default -> {
                System.out.println(centerAlign("Invalid option. Try again.\n", WIDTH));
                yield null;
            }
        };
    }

    private void displayResults(Table filteredDataset) {
        while (true) {
            if (filteredDataset.isEmpty()) {
                System.out.println(centerAlign("No recipes found.\n", WIDTH));
                return;
            }
            recipesList(filteredDataset);
            int recipeNo = intInput("Enter -1 to go back or select the recipe no. to view it:");
            if (recipeNo == -1) return;
            if (recipeNo >= filteredDataset.rowCount()) { // if the recipe number is out of bounds.
                System.out.println("Error: Invalid recipe number. Try again.\n");
                continue;
            }

            fullRecipe(filteredDataset.row(recipeNo));
            int selection = intInput("1. Back to the list\n2. Back to the search menu:");
            if (selection == 2) return;
            if (selection != 1) {
                System.out.println("Error: Invalid selection. Try again.\n");
            }
        }
    }
}
