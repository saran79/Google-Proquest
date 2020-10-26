package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import functionsLibrary.CommonFunctions;
import pageObjects.SearchPage;

public class SearchSteps extends CommonFunctions {

    private  SearchPage searchPage = new SearchPage(driver);
    @Given("^I Navigate to the Provided URl$")
    public void i_Navigate_to_the_Provided_URl()  {
        searchPage.openUrl();
    }

    @When("^I enter the search Text \"(.*?)\"$")
    public void i_enter_the_search_Text(String searchTxt)  {
        searchPage.enterSearchText(searchTxt);
        
    }

    @When("^I hit the enter Key$")
    public void i_hit_the_enter_Key()  {
        searchPage.hitEnterKey();
        
    }

    @When("^I see list of results$")
    public void i_see_list_of_results() {
        searchPage.listResult();
        
    }

    @When("^I write the Titles of all the links into a  text file$")
    public void i_write_the_Titles_of_all_the_links_into_a_text_file() throws Exception {
        searchPage.fileWrite(searchPage.listResult());

    }



}
