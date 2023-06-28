package StepDefinitions;

import Pages.MainPageElements;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SearchSteps {
    MainPageElements mpe = new MainPageElements();

    @When("Send keys to input in website")
    public void sendKeysToInputInWebsite(DataTable dt) {
        List<List<String>> strList = dt.asLists(String.class);
        for (int i = 0; i < strList.size(); i++) {
            WebElement element = mpe.getWebElement(strList.get(i).get(0));
            mpe.sendKeysFunction(element, strList.get(i).get(1));
        }
    }

    @And("Click on the element in website")
    public void clickOnTheElementInWebsite(DataTable items) {
        List<String> strList = items.asList(String.class);

        for (String str : strList) {

            WebElement element = mpe.getWebElement(str);
            mpe.clickFunction(element);
        }
    }

    @Then("Verify searched products")
    public void verifySearchedProducts(DataTable dt) {

        List<WebElement> elementList = GWD.getDriver().findElements(By.cssSelector("div[class='prdct-desc-cntnr-ttl-w two-line-text']>span:nth-child(2)"));
        List<String> strList = dt.asList(String.class);

        for (String str :strList) {
            for (WebElement e : elementList) {
                String title = e.getAttribute("title");

                Assert.assertTrue(title.toLowerCase().contains(str), "Invalid Title: " + title );

            }
        }
    }
}
