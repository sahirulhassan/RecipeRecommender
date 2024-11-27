import tech.tablesaw.api.Table;

import java.util.Arrays;

public class Search {

    private final Table dataset;

    public Search(Table dataset) {
        this.dataset = dataset;
    }

    public Table byIngredients(String[] query) {
        return dataset
                .where(dataset
                        .textColumn("ingredients")
                        .eval(entry -> {
                            return Arrays.stream(query)
                                    .allMatch(queryIngredient -> entry.toLowerCase()
                                            .contains(queryIngredient.toLowerCase()));
                        }));
    }

        public Table byName(String name) {
        return dataset
                .where(dataset
                        .textColumn("name")
                        .eval(entry -> entry.toLowerCase().contains(name.toLowerCase())));
    }
}
