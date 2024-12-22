import tech.tablesaw.api.Row;
import tech.tablesaw.api.Table;

import java.util.List;
import java.util.Random;

public class Search {
    private final Table dataset;

    public Search(Table dataset) {
        this.dataset = dataset;
    }

    public Table byIngredients() {
        List<String> query = Input.userStringList();
        if (query == null) {
            return null;
        }
        return dataset
                .where(dataset
                        .textColumn("ingredients")
                        .eval(entry -> query.stream()
                                    .allMatch(queryIngredient -> entry.toLowerCase()
                                            .contains(queryIngredient.toLowerCase()))));
    }

    public Table byName() {
        String name = Input.stringInput("Search recipe:");
        if (name.isBlank()) {
            System.out.println("Name cannot be empty.");
            return null;
        }
        return dataset
                .where(dataset
                        .textColumn("name")
                        .eval(entry -> entry.toLowerCase().contains(name.toLowerCase())));
    }

    public Table byKeywords() {
        List<String> keywords = Input.userStringList();
        if (keywords == null) {
            return null;
        }
        return dataset
                .where(dataset.textColumn("tags")
                        .eval(entry -> keywords.stream()
                                .allMatch(keyword -> entry.toLowerCase()
                                        .contains(keyword.toLowerCase()))));
    }

    public Row surpriseMe() {
        Random random = new Random();
        return dataset.row(random.nextInt(dataset.rowCount()));
    }
}
