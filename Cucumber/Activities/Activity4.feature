@activity4
Feature: Login page
  Scenario: Testing Login without Examples 
    Given the user is on the login page
    When the user enters username and password
    When the user enters "admin" and "password"
    And clicks the submit button
    Then get the confirmation text and verify message as "Welcome Back, Admin!"