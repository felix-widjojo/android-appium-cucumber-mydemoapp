package android.pages;

import android.utility.TestData;
import bases.AndroidBasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;


public class Homepage extends AndroidBasePage {

    public By idAddToCartButton = By.id("cartBt");
    //Shopping Cart Page
    public By idShoppingCartButton = By.id("cartIV");
    public By ProceedToCheckoutButton = By.xpath("//android.widget.Button[@content-desc='Confirms products for checkout']");
    //Login Page
    public By idUsernameField = By.id("nameET");
    public By idPasswordField = By.id("passwordET");
    public By idLoginButton = By.id("loginBtn");
    //Checkout Personal Details Page
    public By idFullNameField = By.id("fullNameET");
    public By idAddressLine1Field = By.id("address1ET");
    public By idCityField = By.id("cityET");
    public By idZipCodeField = By.id("zipET");
    public By idCountryField = By.id("countryET");
    public By idPaymentButton = By.id("paymentBtn");
    public String idPaymentButtonScroll = "paymentBtn";
    //Checkout CC Details Page
    public By idFullNameCCField = By.id("nameET");
    public By idCardNumberField = By.id("cardNumberET");
    public By idExpField = By.id("expirationDateET");
    public By idCVVField = By.id("securityCodeET");
    public By idReviewOrderButton = By.id("paymentBtn");
    //Checkout Place Order Details Page
    public By idItemName = By.id("titleTV");
    public By idItemQuantity = By.id("itemNumberTV");
    public By idPlaceOrderButton = By.id("paymentBtn");
    //Checkout Complete Page
    public By idCheckoutComplete = By.id("completeTV");
    public By idThankYou = By.id("thankYouTV");
    public By idSwagTV = By.id("swagTV");
    public By idOrderTV = By.id("orderTV");
    public By idHorseIV = By.id("horseIV");
    public By idshoopingBt = By.id("shoopingBt");

    public Homepage(AndroidDriver<AndroidElement> androidDriver) {
        super(androidDriver);
    }

    //Home Page
    public void clickProduct(String name) {
        String idProductText = "titleTV";
        By productImage = By.xpath("//android.widget.ImageView[@content-desc = '" + name + "']");

        scrollToElementByTextAndID(idProductText, name);
        click(productImage);
        TestData.setItemName(name);
    }

    // Product Details Page
    public void clickProductColor(String color) {
        By productColorImage = By.xpath("//android.widget.ImageView[@content-desc = '" + color + " color']");
        click(productColorImage);
    }

    public void clickPlusIcon(int number) {
        By idPlusIconClick = By.id("plusIV");
        String idPlusIcon = "plusIV";
        scrollToElementByID(idPlusIcon);
        for (int i = 1; i < number; i++) {
            click(idPlusIconClick);
        }
        TestData.setItemQuantity(number);
    }
}
