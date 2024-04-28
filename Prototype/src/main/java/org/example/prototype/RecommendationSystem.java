package org.example.prototype;



import java.util.Scanner;


import java.util.ArrayList;
import java.util.List;


public class RecommendationSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample Recommendations (Modify as needed)
        List<Book> sciFiBooks = new ArrayList<>();
        sciFiBooks.add(new Book("Isaac Asimov", "Foundation","Science Fiction", 1951 ));
        sciFiBooks.add(new Book("Andy Weir", "The Martian", "Science Fiction", 2011));
        Recommendation sciFiRec = new Recommendation("Sci-Fi Fans", sciFiBooks);

        List<Book> fantasyBooks = new ArrayList<>();
        fantasyBooks.add(new Book("J.R.R. Tolkien", "The Lord of the Rings","Fantasy", 1954));
        fantasyBooks.add(new Book("George R.R. Martin", "A Game of Thrones", "Fantasy", 1996));
        Recommendation fantasyRec = new Recommendation("Fantasy Readers", fantasyBooks);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. View Recommendations");
            System.out.println("2. Clone and Modify Recommendation");
            System.out.println("3. Exit");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("\nExisting Recommendations:");
                System.out.println(sciFiRec);
                System.out.println(fantasyRec);
            } else if (choice.equals("2")) {
                System.out.println("\nSelect Recommendation to Clone:");
                System.out.println("1. " + sciFiRec.getTargetAudience());
                System.out.println("2. " + fantasyRec.getTargetAudience());

                String cloneChoice = scanner.nextLine();
                Recommendation newRec = null;
                if (cloneChoice.equals("1")) {
                    try {
                        newRec = sciFiRec.clone();
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                } else if (cloneChoice.equals("2")) {
                    try {
                        newRec = fantasyRec.clone();
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Invalid Choice!");
                }

                if (newRec != null) {
                    modifyRecommendation(newRec);
                }
            } else if (choice.equals("3")) {
                break;
            } else {
                System.out.println("Invalid Choice!");
            }
        }
    }

    private static void modifyRecommendation(Recommendation rec) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nModifying Recommendation for: " + rec.getTargetAudience());
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Change Target Audience");
        System.out.println("4. Cancel");

        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            System.out.println("Enter Author:");
            String author = scanner.nextLine();
            System.out.println("Enter Title:");
            String title = scanner.nextLine();
            System.out.println("Enter Genre:");
            String genre = scanner.nextLine();
            System.out.println("Enter Publication Year:");
            int publicationYear = Integer.parseInt(scanner.nextLine());

            rec.addBook(new Book(author, title,genre, publicationYear));
        } else if (choice.equals("2")) {
            System.out.println("Enter Book Index to Remove:");
            int index = Integer.parseInt(scanner.nextLine());
            rec.removeBook(index);
        } else if (choice.equals("3")) {
            System.out.println("Enter New Target Audience:");
            String newAudience = scanner.nextLine();
            rec.setTargetAudience(newAudience);
        } else if (choice.equals("4")) {
            return;
        } else {
            System.out.println("Invalid Choice!");
        }
    }
}


