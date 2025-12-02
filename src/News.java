import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class News {
    private static final String NEWS_REGEX = "<a class=\"dt-text-black-mine\"[^>]*>(.*?)</a>";
    private static final String QUOTE_REGEX = "&quot;";
    private static final String DOUBLE_QUOTE = "\"";

    public static void main(String[] args) {
        try {
            URL url = new URL("https://dantri.com.vn/the-gioi.htm");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
            String line;

            while ((line = br.readLine()) != null) {
                Pattern pattern = Pattern.compile(NEWS_REGEX);
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    String news = matcher.group(1).replaceAll(QUOTE_REGEX, DOUBLE_QUOTE);

                    System.out.println(news);
                }
            }

            br.close();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
