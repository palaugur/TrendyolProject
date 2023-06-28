package StepDefinitions;

import Pages.MainPageElements;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class AddDeleteFavoriteListSteps {
    MainPageElements mpe = new MainPageElements();
    public static List<String> favoriteList = new ArrayList<>();

    @When("Add three product to favorite randomly from search result")
    public void addThreeProductToFavoriteRandomlyFromSearchResult() {
        mpe.popupClose();
        List<WebElement> elementList = GWD.getDriver().findElements(By.cssSelector("i[class='fvrt-btn']"));

        for (int i = 0; i < 3; i++) {
            int random;
            List<Integer> intList = new ArrayList<>();

            do {
                random = mpe.randomGenerator(mpe.productList.size());
            } while (intList.contains(random));
            intList.add(random);

            favoriteList.add(mpe.productList.get(random).getAttribute("title"));
            mpe.clickFunction(elementList.get(random));
        }
    }


    @Then("Verify products in favorite list")
    public void verifyProductsInFavoriteList() {

        for (WebElement e : mpe.productinFavoriteList) {
            Assert.assertTrue(favoriteList.contains(e.getAttribute("title")));
        }
    }


    @And("Remove product from favorite list")
    public void removeProductFromFavoriteList() {
        mpe.waitUntilClickable(mpe.allFavoritesHeader);
        for (int i = 0; i < mpe.productinFavoriteList.size(); i++) {
            System.out.println(mpe.productinFavoriteList.size());
            mpe.clickFunction(mpe.removeFavButton);
        }

    }

    @Then("Verify deleted product from favorite List")
    public void verifyDeletedProductFromFavoriteList() {
        mpe.waitUntilVisible(mpe.emptyFavoriteHeader);
        Assert.assertEquals(mpe.emptyFavoriteHeader.getText(), "Favoriler Listeniz Henüz Boş");
    }
}

