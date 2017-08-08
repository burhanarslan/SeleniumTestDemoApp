import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utility {

    public static WebDriver driver;
    public static String baseURL = "https://www.amazon.com/";
    public static String selectedFavori;
    public static int favoriesCount = 0;
    public static int willDeleteFavorite = 0;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Burhan\\Desktop\\selenium\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(baseURL);
    }

    @AfterClass
    public static void closeCase() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
