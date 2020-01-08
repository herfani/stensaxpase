import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Utils utils = new Utils();
        Random random = new Random();
        Player player = new Player();
        Player computer = new Player();

        String[] computerOptions = {".", "o", "x"};

        boolean playGame = true;

        System.out.println("-You are playing vs the computer-");
        System.out.println("First one to 3 points wins the round!");


        while (playGame) {

            System.out.println("Please pick Rock[.] - Paper[o] - Scissors[x] or press Q to end the game");
            String playerPick = sc.nextLine();

            if (playerPick.equals(".") || playerPick.equals("o") || playerPick.equals("x")) {
                System.out.println("You picked: " + utils.checkPickedValue(playerPick));
                String computerPick = computerOptions[random.nextInt(computerOptions.length)];
                System.out.println("Computer picked: " + utils.checkPickedValue(computerPick));

                if (utils.isPlayerWinner(playerPick, computerPick)) {
                    player.setScore(1);
                    System.out.println("Score this round: You " + player.getScore() + " - " + computer.getScore() + " Computer");

                    if (player.getScore() == 3) {
                        player.setWins(1);
                        System.out.println("You won! Total wins: You " + player.getWins() + " - " + computer.getWins() + " Computer");
                        player.resetScore();
                        computer.resetScore();
                    }

                } else if (utils.isPlayerWinner(computerPick, playerPick)) {
                    computer.setScore(1);
                    System.out.println("Score this round: You " + player.getScore() + " - " + computer.getScore() + " Computer");

                    if (computer.getScore() == 3) {
                        computer.setWins(1);
                        System.out.println("Computer won!\nTotal wins: You " + player.getWins() + " - " + computer.getWins() + " Computer");
                        player.resetScore();
                        computer.resetScore();
                    }

                } else {
                    System.out.println("Draw! Pick again");
                }

            } else if (playerPick.equals("Q") || playerPick.equals("q")) {
                System.out.println("You pressed q, Ending game...");
                playGame = false;
            } else {
                System.out.println("Wrong input, please try again.");
            }
        }

    }
}
