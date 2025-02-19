package recipeRecommender.view;

import tech.tablesaw.api.Row;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;
import tech.tablesaw.io.csv.CsvReadOptions;

import static recipeRecommender.Main.width;

public class View {

    public static Table datasetReader(String filepath) { // to customize how the CSV file should be read
        CsvReadOptions options = CsvReadOptions.builder(filepath)
                .maxCharsPerColumn(13000)
                .build(); // build instantiates the CsvReadOptions object.
                return Table.read().csv(options);
    }

    public static String centerAlign(String text) {
        int padding = (width - text.length()) / 2;
        return " ".repeat(Math.max(padding, 0)) + text + " ".repeat(Math.max(padding, 0));
    }

    public static void printHeader(String title, String subtitle) {
        System.out.println(centerAlign(title));
        System.out.println(centerAlign(subtitle));
    }

    public static void viewRecipe(Row recipe) {

        int id = recipe.getInt("id");

        String name = recipe.getText("name").trim();
        String desc = recipe.getText("description").trim();

        int servings = recipe.getInt("servings");

        String servingSize = recipe.getText("serving_size").trim();

        String ingredients = recipe.getText("ingredients_raw").trim();

        String steps = recipe.getText("steps").trim();

        System.out.printf(
                centerAlign(String.valueOf(id)) + "\n" +
                centerAlign(name) + "\n\n" +
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
    }

    public static void viewRecipes(Table dataset) {
        Column<String> names = dataset.textColumn("name");
        int numberOfRecipes = names.size();
        System.out.println(centerAlign("\nFound " + numberOfRecipes + " recipes\n"));

        int idx = 0;
        int count = 1;
        for (String name : names) {
            System.out.printf("%3d %s %n", idx, name.trim());
            idx++;
            count++;
            if (count > 20) {
                count = 1;
                if (Input.stringInput("View more recipes? (y/n)").equalsIgnoreCase("n")) {
                    break;
                }
            }
        }
    }
}