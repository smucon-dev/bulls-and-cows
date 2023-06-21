package bullscows;

import java.util.Random;

public class SecretCodeGenerator {

    public static String generateCode(int length, int characters) {

        StringBuilder secretCode = new StringBuilder();

        while (secretCode.length() < length) {
            Random r = new Random();
            int randomInt = r.nextInt(length);
            String digit = randomInt < 10 ? String.valueOf(randomInt) : String.valueOf((char)(randomInt + 87));
            if (secretCode.indexOf(digit) == -1) {
                secretCode.append(digit);
            }
        }

        return secretCode.toString();

    }

    public static String codeRange(int characters) {

        StringBuilder sb = new StringBuilder("0-");
        if (characters > 10) {
            sb.append('9');
            sb.append(", ");
            sb.append(charRange(characters));
        } else {
            sb.append(characters - 1);
        }
        return sb.toString();
    }

    private static String charRange(int length) {

        StringBuilder sb = new StringBuilder();
        if (length >= 11) {
            sb.append('a');
        }
        if (length >= 12) {
            sb.append('-');
            sb.append((char)(length+86));
        }

        return sb.toString();
    }
}
