import java.security.SecureRandom;
public class PasswordGenerate {

    private static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERIC_CHARACTERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+";

    public static void main(String[] args) {
        int length = 8; 
        String password = generatePassword(length);
        System.out.println("Generated Password: " + password);
    }

    private static String generatePassword(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        // Ensure at least one character from each character set
        password.append(getRandomCharacter(LOWERCASE_CHARACTERS, random));
        password.append(getRandomCharacter(UPPERCASE_CHARACTERS, random));
        password.append(getRandomCharacter(NUMERIC_CHARACTERS, random));
        password.append(getRandomCharacter(SPECIAL_CHARACTERS, random));

        // Generate the remaining characters
        for (int i = 4; i < length; i++) {
            String characterSet = getCharacterSets();
            password.append(getRandomCharacter(characterSet, random));
        }

        // Shuffle the password to randomize the order of characters
        return shuffleString(password.toString(), random);
    }

    private static String getRandomCharacter(String characterSet, SecureRandom random) {
        int randomIndex = random.nextInt(characterSet.length());
        return characterSet.substring(randomIndex, randomIndex + 1);
    }

    private static String getCharacterSets() {
        return LOWERCASE_CHARACTERS + UPPERCASE_CHARACTERS + NUMERIC_CHARACTERS + SPECIAL_CHARACTERS;
    }

    private static String shuffleString(String input, SecureRandom random) {
        char[] characters = input.toCharArray();
        for (int i = characters.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = characters[index];
            characters[index] = characters[i];
            characters[i] = temp;
        }
        return new String(characters);
    }
}


