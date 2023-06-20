package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    HelperUser userHelper;
    CarHelper car;

    public HelperUser getUserHelper() {
        return userHelper;
    }

    public void init()
    {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.web.app/");
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        userHelper  = new HelperUser(wd);
        car = new CarHelper(wd);

    }
    public void stop()
    {
        wd.quit();
    }

    public CarHelper getCar() {
        return car;
    }
}


