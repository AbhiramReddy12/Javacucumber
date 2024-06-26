Feature: Login Functionality for demo website
	@Smoke
  Scenario: Sucessful login with valid credentials
  #Given user launches chrome browser
  When user opens url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
  When user enters username as "Admin" and Password as "admin123"
  And click on login
  Then the page title should be "OrangeHRM"
  When user click on log out link
  Then the page title should be "OrangeHRM"
  And close browser
  @Regression
  Scenario Outline: log in with datadriven
    #Given user launches chrome browser
    When user opens url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When user enters username as "<username>" and Password as "<password>"
    And click on login
    Then the page title should be "OrangeHRM"
    When user click on log out link
    Then the page title should be "OrangeHRM"
    And close browser

    Examples: 
      | username | password  |
      | Admin    | admin123 |
      | Admin    | admin123 |
