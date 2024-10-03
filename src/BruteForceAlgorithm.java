import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;

public class BruteForceAlgorithm {
    private String mainString;
    private String substring;
    private int currentIndex;
    private int patternMatchIndex;
    private final Highlighter.HighlightPainter matchPainter;
    private final Highlighter.HighlightPainter inspectPainter;
    private final JTextArea textArea;
    private final JTextField patternField;
    private final JTextField indexField;

    public BruteForceAlgorithm(JTextArea textArea, JTextField patternField, JTextField indexField) {
        this.textArea = textArea;
        this.patternField = patternField;
        this.indexField = indexField;
        this.matchPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
        this.inspectPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.LIGHT_GRAY);
        reset();
    }

    public void moveNext() {
        mainString = textArea.getText();
        substring = patternField.getText();

        if (substring.isEmpty()) {
            showMessage("Please enter a pattern.");
            return;
        }

        if (currentIndex < mainString.length()) {
            AlgorithmStep.INSPECTING.execute(this);

            if (mainString.charAt(currentIndex) == substring.charAt(patternMatchIndex)) {
                AlgorithmStep.MATCHING.execute(this);

                if (patternMatchIndex == substring.length()) {
                    AlgorithmStep.COMPLETED.execute(this);
                }
            } else {
                AlgorithmStep.NOT_MATCHING.execute(this);
            }
            currentIndex++;
        } else {
            showMessage("End of text reached.");
        }
    }

    public void movePrevious() {
        mainString = textArea.getText();
        substring = patternField.getText();

        if (substring.isEmpty()) {
            showMessage("Please enter a pattern.");
            return;
        }

        if (currentIndex > 0) {
            currentIndex--;
            AlgorithmStep.INSPECTING.execute(this);

            if (mainString.charAt(currentIndex) == substring.charAt(patternMatchIndex)) {
                AlgorithmStep.MATCHING.execute(this);

                if (patternMatchIndex == substring.length()) {
                    AlgorithmStep.COMPLETED.execute(this);
                }
            } else {
                AlgorithmStep.NOT_MATCHING.execute(this);
            }
        } else {
            showMessage("Start of text reached.");
        }
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public int getPatternMatchIndex() {
        return patternMatchIndex;
    }

    public void incrementPatternMatchIndex() {
        patternMatchIndex++;
    }

    public void resetPatternMatchIndex() {
        patternMatchIndex = 0;
    }

    public JTextField getIndexField() {
        return indexField;
    }

    public void highlightInspectedCharacter(int index) {
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

    public void highlightTextArea(int startIndex, int endIndex) {
        try {
            textArea.getHighlighter().addHighlight(startIndex, endIndex, matchPainter);
            textArea.setCaretPosition(endIndex);
        } catch (Exception e) {
            showErrorDialog("Error while highlighting text area: " + e.getMessage());
        }
    }

    public void highlightPatternField(int endIndex) {
        try {
            patternField.getHighlighter().removeAllHighlights();
            patternField.getHighlighter().addHighlight(0, endIndex, matchPainter);
            patternField.setCaretPosition(endIndex);
        } catch (Exception e) {
            showErrorDialog("Error while highlighting pattern field: " + e.getMessage());
        }
    }

    public void clearPatternHighlight() {
        patternField.getHighlighter().removeAllHighlights();
    }

    public void reset() {
        currentIndex = 0;
        patternMatchIndex = 0;
        textArea.getHighlighter().removeAllHighlights();
        clearPatternHighlight();
        indexField.setText("");
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
