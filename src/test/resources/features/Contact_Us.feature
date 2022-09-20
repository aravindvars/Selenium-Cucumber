@contact-us @regression

Feature: WebDriver University - Contact Us Page

  Background:
    Given I access webDriver university contact us page

    Scenario: Validate Successful Submission - Unique data
      When I enter a unique first name
      And I enter a unique last name
      And I enter a unique email address
      And I enter a unique comment
      And I click on Submit
      Then I should be displayed with a Thank you message

    Scenario:Validate Successful Submission - Specific data
      When I enter a specific first name arun
      And I enter a specific last name sharma
      And I enter a specific email address arunblogs@mail.com
      And I enter a specific comment "How is it? Is it noce"
      And I click on Submit
      Then I should be displayed with a Thank you message