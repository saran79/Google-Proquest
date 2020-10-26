Feature: Search and write

Scenario: Search  for a text and write the results to the file
 Given I Navigate to the Provided URl
 When I enter the search Text ""
  And I hit the enter Key
  And I see list of results
  Then I write the Titles of all the links into a  text file


