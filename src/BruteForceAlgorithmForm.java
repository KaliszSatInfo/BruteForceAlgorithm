import javax.swing.*;

public class BruteForceAlgorithmForm extends JFrame {
    private JPanel panel;
    private JTextField patternField;
    private JTextField indexField;
    private JTextArea textArea;
    private JButton nextButton;
    private JButton resetButton;
    private JButton prevButton;

    private final BruteForceAlgorithm algorithm;

    public BruteForceAlgorithmForm() {
        setContentPane(panel);
        setSize(650, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        algorithm = new BruteForceAlgorithm(textArea, patternField, indexField);

        nextButton.addActionListener(e -> algorithm.moveNext());
        prevButton.addActionListener(e -> algorithm.movePrevious());
        resetButton.addActionListener(e -> algorithm.reset());

        algorithm.reset();
    }

    public static void main(String[] args) {
        BruteForceAlgorithmForm demo = new BruteForceAlgorithmForm();
        demo.setVisible(true);
    }
}
