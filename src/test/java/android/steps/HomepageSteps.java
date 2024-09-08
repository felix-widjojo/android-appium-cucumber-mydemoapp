package android.steps;

import android.pages.Homepage;
import android.pages.PagePool;
import android.utility.TestData;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomepageSteps {

    @Given("Customer open customer app")
    public void customerOpenCustomerApp() throws Exception {
        AndroidDriver androidDriver = PagePool.homepage.appiumStart();
        PagePool.homepage = new Homepage(androidDriver);
    }
    @When("Customer click {string} product name")
    public void customerClickProductName(String name) {
        PagePool.homepage.clickProduct(name);
    }

    @Then("Customer click {string} product color")
    public void customerClickProductColor(String color) {
        PagePool.homepage.clickProductColor(color);
    }

    @And("Customer click plus icon by {int} to increase quantity")
    public void customerClickPlusIconByToIncreaseQuantity(int number) {
        PagePool.homepage.clickPlusIcon(number);
    }

    @And("Customer click Add to cart button")
    public void customerClickAddToCartButton() {
        PagePool.homepage.click(PagePool.homepage.idAddToCartButton);
    }

    @And("Customer click Shopping Cart button")
    public void customerClickCartButton() {
        PagePool.homepage.click(PagePool.homepage.idShoppingCartButton);
    }

    @And("Customer click Proceed to Checkout button")
    public void customerClickProceedToCheckoutButton() {
        PagePool.homepage.click(PagePool.homepage.ProceedToCheckoutButton);
    }

    @And("Customer login with {string} username and {string} password")
    public void customerLoginWithUsernameAndPassword(String username, String password) {
        PagePool.homepage.sendKeys(PagePool.homepage.idUsernameField, username);
        PagePool.homepage.sendKeys(PagePool.homepage.idPasswordField, password);
        PagePool.homepage.click(PagePool.homepage.idLoginButton);
    }

    @And("Customer enter {string} as Full Name")
    public void customerEnterAsFullName(String fullname) {
        PagePool.homepage.sendKeys(PagePool.homepage.idFullNameField, fullname);
    }

    @And("Customer enter {string} as Address Line 1")
    public void customerEnterAsAddressLine(String address) {
        PagePool.homepage.sendKeys(PagePool.homepage.idAddressLine1Field, address);
    }

    @And("Customer enter {string} as City")
    public void customerEnterAsCity(String city) {
        PagePool.homepage.sendKeys(PagePool.homepage.idCityField, city);
    }

    @And("Customer enter {string} as Zip Code")
    public void customerEnterAsZipCode(String zipcode) {
        PagePool.homepage.sendKeys(PagePool.homepage.idZipCodeField, zipcode);
    }

    @And("Customer enter {string} as Country")
    public void customerEnterAsCountry(String country) {
        PagePool.homepage.sendKeys(PagePool.homepage.idCountryField, country);
    }

    @And("Customer click Payment button")
    public void customerClickPaymentButton() {
        PagePool.homepage.scrollToElementByID(PagePool.homepage.idPaymentButtonScroll);
        PagePool.homepage.click(PagePool.homepage.idPaymentButton);
    }

    @And("Customer enter {string} as Card Holder Full Name")
    public void customerEnterAsCardHolderFullName(String fullnameCC) {
        PagePool.homepage.sendKeys(PagePool.homepage.idFullNameCCField, fullnameCC);
    }

    @And("Customer enter {string} as Card Number")
    public void customerEnterAsCardNumber(String cardNumber) {
        PagePool.homepage.sendKeys(PagePool.homepage.idCardNumberField, cardNumber);
    }

    @And("Customer enter {string} as Expiration Date")
    public void customerEnterAsExpirationDate(String expDate) {
        PagePool.homepage.sendKeys(PagePool.homepage.idExpField, expDate);
    }

    @And("Customer enter {string} as Security Code")
    public void customerEnterAsSecurityCode(String securityCode) {
        PagePool.homepage.sendKeys(PagePool.homepage.idCVVField, securityCode);
    }

    @And("Customer click Review Order button")
    public void customerClickReviewOrderButton() {
        PagePool.homepage.click(PagePool.homepage.idReviewOrderButton);
    }

    @And("Customer check order and click Place Order button")
    public void customerClickPlaceOrderButton() {
        PagePool.homepage.assertText(PagePool.homepage.idItemName, TestData.getItemName());
        PagePool.homepage.assertText(PagePool.homepage.idItemQuantity, TestData.getItemQuantity() + " Items");
        PagePool.homepage.click(PagePool.homepage.idPlaceOrderButton);
    }

    @Then("Customer click Continue Shopping button")
    public void customerClickContinueShoppingButton() {
        PagePool.homepage.check(PagePool.homepage.idCheckoutComplete);
        PagePool.homepage.check(PagePool.homepage.idThankYou);
        PagePool.homepage.check(PagePool.homepage.idSwagTV);
        PagePool.homepage.check(PagePool.homepage.idOrderTV);
        PagePool.homepage.check(PagePool.homepage.idHorseIV);
        PagePool.homepage.click(PagePool.homepage.idshoopingBt);
    }
}
