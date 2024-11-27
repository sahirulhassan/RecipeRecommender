import tech.tablesaw.api.Row;
import tech.tablesaw.api.Table;
import utility.Input;

import java.util.Arrays;
import java.util.Random;

public class Search {

    private final Table dataset;

    public Search(Table dataset) {
        this.dataset = dataset;
    }

    public Table byIngredients() {
        String[] query = Input.userStringArr();
        return dataset
                .where(dataset
                        .textColumn("ingredients")
                        .eval(entry -> Arrays.stream(query)
                                    .allMatch(queryIngredient -> entry.toLowerCase()
                                            .contains(queryIngredient.toLowerCase()))));
    }

    public Table byName() {
        String name = Input.stringInput("Search recipe:");
        return dataset
                .where(dataset
                        .textColumn("name")
                        .eval(entry -> entry.toLowerCase().contains(name.toLowerCase())));
    }

    public Table byKeywords() {
        String[] keywords = Input.userStringArr();
        return dataset
                .where(dataset.textColumn("tags")
                        .eval(entry -> Arrays.stream(keywords)
                                .allMatch(keyword -> entry.toLowerCase()
                                        .contains(keyword.toLowerCase()))));
    }

    public Row surpriseMe() {
        Random random = new Random();
        return dataset.row(random.nextInt(dataset.rowCount()));
    }
}
