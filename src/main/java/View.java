import tech.tablesaw.api.Row;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;

import java.util.List;


public class View {
    public static RecipesList history = new RecipesList(10);
    public static RecipesList saved = new RecipesList(20);


    public static String centerAlign(String text, int width) {
        int padding = (width - text.length()) / 2;
        return " ".repeat(Math.max(padding, 0)) + text + " ".repeat(Math.max(padding, 0));
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


    }

    public static void recipesList(Table dataset) {
        Column<String> names = dataset.textColumn("name");

        int idx = 0;
        for (Object name : names) {
            System.out.printf("%3d %s %n", idx, name.toString().trim());
            idx++;
        }
        System.out.printf("\n%3d Back\n\n", -1);
    }

    public static void recipesList(List<Row> dataset) {
        int idx = 0;
        for (Row recipe : dataset) {
            System.out.printf("%3d %s %n", idx, recipe.getText("name").trim());
            idx++;
        }
        System.out.printf("\n%3d Back\n\n", -1);
    }
}
