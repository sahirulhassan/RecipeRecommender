import tech.tablesaw.api.*;

import java.util.LinkedList;
import java.util.List;

public class History {
    private final List<Row> history;
    private final int maxSize;

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
            System.out.println(View.centerAlign("No history yet.\n", 100));
            return;
        }
        View.recipesList(history);
    }

    public void viewRecipe(int index) {
        Row recipe = history.get(index);
        View.fullRecipe(recipe);
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }
}
