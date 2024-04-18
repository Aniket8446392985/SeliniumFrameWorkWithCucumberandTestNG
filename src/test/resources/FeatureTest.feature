Feature: Test Feature for practice

  ## This is ann exmaple of background tags in cucumber
  ## This will execute before every scenarion in given feature file
  Background:
   # Given User is launched browser // This we have defined in before hooks in hooks class
    Then User loads website URL

  ## This is an example of normal parameterazation of any scenario
@SmokeTest
  Scenario: Test login page with single parameters
    Given user is on login page
     When user enters username "Aniket_FOS"
     And user enters password "Pass@123"
     Then user lands on home page

  ## This is the example of scenario outline , where we pass multiple data in same test case
  @SmokeTest
  Scenario Outline: Test login page with multiple input data
    Given user is on login page
    When user enters username "<UserName>" combination
    And user enters password "<Password>" combination
    Then user lands on home page
    Examples:
      |UserName|Password|
    |Aniket_CREDIT|Credit@123|
    |Aniket_BOPS|BOPS@123|
    |Aniket_HOPS|HOPS@123|

  ## This is an example of reg ex patterns used in Step defination file
  # to ask java to accept any data type of parameter not just String
  @SmokeTest
  Scenario: Test login page with any ata type of parameters using regex patterns
    Given user is on login page
    When user enters regex username Aniket_FOS
    And user enters regex password Pass@123
    Then user lands on home page

  @SmokeTest
  Scenario Outline: Test login page with any ata type of parameters using regex patterns
    Given user is on login page
       When user enters regex username <Username>
         And user enters regex password <Password>
           Then user lands on home page
             Examples:|Username|Password|
               |  1st_username | 1st_password |
                 |  2nd_username | 2nd_password |
                 |  3rd_username| 3rd_password|

  ## This is an example of data driven from list in test case
  @SmokeTest
  Scenario: Test sign up page with multiple data inputs
    Given user is on sign up page
    When User enters the multiple details on sign up page
      |First name|
      |Last name|
      |Email id|
      |Mobile no|
    Then User lands on successfull sign up page

    ## This and above is an example of tagged based scenario running for this we have added this tag in testng.xml
  @SmokeTest @RegressionTest
  Scenario: Test login page with single parameters with tags
    Given user is on login page
    When user enters username "Aniket_FOS"
    And user enters password "Pass@123"
    Then user lands on home page



