#Author: varun dev sinha
@etl
Feature: The data flow between multiple tables, layers, and databases with implemented business logic.
  The database system is developed and analyse with conditoned data.

  @crr @ist/uat @countValidation1 @singleQueryCount
  Scenario Outline: Verify count of data loaded to the target table.
    Given Test Data loaded for <TestCaseId>.
    When Executes the "DB1_SQLquery" with "DB1_Name" connection and prepare the evidence.
    Then Compare the count of target table data with "DB1_SQLquery_ExpectedResult" value.
    And Upload the evidence to Jira and update the issue status.
    And Close the database connection.

    Examples: 
      | TestCaseId     |
      | AMLCRRDB_TC007 |

  @crr @ist/uat @countValidation2 @doubleQueryCount
  Scenario Outline: Verify count of data loaded to the target table from source table.
    Given Test Data loaded for <TestCaseId>.
    When Executes the "DB1_SQLquery" query with "DB1_Name" connection and "DB2_SQLquery" query with "DB2_Name" connection then prepare the evidence.
    Then Compare the count of target table data with source table data.
    And Upload the evidence to Jira and update the issue status.
    And Close the database connection.

    Examples: 
      | TestCaseId     |
      | AMLCRRDB_TC008 |
      | AMLCRRDB_TC009 |

  @crr @ist/uat @duplicateValidation1 @singleQueryDuplicate
  Scenario Outline: Verify no duplicate data in the target table.
    Given Test Data loaded for <TestCaseId>.
    When Executes the "DB1_SQLquery" with "DB1_Name" connection and prepare the evidence.
    Then Check no duplicate data in the target table.
    And Upload the evidence to Jira and update the issue status.
    And Close the database connection.

    Examples: 
      | TestCaseId     |
      | AMLCRRDB_TC004 |

  @crr @ist/uat @duplicateValidation2 @doubleQueryDuplicate
  Scenario Outline: Verify no duplicate data in the source table and target table.
    Given Test Data loaded for <TestCaseId>.
    When Executes the "DB1_SQLquery" query with "DB1_Name" connection and "DB2_SQLquery" query with "DB2_Name" connection then prepare the evidence.
    Then Check no duplicate data in the source table and target table.
    And Upload the evidence to Jira and update the issue status.
    And Close the database connection.

    Examples: 
      | TestCaseId     |
      | AMLCRRDB_TC005 |
      | AMLCRRDB_TC006 |

  @crr @ist/uat @dataValidation1 @singleQueryData
  Scenario Outline: Verify data in the target table.
    Given Test Data loaded for <TestCaseId>.
    When Executes the "DB1_SQLquery" with "DB1_Name" connection and prepare the evidence.
    Then Check all data in target table is satisfying the conditions.
    And Upload the evidence to Jira and update the issue status.
    And Close the database connection.

    Examples: 
      | TestCaseId     |
      | AMLCRRDB_TC001 |

  @crr @ist/uat @dataValidation2 @doubleQueryData
  Scenario Outline: Verify data is matching in the target table with data of source table.
    Given Test Data loaded for <TestCaseId>.
    When Executes the "DB1_SQLquery" query with "DB1_Name" connection and "DB2_SQLquery" query with "DB2_Name" connection then prepare the evidence.
    Then Check all target table data matching with source table data.
    And Upload the evidence to Jira and update the issue status.
    And Close the database connection.

    Examples: 
      | TestCaseId     |
      | AMLCRRDB_TC002 |
      | AMLCRRDB_TC003 |
