import javax.swing.*;
import java.awt.event.ActionListener;

public class DemonstraceAlgoritmu extends JFrame {
    private String mainString;
    private String subString;
    private int mainS;
    private int subS;
    private JTextArea mainStringArea;
    private JButton nextButton;
    private JTextField subStringArea;
    private JPanel panel;
    private int stepsTaken = 0;

    public DemonstraceAlgoritmu() {

        nextButton.addActionListener( e ->{
            this.mainString = mainStringArea.getText();
            this.subString = subStringArea.getText();
            mainS = mainString.length();
            subS = subString.length();
            //oneStep(stepsTaken, oneStep(stepsTaken, oneStep(stepsTaken, oneStep())));
        });

    }


    public double BruteForce() {

        int currentIndex = 0;
        if (mainS > subS) {
            while (true) {
                //number of found symbols from substring
                int subIndex = 0;
                //Curren symbol in sub and main string
                int savedIndex = currentIndex;

                while (subIndex < subS && currentIndex < mainS && mainString.charAt(currentIndex) == subString.charAt(subIndex)) {
                    currentIndex++;
                    subIndex++;
                }
                //We found the whole substring
                if (subIndex == subS) {
                    return savedIndex;
                }
                //At the end of text
                if (currentIndex == mainS) {
                    break;
                }
                //Move current sub and main string forward
                currentIndex++;
            }

        }
        return -1;
    }
    public int oneStep(int subIndex, int currentIndex0){
        int currentIndex = currentIndex0;
        if(mainS > subS){
            int savedIndex = currentIndex;
            if (subIndex < subS && currentIndex < mainS && mainString.charAt(currentIndex) == subString.charAt(subIndex)) {
                currentIndex++;
                subIndex++;
            }
            if(subIndex == subS)
            {
                System.out.println("done");
            }
            if (currentIndex == mainS) {
                System.out.println("done");
            }
            currentIndex++;


        }
        return currentIndex;

    }


    }


