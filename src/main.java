import java.util.Scanner;

public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Enter full text");
    String mainString = myObj.nextLine();  // Read user input
    System.out.println("Enter looked for string");
    String subString = myObj.nextLine();
    int response = 1;

        while (response > 0){
            System.out.println("Next(n) or Previous(p) ?");
            String res = myObj.nextLine();
            if(res.equals("n")){
                response = new BruteForceSearch(mainString, subString, true);
            } else if (res.equals("p")) {
                response = new BruteForceSearch(mainString, subString, false);
            }
            else {
                System.out.println("Invalid input");
                System.out.println("grrrrr >:(");
            }}








        /*if (result != ) {
            System.out.println("Pattern found at index: " + result);
        } else {
            System.out.println("Pattern not found.");
        }*/

}