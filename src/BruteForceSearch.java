public class BruteForceSearch {

    public static double bruteForceSearch(String mainString, String substring) {
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
    }

    public static void main(String[] args) {
        String mainString = "vlk vlak kos nos bos pos";
        String substring = "gay";

        int result = (int) bruteForceSearch(mainString, substring);

        if (result != -1) {
            System.out.println("Pattern found at index: " + result);
        } else {
            System.out.println("Pattern not found.");
        }
    }
}
