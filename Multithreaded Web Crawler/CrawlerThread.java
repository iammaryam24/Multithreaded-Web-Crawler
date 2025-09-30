import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Set;

public class CrawlerThread extends Thread {
    private String url;
    private Set<String> visited;

    public CrawlerThread(String url, Set<String> visited) {
        this.url = url;
        this.visited = visited;
    }

    @Override
    public void run() {
        try {
            if (visited.contains(url)) return;
            visited.add(url);

            System.out.println("Crawling: " + url);
            URL site = new URL(url);
            BufferedReader br = new BufferedReader(new InputStreamReader(site.openStream()));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("href=\"")) {
                    int start = line.indexOf("href=\"") + 6;
                    int end = line.indexOf("\"", start);
                    if (end > start) {
                        String link = line.substring(start, end);
                        if (link.startsWith("http") && !visited.contains(link)) {
                            new CrawlerThread(link, visited).start();
                        }
                    }
                }
            }
            br.close();
        } catch (Exception e) {
            // ignore invalid links
        }
    }
}
