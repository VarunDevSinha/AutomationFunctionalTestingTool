#Author: varun dev sinha
@abcRestapi
Feature: The abc restAPI is being used by different users within the enterprise banking system.
  Authenticate users sends the Authorized requests to abc restAPI for banking process.

  Background: 
    Given I verify the abc restAPI "end point" is up and running.

  @post @associate
  Scenario Outline: Associate is un-autherized to add a new record.
    Given I get the test data for <"TestCaseId">.
    When I login with "UserId" and "UserPassword" for authentication.
    Then I send "Post" request with "OAuth2AccessToken" for authentication.
    And I validate the required details and response schema.
    And I verify user un-autherization and response body.

    Examples: 
      | TestCaseId    |
      | AMLCRRNSTC001 |

  @post @analyst @supervisor
  Scenario Outline: Analyst and Supervisor are autherized to add a new record.
    Given I get the test data for <"TestCaseId">.
    When I login with "UserId" and "UserPassword" for authentication.
    Then I send "Post" request with "OAuth2AccessToken" for authentication.
    And I validate the required details and response schema.
    And I verify user autherization and response body.

    Examples: 
      | TestCaseId    |
      | AMLCRRNSTC002 |
      | AMLCRRNSTC003 |

  @get @associate
  Scenario Outline: Associate is un-autherized to fetch a record.
    Given I get the test data for <"TestCaseId">.
    When I login with "UserId" and "UserPassword" for authentication.
    Then I send "Get" request with "OAuth2AccessToken" for authentication.
    And I validate the required details and response schema.
    And I verify user un-autherization and response body.

    Examples: 
      | TestCaseId    |
      | AMLCRRNSTC004 |

  @get @analyst @supervisor
  Scenario Outline: Analyst and Supervisor are autherized to fetch a record.
    Given I get the test data for <"TestCaseId">.
    When I login with "UserId" and "UserPassword" for authentication.
    Then I send "Get" request with "OAuth2AccessToken" for authentication.
    And I validate the required details and response schema.
    And I verify user autherization and response body.

    Examples: 
      | TestCaseId    |
      | AMLCRRNSTC005 |
      | AMLCRRNSTC006 |

  @put @associate
  Scenario Outline: Associate is un-autherized to update a record.
    Given I get the test data for <"TestCaseId">.
    When I login with "UserId" and "UserPassword" for authentication.
    Then I send "Put" request with "OAuth2AccessToken" for authentication.
    And I validate the required details and response schema.
    And I verify user un-autherization and response body.

    Examples: 
      | TestCaseId    |
      | AMLCRRNSTC007 |

  @put @analyst @supervisor
  Scenario Outline: Analyst and Supervisor are autherized to update a record.
    Given I get the test data for <"TestCaseId">.
    When I login with "UserId" and "UserPassword" for authentication.
    Then I send "Put" request with "OAuth2AccessToken" for authentication.
    And I validate the required details and response schema.
    And I verify user autherization and response body.

    Examples: 
      | TestCaseId    |
      | AMLCRRNSTC008 |
      | AMLCRRNSTC009 |

  @patch @associate
  Scenario Outline: Associate is un-autherized to partial-update a record.
    Given I get the test data for <"TestCaseId">.
    When I login with "UserId" and "UserPassword" for authentication.
    Then I send "Patch" request with "OAuth2AccessToken" for authentication.
    And I validate the required details and response schema.
    And I verify user un-autherization and response body.

    Examples: 
      | TestCaseId    |
      | AMLCRRNSTC010 |

  @patch @analyst @supervisor
  Scenario Outline: Analyst and Supervisor are autherized to partial-update a record.
    Given I get the test data for <"TestCaseId">.
    When I login with "UserId" and "UserPassword" for authentication.
    Then I send "Patch" request with "OAuth2AccessToken" for authentication.
    And I validate the required details and response schema.
    And I verify user autherization and response body.

    Examples: 
      | TestCaseId    |
      | AMLCRRNSTC011 |
      | AMLCRRNSTC012 |

  @delete @associate
  Scenario Outline: Associate is un-autherized to delete a record.
    Given I get the test data for <"TestCaseId">.
    When I login with "UserId" and "UserPassword" for authentication.
    Then I send "Delete" request with "OAuth2AccessToken" for authentication.
    And I validate the required details and response schema.
    And I verify user un-autherization and response body.

    Examples: 
      | TestCaseId    |
      | AMLCRRNSTC013 |

  @delete @analyst @supervisor
  Scenario Outline: Analyst and Supervisor are autherized to delete a record.
    Given I get the test data for <"TestCaseId">.
    When I login with "UserId" and "UserPassword" for authentication.
    Then I send "Delete" request with "OAuth2AccessToken" for authentication.
    And I validate the required details and response schema.
    And I verify user autherization and response body.

    Examples: 
      | TestCaseId    |
      | AMLCRRNSTC014 |
      | AMLCRRNSTC015 |
