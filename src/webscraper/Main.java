package webscraper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        // Download webs
        List<String> links = new ArrayList<>();
        links.add("https://www.bbc.com/");
        links.add("https://getbootstrap.com");
        links.add("https://michalsnik.github.io/aos/");
        Long timeStart=System.nanoTime();
        links.stream().parallel().forEach(link->getWebContent(link));
        Long timeEnd=System.nanoTime();
        System.out.println(timeEnd-timeStart);
    }
    public synchronized static String getWebContent(String link){
        System.out.println("INIT");
        System.out.println(link);
        try{
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            String encoding=conn.getContentEncoding();

            InputStream input=conn.getInputStream();
            System.out.println("END");
            return new BufferedReader(new InputStreamReader(input))
                    .lines()
                    .collect(Collectors.joining());
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }
}
