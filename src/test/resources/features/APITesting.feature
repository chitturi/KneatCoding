@APItest
Feature: CRUD Operations on Pet
 
  Scenario: Create a pet - POST CALL
    Given I have a payload with pet information
    When I send a POST request to add a new pet
    Then I get a response with 200 success
    And I validate pet details in response body
  
  Scenario: Find a pet - GET CALL based on Pet ID
    Given I had ID of pet
    When I send a GET request to get details of pet based on ID
    Then I get a response with 200 success
    And I can see pet details in response body
    
  Scenario: Update a pet - PUT CALL to update Pet Status
    Given I had ID of pet
    And I want to update pet status as "sold"
    When I send a PUT request with pet ID and status as sold
    Then I get a response with 200 success
    And I can see pet details updated in response body
    
   Scenario: Delete a pet - DELETE PET based on Pet ID
    Given I had ID of pet
    When I send a DELETE request with pet ID
    Then I get a response with 200 success
    And I can see deleted pet details in response body