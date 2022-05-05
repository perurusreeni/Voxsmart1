Feature: Shopping Feature
@loginandshopaproductwithlowprice
Scenario Outline: E2E shopping page scenario
Given user launch the url
When the user entered valid "<username>" and "<password>" 
Then page title should be "Swag Labs"
When the user sort the pricing as low to high and add the lowest priced product in the cart
Then click the cart and proceed checkout
And the user enters the basic details and click continue
Then validate the order information and click on finish button
And the user will be redirect to a page and finally quit

Examples:
|username|password|
|standard_user|secret_sauce|


@InvalidCredentialValidation
  Scenario: Login validation with invalid credentials
    Given user launch the url
    Then enter the invalid credential and click submit
      | username      | password     |
      | standard_user | secret_sauces |



