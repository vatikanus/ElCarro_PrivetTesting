package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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


    public void openloginForm()
    {
        click(By.xpath("//a[text()= ' Log in ']"));
    }
    public void fillLoginForm(String email,String password) {
        type(By.id("email"), email);
        type(By.id("password"), password);

    }

    public void fillLoginForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());

    }


    public void submitForm() {
        click(By.cssSelector("[type='submit']"));
    }

    public boolean isLoggedSuccess() {
        WebDriverWait wait = new WebDriverWait(wd,10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("#mat-dialog-0"))));
        return wd.findElement(By.cssSelector("#mat-dialog-0")).getText().contains("success");
    }

    public void clickOkButton() {
        if(isElementPresent(By.xpath("//*[@id=\"mat-dialog-0\"]/app-error/div/div/button")))
            click(By.xpath("//*[@id=\"mat-dialog-0\"]/app-error/div/div/button"));
    }
}
