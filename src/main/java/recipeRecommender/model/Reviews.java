package recipeRecommender.model;

import recipeRecommender.view.View;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Reviews {
    private final Map<Integer, List<Review>> reviews = new HashMap<>();

    public void addReview(String name, int id, String review, int rating) {
        if (rating < 1 || rating > 5) {
            System.out.println("Invalid rating! Please enter a value between 1 and 5.");
            return;
        }

        Review reviewObj = new Review(name, review, rating);
        if (!reviews.containsKey(id)) { // If the recipe does not have any reviews yet
            List<Review> reviewList = new ArrayList<>();
            reviewList.add(reviewObj);
            reviews.put(id, reviewList);
            return;
        }
        // If the recipe already has reviews, add the new review to the list
        reviews.get(id).add(reviewObj);
        System.out.println("Review added successfully!");
    }

    public void displayReviews() {
        System.out.println(View.centerAlign("REVIEWS"));
        if (reviews.isEmpty()) {
            System.out.println("\nNo reviews available.\n");
            return;
        }
        for (Map.Entry<Integer, List<Review>> entry : reviews.entrySet()) {
            System.out.println("\nRecipe: " + entry.getKey());
            for (Review review : entry.getValue()) {
                System.out.println(review);
            }
        }
    }

    public void displayReview(int id) {
        System.out.println(View.centerAlign("REVIEWS"));
        if (!reviews.containsKey(id)) {
            System.out.println("No reviews available for this recipe.");
            return;
        }
        System.out.println("\nRecipe: " + id);
        for (Review review : reviews.get(id)) {
            System.out.println(review);
        }
    }
}
