package pageObjects;

import functionsLibrary.CommonFunctions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

public class ScreenShotPage {
    WebDriver driver;
    CommonFunctions commonFunctions = new CommonFunctions();

    @FindBy(xpath="//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/a/h3/span")
    private WebElement clkLink;
    @FindBy(xpath = "//*[@id=\"introAgreeButton\"]/span/span")
    private WebElement clkAgreeBtn;
    @FindBy(xpath="//*[@id=\"imgClassSwitch\"]/a/div")
    private WebElement logo;
    @FindBy(id="searchTerm")
    private WebElement searchTxtFld;
    @FindBy(id="expandedSearch")
    private WebElement searchIcon;
    @FindBy(xpath="/html/body/div[8]/div[1]/div/div[2]/div[2]/a[1]")
    private WebElement proQuestAgreeBtn;
    @FindBy(xpath="//*[@id=\"gwt-debug-close_id\"]")
    private WebElement proQuestcloseBtn;
    public ScreenShotPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

       public void clickLink() {
           WebDriverWait wait = new WebDriverWait(driver, 5000);
           wait.until(driver -> driver.switchTo().frame(0));
           clkAgreeBtn.click();
           clkLink.click();
    }

    public void homePage() {
        //assert(logo.isDisplayed());
    }

    public void searchText(String srchTxt) {
        searchTxtFld.sendKeys(srchTxt);

        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(driver -> driver.switchTo().frame(0));
        proQuestAgreeBtn.click();
        proQuestcloseBtn.click();
        driver.switchTo().defaultContent();
        searchIcon.click();
    }
        public void takeScreenShot()  throws Exception{
        commonFunctions.wait(5);
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("C:\\test\\Simulation\\src\\main\\resources\\one.jpg");
        FileUtils.copyFile(srcFile,destFile);
    }
}
