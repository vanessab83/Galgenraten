import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HangmanGame game = new HangmanGame(scanner);
        game.start();

        scanner.close();
    }
}

class HangmanGame {

    private static final int MAX_WRONG_ATTEMPTS = 6;

    private final Scanner scanner;
    private SecretWord secretWord;
    private final GuessedLetters guessedLetters;

    private int wrongAttempts;

    public HangmanGame(Scanner scanner) {
        this.scanner = scanner;
        this.guessedLetters = new GuessedLetters();
        this.wrongAttempts = 0;
    }

    public void start() {
        System.out.println("=== Galgenmännchen ===");
        System.out.println();

        String word = askForSecretWord();
        secretWord = new SecretWord(word);

        hideSecretWord();

        playGame();

        printEndMessage();
    }

    private String askForSecretWord() {
        while (true) {
            System.out.print("Spieler 1, gib das geheime Wort ein: ");
            String input = scanner.nextLine().trim();

            if (InputValidator.isValidWord(input)) {
                return input.toLowerCase(Locale.GERMAN);
            }

            System.out.println("Ungültiges Wort. Bitte gib nur Buchstaben ein.");
            System.out.println();
        }
    }

    private void hideSecretWord() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }

    private void playGame() {
        while (!hasPlayerWon() && !hasPlayerLost()) {
            printGameStatus();

            char guessedLetter = askForLetter();

            if (guessedLetters.contains(guessedLetter)) {
                System.out.println("Diesen Buchstaben hast du schon geraten.");
                System.out.println();
                continue;
            }

            guessedLetters.add(guessedLetter);

            if (secretWord.contains(guessedLetter)) {
                secretWord.revealLetter(guessedLetter);
                System.out.println("Richtig geraten!");
            } else {
                wrongAttempts++;
                System.out.println("Falsch geraten!");
            }

            System.out.println();
        }
    }

    private char askForLetter() {
        while (true) {
            System.out.print("Spieler 2, gib einen Buchstaben ein: ");
            String input = scanner.nextLine().trim().toLowerCase(Locale.GERMAN);

            if (InputValidator.isValidLetter(input)) {
                return input.charAt(0);
            }

            System.out.println("Ungültige Eingabe. Bitte gib genau einen Buchstaben ein.");
            System.out.println();
        }
    }

    private void printGameStatus() {
        System.out.println("Aktuelles Wort:");
        System.out.println(secretWord.getDisplayWord());
        System.out.println();

        System.out.println("Geratene Buchstaben:");
        System.out.println(guessedLetters);
        System.out.println();

        System.out.println("Fehlversuche: " + wrongAttempts + " von " + MAX_WRONG_ATTEMPTS);
        System.out.println();
    }

    private boolean hasPlayerWon() {
        return secretWord.isCompletelyRevealed();
    }

    private boolean hasPlayerLost() {
        return wrongAttempts >= MAX_WRONG_ATTEMPTS;
    }

    private void printEndMessage() {
        System.out.println("=== Spiel beendet ===");

        if (hasPlayerWon()) {
            System.out.println("Gewonnen! Das Wort wurde erraten.");
        } else {
            System.out.println("Verloren! Zu viele Fehlversuche.");
            System.out.println("Das gesuchte Wort war: " + secretWord.getOriginalWord());
        }
    }
}

class SecretWord {

    private final String originalWord;
    private final boolean[] revealedLetters;

    public SecretWord(String word) {
        this.originalWord = word;
        this.revealedLetters = new boolean[word.length()];
    }

    public boolean contains(char letter) {
        for (int i = 0; i < originalWord.length(); i++) {
            if (originalWord.charAt(i) == letter) {
                return true;
            }
        }

        return false;
    }

    public void revealLetter(char letter) {
        for (int i = 0; i < originalWord.length(); i++) {
            if (originalWord.charAt(i) == letter) {
                revealedLetters[i] = true;
            }
        }
    }

    public String getDisplayWord() {
        String displayWord = "";

        for (int i = 0; i < originalWord.length(); i++) {
            if (revealedLetters[i]) {
                displayWord += originalWord.charAt(i) + " ";
            } else {
                displayWord += "_ ";
            }
        }

        return displayWord;
    }

    public boolean isCompletelyRevealed() {
        for (int i = 0; i < revealedLetters.length; i++) {
            if (!revealedLetters[i]) {
                return false;
            }
        }

        return true;
    }

    public String getOriginalWord() {
        return originalWord;
    }
}

class GuessedLetters {

    private final Set<Character> letters;

    public GuessedLetters() {
        this.letters = new LinkedHashSet<>();
    }

    public void add(char letter) {
        letters.add(letter);
    }

    public boolean contains(char letter) {
        return letters.contains(letter);
    }

    @Override
    public String toString() {
        if (letters.isEmpty()) {
            return "Noch keine Buchstaben geraten.";
        }

        String result = "";

        for (char letter : letters) {
            result += letter + " ";
        }

        return result;
    }
}

class InputValidator {

    public static boolean isValidWord(String input) {
        if (input == null || input.isBlank()) {
            return false;
        }

        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetter(input.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isValidLetter(String input) {
        if (input == null || input.length() != 1) {
            return false;
        }

        return Character.isLetter(input.charAt(0));
    }
}