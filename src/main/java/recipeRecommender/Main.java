package recipeRecommender;

import recipeRecommender.model.Reviews;
import recipeRecommender.model.Search;
import recipeRecommender.model.UserList;

import static recipeRecommender.view.Input.stringInput;
import static recipeRecommender.view.View.centerAlign;
import static recipeRecommender.control.MainMenu.mainMenu;
import static recipeRecommender.view.View.datasetReader;

public class Main {
    public static String username;
    public static UserList history;
    public static UserList saved;
    public static Reviews reviews;
    public static Search search;
    public static int width;

    public Main() {
        username = stringInput("Enter your username:");
        System.out.println(centerAlign("\nWelcome to Recipe Recommender, " + username + "!"));
        System.out.println(centerAlign("Loading data...\n"));

        history = new UserList(10);
        saved = new UserList(20);
        reviews = new Reviews();
        width = 100;
        search = new Search(datasetReader("src/main/resources/dataset.csv"));
        mainMenu();
    }

    public static void main(String[] args) {
        new Main();
    }
}