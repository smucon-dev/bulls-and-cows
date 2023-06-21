package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        /**
         * Handle input errors without Java exception handling.
         */

        System.out.println("Input the length of the secret code:");
        int codeLength = readIntFromSystemIn();
        if (codeLength == -1) { return; };

        System.out.println("Input the number of possible symbols in the code:");
        int possibleChars = readIntFromSystemIn();
        if (possibleChars == -1) { return; };

        if (codeLength > 36 || possibleChars > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return;
        }

        if (codeLength == 0) {
            System.out.println("Error: it's not possible to generate a code with a length of 0.");
            return;
        }

        if (codeLength > possibleChars) {
            System.out.printf("Error: it's not possible to generate a code with a length of %d with %s unique symbols.", codeLength, possibleChars);
            return;
        }

        // generate secret code
        String secretCode = SecretCodeGenerator.generateCode(codeLength, possibleChars);
        StringBuilder sb = new StringBuilder(codeLength);
        for (int i = 0; i < codeLength ; i++) {
            sb.append('*');
        }
        System.out.printf("The secret is prepared: %s (%s).%n", sb, SecretCodeGenerator.codeRange(possibleChars));

        // run game
        System.out.println("Okay, let's start a game!");
        int turn = 1;
        while (true) {
            System.out.printf("Turn %d:%n", turn);
            String guess = scanner.next();

            if (!guess.matches("[0-9a-f]+")) {
                System.out.printf("Error: %s isn't a valid code (0-9, a-z)", guess);
                break;
            }

            if (SecretCodeEvaluator.evaluateGuess(secretCode, guess)) {
                System.out.println("Congratulations! You guessed the secret code.");
                break;
            }
            turn++;
        }
    }

    private static int readIntFromSystemIn() {

        String input = scanner.nextLine();
        if (!input.matches("\\d+")) {
            System.out.printf("Error: %s isn't a valid number.", input);
            return -1;
        } else {
            return Integer.valueOf(input);
        }
    }

}
