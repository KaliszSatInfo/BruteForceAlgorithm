public class BruteForceSearch {

    public static double bruteForceSearch(String mainString, String substring) {
        int mainS = mainString.length();
        int subS = substring.length();
        int currentIndex = 0;

        while (true) {
            int subIndex = 0;
            int savedIndex = currentIndex;

            while (subIndex < subS && currentIndex < mainS && mainString.charAt(currentIndex) == substring.charAt(subIndex)) {
                currentIndex++;
                subIndex++;
            }

            if (subIndex == subS) {
                return savedIndex;
            }

            if (currentIndex == mainS) {
                break;
            }

            currentIndex = savedIndex + 1;
        }

        return -1;
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
