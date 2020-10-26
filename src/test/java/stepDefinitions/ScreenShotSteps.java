package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import functionsLibrary.CommonFunctions;
import pageObjects.ScreenShotPage;

public class ScreenShotSteps extends CommonFunctions {

    ScreenShotPage screenShotPage = new ScreenShotPage(driver);

    @When("^I click the link of the Title \"(.*?)\"$")
    public void i_click_the_link_of_the_Title(String arg1)  {

    screenShotPage.clickLink();
    }

    @When("^I navigate to the Home page of the Title$")
    public void i_navigate_to_the_Home_page_of_the_Title()  {
    screenShotPage.homePage();
    }

    @When("^I enter the Word \"(.*?)\" and click search$")
    public void i_enter_the_Word_and_click_search(String srchTxt)  {
        screenShotPage.searchText(srchTxt);

    }

    @Then("^I take a screenshot of the results$")
    public void i_take_a_screenshot_of_the_results() throws Exception {
        screenShotPage.takeScreenShot();
    }



}
