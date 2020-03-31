package examples;

import utils.URLReader;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadLinkAndWriteToFileOneTread {
    private static final String OTODOM_LINK = "https://www.otodom.pl/inwestycje/warszawa/";

    //One Thread - 26 sec
    //Multi Thread - 1 sec

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        long start = System.currentTimeMillis();

        Set<String> setOfLinks = new TreeSet<>();
        StringBuilder stringBuilder = URLReader.getLink(OTODOM_LINK);
        String content = stringBuilder.toString();
        for (int i = 0; i < content.length(); i++) {
            i = content.indexOf("https://www.otodom.pl/oferta/", i);
            if (i < 0)
                break;
            String splitLink = content.substring(i).split("\"")[0];
            if (setOfLinks.add(splitLink)) {
                int finalI = i;
                executorService.submit(() -> {
                    try {
                        URLReader.getLinkAndWriteToFile(splitLink, finalI + ".html");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            executorService.shutdown();
        }

        long stop = System.currentTimeMillis();
        System.out.println((stop-start)/1000);
    }
}
