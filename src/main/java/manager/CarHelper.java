package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarHelper extends HelperBase {


    public CarHelper(WebDriver wd) {
        super(wd);
    }

    public void openCarForm() {
        click(By.xpath("//*[@id=\"1\"]"));
    }

    public void fillCarForm(Car car) {
        if(isCarCreationFormPresent())
        {
            typeLocation( car.getAddress());
            type(By.id("make"),car.getMake());
            type(By.id("model"),car.getModel());
            type(By.id("year"),car.getYear());
            //type(By.id("engine"),car.getEngine());

            select(By.id("fuel"),car.getFuel());
           // select(By.id("gear"),car.getGear());
            //select(By.id(""));
            type(By.id("seats"), car.getSeats());
            type(By.id("class"),car.getClasS());
            type(By.id("serialNumber"),car.getCarRegNum());
            type(By.id("price"),car.getPrice());
            type(By.id("about"), car.getAbout());



        }
    }

    public void select(By locator, String option) {
        //new Select(wd.findElement(locator)).selectByIndex(2);
          new Select(wd.findElement(locator)).selectByValue(option);
       // new Select(wd.findElement(locator)).selectByVisibleText("Petrol");
    }

    private void typeLocation( String address) {
        type(By.cssSelector("#pickUpPlace"),address);
        click(By.cssSelector("#pickUpPlace"));
        click(By.cssSelector("div.pac-item"));
        pause(500);

    }

    private boolean isCarCreationFormPresent()
    {
        Boolean isForm = new WebDriverWait(wd, 10).until(ExpectedConditions
                .textToBePresentInElement(wd.findElement(By.cssSelector("h2")), "Write some details about your car to rent it out"));
        return isForm;
    }

    public void attachedPhoto()
    {
        wd.findElement(By.id("photos")).sendKeys("C:\\TestTelRan\\ElCarro_PrivetTesting\\bmw m5.jpeg");
    }
    public String textOfElement()
    {
        return ElementPresent(By.cssSelector("#mat-dialog-1 > app-error > div > h1"));
    }

}
