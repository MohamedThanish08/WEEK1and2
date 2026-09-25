package WEEK1and2;

import java.util.Scanner;

public class TrafficSignalStreakAnalyzer {

   
    public static void findLongestStreak(String signalLog) {

        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("Signal log is empty.");
            return;
        }

        char currentColor = signalLog.charAt(0);
        char longestColor = currentColor;

        int currentStreak = 1;
        int longestStreak = 1;

       
        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == currentColor) {
                
                currentStreak++;
            } else {
               
                currentColor = signalLog.charAt(i);
                currentStreak = 1;
            }

            
            if (currentStreak > longestStreak) {
                longestStreak = currentStreak;
                longestColor = currentColor;
            }
        }

        System.out.println(
                "Longest Streak: '" + longestColor
                        + "' repeated " + longestStreak + " times"
        );
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter signal log (R/Y/G): ");
        String signalLog = scanner.nextLine();

        findLongestStreak(signalLog);

        scanner.close();
    }
}