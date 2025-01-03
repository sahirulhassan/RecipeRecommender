package recipeRecommender.model;

public class Review {
    private final String reviewer;
    private final String review;
    private final int rating;

    public Review(String reviewer, String review, int rating) {
        this.reviewer = reviewer;
        this.review = review;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Reviewer: " + reviewer + "\nRating: " + rating + "\nReview: " + review;
    }
}