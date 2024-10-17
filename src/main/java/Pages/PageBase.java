package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
    public PageBase(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
    protected WebDriver driver;

    protected void SetElements(WebElement Txt,String Value)
    {
        Txt.sendKeys(Value);
    }
    protected void ClickBtn(WebElement Button)
    {
        Button.click();
    }
}
