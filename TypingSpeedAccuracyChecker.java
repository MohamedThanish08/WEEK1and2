package WEEK1and2;

import java.util.Scanner;

public class TypingSpeedAccuracyChecker {

  
    public static void checkTypingAccuracy(String original, String typed) {

        int matched = 0;
        int firstMismatch = -1;

        int comparisonLength = Math.min(original.length(), typed.length());

        for (int i = 0; i < comparisonLength; i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        
        if (original.length() != typed.length()) {
            if (firstMismatch == -1) {
                firstMismatch = comparisonLength;
            }
        }

      
        double accuracy = ((double) matched / original.length()) * 100;

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%",
                matched, original.length(), accuracy);

        
        if (firstMismatch == -1) {

            System.out.println(" | No Mismatches");

        } else {

            char originalChar = original.charAt(firstMismatch);

            String typedChar;

            if (firstMismatch < typed.length()) {
                typedChar = "'" + typed.charAt(firstMismatch) + "'";
            } else {
                typedChar = "missing";
            }

            System.out.println(
                    " | First Mismatch at position "
                    + (firstMismatch + 1)
                    + " ('"
                    + originalChar
                    + "' vs "
                    + typedChar
                    + ")"
            );
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter original passage: ");
        String original = scanner.nextLine();

        System.out.print("Enter typed text: ");
        String typed = scanner.nextLine();

        checkTypingAccuracy(original, typed);

        scanner.close();
    }
}