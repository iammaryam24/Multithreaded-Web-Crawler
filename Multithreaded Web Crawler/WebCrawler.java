import java.util.HashSet;
import java.util.Set;

public class WebCrawler {
    private String startURL;
    private int depth;

    public WebCrawler(String startURL, int depth) {
        this.startURL = startURL;
        this.depth = depth;
    }

    public void startCrawling() {
        Set<String> visited = new HashSet<>();
        CrawlerThread thread = new CrawlerThread(startURL, visited, depth);
        thread.start();
    }
}
