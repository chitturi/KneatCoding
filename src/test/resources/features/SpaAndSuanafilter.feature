@SpaAndSuanafeature
Feature: To Test Suana filter
   
   Background: User navigates to Search results
   Given I am on Booking home page
   And I Enter Limerick as City 
   And I Enter dates for one night from 3 months
   When I click on Search Button
   Then I can see All types of rentals are loaded with filter options
   
   @Spascenario
   Scenario: To Test Spa Rating Filter
   Given User is on search results page
   And I checked if any filters are activated and cleared
   When I click on Spa filter
   Then I see all Hotels are filtered with Spa option
   And The Savoy hotel is shown in filtered results
   And Absolute Hotel Limerick is shown in filtered results
   And George Limerick hotel is not shown in filtered results
   
   @Suanascenario
   Scenario: To Test Suana Rating Filter
   Given User is on search results page
   And I checked if any filters are activated and cleared
   When I click on Suana filter
   Then I see all Hotels are filtered with Suana option
   And Limerick Strand hotel is shown in filtered results
   And George Limerick hotel is not shown in filtered results
   
  