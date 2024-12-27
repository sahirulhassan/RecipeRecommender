package recipeRecommender;

import recipeRecommender.model.Reviews;
import recipeRecommender.model.UserList;
import recipeRecommender.view.Input;

import static recipeRecommender.view.View.centerAlign;
import static recipeRecommender.control.MainMenu.mainMenu;

public class Main {
    public static String username;
    public static UserList history;
    public static UserList saved;
    public static Reviews reviews;
    public static int width;

    public Main() {
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
        new Main();
    }
}