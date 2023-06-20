package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase {

    @BeforeMethod
    public void precondition()
    {
        if(app.getUserHelper().isLoginPresent())
        {
            app.getUserHelper().login(new User().withEmail("evgeny@mail.ru").withPassword("123456Sa$"));
        }

    }

    @Test
    public void addNewCarTestPositive()
    {
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        Car car = Car.builder()
                .address("Tel-Aviv")
                .make("BMW")
                .model("M5")
                .year("2020")
               // .engine("2.5")
                .fuel("Petrol")
                //.gear("MT")
                //.wD("AWD")
                //.doors("5")
                .seats("4")
                .clasS("C")
                //.fuelConsumption("6.5")
                .carRegNum("100-55-"+ i)
                .price("65")
               // .distanceIncluded("500")
                //.typeFeature("type of")
                .about("Very nice car")
                .build();
        app.getCar().openCarForm();
        app.getCar().fillCarForm(car);
        app.getCar().attachedPhoto();
        app.getUserHelper().pause(1000);
        app.getUserHelper().submitForm();

        Assert.assertEquals(app.getCar().textOfElement(),"Car added");

    }
}
