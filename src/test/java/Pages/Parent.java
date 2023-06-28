package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Parent {

    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));

    public void hoverElement(WebElement element) {
        Actions actions = new Actions(GWD.getDriver());
        actions.moveToElement(element).build().perform();
    }

    public void sendKeysFunction(WebElement element, String text) {
        waitUntilVisible(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void clickFunction(WebElement element) {
        waitUntilClickable(element);
        scrollToElement(element);
        element.click();
    }


    public void verifyContainsTextFunction(WebElement element, String value) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
        Assert.assertTrue(element.getText().contains(value), "Text not found");
        //new Actions(PageDriver.getDriver()).sendKeys(Keys.ESCAPE).perform();
    }

    public void verifyElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue((element.isDisplayed()));
    }


    public void scrollToElement(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", element);
    }

    public void jsClickFunction(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", element);
        js.executeScript("arguments[0].click;", element);
    }

    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilNoStale(WebElement element) {
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    public int randomGenerator(int max) {
        return (int) (Math.random() * max);
    }

    public void popupClose() {

        List<WebElement> popupList = GWD.getDriver().findElements(By.cssSelector("div[class='popup']"));


        if (popupList.size() > 0) {
            WebElement close = GWD.getDriver().findElement(By.cssSelector("div[class='overlay']"));
            clickFunction(close);
        }
    }
    public void cartPopupClose(){

        List<WebElement> cartPopup = GWD.getDriver().findElements(By.xpath("//button[text()='Anladım']"));
        if (cartPopup.size() > 0) {
            WebElement closePopup = GWD.getDriver().findElement(By.xpath("//button[text()='Anladım']"));
            clickFunction(closePopup);
        }
    }
}


