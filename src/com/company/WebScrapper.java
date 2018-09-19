package com.company;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class WebScrapper {
    public static void main(String[] unused) {
        System.out.println(counting("Prince","http://erdani.com/tdpl/hamlet.txt"));
    }
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

    public static int counting(final String word, final String url) {
        int n = 0;
        Scanner input = new Scanner(System.in);
        String[] newstring = urlToString(url).split("[^a-zA-Z0-9+]");
        for (int i = 0; i < newstring.length; i++) {
            if (newstring[i].equals(word)) {
                n += 1;
            }
        }
        return n;
    }
}
