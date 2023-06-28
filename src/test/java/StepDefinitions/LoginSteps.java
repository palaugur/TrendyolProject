package StepDefinitions;

import Pages.LoginPageElements;
import Utilities.ExcelUtility;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class LoginSteps {

    LoginPageElements lpe = new LoginPageElements();

    @Given("Navigate to main page")
    public void navigateToMainPage() {
        GWD.getDriver().get("https://www.trendyol.com/en/select-country");

    }

    @And("Select Country")
    public void selectCountry(DataTable dt) {
        WebElement countryHeader = GWD.getDriver().findElement(By.cssSelector("div[class='country-header']"));
        lpe.waitUntilVisible(countryHeader);
        WebElement selectCountry = GWD.getDriver().findElement(By.cssSelector("div[class='country-select']>select"));
        Select select = new Select(selectCountry);

        List<String> strList = dt.asList(String.class);
        for (String str : strList) {
            select.selectByVisibleText(str);
        }
        WebElement selectBtn = GWD.getDriver().findElement(By.xpath("//button[text()='Select']"));
        selectBtn.click();
    }

    @And("Hover on the element")
    public void hoverOnTheElement(DataTable dt) {
        List<String> strList = dt.asList(String.class);
        for (String str : strList) {
            WebElement element = lpe.getWebElement(str);
            lpe.hoverElement(element);
        }
    }

    @And("Click on the element")
    public void clickOnTheElement(DataTable dt) {
        List<String> strList = dt.asList(String.class);
        for (String str : strList) {
            WebElement element = lpe.getWebElement(str);
            lpe.clickFunction(element);
        }
    }

    @When("Enter information from Excel")
    public void enterInformationFromExcel(DataTable dt) {
        List<List<String>> strList = dt.asLists(String.class);
        for (int i = 0; i < strList.size(); i++) {
            WebElement element = lpe.getWebElement(strList.get(i).get(0));
            lpe.sendKeysFunction(element, ExcelUtility.findFromExcel(strList.get(i).get(1)));
        }

    }


    @Then("Control element status is disabled")
    public void controlElementStatusIsDisabled(DataTable dt) {
        List<String> strList = dt.asList(String.class);
        for (String str : strList) {
            WebElement element = lpe.getWebElement(str);
            Assert.assertFalse(element.isEnabled());
            //System.out.println(element.isEnabled());
        }
    }

    @Then("Message or element should be seen")
    public void messageOrElementShouldBeSeen(DataTable dt) {
        List<List<String>> items = dt.asLists(String.class);

        for (int i = 0; i < items.size(); i++) {
            WebElement element = lpe.getWebElement(items.get(i).get(0));
            String text = items.get(i).get(1);

            lpe.verifyContainsTextFunction(element, text);
            //System.out.println("element = " + element.getText());
            //System.out.println("text = " + text);

        }
    }


}

