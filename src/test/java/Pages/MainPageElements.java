package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPageElements extends Parent {
    public MainPageElements() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "input[data-testid='suggestion']")
    public WebElement searchBox;
    @FindBy(css = "i[data-testid='search-icon']")
    public WebElement searchBtn;

    @FindBy(css = "div[class='prdct-desc-cntnr-ttl-w two-line-text']>span:nth-child(2)")
    public List<WebElement> productList;
    @FindBy(css = "div[class='prdct-desc-cntnr']>span:nth-child(2)")
    public List<WebElement> productinFavoriteList;

    @FindBy(xpath = "(//div[@class='prdct-desc-cntnr']/span)[2]")
    public WebElement firstProcutInFavList;

    @FindBy(css = "a[href='/Hesabim/Favoriler']")
    public WebElement myFavorites;
    @FindBy(css = "a[class='link account-basket']")
    public WebElement myCart;
    @FindBy(xpath = "(//div[@class='ufvrt-btn-wrppr'])[1]")
    public WebElement removeFavButton;
    @FindBy(css = "p[class='empty-favorites-header']")
    public WebElement emptyFavoriteHeader;
    @FindBy(xpath = "//div[@class='pb-basket-item-actions']/button")
    public WebElement deleteButton;
    @FindBy(css = "i[class='i-bagg']+span")
    public WebElement emptyCartMessage;
    @FindBy(xpath = "//span[text()='Tüm Favoriler']")
    public WebElement allFavoritesHeader;

    public WebElement getWebElement(String strButton) {
        switch (strButton) {
            case "searchBox":
                return searchBox;
            case "searchBtn":
                return searchBtn;
            case "myFavorites":
                return myFavorites;
            case "myCart":
                return myCart;
            case "removeFavButton":
                return removeFavButton;
            case "emptyFavoriteHeader":
                return emptyFavoriteHeader;


        }
        return null;

    }
}
