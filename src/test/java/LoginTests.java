import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        if (!app.getUserHelper().isLoginPresent()){
            app.getUserHelper().logout();

        }
    }
    @Test
    public void loginSuccess()
    {
        app.getUserHelper().openloginForm();
        app.getUserHelper().fillLoginForm("noa@gmail.com","Nnoa12345$");
        


    }
}
