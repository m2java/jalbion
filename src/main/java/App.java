import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class App {
    public static String propertiesFile = "item.properties";


    public static void main(String[] noob) throws IOException {
        App app = new App();
        app.loadLocalResources(propertiesFile);
        Crawler crawler = new Crawler();
        crawler.init("T1_HIDE");
        crawler.getResponse();
    //  System.out.println(crawler.getResponse());
    }

    public Properties loadLocalResources(String resource) {
        String localPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String resourcePath = localPath + resource;
        Properties appProperties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(resourcePath)) {
            appProperties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appProperties;
    }
}
