package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Set;
import java.util.TreeSet;

public class URLReader {
    public static StringBuilder getLink(String url) throws Exception {
        URL link = new URL(url);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(link.openStream()));

        String inputLine;
        StringBuilder stringBuilder = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            stringBuilder.append(inputLine);
            stringBuilder.append(System.lineSeparator());
        }
        in.close();
        return stringBuilder;
    }
    public static void getLinkAndWriteToFile(String url, String filename) throws Exception {
        URL link = new URL(url);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(link.openStream()));

        String inputLine;
        StringBuilder stringBuilder = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            stringBuilder.append(inputLine);
            stringBuilder.append(System.lineSeparator());
        }
        in.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false));
        bw.write(stringBuilder.toString());
        bw.close();
    }
}
