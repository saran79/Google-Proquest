package pageObjects;

import functionsLibrary.CommonFunctions;
import gherkin.lexer.Ja;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SearchPage {
      private WebDriver driver;
      CommonFunctions commonFunctions = new CommonFunctions();
    public SearchPage( WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(name="q")
    private WebElement searchTxtFld;
    @FindBy(xpath = "//h3[@class='LC20lb DKV0Md']")
    private WebElement titleOfResults;

    public void openUrl() {
        driver.get("http://google.com");
    }
    public void enterSearchText(String searchTxt) {
        searchTxtFld.sendKeys(searchTxt);
    }

    // xpath for google search list "//ul[@role='listbox']//li/descendant::div[@class='sbl1']"
    public void hitEnterKey() {
        searchTxtFld.sendKeys(Keys.ENTER);
    }

    public List<WebElement> listResult()  {
        commonFunctions.wait(6);
        List<WebElement> allList = driver.findElements(By.xpath("//h3[@class='LC20lb DKV0Md']"));
        return allList;
    }
    public void fileWrite(List<WebElement> allList)  throws Exception {
        FileWriter fileWriter = new FileWriter("C:\\test\\Simulation\\src\\main\\resources\\googleResults.txt");
        for(int i =0;i<allList.size();i++){
            commonFunctions.wait(3);
            String text= allList.get(i).getText();
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(text);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        System.out.println(allList.size());
    }
}
