package recipeRecommender;

import static recipeRecommender.View.centerAlign;
import static recipeRecommender.menus.MainMenu.mainMenu;

public class RecipeRecommender {
    public static String username;
    public static UserList history;
    public static UserList saved;
    public static Reviews reviews;
    public static int width;

    public RecipeRecommender() {
        username = Input.stringInput("Enter your username:");
        System.out.println(centerAlign("\nWelcome to Recipe Recommender, " + username + "!"));
        System.out.println(centerAlign("Loading data...\n"));

        history = new UserList(10);
        saved = new UserList(10);
        reviews = new Reviews();
        width = 100;
        mainMenu();
    }

    public static void main(String[] args) {
        new RecipeRecommender();
    }
}