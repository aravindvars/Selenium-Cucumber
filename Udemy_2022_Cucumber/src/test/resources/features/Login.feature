@login @regression

Feature: WebDriver University - Validating Login Functionality

  Background:
    Given I enter Webdriver Login page


  Scenario Outline:Validating Successful & UnSuccessful Login Attempt
    When I enter username of <username>
    When I enter password of <password>
    And I click on Login
    Then I should be presented with <Validationmessage>

    Examples:
      | username  | password     | Validationmessage   |
      | webdriver | webdriver123 | validation succeeded |
      | webdriver | xyz123       | validation failed    |
      | sx4###    | s@341        | validation failed    |

  Scenario: Validating Successful Login Attempt
    When I enter username of webdriver
    And I enter password of webdriver123
    And I click on Login
    Then I should be presented with Validation successful message

  Scenario: Validating UnSuccessful Login Attempt
    When I enter username of webdriver
    And I enter password of xyz123
    And I click on Login
    Then I should be presented with Validation unsuccessful message