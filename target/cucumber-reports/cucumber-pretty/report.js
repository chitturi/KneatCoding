$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("APITesting.feature");
formatter.feature({
  "line": 2,
  "name": "CRUD Operations on Pet",
  "description": "",
  "id": "crud-operations-on-pet",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@APItest"
    }
  ]
});
formatter.before({
  "duration": 33244843,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Create a pet - POST CALL",
  "description": "",
  "id": "crud-operations-on-pet;create-a-pet---post-call",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I have a payload with pet information",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I send a POST request to add a new pet",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I get a response with 200 success",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "I validate pet details in response body",
  "keyword": "And "
});
formatter.match({
  "location": "APIStepdefinitions.i_have_a_payload_with_pet_information()"
});
formatter.result({
  "duration": 1112667598,
  "status": "passed"
});
formatter.match({
  "location": "APIStepdefinitions.i_send_a_POST_request_to_add_a_new_pet()"
});
formatter.result({
  "duration": 1548025336,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 22
    }
  ],
  "location": "APIStepdefinitions.i_get_a_response_with_success(int)"
});
formatter.result({
  "duration": 5455802,
  "status": "passed"
});
formatter.match({
  "location": "APIStepdefinitions.i_validate_pet_details_in_response_body()"
});
formatter.result({
  "duration": 476960357,
  "status": "passed"
});
formatter.after({
  "duration": 342293,
  "status": "passed"
});
formatter.before({
  "duration": 122383,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Find a pet - GET CALL based on Pet ID",
  "description": "",
  "id": "crud-operations-on-pet;find-a-pet---get-call-based-on-pet-id",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "I had ID of pet",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "I send a GET request to get details of pet based on ID",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "I get a response with 200 success",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "I can see pet details in response body",
  "keyword": "And "
});
formatter.match({
  "location": "APIStepdefinitions.i_had_ID_of_pet()"
});
formatter.result({
  "duration": 67853,
  "status": "passed"
});
formatter.match({
  "location": "APIStepdefinitions.i_send_a_GET_request_to_get_details_of_pet_based_on_ID()"
});
formatter.result({
  "duration": 928636869,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 22
    }
  ],
  "location": "APIStepdefinitions.i_get_a_response_with_success(int)"
});
formatter.result({
  "duration": 205876,
  "status": "passed"
});
formatter.match({
  "location": "APIStepdefinitions.i_can_see_pet_details_in_response_body()"
});
formatter.result({
  "duration": 35723804,
  "status": "passed"
});
formatter.after({
  "duration": 122857,
  "status": "passed"
});
formatter.before({
  "duration": 197680,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Update a pet - PUT CALL to update Pet Status",
  "description": "",
  "id": "crud-operations-on-pet;update-a-pet---put-call-to-update-pet-status",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 17,
  "name": "I had ID of pet",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "I want to update pet status as \"sold\"",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I send a PUT request with pet ID and status as sold",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "I get a response with 200 success",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "I can see pet details updated in response body",
  "keyword": "And "
});
formatter.match({
  "location": "APIStepdefinitions.i_had_ID_of_pet()"
});
formatter.result({
  "duration": 50879,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sold",
      "offset": 32
    }
  ],
  "location": "APIStepdefinitions.i_want_to_update_pet_status_as(String)"
});
formatter.result({
  "duration": 1333734,
  "status": "passed"
});
formatter.match({
  "location": "APIStepdefinitions.i_send_a_POST_request_with_pet_ID_and_status_as_sold()"
});
formatter.result({
  "duration": 684522525,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 22
    }
  ],
  "location": "APIStepdefinitions.i_get_a_response_with_success(int)"
});
formatter.result({
  "duration": 340752,
  "status": "passed"
});
formatter.match({
  "location": "APIStepdefinitions.i_can_see_pet_details_updated_in_response_body()"
});
formatter.result({
  "duration": 30028558,
  "status": "passed"
});
formatter.after({
  "duration": 140897,
  "status": "passed"
});
formatter.before({
  "duration": 147846,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Delete a pet - DELETE PET based on Pet ID",
  "description": "",
  "id": "crud-operations-on-pet;delete-a-pet---delete-pet-based-on-pet-id",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 24,
  "name": "I had ID of pet",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "I send a DELETE request with pet ID",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "I get a response with 200 success",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "I can see deleted pet details in response body",
  "keyword": "And "
});
formatter.match({
  "location": "APIStepdefinitions.i_had_ID_of_pet()"
});
formatter.result({
  "duration": 45447,
  "status": "passed"
});
formatter.match({
  "location": "APIStepdefinitions.i_send_a_DELETE_request_with_pet_ID()"
});
formatter.result({
  "duration": 939164765,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 22
    }
  ],
  "location": "APIStepdefinitions.i_get_a_response_with_success(int)"
});
formatter.result({
  "duration": 196815,
  "status": "passed"
});
formatter.match({
  "location": "APIStepdefinitions.i_can_see_deleted_pet_details_in_response_body()"
});
formatter.result({
  "duration": 17661708,
  "status": "passed"
});
formatter.after({
  "duration": 127721,
  "status": "passed"
});
formatter.uri("PayPalLogin.feature");
formatter.feature({
  "line": 2,
  "name": "To Test failed login scenarios",
  "description": "",
  "id": "to-test-failed-login-scenarios",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@functionaltest"
    }
  ]
});
formatter.before({
  "duration": 111009,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Test with entering wrong password",
  "description": "",
  "id": "to-test-failed-login-scenarios;test-with-entering-wrong-password",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@login"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I am on Paypal UK login page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I enter email \"chitturi.udaykiran@gmail.com\" and click on Next button",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I see Password page with password field",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I enter wrong password \"testpassword\" and click on Login",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I see Login error with incorrect information",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinitions.i_am_on_Paypal_UK_login_page()"
});
formatter.result({
  "duration": 1933724623,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "chitturi.udaykiran@gmail.com",
      "offset": 15
    }
  ],
  "location": "LoginStepDefinitions.i_enter_email_and_click_on_Next_button(String)"
});
formatter.result({
  "duration": 443090546,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinitions.i_see_Password_page_with_password_field()"
});
formatter.result({
  "duration": 652400112,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "testpassword",
      "offset": 24
    }
  ],
  "location": "LoginStepDefinitions.i_enter_wrong_password_and_click_on_Login(String)"
});
formatter.result({
  "duration": 937821278,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinitions.i_see_Login_error_with_incorrect_information()"
});
formatter.result({
  "duration": 35204560,
  "status": "passed"
});
formatter.after({
  "duration": 95053,
  "status": "passed"
});
formatter.before({
  "duration": 79920,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Test without entering any email in Email address field",
  "description": "",
  "id": "to-test-failed-login-scenarios;test-without-entering-any-email-in-email-address-field",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "I am on Paypal UK login page",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "I click on Login button with empty Email field",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "I see an error with information to enter Email address or mobile number",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinitions.i_am_on_Paypal_UK_login_page()"
});
formatter.result({
  "duration": 840164322,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinitions.i_click_on_Login_button_with_empty_Email_field()"
});
formatter.result({
  "duration": 158682650,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinitions.i_see_an_error_with_information_to_enter_Email_address_or_mobile_number()"
});
formatter.result({
  "duration": 86116838,
  "status": "passed"
});
formatter.after({
  "duration": 109567,
  "status": "passed"
});
formatter.before({
  "duration": 219625,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Test without entering any password in password field",
  "description": "",
  "id": "to-test-failed-login-scenarios;test-without-entering-any-password-in-password-field",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 18,
  "name": "I am on Paypal UK login page",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "I enter email \"chitturi.udaykiran@gmail.com\" and click on Next button",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "I see Password page with password field",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "Click on Login button with empty password field",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "I see an error Password is required",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinitions.i_am_on_Paypal_UK_login_page()"
});
formatter.result({
  "duration": 1269577751,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "chitturi.udaykiran@gmail.com",
      "offset": 15
    }
  ],
  "location": "LoginStepDefinitions.i_enter_email_and_click_on_Next_button(String)"
});
formatter.result({
  "duration": 296858460,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinitions.i_see_Password_page_with_password_field()"
});
formatter.result({
  "duration": 617907839,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinitions.click_on_Login_button_with_empty_password_field()"
});
formatter.result({
  "duration": 84610922,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinitions.i_see_an_error_Password_is_required()"
});
formatter.result({
  "duration": 40517692,
  "status": "passed"
});
formatter.after({
  "duration": 83472,
  "status": "passed"
});
});