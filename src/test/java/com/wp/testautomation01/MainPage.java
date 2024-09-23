package com.wp.testautomation01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://demoqa.com/
public class MainPage {
    @FindBy(xpath = "//h5[text()='Elements']")
    public WebElement elemetsCard;

    @FindBy(xpath = "//span[text()='Text Box']")
    public WebElement textBox;

    @FindBy(xpath = "//input[@id='userName']")
    public WebElement name;

    @FindBy(xpath = "//input[@id='userEmail']")
    public WebElement email;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    public WebElement currentAdd;

    @FindBy(xpath = "//textarea[@id='permanentAddress']")
    public WebElement permanentAdd;

    @FindBy(xpath = "//button[@id='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//span[text()='Check Box']")
    public WebElement checkBox;

    @FindBy(xpath = "//button[@class='rct-option rct-option-expand-all']")
    public WebElement expandArrow;

    @FindBy(xpath = "(//span[@class='rct-checkbox'])[2]")
    public WebElement desktopCheckbox;

    @FindBy(xpath = "//span[text()='Radio Button']")
    public WebElement radioButton;

    @FindBy(xpath = "//label[@class='custom-control-label']")
    public WebElement yesRadio;

   @FindBy(xpath = "//p[@class='mt-3']")
    public WebElement radioResult;

   @FindBy(xpath = "//span[text()='Buttons']")
    public WebElement buttonItem;

   @FindBy(xpath = "//button[@id='doubleClickBtn']")
    public WebElement doubleClickButton;

   @FindBy(xpath = "//h5[text()='Widgets']")
    public WebElement widgetsCard;

   @FindBy(xpath = "//span[text()='Date Picker']")
    public WebElement datePickerHeading;

   @FindBy(xpath = "//input[@id='datePickerMonthYearInput']")
    public WebElement datePickerInput;

   @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    public WebElement altertCard;

   @FindBy(xpath = "//span[text()='Modal Dialogs']")
    public WebElement modelDialogs;

   @FindBy(xpath = "//button[@id='showSmallModal']")
    public WebElement smallModal;

   @FindBy(xpath = "//span[text()='Links']")
    public WebElement links;

   @FindBy(xpath = "//a[@id='simpleLink']")
    public WebElement homeLink;






    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
