import com.fasterxml.jackson.core.JsonProcessingException;
import tech.tablesaw.api.Row;
import tech.tablesaw.api.Table;
import com.fasterxml.jackson.databind.ObjectMapper;


public class View {
    public static String centerAlign(String text, int width) {
        int padding = (width - text.length()) / 2;
        return " ".repeat(Math.max(padding, 0)) + text + " ".repeat(Math.max(width - text.length() - padding, 0));
    }

    public static void fullRecipe(Row row) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        int id = row.getInt("id");

        String name = row.getText("name").trim();
        String desc = row.getText("description").trim();

        int servings = row.getInt("servings");

        String servingSize = row.getText("serving_size");

        String ingredientsRaw = row.getText("ingredients_raw");
        String[] ingredientsArr = objectMapper.readValue(ingredientsRaw, String[].class);
        StringBuilder ingredients = new StringBuilder(String.join("\n", ingredientsArr));

        String stepsRaw = row.getText("steps");
        String[] stepsArr = objectMapper.readValue(stepsRaw, String[].class);
        StringBuilder steps = new StringBuilder(String.join("\n", stepsArr));

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
                        "%s",
                desc, servings, servingSize, ingredients, steps
        );
    }
}
