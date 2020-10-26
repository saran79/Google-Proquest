import cucumber.api.java.After;
import cucumber.api.java.Before;
import functionsLibrary.CommonFunctions;

public class Hooks {

    CommonFunctions commonFunctions = new CommonFunctions();
    @Before
    public void beforeTest() {
        commonFunctions.openBrowser();
    }
   // @After
    public void afterTest(){
        commonFunctions.closeBrowser();
    }
}
