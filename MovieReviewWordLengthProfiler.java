package WEEK1and2;

import java.util.Scanner;

public class MovieReviewWordLengthProfiler {

    
    public static void classifyWordLengths(String review) {

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

       
        String[] words = review.trim().split("\\s+");

        
        for (String word : words) {

            int length = word.length();

            if (length >= 1 && length <= 4) {
                shortCount++;
            } else if (length >= 5 && length <= 8) {
                mediumCount++;
            } else {
                longCount++;
            }
        }

       
        System.out.println(
                "Short: " + shortCount
                + " | Medium: " + mediumCount
                + " | Long: " + longCount
        );
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter movie review: ");
        String review = scanner.nextLine();

        classifyWordLengths(review);

        scanner.close();
    }
}