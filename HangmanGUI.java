import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangmanGUI {
    private JFrame frame;
    private HangmanGame game;
    private JLabel wordLabel;
    private JLabel guessedLabel;
    private JLabel attemptsLabel;

    private JTextField inputField;
    private JButton guessButton;
    private JPanel panel;
    private JPanel startPanel;
    private JButton startButton;

    public HangmanGUI(HangmanGame game) {
        this.game = game;
        frame = new JFrame("Galgenmännchen");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); //Fenster wird zentriert
        panel = new JPanel();
        startPanel = new JPanel();
        JLabel title = new JLabel("GALGENMÄNNCHEN");
        title.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 30));
        startButton = new JButton("Spiel starten");

        startPanel.add(title);
        startPanel.add(startButton);

        frame.setContentPane(startPanel);
        wordLabel = new JLabel("Noch kein Spiel gestartet");
        guessedLabel = new JLabel("Geratene Buchstaben:");
        attemptsLabel = new JLabel("Fehlversuche: 0/6");

        inputField = new JTextField(2);
        guessButton = new JButton("Raten");
        frame.getRootPane().setDefaultButton(guessButton);

        panel.add (wordLabel);
        panel.add (guessedLabel);
        panel.add(attemptsLabel);
        panel.add(inputField);
        panel.add(guessButton);

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText().trim().toLowerCase();
                if(!InputValidator.isValidLetter(input)){
                    return;
                }
                game.guessLetter(input.charAt(0));
                updateGame();

                inputField.setText("");
            }
        });
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String word = JOptionPane.showInputDialog(
                        frame,
                        "Spieler 1: Geheimes Wort eingeben");

                if (word == null || word.isBlank()) {
                    return;
                }

                game.start(word);

                updateGame();

                frame.setContentPane(panel);
                frame.revalidate();
            }
        });

        frame.setVisible(true);
    }

    public void updateGame(){
        if(game.getSecretWord() != null){
            wordLabel.setText(game.getSecretWord().getDisplayWord());
            guessedLabel.setText(
                    "Geratene Buchstaben: "
                    + game.getGuessedLetters());
            attemptsLabel.setText(
                    "Fehlversuche:"
                            + game.getWrongAttempts()
                    +"/6");

        }
        if (game.hasPlayerWon()) {
            showWinScreen();
        }

        if (game.hasPlayerLost()) {
            showLoseScreen();
        }
    }
    public void showWinScreen() {

        JPanel winPanel = new JPanel();

        JLabel label = new JLabel("🎉 Gewonnen!");
        label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 30));
        JButton restartButton = new JButton("Neues Spiel");
        JButton closeButton = new JButton("Beenden");

        winPanel.add(label);
        winPanel.add(restartButton);
        winPanel.add(closeButton);

        frame.setContentPane(winPanel);
        frame.revalidate();
        frame.repaint();
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String word = JOptionPane.showInputDialog(
                        frame,
                        "Spieler 1: Neues Wort eingeben");

                if (word == null || word.isBlank()) {
                    return;
                }

                game.reset(word);

                frame.setContentPane(panel);

                updateGame();

                frame.revalidate();
                frame.repaint();
            }
        });

        closeButton.addActionListener(e -> System.exit(0));

        closeButton.addActionListener(e -> System.exit(0));
    }

    public void showLoseScreen() {

        JPanel losePanel = new JPanel();

        JLabel label = new JLabel("☠ Game Over");
        label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 30));

        JLabel word = new JLabel(
                "Das Wort war: " + game.getSecretWord().getOriginalWord());
        JButton restartButton = new JButton("Neues Spiel");
        JButton closeButton = new JButton("Beenden");

        losePanel.add(label);
        losePanel.add(word);
        losePanel.add(restartButton);
        losePanel.add(closeButton);

        frame.setContentPane(losePanel);
        frame.revalidate();
        frame.repaint();
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String word = JOptionPane.showInputDialog(
                        frame,
                        "Spieler 1: Neues Wort eingeben");

                if (word == null || word.isBlank()) {
                    return;
                }

                game.reset(word);

                frame.setContentPane(panel);

                updateGame();

                frame.revalidate();
                frame.repaint();
            }
        });

        closeButton.addActionListener(e -> System.exit(0));

        closeButton.addActionListener(e -> System.exit(0));
    }
}
