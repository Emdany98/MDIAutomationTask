package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"icp-language-settings\"]/div[3]/div/label/span/span")
    WebElement SelectEnglish;

    public void SelectEnglishLang() {
        ClickBtn(SelectEnglish);
    }

    @FindBy(css = "input.a-button-input")
    WebElement SaveBtn;

    public void ClickSaveBtn() {
        ClickBtn(SaveBtn);
    }

    @FindBy(id = "icp-nav-flyout")
    WebElement SelectLanguage;

    public void SelectLanguage() {
        ClickBtn(SelectLanguage);
    }

    @FindBy(partialLinkText = "Account & Lists")
    public WebElement SignInBtn;

    public void UserSignInBtn() {
        ClickBtn(SignInBtn);
    }

    @FindBy(id = "ap_email")
    public WebElement EmailTxt;

    @FindBy(id = "continue")
    WebElement ContinueBtn;

    @FindBy(id = "ap_password")
    WebElement PasswordTxt;

    @FindBy(id = "signInSubmit")
    WebElement SignInSubmitBtn;

    public void Login(String Email, String Password) {
        SetElements(EmailTxt, Email);
        ClickBtn(ContinueBtn);
        SetElements(PasswordTxt, Password);
        ClickBtn(SignInSubmitBtn);
    }

    @FindBy(id = "nav-hamburger-menu")
    public WebElement AllItemsBtn;

    public void AllItemsList() {
        ClickBtn(AllItemsBtn);
    }


    @FindBy(xpath = "/html/body/div[3]/div[2]/div/ul[1]/li[14]")
    public WebElement SeeAllBtn;

    public void SeeAll() {
        ClickBtn(SeeAllBtn);
    }

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/ul[1]/ul/li[11]/a")
    public WebElement VideoGamesList;

    public void VideoGamesItem() {
        ClickBtn(VideoGamesList);
    }

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/ul[32]/li[3]/a")
    WebElement AllVideoGamesList;

    public void VideoGamesPage() {
        ClickBtn(AllVideoGamesList);
    }

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/ul/li/span/a/div[1]/label")
    public WebElement FreeShippingRBtn;

    public void FreeShipping() {
        ClickBtn(FreeShippingRBtn);
    }

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/span/div/span/div/div/div[7]/ul[1]/span/span[1]/li/span")
    public WebElement ConditionFilter;
    public void Condition(){ClickBtn(ConditionFilter);}

    @FindBy(id = "a-autoid-0-announce")
    public WebElement DropDown;

    public void DropDownList() {
        ClickBtn(DropDown);
    }

    @FindBy(xpath = "/html/body/div[5]/div/div/ul/li[3]")
    WebElement SortingChoice;

    public void Sort() {
        ClickBtn(SortingChoice);
    }

    @FindBy(xpath="//div[contains(@class, 's-product-image-container') and contains(@class, 'aok-relative')]")
    public List<WebElement> ProductsImage;


    @FindBy(css = "a.s-pagination-next")
    public WebElement NextPage;
    public void NextPage()
    {
        ClickBtn(NextPage);
    }

    @FindBy(id = "nav-cart-count-container")
    public WebElement GoToCartBtn;
    public void GoToCart()
    {
        ClickBtn(GoToCartBtn);
    }
    @FindBy(name = "proceedToRetailCheckout")
    public WebElement ProceedToBuyBtn;
    public void ProceedToBuy()
    {
        ClickBtn(ProceedToBuyBtn);
    }
    @FindBy(xpath = "//input[@type='radio' and contains(@value, 'instrumentId=amzn1.pm.pma.gil-TG9hbjpHbG9iYWxJbnN0YWxsbWVudExlbmRpbmdDcmVkaXRMaW5l')]")
    public WebElement PaymentMethodRBtn;
    public void ValuPaymentMethod()
    {
        ClickBtn(PaymentMethodRBtn);
    }

    @FindBy(xpath = "//span[@id='orderSummaryPrimaryActionBtn']")
    public WebElement PaymentMethodBtn;
    public void ChoosePaymentMethod()
    {
        ClickBtn(PaymentMethodBtn);
    }

    @FindBy(id = "bottomSubmitOrderButtonId-announce")
    public WebElement VerifyYourOrderBtn;

    @FindBy(xpath = "//td[contains(@class, 'grand-total-price') and contains(text(), 'EGP')]")
    public WebElement totalOrderPrice;
}

