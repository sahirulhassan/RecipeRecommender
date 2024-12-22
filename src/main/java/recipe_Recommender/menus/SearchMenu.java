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
            printHeader("Search Menu");
            System.out.println("""
                    1. Search by Ingredients
                    2. Search by Recipe Names
                    3. Search by Keywords
                    4. Back
                    """);
            int selection = intInput("Select from the menu:");
            if (selection == 4) return;

            Table filteredDataset = searchSelector(selection);
            if (filteredDataset == null) continue;

            displayResults(filteredDataset);
        }
    }

    private Table searchSelector(int searchMethod) {
        return switch (searchMethod) {
            case 1 -> search.byIngredients();
            case 2 -> search.byName();
            case 3 -> search.byKeywords();
            default -> {
                System.out.println(centerAlign("Invalid option. Try again.", WIDTH));
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

            fullRecipe(filteredDataset.row(recipeNo));
            int selection = intInput("1. Back to the list\n2. Back to the search menu:");
            if (selection == 2) return;
        }
    }

    private void printHeader(String title) {
        System.out.println(centerAlign(title, WIDTH));
    }
}
