package recipe_Recommender;

import tech.tablesaw.api.Row;
import tech.tablesaw.api.Table;

import static recipe_Recommender.View.*;
import static recipe_Recommender.Input.*;


public class Menu {
    private static int selection;
    private static final Search search = new Search(datasetReader("src/main/resources/dataset.csv"));

    public static void mainMenu() throws Exception {
        System.out.println(centerAlign("Recipe Recommender", 100));
        while (true) {
            System.out.printf(
                    centerAlign(
                            "Main Menu", 100) + "\n\n" +
                            "1. Search Recipes\n" +
                            "2. Surprise me\n" +
                            "3. Recently Viewed\n" +
                            "4. View saved recipes\n" +
                            "5. Exit\n"
            );
            selection = intInput("Select from the menu:");
            switch (selection) {
                case 1:
                    searchMenu();
                    break;
                case 2:
                    Row surprise = search.surpriseMe();
                    fullRecipe(surprise);
                    break;
                case 3:
                    listMenu(history);
                    break;
                case 4:
                    listMenu(saved);
                    break;
                case 5:
                    System.out.println(centerAlign("Goodbye! Exiting...", 100));
                    return;
            }
        }
    }

    private static Table searchSelector(int searchMethod) throws Exception {
        return switch (searchMethod) {
            case 1 -> search.byIngredients();
            case 2 -> search.byName();
            case 3 -> search.byKeywords();
            default -> throw new Exception("Select a valid option.");
        };
    }

    private static void searchMenu() throws Exception {
        while (true) {
            System.out.println(centerAlign("Search Menu", 100));
            System.out.print(
                    "1. Search by Ingredients\n" +
                    "2. Search by Recipe Names\n" +
                    "3. Search by Keywords\n" +
                    "4. Back\n"
            );
            selection = intInput("Select from the menu:");
            Table filteredDataset;
            switch (selection) {
                case 1:
                    filteredDataset = searchSelector(1);
                    break;
                case 2:
                    filteredDataset = searchSelector(2);
                    break;
                case 3:
                    filteredDataset = searchSelector(3);
                    break;
                case 4:
                    System.out.println("Going back to the main menu...");
                    return;
                default:
                    throw new Exception("Select a valid option.");
            }
            while (true) {
                if (filteredDataset == null) {
                    break;
                }
                System.out.println(centerAlign("Found Results", 100));
                if (filteredDataset.isEmpty()) {
                    System.out.println(centerAlign("No recipes found.\n", 100));
                    break;
                }
                recipesList(filteredDataset);
                int recipeNo = intInput("Enter -1 to go back or select the recipe no. to view it.");
                if (recipeNo == -1) {
                    break;
                }
                fullRecipe(filteredDataset.row(recipeNo));
                selection = intInput("1. Back to the list\n2. Back to the search menu");
                switch (selection) {
                    case 1:
                        System.out.println("Going back to the recipes list...");
                        break;
                    case 2:
                        System.out.println("Going back to the Search Menu...");
                        return;
                }
            }
            System.out.println("Going back to the Search Menu...");
        }
    }

    public static void listMenu(RecipesList list) {
        while (true) {
            if (list == history) {
                System.out.println(centerAlign("HISTORY", 100));
            } else {
                System.out.println(centerAlign("SAVED RECIPES", 100));
            }
            list.viewList();
            if (list.isEmpty()) {
                break;
            }
            selection = intInput("Enter -1 to go back or select the recipe no. to view it.");
            if (selection == -1) {
                break;
            }
            list.viewRecipe(selection);
            selection = intInput("1. Back to the list\n2. Back to the search menu");
            switch (selection) {
                case 1:
                    break;
                case 2:
                    System.out.println("Going back to the Main Menu...");
                    return;
            }
        }
        System.out.println("Going back to the main menu...");
    }
}
