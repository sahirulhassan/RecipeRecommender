package recipe_Recommender;

import tech.tablesaw.api.Row;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;
import tech.tablesaw.io.csv.CsvReadOptions;

import java.util.List;


public class View {
    public static RecipesList history = new RecipesList(10);
    public static RecipesList saved = new RecipesList(20);


    public static Table datasetReader(String filepath) {
        CsvReadOptions options = CsvReadOptions.builder(filepath)
                .maxCharsPerColumn(13000)
                .build();
        return Table.read().csv(options);
    }

    public static String centerAlign(String text, int width) {
        int padding = (width - text.length()) / 2;
        return " ".repeat(Math.max(padding, 0)) + text + " ".repeat(Math.max(padding, 0));
    }

    public static void printHeader(String title, String subtitle, int WIDTH) {
        System.out.println(centerAlign(title, WIDTH));
        System.out.println(centerAlign(subtitle, WIDTH));
    }

    public static void fullRecipe(Row recipe) {

        int id = recipe.getInt("id");

        String name = recipe.getText("name").trim();
        String desc = recipe.getText("description").trim();

        int servings = recipe.getInt("servings");

        String servingSize = recipe.getText("serving_size").trim();

        String ingredients = recipe.getText("ingredients_raw").trim();

        String steps = recipe.getText("steps").trim();

        System.out.printf(
                centerAlign(String.valueOf(id), 100) + "\n" +
                centerAlign(name, 100) + "\n\n" +
                "Description:\n" +
                        "%s\n\n" +
                        "Servings: %s\n" +
                        "Serving Size: %s\n\n" +
                        "Ingredients:\n" +
                        "%s\n\n" +
                        "Steps:\n" +
                        "%s\n\n",
                desc, servings, servingSize, ingredients, steps
        );
        history.add(recipe);
        if (Input.stringInput("Add to saved recipes? (y/n)").equalsIgnoreCase("y")) {
            saved.add(recipe);
            System.out.println("Recipe saved.");
        } else {
            System.out.println("Recipe not saved.");
            System.out.println("Going back...");
        }
    }

    public static void recipesList(Table dataset) {
        Column<String> names = dataset.textColumn("name");

        int idx = 0;
        for (Object name : names) {
            System.out.printf("%3d %s %n", idx, name.toString().trim());
            idx++;
        }
    }

    public static void recipesList(List<Row> dataset) {
        int idx = 0;
        for (Row recipe : dataset) {
            System.out.printf("%3d %s %n", idx, recipe.getText("name").trim());
            idx++;
        }
    }
}