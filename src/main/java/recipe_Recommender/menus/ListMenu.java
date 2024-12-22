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
                System.out.println(centerAlign("No recipes available.", 100));
                return;
            }

            int selection = intInput("Enter -1 to go back or select the recipe no. to view it:");
            if (selection == -1) return;

            list.viewRecipe(selection);
            int action = intInput("1. Back to the list\n2. Back to the main menu:");
            if (action == 2) return;
        }
    }
}
