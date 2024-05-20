Feature: E-Learning Application Testing

  @login
  Scenario: Login to application as a valid user
    Given user on login page
    When user enter userid and password from XL file
    And click on login button
    Then successfully login to the dashboard


