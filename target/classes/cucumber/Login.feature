
Feature: Login test

Background: Initialize the driver

  Scenario Outline: Unsuccsefull log
    Given I want to launch fb page
    When I enter wrong username <username> and password <password>
    Then I verify error message

    Examples: 
     |username|password|
     |mohan1	|pass1	 |
     |mohan2 	|pass2 	 |
     |mohan3 	|pass3 	 |