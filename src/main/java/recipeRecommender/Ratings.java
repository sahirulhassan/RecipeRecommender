package recipeRecommender;

import java.util.ArrayList;
import java.util.List;

import static recipeRecommender.View.centerAlign;

public class Ratings {
    private final List<String> recipeNames = new ArrayList<>();
    private final List<List<Integer>> allRatings = new ArrayList<>();

    public void addRating(String name, int rating) {
        if (rating < 1 || rating > 5) {
            System.out.println("Invalid rating! Please enter a value between 1 and 5.");
            return;
        }
        int index = recipeNames.indexOf(name);
        if (index == -1) {
            recipeNames.add(name);
            allRatings.add(new ArrayList<>());
            index = recipeNames.size() - 1;
        }
        allRatings.get(index).add(rating);
        System.out.println("Rating added successfully!");
    }

    public void displayRatings() {
        System.out.println(centerAlign("RATINGS", 100));
        if (recipeNames.isEmpty()) {
            System.out.println("No ratings available.");
            return;
        }
        for (int i = 0; i < recipeNames.size(); i++) {
            System.out.println("Recipe: " + recipeNames.get(i));
            System.out.println("Ratings: " + allRatings.get(i));
        }
    }
}