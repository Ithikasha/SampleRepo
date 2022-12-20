@Regression
Feature: Feature to test login functionality

  Scenario: Validate whether user able to reach login page
    Given I am on homepage
    When I click Login button.
    Then I should see login page

  Scenario: Validate whether user able to to login with valid credentials
    Given I am on homepage
    When I click Login button.
    And I enter valid username and password
    Then I should see user able to login with valid credentials

  Scenario: Validate whether the Menu Icon in the Homepage is functional
    Given I am on homepage
    When I click Menu Icon.
    Then I should see the Menu items

  Scenario: Validate whether the Search Icon in the Homepage is functional
    Given I am on homepage
    When I click Search Icon.
    Then I should see the Search Module

  Scenario: Validate whether the Login Icon in the Homepage is functional
    Given I am on homepage
    When I click Login Icon.
    Then I Should see the User is navigated to Login page.

  Scenario: Validate whether the Fifth member club icon is functional
    Given I am on homepage.
    When I click the Fifth member icon.
    Then I should see the User is navigated to Fifth member club page.

  Scenario: Validate whether the Met Store link in the Homepage is functional.
    Given I am on homepage.
    When I click Met Store link.
    Then I should see the User is navigated to Met Store.

  Scenario: Validate whether the Mini Cart icon in the Homepage is functional.
    Given I am on homepage.
    When I click Mini Cart icon.
    Then I should see the Mini Cart view.

  Scenario: Validate whether the Help link in the Global footer is functional.
    Given I am on homepage.
    When I click the Help link.
    Then I should see the User is navigated to Help page.

  Scenario: Validate whether the Return link in the Global footer is functional.
    Given I am on homepage.
    When I click the Return link.
    Then I should see the User is navigated to Return/Exchange policy page.

  Scenario: Validate whether the Credit link in the Global footer is functional.
    Given I am on homepage.
    When I click the Credit link.
    Then I should see the User is navigated to Credits page.

  Scenario: Validate whether the Terms of Use link in the Global footer is functional.
    Given I am on homepage.
    When I click the Terms of Use link.
    Then I should see the User is navigated to Terms of Use and Conditions page.

  Scenario: Validate whether the Privacy Policy link in the Global footer is functional.
    Given I am on homepage.
    When I click the Privacy Policy link.
    Then I should see the User is navigated to Privacy Policy page.

  Scenario: Verify whether the User is able to login to the User Account from Home page
    Given I am on homepage
    When I click Login button.
    And I enter username and password.
    Then I should see user able to login.

  Scenario: Validate whether the User is not able to login with Invalid credentials
    Given I am on homepage
    When I click Login button.
    And I enter Invalid username and password.
    Then I should see the Error message appears.

  Scenario: Verify whether the User is able to login from cartpage
    Given I am on homepage
    When I add a product to cart
    And I enter only username
    And I select the No, I d like to checkout as a guest radio button.
    And I click the Checkout button
    Then I should see the User is navigated to shipping page.

  Scenario: Validate the Personal Information link is clickable in the MyAccount Page.
    Given I am on login page.
    And I login with valid credentials.
    When I click personal information link
    Then I should see the Personal Information page.

  Scenario: Validate the Address link is clickable in the MyAccount Page.
    Given I am on my account page.
    When I click Address link.
    Then I should see the Address detail page.

  Scenario: Validate the Payment Setting link is functional in the MyAccount Page.
    Given I am on my account page.
    When I click Payment Setting link.
    Then I should see the Payment details page.

  Scenario: Validate the Presale codes link is functional in the MyAccount Page.
    Given I am on my account page.
    When I click Payment Setting link.
    Then I should see the Payment details page.

  Scenario: Validate the Free download link is functional in the MyAccount Page.
    Given I am on my account page.
    When I click Free download link.
    Then I should see the Free download page.

  Scenario: Validate the Contest link is functional in the MyAccount Page.
    Given I am on my account page.
    When I click Contest link.
    Then I should see the Contest page.

  Scenario: Validate the Vinyl club link is functional in the MyAccount Page.
    Given I am on my account page.
    When I click vinyl club link.
    Then I should see the Vinyl club details page.

  Scenario: Validate the Order history link is functional in the MyAccount Page.
    Given I am on my account page.
    When I click  Order history link.
    Then I should see the Order details page.

  Scenario: Validate the Product Image and description displayed.
    Given I am on homepage
    When I click MetStore icon
    And I select any product
    Then I should see the Product image and description

  Scenario: Validate the Einstein Product recommendations below the product.
    Given I am on homepage
    When I click MetStore icon
    And I select any product
    Then I should see the Einstein Product recommendations below the product.

  Scenario: Validate the share icons in the PDP is functional
    Given I am on homepage
    When I click MetStore icon
    And I select any product
    And I click the Share icons.
    Then I should see the User is navigated to the respective pages.

  Scenario: Validate the quantity can be added as per user requirements from the PDP
    Given I am on homepage
    When I click MetStore icon
    And I select any product
    And I add the quantity of the product
    And I click Add to cart button
    Then I should see the product with the added quantity

  Scenario: Validate the Pre-order functionality for pre-order products.
    Given I am on homepage
    And I search for pre-order product
    When I click pre-order button
    Then I should see the Pre-Order popup modal.

  Scenario: Verify whether products added are reflecting in cart page.
    Given I am on homepage
    When I click MetStore icon
    And I select any product
    And I click Add to cart button
    Then I should see the products are reflecting in cart page.

  Scenario: Verify whether the user is able to update product quantity in the Cart page.
    Given I am on homepage
    When I click MetStore icon
    And I select any product
    And I click Add to cart button
    And I update the quantity of the product.
    And I click Update cart button
    Then I should see the quantity of the product is updated.
