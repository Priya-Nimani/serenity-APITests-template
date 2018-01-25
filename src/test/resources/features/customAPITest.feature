@version=customTestTag

Feature: Testing a REST API
  Users should be able to submit GET and POST requests to a web service,
  represented by Postcode and Geolocation

  Scenario: Look up with a valid postcode
    When a user does a look up for postcode "S6 5BX"
    Then the server should return a success status along with admin district as "Sheffield"

  Scenario: Look up with a invalid postcode
    When a user does a look up for postcode "S12345"
    Then the server should return a error status along with the error message "Invalid postcode"

  Scenario Outline: Validate a postcode
    When a user attempts to validate a postcode "<postcode>"
    Then the server should return the validation status as "<status>"

    Examples:
    |postcode|status|
    |S6 5LH  |true  |
    |LS27 0WH|true  |
    |S12 212 |false |

    Scenario: Get nearest postcodes for a given longitude & latitude
      When user does a search with longitude "0.629805756141451" and lattitude "51.7923253460324"
      Then list of valid postcodes is returned
      |CM8 1EF|
      |CM8 1EU|
      |CM8 1PH|
      |CM8 1PQ|



