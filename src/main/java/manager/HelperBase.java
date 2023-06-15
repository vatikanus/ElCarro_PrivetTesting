package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public boolean isElementPresent(By locator)
    {
        return wd.findElements(locator).size()>0;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text)
    {
        if(text != null && !text.isEmpty())
        {
            WebElement el = wd.findElement(locator);
            el.click();
            el.clear();
            el.sendKeys(text);

        }
    }
}

