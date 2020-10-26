Feature: search and Screenshot
  @tes
  Scenario:
    Given I Navigate to the Provided URl
    When I enter the search Text "ProQuest"
    And I hit the enter Key
    And I see list of results
    And I write the Titles of all the links into a  text file
    And I click the link of the Title "ProQuest"
    And I navigate to the Home page of the Title
    And I enter the Word "QA" and click search
    And I take a screenshot of the results


