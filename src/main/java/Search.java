import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.tablesaw.api.Table;

import java.util.Arrays;

public class Search {

    private final Table dataset;

    public Search(Table dataset) {
        this.dataset = dataset;
    }
//    Deprecated:
//    public Table byIngredients(String[] list) throws JsonProcessingException {
//        Column ingredientsCol = dataset.column("ingredients");
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        Table filteredDataset = dataset.emptyCopy();
//        for (int i = 0; i < ingredientsCol.size(); i++) {
//            String ingredientsStr = ingredientsCol.get(i).toString();
//            String[] ingredientsArr = objectMapper.readValue(ingredientsStr, String[].class);
//            if(ArrayComparison.isArraySubset(ingredientsArr, list)) {
//                filteredDataset.append(dataset.row(i));
//            }
//        }
//        return filteredDataset;
//    }

    public Table byIngredients(String[] query) {
        ObjectMapper mapper = new ObjectMapper();
        return dataset
                .where(dataset
                        .textColumn("ingredients")
                        .eval(entry -> {
            try {
                String[] ingredientsEntry = mapper.readValue(entry, String[].class);
                String stringifiedEntry = String.join(" ", ingredientsEntry)
                        .toLowerCase();
                return Arrays.stream(query)
                        .allMatch(queryIngredient -> stringifiedEntry
                                .contains(queryIngredient.toLowerCase()));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } ));
    }

    public Table byName(String name) {
        return dataset
                .where(dataset
                        .textColumn("name")
                        .eval(entry -> entry.equalsIgnoreCase(name)));
    }
}
