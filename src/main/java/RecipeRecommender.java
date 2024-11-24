import com.fasterxml.jackson.core.JsonProcessingException;
import tech.tablesaw.columns.Column;
import tech.tablesaw.io.csv.CsvReadOptions;
import tech.tablesaw.api.Table;
import com.fasterxml.jackson.databind.ObjectMapper;
import static utility.Input.userStringArr;


public class RecipeRecommender {
    public static Table datasetReader(String filepath) {
        CsvReadOptions options = CsvReadOptions.builder(filepath)
                .maxCharsPerColumn(13000)
                .build();
        return Table.read().csv(options);
    }

    public static Table filter(Table dataset, String[] list) throws JsonProcessingException {
        Column ingredientsCol = dataset.column("ingredients");
        ObjectMapper objectMapper = new ObjectMapper();
        Table filteredDataset = dataset.emptyCopy();
        for (int i = 0; i < ingredientsCol.size(); i++) {
            String ingredientsStr = ingredientsCol.get(i).toString();
            String[] ingredientsArr = objectMapper.readValue(ingredientsStr, String[].class);
            if(ArrayComparison.isArraySubset(ingredientsArr, list)) {
                filteredDataset.append(dataset.row(i));
            }
        }
        return filteredDataset;
    }

    public static void main(String[] args) throws JsonProcessingException {
        Table dataset = datasetReader("src/main/java/recipes_ingredients.csv");
        String[] userValues = userStringArr();
        Table filteredDataset = filter(dataset, userValues);
        System.out.println(filteredDataset.rowCount());
        //represent the filtered data!
    }
}
