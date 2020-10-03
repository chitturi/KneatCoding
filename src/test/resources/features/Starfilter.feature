@Starfeature
Feature: To Test Star filter
   
   Background: User navigates to Search results
   Given I am on Booking home page
   And I Enter Limerick as City 
   And I Enter dates for one night from 3 months
   When I click on Search Button
   Then I can see All types of rentals are loaded with filter options
   
   @5Starscenario
   Scenario: To Test 5 Star Rating Filter
   Given User is on search results page
   And I checked if any filters are activated and cleared
   When I click on 5 Star filter
   Then I see all Hotels are filtered with 5 Star rating
   And The Savoy hotel is shown in filtered results
   And George Limerick hotel is not shown in filtered results
   
   @4Starscenario
   Scenario: To Test 4 Star Rating Filter
   Given User is on search results page
   And I checked if any filters are activated and cleared
   When I click on 4 Star filter
   Then I see all Hotels are filtered with 4 Star rating
   And The Savoy hotel is not shown in filtered results
   And George Limerick hotel is shown in filtered results
   
  