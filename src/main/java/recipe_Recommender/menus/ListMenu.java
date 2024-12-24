package recipe_Recommender.menus;

import recipe_Recommender.RecipesList;

import static recipe_Recommender.Input.*;
import static recipe_Recommender.View.*;

public class ListMenu {
    private final RecipesList list;
    private final String title;

    public ListMenu(RecipesList list, String title) {
        this.list = list;
        this.title = title;
    }

    public void display() {
        while (true) {
            System.out.println(centerAlign(title, 100));
            list.viewList();

            if (list.isEmpty()) {
                System.out.println(centerAlign("No recipes available.\n", 100));
                return;
            }

            int selection = intInput("""
                    
                    Select the recipe no. to view it,
                    or select an action:
                    
                    -1. Delete a recipe.
                    -2. Delete all recipes.
                    -3. Back.
                    """);

            if (selection == -1) {
                int recipeIndex = intInput("Enter the recipe no. to delete:");
                list.delete(recipeIndex);
                continue;
            }
            if (selection == -2) {
                list.deleteAll();
                continue;
            }
            if (selection == -3) return;

            if (selection < -3 || selection > list.getSize()) { // Invalid selection handling.
                System.out.println("Error: Enter a valid selection.\n");
                continue;
            }

            list.viewRecipe(selection);
            int action = intInput("1. Back to the list\n2. Back to the main menu:");
            if (action == 2) return;
        }
    }
}
