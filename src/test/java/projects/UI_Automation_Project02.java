package projects;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import scripts.Base;

public class UI_Automation_Project02 extends Base {
    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend/project-2");
    }

    @Test(priority = 1)
    public void validateTheLoginForm() {

    WebElement usernameInputBox = driver.findElement(By.id("username"));
    Assert.assertTrue(usernameInputBox.isDisplayed());
   // Assert.assertEquals(usernameInputBox.getAttribute("required"),"null");

    WebElement usernameLabel = driver.findElement(By.cssSelector("div:nth-child(1)>label"));
    Assert.assertTrue(usernameLabel.isDisplayed());
    Assert.assertEquals(usernameLabel.getText(), "Please enter your username");

    WebElement passwordInputBox = driver.findElement(By.id("password"));
    Assert.assertTrue(passwordInputBox.isDisplayed());
  //  Assert.assertEquals(passwordInputBox.getAttribute("required"),"null");

    WebElement  passwordLabel = driver.findElement(By.cssSelector("div:nth-child(2)>label"));
    Assert.assertEquals(passwordLabel.getText(), "Please enter your password");

    WebElement loginButton = driver.findElement(By.id("login_btn"));
    Assert.assertTrue(loginButton.isDisplayed());
    Assert.assertTrue(loginButton.isEnabled());
    Assert.assertEquals(loginButton.getText(), "LOGIN");

    WebElement forgotPasswordLink = driver.findElement(By.cssSelector("div:nth-child(3)>a"));
    Assert.assertTrue(forgotPasswordLink.isDisplayed());
    Assert.assertEquals(forgotPasswordLink.getText(), "Forgot Password?");

    }

    @Test(priority = 2)
    public void validateValidLogin(){
        driver.findElement(By.id("username")).sendKeys("TechGlobal");
        driver.findElement(By.id("password")).sendKeys("Test1234");
        driver.findElement(By.id("login_btn")).click();
        driver.findElement(By.id("success_lgn")).isDisplayed();
        driver.findElement(By.id("logout")).isDisplayed();
    }

    @Test(priority = 3)
    public void validateTheLogout(){
        driver.findElement(By.id("username")).sendKeys("TechGlobal");
        driver.findElement(By.id("password")).sendKeys("Test1234");
        driver.findElement(By.id("login_btn")).click();
        driver.findElement(By.id("logout")).click();
        validateTheLoginForm();
    }

    @Test(priority = 4)
    public void validateForgotPasswordLink(){
        driver.findElement(By.cssSelector("div:nth-child(3)>a")).click();
        Assert.assertTrue(driver.findElement(By.id("sub_heading")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("delete")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());
        WebElement emailInputBox = driver.findElement(By.cssSelector("div:nth-child(1)>label"));
        Assert.assertEquals(emailInputBox.getText(), "Enter your email address and we'll send you a link to reset your password.");
        WebElement submitButton = driver.findElement(By.id("submit"));
        Assert.assertTrue(submitButton.isDisplayed());
        Assert.assertEquals(submitButton.getText(), "SUBMIT");

    }

    @Test(priority = 5)
    public void validateRestPasswordModalCloseButton(){
        driver.findElement(By.cssSelector("div:nth-child(3)>a")).click();
        WebElement resetPasswordModal = driver.findElement(By.cssSelector("div.modal-card.undefined"));
        Assert.assertTrue(resetPasswordModal.isDisplayed());
        driver.findElement(By.className("delete")).click();
        Assert.assertFalse(driver.findElement(By.id("sub_heading")).isDisplayed());


    }
    @Test(priority = 6)
    public void validateResetSubmission(){
        WebElement forgotPassword = driver.findElement(By.cssSelector("div:nth-child(3)>a"));
        forgotPassword.click();

        WebElement inputEmail = driver.findElement(By.id("email"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        inputEmail.sendKeys("techGlobalSchool@gmail.com");
        submitButton.click();

        WebElement resetConfirmation = driver.findElement(By.id("confirmation_message"));
        Assert.assertTrue(resetConfirmation.getLocation().getY() > submitButton.getLocation().getY(), "A link to reset your password has been sent to your email address.");
    }

    @Test(priority = 7)
    public void validateInvalidLogin(){
        driver.findElement(By.id("login_btn")).click();
        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Invalid Username entered!");

    }

    @Test(priority = 8)
    public void validateInvalidLoginWrongUsername(){
      driver.findElement(By.id("username")).sendKeys("John");
      driver.findElement(By.id("password")).sendKeys("Test1234");
      driver.findElement(By.id("login_btn")).click();
      WebElement errorMessage = driver.findElement(By.id("error_message"));
      Assert.assertTrue(errorMessage.isDisplayed());
      Assert.assertEquals(errorMessage.getText(), "Invalid Username entered!");

    }
    @Test(priority = 9)
    public void validateInvalidLoginWrongPassword(){
        driver.findElement(By.id("username")).sendKeys("TechGlobal");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.id("login_btn")).click();
        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Invalid Password entered!");

    }

    @Test
    public void validateInvalidLoginWrongUsernameAndPassword(){
        driver.findElement(By.id("username")).sendKeys("John");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.id("login_btn")).click();
        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Invalid Username entered!");

    }

}
