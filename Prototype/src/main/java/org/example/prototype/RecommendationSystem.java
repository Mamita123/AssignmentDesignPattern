package org.example.prototype;

import java.util.Scanner;

public class RecommendationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create initial recommendation
        Recommendation recommendation = new Recommendation("Young Adults");

        // Add some books to the recommendation
        recommendation.addBook(new Book("The Hunger Games", "Suzanne Collins", "Young Adult", 2008));
        recommendation.addBook(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "Fantasy", 1997));

        // Display recommendation
        System.out.println("Initial Recommendation:");
        System.out.println(recommendation);

        // Clone recommendation and modify
        Recommendation clonedRecommendation = recommendation.clone();
        clonedRecommendation.setTargetAudience("Adults");
        clonedRecommendation.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Classic", 1925));

        // Display cloned recommendation
        System.out.println("\nCloned and Modified Recommendation:");
        System.out.println(clonedRecommendation);

        scanner.close();}}


