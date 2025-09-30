public class Main {
    public static void main(String[] args) {
        String url = "https://example.com";
        int depth = 2; // crawl depth

        WebCrawler crawler = new WebCrawler(url, depth);
        crawler.startCrawling();
    }
}
