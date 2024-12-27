package recipeRecommender.control;

import recipeRecommender.model.UserList;

import static recipeRecommender.view.Input.*;
import static recipeRecommender.view.View.*;

public class ListMenu {
    private final UserList list;
    private final String title;

    public ListMenu(UserList list, String title) {
        this.list = list;
        this.title = title;
    }

    public void display() {
        while (true) {
            System.out.println(centerAlign(title));
            list.view();

            if (list.isEmpty()) {
                System.out.println(centerAlign("No recipes available.\n"));
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

            new RecipePage(list.getRecipe(selection)).display();
        }
    }
}
