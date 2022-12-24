Feature: New Customer

Scenario: Add new customer in Guru99 Bank
Given User launch chrome browser
When User opens URL "https://demo.guru99.com/v4/index.php"
And User enters userID as "mngr461110" and password as "nEvaqEh"
And click on login
Then Page Title should be "Guru99 Bank Manager HomePage"
When User click on  New Customer menu
Then User can view Add new customer page
When User enters customer info
And click on Submit button 
Then User can view confirmation message "Customer Registered Successfully!!!" 
And close browser
