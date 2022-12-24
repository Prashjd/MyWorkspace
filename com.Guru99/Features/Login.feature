Feature: Login

Scenario: Succesful login with valid credentials.
Given User launch chrome browser
When User opens URL "https://demo.guru99.com/v4/index.php"
And User enters userID as "mngr461110" and password as "nEvaqEh"
And click on login
Then Page Title should be "Guru99 Bank Manager HomePage"
When User click on Logout link
And Accept Alert
Then Page Title should be "Guru99 Bank Home Page"
And close browser