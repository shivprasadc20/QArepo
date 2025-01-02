
Feature: feature to test M2I US features
@tag1
Scenario: Check login with valid credentials
  Given User is on login page
  When User enters loginid 'best18@gmail.com'   & password 'Test@123'
  When Clicks Login button
  Then User is navigated to the home page
  Given Click on My profile button
  When click on Logout button
  Then User is logging out


@Sendmoney
Scenario: Check Sendmoney functionality
  Given User is on login page
  When User enters loginid 'best18@gmail.com'   & password 'Test@123'
  When Clicks Login button
  Then User is navigated to the home page
  Given Bank transfer option is visible with the credit timelines message
  And Select Bank transfer option is clickable
  When User enters Amount 500
  Then User is getting correct reciver amount to Reciever gets field
#  And User is able to see correct amount in breakup details with compare to Reciever amount
#  Given Sendmoney button is visible
#  When Sendmoney button is clickable user is navigating to select account details page

