package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase
{
    public HelperUser(WebDriver wd)
    {
        super(wd);
    }

    public boolean isLoginPresent()
    {
        return  isElementPresent(By.xpath("//a[text()= ' Log in ']"));
    }

    public void logout() {
        click(By.xpath("//a[text() = ' Logout ']"));

    }


}
