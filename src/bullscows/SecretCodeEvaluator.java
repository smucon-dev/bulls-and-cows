package bullscows;

public class SecretCodeEvaluator {

    public static boolean evaluateGuess(String secretCode, String guess) {
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == secretCode.charAt(i)) {
                bulls++;
            } else if (secretCode.indexOf(guess.charAt(i)) > -1) {
                cows++;
            }
        }
        printGameLog(bulls, cows);

        return bulls == secretCode.length();
    }

    private static void printGameLog(int bulls, int cows) {
        if (bulls > 0 || cows > 0) {
            String bullsGrade = bulls > 0 ? String.format("%d bull(s)", bulls) : "";
            String cowsGrade = cows > 0 ? String.format("%d cow(s)", cows) : "";
            String andGrade = bulls > 0 && cows > 0 ? " and " : "";
            System.out.printf("Grade: %s%s%s.%n", bullsGrade, andGrade, cowsGrade);
        } else {
            System.out.println("Grade: None.");
        }
    }

}
