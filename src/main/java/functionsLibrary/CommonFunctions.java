package functionsLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class CommonFunctions {

    protected static WebDriver driver;

    public void openBrowser(){
        HashMap<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values,notifications",2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs",prefs);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    public void closeBrowser() {
        driver.quit();
    }
    public void wait(int waitTime){
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
    }

}
