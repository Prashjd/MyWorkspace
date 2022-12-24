Feature: New Account

Scenario: Succesfully Added New Acoount in Guru99 Bank
Given User launch chrome browser
When User opens URL "https://demo.guru99.com/v4/index.php"
And User enters userID as "mngr461110" and password as "nEvaqEh"
And click on login
Then Page Title should be "Guru99 Bank Manager HomePage"
When User click on  New Account Menu Item
Then User can view Add new account page
When User enters details
And click on Submit button 
Then User can view confirmation message "Account Generated Successfully!!!" 
And close browser
