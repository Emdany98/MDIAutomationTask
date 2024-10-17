package Tests;

import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class TestCase extends TestBase {
    HomePage HomePageObject;


    @Test
    public void Test_Case() throws AWTException, InterruptedException {
        HomePageObject = new HomePage(driver);

        HomePageObject.SelectLanguage();
        HomePageObject.SelectEnglishLang();
        HomePageObject.ClickSaveBtn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(HomePageObject.SignInBtn));
        HomePageObject.UserSignInBtn();
        wait.until(ExpectedConditions.elementToBeClickable(HomePageObject.EmailTxt));
        HomePageObject.Login("01063146629", "EMdany");
        HomePageObject.AllItemsList();
        wait.until(ExpectedConditions.visibilityOf(HomePageObject.SeeAllBtn));
        HomePageObject.SeeAll();
        Actions actions = new Actions(driver);
        for (int i = 0; i < 10; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            Thread.sleep(500);
        }
        Thread.sleep(1000);
        HomePageObject.VideoGamesItem();
        HomePageObject.VideoGamesPage();
        wait.until(ExpectedConditions.elementToBeClickable(HomePageObject.FreeShippingRBtn));
        HomePageObject.FreeShipping();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        HomePageObject.Condition();
        wait.until(ExpectedConditions.visibilityOf(HomePageObject.DropDown));
        HomePageObject.DropDownList();
        HomePageObject.Sort();

        Thread.sleep(500);
        double totalPrice=0;
        int numberPages = 0;
        int totalProductsAdded = 0;

        while (totalProductsAdded<20 && numberPages < 3) {
            int elementsAddedInSinglePage = 0;

            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.s-result-item.s-asin")));
            List<WebElement> ProductImage = driver.findElements(By.cssSelector("div.s-result-item.s-asin"));
            for (WebElement product : ProductImage) {

                try {
//                   Fetching price from front end
                    WebElement ProductPrice = product.findElement(By.cssSelector("span.a-price-whole"));
                    WebElement ProductFractionPrice = product.findElement(By.cssSelector("span.a-price-fraction"));
                    String priceText = ProductPrice.getText() + "." + ProductFractionPrice.getText();

//                   Converting fetched price from text to double
                    priceText = priceText.replace(",", "").trim();
                    double price = Double.parseDouble(priceText);

                    if (price < 15000) {
                        WebElement AddToCartBtn = product.findElement(By.cssSelector("button.a-button-text"));

//                       Scroll down to Add to Cart Button
                        js.executeScript("arguments[0].scrollIntoView(true);", AddToCartBtn);
                        AddToCartBtn.click();
                        Thread.sleep(1000);

                        elementsAddedInSinglePage += 1;
                        totalProductsAdded += 1;
                        totalPrice += price;
                    }
                } catch (Exception e) {
                    // Some product in the amazon website doesn't have span.a-price-whole
                    // To prevent the code from crashing we added Try and catch block
                }
            }

            actions.moveToElement(HomePageObject.NextPage);
            HomePageObject.NextPage();
            wait.until(ExpectedConditions.elementToBeClickable(HomePageObject.NextPage));

            numberPages += 1;

        }

        HomePageObject.GoToCart();

        //This assertion to compare between the elements I added in the cart with the elements that already exists
        List<WebElement> items = driver.findElements(By.cssSelector("[data-bundleitem='absent']"));
        int actualCount = items.size();
        Assert.assertEquals(actualCount, totalProductsAdded);

        //After the assertion I want to proceed to my basket so this button to Go to my cart and to wait till the condition is performed
        HomePageObject.ProceedToBuy();
        wait.until(ExpectedConditions.invisibilityOf(HomePageObject.ProceedToBuyBtn));
        HomePageObject.ValuPaymentMethod();
        HomePageObject.ChoosePaymentMethod();
        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOf(HomePageObject.totalOrderPrice));
        wait.until(ExpectedConditions.elementToBeClickable(HomePageObject.totalOrderPrice));

        String PriceText=HomePageObject.totalOrderPrice.getText().trim();
        String numericValue=PriceText.replaceAll("[^\\d.]", "").replace(",","");
        double price=Double.parseDouble(numericValue);

        //This Assertion in order to compare between the expected price I calculated while adding elements in my cart and between the actual price calculated with shipping and fees
        System.out.println("Expected price:  "+price);
        System.out.println("the actual calculated price: "+ totalPrice);
        Assert.assertEquals(price,totalPrice);

        // Scroll down till you find the Verify Your order button at the end of the page
        js.executeScript("arguments[0].scrollIntoView(true);", HomePageObject.VerifyYourOrderBtn);
        System.out.println(HomePageObject.VerifyYourOrderBtn.getText());

    }
}
