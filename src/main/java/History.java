import tech.tablesaw.api.*;

import java.util.LinkedList;
import java.util.List;

public class History {
    private final List<Row> history;
    private final int maxSize;
    private Table table;

    public History(int maxSize) {
        history = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public void add(Row recipe) {
        if (history.size() == maxSize) {
            history.removeLast();
        }
        history.addFirst(recipe);
    }

    public void viewList() {
        System.out.println(View.centerAlign("RECENTLY VIEWED", 100));
        if (history.isEmpty()) {
            System.out.println(View.centerAlign("No history yet.", 100));
            return;
        }
        table = Table.create("History") //We already have a method to print the recipes list so for reusability's sake we will use it by creating a table.
                .addColumns(
                IntColumn.create("id"),
                TextColumn.create("name"),
                TextColumn.create("description"),
                TextColumn.create("ingredients"),
                TextColumn.create("ingredients_raw"),
                TextColumn.create("steps"),
                IntColumn.create("servings"),
                StringColumn.create("serving_size"),
                TextColumn.create("tags")
        );
        for (Row recipe : history) {
            table.append(recipe);
        }
        View.recipesList(table);
    }

    public void viewRecipe(int index) {
        Row recipe = table.row(index);
        View.fullRecipe(recipe);
    }
}
