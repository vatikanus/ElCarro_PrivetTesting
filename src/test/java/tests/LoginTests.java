package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        if (!TestBase.app.getUserHelper().isLoginPresent()){
            TestBase.app.getUserHelper().logout();

        }
    }
    @Test
    public void loginSuccess()

    {
        User user = new User().withEmail("evgeny@mail.ru").withPassword("123456Sa$");


       TestBase.app.getUserHelper().openloginForm();
      // app.getUserHelper().fillLoginForm("evgeny@mail.ru","123456Sa$");
       TestBase.app.getUserHelper().fillLoginForm(user);
       TestBase.app.getUserHelper().submitForm();
        Assert.assertTrue(TestBase.app.getUserHelper().isLoggedSuccess());

    }
    @AfterMethod
    public void postCondition(){
        TestBase.app.getUserHelper().clickOkButton();
    }
}
