import tech.tablesaw.io.csv.CsvReadOptions;
import tech.tablesaw.api.Table;
import java.util.Scanner;
import static utility.Input.userStringArr;


public class RecipeRecommender {
    public static Table datasetReader(String filepath) {
        CsvReadOptions options = CsvReadOptions.builder(filepath)
                .maxCharsPerColumn(13000)
                .build();
        return Table.read().csv(options);
    }

    public static void main(String[] args) {
        Table dataset = datasetReader("src/main/resources/dataset_cleaned.csv");
        Search search = new Search(dataset);
        String[] userQuery = userStringArr();
        Table filteredDataset = search.byIngredients(userQuery);
        //Table filteredDataset = search.byName("pizza");
        View.recipesList(filteredDataset);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the recipe no.:");
        int selection = scanner.nextInt();
        scanner.close();
        View.fullRecipe(filteredDataset.row(selection));
    }
}