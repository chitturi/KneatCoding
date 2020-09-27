@functionaltest
Feature: To Test failed login scenarios
   
  @login 
  Scenario: Test with entering wrong password
    Given I am on Paypal UK login page
    And I enter email "chitturi.udaykiran@gmail.com" and click on Next button
    And I see Password page with password field
    When I enter wrong password "testpassword" and click on Login
    Then I see Login error with incorrect information

  Scenario: Test without entering any email in Email address field
    Given I am on Paypal UK login page
    When I click on Login button with empty Email field
    Then I see an error with information to enter Email address or mobile number
    
  Scenario: Test without entering any password in password field
    Given I am on Paypal UK login page
    And I enter email "chitturi.udaykiran@gmail.com" and click on Next button
    And I see Password page with password field
    When Click on Login button with empty password field
    Then I see an error Password is required