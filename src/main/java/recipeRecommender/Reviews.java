package recipeRecommender;

import java.util.ArrayList;
import java.util.List;

import static recipeRecommender.View.centerAlign;

public class Reviews {
    private final List<String> recipeNames = new ArrayList<>();
    private final List<List<String>> allReviews = new ArrayList<>();

    public void addReview(String name, String review) {
        int index = recipeNames.indexOf(name);
        if (index == -1) {
            recipeNames.add(name);
            allReviews.add(new ArrayList<>());
            index = recipeNames.size() - 1;
        }
        allReviews.get(index).add(review);
        System.out.println("Review added successfully!");
    }

    public void displayReviews() {
        System.out.println(centerAlign("REVIEWS", 100));
        if (recipeNames.isEmpty()) {
            System.out.println("No reviews available.");
            return;
        }
        for (int i = 0; i < recipeNames.size(); i++) {
            System.out.println("\nRecipe: " + recipeNames.get(i));
            for (String review : allReviews.get(i)) {
                System.out.println("- " + review);
            }
        }
    }
}