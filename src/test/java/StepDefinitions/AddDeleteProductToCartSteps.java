package StepDefinitions;

import Pages.MainPageElements;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AddDeleteProductToCartSteps {
    MainPageElements mpe = new MainPageElements();

    public static List<String> cartList = new ArrayList<>();

    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));

    @When("Add three product to Cart randomly from search result")
    public void addThreeProductToCartRandomlyFromSearchResult() {
        mpe.popupClose();
        List<WebElement> elementList = GWD.getDriver().findElements(By.cssSelector("button[class='add-to-basket-button']"));

        for (int i = 0; i < 3; i++) {
            int random;
            List<Integer> intList = new ArrayList<>();

            do {
                random = mpe.randomGenerator(mpe.productList.size());
            } while (intList.contains(random));
            intList.add(random);

            cartList.add(mpe.productList.get(random).getAttribute("title"));
            mpe.clickFunction(elementList.get(random));
        }
    }


    @Then("Verify products in Cart")
    public void verifyProductsInCart() {
        for (WebElement e : mpe.productinFavoriteList) {
            Assert.assertTrue(cartList.contains(e.getAttribute("title")));
        }


    }

    @And("Remove product from the cart")
    public void removeProductFromTheCart() {
        mpe.popupClose();
        for (int i = 0; i < 3; i++) {
            mpe.clickFunction(mpe.deleteButton);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'ty-display-flex ty-modal ty-bordered')]")));
        }
    }


    @Then("Verify deleted product from Cart")
    public void verifyDeletedProductFromCart() {

        Assert.assertTrue(mpe.emptyCartMessage.getText().contains("Sepetinde ürün bulunmamaktadır."));
    }
}


