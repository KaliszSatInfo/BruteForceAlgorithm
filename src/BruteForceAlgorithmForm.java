import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;

public class BruteForceAlgorithmForm extends JFrame {
    private JPanel panel;
    private JTextField patternField;
    private JTextField indexField;
    private JTextArea textArea;
    private JButton nextButton;
    private JButton resetButton;
    private JButton prevButton;

    private String mainString;
    private String substring;
    private int currentIndex;
    private int patternMatchIndex;
    private final Highlighter.HighlightPainter matchPainter;
    private final Highlighter.HighlightPainter inspectPainter;

    public BruteForceAlgorithmForm(){
        setContentPane(panel);
        setSize(650, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        matchPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
        inspectPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.LIGHT_GRAY);

        nextButton.addActionListener(_ -> moveNext());
        prevButton.addActionListener(_ -> movePrevious());
        resetButton.addActionListener(_ -> reset());

        reset();
    }

    private void moveNext() {
        mainString = textArea.getText();
        substring = patternField.getText();

        if (substring.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a pattern.");
            return;
        }

        if (currentIndex < mainString.length()) {
            highlightInspectedCharacter(currentIndex);

            indexField.setText(String.valueOf(currentIndex));

            if (mainString.charAt(currentIndex) == substring.charAt(patternMatchIndex)) {
                patternMatchIndex++;

                highlightTextArea(currentIndex - patternMatchIndex + 1, currentIndex + 1);
                highlightPatternField(patternMatchIndex);

                if (patternMatchIndex == substring.length()) {
                    JOptionPane.showMessageDialog(this, "Pattern fully matched at index: " + (currentIndex - patternMatchIndex + 1));
                    patternMatchIndex = 0;
                }
            } else {
                patternMatchIndex = 0;
                clearPatternHighlight();
            }

            currentIndex++;
        } else {
            JOptionPane.showMessageDialog(this, "End of text reached.");
        }
    }

    private void movePrevious() {
        mainString = textArea.getText();
        substring = patternField.getText();

        if (substring.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a pattern.");
            return;
        }

        if (currentIndex > 0) {
            currentIndex--;

            highlightInspectedCharacter(currentIndex);

            indexField.setText(String.valueOf(currentIndex));

            if (mainString.charAt(currentIndex) == substring.charAt(patternMatchIndex)) {
                patternMatchIndex++;

                highlightTextArea(currentIndex, currentIndex + patternMatchIndex);
                highlightPatternField(patternMatchIndex);

                if (patternMatchIndex == substring.length()) {
                    JOptionPane.showMessageDialog(this, "Pattern fully matched at index: " + currentIndex);
                    patternMatchIndex = 0;
                }
            } else {
                patternMatchIndex = 0;
                clearPatternHighlight();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Start of text reached.");
        }
    }

    private void highlightInspectedCharacter(int index) {
        try {
            textArea.getHighlighter().removeAllHighlights();

            textArea.getHighlighter().addHighlight(index, index + 1, inspectPainter);

            if (patternMatchIndex > 0) {
                highlightTextArea(index - patternMatchIndex + 1, index + 1);
                highlightPatternField(patternMatchIndex);
            }

            textArea.setCaretPosition(index + 1);
        } catch (Exception e) {
            showErrorDialog("Error while highlighting character: " + e.getMessage());
        }
    }

    private void highlightTextArea(int startIndex, int endIndex) {
        try {
            textArea.getHighlighter().addHighlight(startIndex, endIndex, matchPainter);
            textArea.setCaretPosition(endIndex);
        } catch (Exception e) {
            showErrorDialog("Error while highlighting text area: " + e.getMessage());
        }
    }

    private void highlightPatternField(int endIndex) {
        try {
            patternField.getHighlighter().removeAllHighlights();

            patternField.getHighlighter().addHighlight(0, endIndex, matchPainter);
            patternField.setCaretPosition(endIndex);
        } catch (Exception e) {
            showErrorDialog("Error while highlighting pattern field: " + e.getMessage());
        }
    }

    private void clearPatternHighlight() {
        patternField.getHighlighter().removeAllHighlights();
    }

    private void reset() {
        currentIndex = 0;
        patternMatchIndex = 0;
        textArea.getHighlighter().removeAllHighlights();
        clearPatternHighlight();
        indexField.setText("");
    }

    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        BruteForceAlgorithmForm demo = new BruteForceAlgorithmForm();
        demo.setVisible(true);
    }
}
