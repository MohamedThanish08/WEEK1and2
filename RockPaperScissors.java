package WEEK1and2;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    
    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {

            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int N = 5;

        String[] moves = {"Rock", "Paper", "Scissors"};

        String[] playerMoves = new String[N];
        String[] computerMoves = new String[N];
        String[] results = new String[N];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        
        for (int i = 0; i < N; i++) {

            System.out.print("Round " + (i + 1)
                    + " - Enter Rock, Paper, or Scissors: ");

            String playerMove = sc.nextLine();

           
            playerMove = playerMove.substring(0, 1).toUpperCase()
                    + playerMove.substring(1).toLowerCase();

           
            if (!playerMove.equals("Rock")
                    && !playerMove.equals("Paper")
                    && !playerMove.equals("Scissors")) {

                System.out.println("Invalid move! Try again.");
                i--;
                continue;
            }

           
            String computerMove = moves[random.nextInt(3)];

            
            String result = playRound(playerMove, computerMove);

            
            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println("Computer: " + computerMove);
            System.out.println("Result: " + result);
            System.out.println();
        }

       
        double winPercentage = (wins * 100.0) / N;

        
        System.out.println("\n========== FINAL SUMMARY ==========");

        System.out.printf("%-8s %-15s %-17s %-15s%n",
                "Round", "Player Move", "Computer Move", "Result");

        for (int i = 0; i < N; i++) {

            System.out.printf("%-8d %-15s %-17s %-15s%n",
                    i + 1,
                    playerMoves[i],
                    computerMoves[i],
                    results[i]);
        }

        System.out.println("===================================");

        System.out.println("Wins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);

        System.out.printf("Win %%  : %.1f%%%n", winPercentage);

        sc.close();
    }
}

