import java.util.Random;
import javax.swing.JOptionPane;

public class NumberGuessingGame {
    public static void main(String[] args) {
        int range = 100;
        int maxAttempts = 10;
        int score = 0;
        int numberOfRounds = 1;
        Random random = new Random();

        while (true) {
            int randomNumber = random.nextInt(range) + 1;
            int attemptsLeft = maxAttempts;

            JOptionPane.showMessageDialog(null, "Round " + numberOfRounds);

            while (attemptsLeft > 0) {
                int guess = Integer.parseInt(JOptionPane.showInputDialog(
                        "Guess the number (between 1 and " + range + ") " + attemptsLeft + " attempts left"));

                if (guess == randomNumber) {
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number!");
                    score += attemptsLeft;
                    break;
                } else if (guess < randomNumber) {
                    JOptionPane.showMessageDialog(null, "Too low!");
                } else {
                    JOptionPane.showMessageDialog(null, "Too high!");
                }

                attemptsLeft--;
            }

            if (attemptsLeft == 0) {
                JOptionPane.showMessageDialog(null, "Game over! The number was " + randomNumber);
            }

            int choice = JOptionPane.showConfirmDialog(null, "Do you want to play again?");
            if (choice == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Your final score is: " + score);
                break;
            }

            numberOfRounds++;
        }
    }
}
