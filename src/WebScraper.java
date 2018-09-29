import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    /**
     *
     * @param text the text to look through
     * @param word the word you are counting
     * @return number of occurrences of word
     */
    public static int numberOfOccurences(final String text, final String word) {
        int index = text.indexOf(word);
        String simpleText = text.toLowerCase();
        String search = word.toLowerCase();
        int count = 0;
        while (index != -1) {
            count++;
            System.out.println(simpleText.substring(index - 5, index + 15));
            simpleText = simpleText.substring(index + 1);
            index = simpleText.indexOf(search);
        }
        return count;
    }
    public static void main (String[] arguments) {
        String text = urlToString("http://erdani.com/tdpl/hamlet.txt");
        //System.out.println(text);
        System.out.println(numberOfOccurences(text, "PRINCE"));
    }
}
