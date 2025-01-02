
  Feature: Check signup functionality
    @Signup
    Scenario: To check sign up fetaure
      Given user click on sign up button
      Then user is navigating to sign up page
#      And verify Sending money from country drop down as United states by default
      Given User is able to select Business for sign up
      And user is able to select Individual for sign up
      Given User enters "Roman" in first text field
      And User enters "cargo" in second text field
      And User enters "7709798568" in text field
      And User enters "romancarry1@yopmail.com" in email text field
      And user selects  Terms & conditions checkbox
      And User selects Yes for marketing communication.
      And User selects NO for marketing communication.
      Given Verify with OTP button is visible
      When Click on Verify with OTP button is clickable
      Then user is navigating to OTP page & submit otp to verify.
      Given user is navigate to password page to set password
      And user eneters password "Test@1234" on password page
      And user eneters confirm password "Test@1234" on password page
      Given Signup button is visible
      When User click on Signup button
      Then User is navigating to sign up send money page