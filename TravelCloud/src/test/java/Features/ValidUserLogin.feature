Feature: Valid User Login

  Scenario Outline: Valid login user
    Given i choose to navigate to travel cloud
     When i choose to log in with user with valid <Username> username and <Password> password
     Then authentication is successful
      And the user can view his dashboard
    Examples:
      | Username                         | Password   |
      | qualityassurance@clicktravel.com | Testing123 |
