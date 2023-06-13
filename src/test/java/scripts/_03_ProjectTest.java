package scripts;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.omg.CORBA.Current;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Project3Page;
import utils.DropdownHandler;
import utils.Waiter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class _03_ProjectTest extends Base {
    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend/project-3");
        project3Page = new Project3Page();
    }

    @Test(priority = 1, description = "Test Case 01 - Validate the default Book your trip form")
    public void validateTheDefaultBookYourTripForm() {

        Assert.assertTrue(project3Page.oneWayRadioButton.isDisplayed());
        Assert.assertTrue(project3Page.oneWayRadioButton.isEnabled());
        Assert.assertTrue(project3Page.oneWayRadioButton.isSelected());

        Assert.assertTrue(project3Page.roundTripRadioButton.isDisplayed());
        Assert.assertTrue(project3Page.roundTripRadioButton.isEnabled());
        Assert.assertFalse(project3Page.roundTripRadioButton.isSelected());

        Assert.assertTrue(project3Page.cabinClassLabel.isDisplayed());
        Assert.assertTrue(project3Page.cabinClassDropdown.isDisplayed());

        Assert.assertTrue(project3Page.fromLabel.isDisplayed());
        Assert.assertTrue(project3Page.fromDropdown.isDisplayed());

        Assert.assertTrue(project3Page.toLabel.isDisplayed());
        Assert.assertTrue(project3Page.toDropdown.isDisplayed());

        Assert.assertTrue(project3Page.departLabel.isDisplayed());
        Assert.assertTrue(project3Page.departDatePicker.isDisplayed());

        Assert.assertTrue(project3Page.returnLabel.isDisplayed());
        Assert.assertTrue(project3Page.returnDatePicker.isDisplayed());

        Assert.assertTrue(project3Page.numberOfPassengersLabel.isDisplayed());
        Assert.assertTrue(project3Page.numberOfPassengersDropdown.isDisplayed());
        // Assert.assertEquals(project3Page.numberOfPassengersDropdown.getAttribute(project3Page.numberOfPassengersDropdown.getText()), "1");

        Assert.assertTrue(project3Page.passenger1CategoryLabel.isDisplayed());
        Assert.assertTrue(project3Page.passenger1CategoryDropdown.isDisplayed());
        // Assert.assertEquals(project3Page.passenger1CategoryDropdown.getAttribute());

        Assert.assertTrue(project3Page.bookButton.isDisplayed());
        Assert.assertTrue(project3Page.bookButton.isEnabled());

    }

    @Test(priority = 1, description = "Test Case 02 - Validate the Book your trip form when Round trip is selected")
    public void validateTheBookYourTripRoundTripSelected() {
        project3Page.roundTripRadioButton.click();
        Assert.assertTrue(project3Page.roundTripRadioButton.isSelected());
        Assert.assertFalse(project3Page.oneWayRadioButton.isSelected());

        Assert.assertTrue(project3Page.cabinClassLabel.isDisplayed());
        Assert.assertTrue(project3Page.cabinClassDropdown.isDisplayed());

        Assert.assertTrue(project3Page.fromLabel.isDisplayed());
        Assert.assertTrue(project3Page.fromDropdown.isDisplayed());

        Assert.assertTrue(project3Page.toLabel.isDisplayed());
        Assert.assertTrue(project3Page.toDropdown.isDisplayed());

        Assert.assertTrue(project3Page.departLabel.isDisplayed());
        Assert.assertTrue(project3Page.departDatePicker.isDisplayed());

        Assert.assertTrue(project3Page.returnLabel.isDisplayed());
        Assert.assertTrue(project3Page.returnDatePicker.isDisplayed());

        Assert.assertTrue(project3Page.numberOfPassengersLabel.isDisplayed());
        Assert.assertTrue(project3Page.numberOfPassengersDropdown.isDisplayed());
        // Assert.assertTrue(project3Page.numberOfPassengersDropdown.isDisplayed());

        Assert.assertTrue(project3Page.passenger1CategoryLabel.isDisplayed());
        Assert.assertTrue(project3Page.passenger1CategoryDropdown.isDisplayed());
        // Assert.assertTrue(project3Page.passenger1CategoryDropdown.isDisplayed());

        Assert.assertTrue(project3Page.bookButton.isDisplayed());
        Assert.assertTrue(project3Page.bookButton.isEnabled());

    }

    @Test(priority = 3, description = "Test Case 03 - Validate the booking for 1 passenger and one way")
    public void validateBookingFor1PassengerOneWay() {
        project3Page.oneWayRadioButton.click();

        DropdownHandler.selectByVisibleText(project3Page.cabinClassDropdown, "Business");
        DropdownHandler.selectByVisibleText(project3Page.fromDropdown, "Illinois");
        DropdownHandler.selectByVisibleText(project3Page.toDropdown, "Florida");

        project3Page.departDatePicker.sendKeys("18");
        Waiter.pause(3);

        DropdownHandler.selectByVisibleText(project3Page.numberOfPassengersDropdown, "1");
        DropdownHandler.selectByVisibleText(project3Page.passenger1CategoryDropdown, "Senior (65+)");
        Waiter.pause(3);

        project3Page.bookButton.click();
        Waiter.pause(3);
        Assert.assertEquals(project3Page.confirmationMessage.getText(), "DEPART\n" +
                "IL to FL\n" +
                "Sun Jun 18 2023\n" +
                "Number of Passengers: 1\n" +
                "Passenger 1: Senior (65+)\n" +
                "Cabin class: Business");
    }

    @Test(priority = 4, description = "Test Case 04 - Validate the booking for 1 passenger and round trip")
    public void validateBookingRoundTrip() {
               /*

       Navigate to https://techglobal-training.com/frontend/project-3
       Select the “Round trip” radio button
       Select “First” for the “Cabin Class” dropdown
       Select “California” for the “From” dropdown
       Select “Illinois” for the “To” dropdown
       Select the next week for the ”Depart”
       Select the next month for the “Return”
       Select “1” for the “Number of passengers” dropdown
       Select “Adult (16-64)” for the Passenger 1 dropdown
       Click on the “BOOK” button
       Validate the booking information displayed below
       DEPART
       CA to IL
       {dynamic date}
       Number of passengers: 1
       Passenger 1: Adult (16-64)
       Cabin Class: First


       RETURN
       IL to CA
       {dynamic date}
       */



        project3Page.roundTripRadioButton.click();
        DropdownHandler.selectByVisibleText(project3Page.cabinClassDropdown, "First");
        DropdownHandler.selectByVisibleText(project3Page.fromDropdown, "California");
        DropdownHandler.selectByVisibleText(project3Page.toDropdown, "Illinois");

        //project3Page.departDatePicker.sendKeys("18");
        //  project3Page.returnDatePicker.sendKeys("18");

        DropdownHandler.selectByVisibleText(project3Page.numberOfPassengersDropdown, "1");
        DropdownHandler.selectByVisibleText(project3Page.passenger1CategoryDropdown, "Adult (16-64)");
        Waiter.pause(3);

        project3Page.bookButton.click();
        Waiter.pause(3);
        Assert.assertEquals(project3Page.confirmationMessage.getText(), "DEPART\n" +
                "CA to IL\n" +
                "Sun Jun 18 2023\n" +
                "Number of Passengers: 1\n" +
                "Passenger 1: Adult (16-64)\n" +
                "Cabin class: First");

    }

         @Test(priority = 5, description = "Test Case 05 - Validate the booking for 2 passengers and one way")
         public void validateBooking2PassengersOneWay() {
         /*
         Navigate to https://techglobal-training.com/frontend/project-3
     Select the “One way” radio button
     Select “Premium Economy” for the “Cabin Class” dropdown
     Select “New York” for the “From” dropdown
     Select “Texas” for the “To” dropdown
     Select the next day for the ”Depart”
     Select “2” for the “Number of passengers” dropdown
     Select “Adult (16-64)” for the Passenger 1 dropdown
     Select “Child (2-11)” for the Passenger 2 dropdown
     Click on the “BOOK” button
     Validate the booking information displayed below
     DEPART
     NY to TX
     {dynamic date}
     Number of passengers: 2
     Passenger 1: Adult (16-64)
     Passenger 2: Child (2-11)
     Cabin Class: Premium Economy

 */

             project3Page.oneWayRadioButton.click();

             DropdownHandler.selectByVisibleText(project3Page.cabinClassDropdown, "Premium Economy");
             DropdownHandler.selectByVisibleText(project3Page.fromDropdown, "New York");
             DropdownHandler.selectByVisibleText(project3Page.toDropdown, "Texas");

         //    project3Page.departDatePicker.sendKeys("18");
             LocalDateTime date = LocalDateTime.now();
             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E MMM dd yyyy");
             date = date.plusDays(1);

             project3Page.departDatePicker.sendKeys((dtf.format(date)));

             Waiter.pause(3);

             DropdownHandler.selectByVisibleText(project3Page.numberOfPassengersDropdown, "2");
             DropdownHandler.selectByVisibleText(project3Page.passenger1CategoryDropdown, "Adult (16-64)");
             DropdownHandler.selectByVisibleText(project3Page.passenger2CategoryDropdown, "Child (2-11)");
             Waiter.pause(3);

             project3Page.bookButton.click();
             Waiter.pause(3);
             Assert.assertEquals(project3Page.confirmationMessage.getText(), "DEPART\n" +
                     "NY to TX\n" +
                     date +
                     "Number of Passengers: 2\n" +
                     "Passenger 1: Adult (16-64)\n" +
                     "Passenger 2: Child (2-11)\n" +
                     "Cabin class: Premium Economy");
         }



        }
