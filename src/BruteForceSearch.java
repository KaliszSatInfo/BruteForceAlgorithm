import java.util.Scanner;

public class BruteForceSearch {
    private String step = "step0";
    private boolean direction;
    int mainS;
    int subS;
    int subIndex;
    int currentIndex;
    int savedIndex;
    private String mainString;
    private String subString;
    int response;

    public BruteForceSearch(String mainString, String subString, boolean direction) {
        this.direction = direction;
        this.mainString = mainString;
        this.subString = subString;

    }
    public void move(){
        switch(step){
            case
    }

    /*public static double bruteForceSearch(String mainString, String substring) {
        int mainS = mainString.length();
        int subS = substring.length();
        int currentIndex = 0;
        if(mainS > subS) {
            while (true) {
                //number of found symbols from substring
                int subIndex = 0;
                //Curren symbol in sub and main string
                int savedIndex = currentIndex;

                while (subIndex < subS && currentIndex < mainS && mainString.charAt(currentIndex) == substring.charAt(subIndex)) {
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

        } return -1;
    }*/

    public void step0(){
        mainS = mainString.length();
        subS = subString.length();
        currentIndex = 0;
        if(direction)step = "step1";
        else step = "step1_reverse";
    }
    private void step1(){
        if(mainS > subS) {
            subIndex = 0;
            savedIndex = currentIndex;
            if(subIndex < subS && currentIndex < mainS && mainString.charAt(currentIndex) == subString.charAt(subIndex) ) {
                step = "step2";
            }
            if(subIndex == subS){
                step = "step3";
            }
            if (currentIndex == mainS) {
                step = "step4";
            }
        }
    }
    public void step2(){
        currentIndex++;
        subIndex++;
        step = "step1";
    }
    private void step3(){
        response =  currentIndex - subS;
    }
    private void step4(){
        response =  -1;
    }



    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter full text");
        String mainString = myObj.nextLine();  // Read user input
        System.out.println("Enter looked for string");
        String subString = myObj.nextLine();
        while(true){
            System.out.println("Next(n) or Previous(p) ?");
            String response = myObj.nextLine();
            if(response.equals("n")){
                new BruteForceSearch(mainString, subString).forward();
            } else if (response.equals("p")) {
                new BruteForceSearch(mainString, subString).backward();
            }
            else {
                System.out.println("Invalid input");
                break;
            }


        }




        if (result != ) {
            System.out.println("Pattern found at index: " + result);
        } else {
            System.out.println("Pattern not found.");
        }
    }
}
