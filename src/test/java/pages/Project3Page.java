package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class Project3Page {
    public Project3Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "label.radio.ml-0>input")
    public WebElement oneWayRadioButton;

    @FindBy(css = "label:nth-child(2)>input")
    public WebElement roundTripRadioButton;

    @FindBy(css = "label:nth-child(2)>input")//
    public WebElement cabinClassLabel;

    @FindBy(css = "div:nth-child(2)>div>select")
    public WebElement cabinClassDropdown;

    @FindBy(css = "div:nth-child(3)>label")
    public WebElement fromLabel;

    @FindBy(css = "div:nth-child(3)>div>select")
    public WebElement fromDropdown;

    @FindBy(css = "div:nth-child(4)>label")
    public WebElement toLabel;

    @FindBy(css = " div:nth-child(4)>div>select")
    public WebElement toDropdown;

    @FindBy(css = "div:nth-child(3)>div>select")
    public WebElement departLabel;

    @FindBy(css = "div:nth-child(5)>div>div>div>div")
    public WebElement departDatePicker;

    @FindBy(css = "div:nth-child(6)>label")
    public WebElement returnLabel;

    @FindBy(css = "div:nth-child(6) > div > div > div")
    public WebElement returnDatePicker;

    @FindBy(css = "div:nth-child(7) > label")
    public WebElement numberOfPassengersLabel;

    @FindBy(css = "div:nth-child(7) > div > select")
    public WebElement numberOfPassengersDropdown;

    @FindBy(css = "div:nth-child(8) > label")
    public WebElement passenger1CategoryLabel;

    @FindBy(css = " div:nth-child(9) > label")
    public WebElement passenger2CategoryLabel;

    @FindBy(css = "div:nth-child(8) > div > select")
    public WebElement passenger1CategoryDropdown;

    @FindBy(css = " div:nth-child(9) > div > select")
    public WebElement passenger2CategoryDropdown;

    @FindBy(css = "form > div:nth-child(2) > div > button")
    public WebElement bookButton;

    @FindBy(css = " div.ml-3")
    public WebElement confirmationMessage;
















}
