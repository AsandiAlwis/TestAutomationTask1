package com.wp.testautomation01;

import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/");

        mainPage = new MainPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCase1() {
        // Scroll to the "Elements" section
        WebElement elementsHeading = driver.findElement(By.xpath("//h5[text()='Elements']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementsHeading);

        mainPage.elemetsCard.click(); //click on elements card
        mainPage.textBox.click(); //click ob textbox

        // Fill the form
        mainPage.name.sendKeys("Asandi Alwis");
        mainPage.email.sendKeys("asandi@gmail.com");
        mainPage.currentAdd.sendKeys("21/100, Desi avenue, Colombo");
        mainPage.permanentAdd.sendKeys("21/100, Desi avenue, Colombo");

        // Scroll to the "Submit" section
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);

        // click and submit the form
        mainPage.submitButton.click();


        // Validate fields...
        WebElement validateFullName = driver.findElement(By.xpath("//p[@id='name']"));
        assertEquals(validateFullName.getText(), "Name:Asandi Alwis");

        WebElement validateEmail = driver.findElement(By.xpath("//p[@id='email']"));
        assertEquals(validateEmail.getText(), "Email:asandi@gmail.com");

        WebElement validateCurrentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        assertEquals(validateCurrentAddress.getText(), "Current Address :21/100, Desi avenue, Colombo");

        WebElement validatePermanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        assertEquals(validatePermanentAddress.getText(), "Permananet Address :21/100, Desi avenue, Colombo");
    }


    @Test
    public void testCase2() {
        // Scroll to the "Elements" section
        WebElement elementsHeading = driver.findElement(By.xpath("//h5[text()='Elements']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementsHeading);

        // Click on elements card
        mainPage.elemetsCard.click();
        // Click on checkbox
        mainPage.checkBox.click();

        // Expand the tree structure under 'Home'
        mainPage.expandArrow.click();

        // Select the checkbox for 'Desktop'
        mainPage.desktopCheckbox.click();

        // Scroll to the results section
        WebElement scrollToResults = driver.findElement(By.xpath("//div[@id='result']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollToResults);

        // Validate the result text
        WebElement selectionsValidation = driver.findElement(By.xpath("//div[@id='result']"));
        assertEquals("You have selected :\n" +
                "desktop\n" +
                "notes\n" +
                "commands",selectionsValidation.getText());

    }

    @Test
    public void testCase3() {
        // Scroll to the "Elements" section
        WebElement elementsHeading = driver.findElement(By.xpath("//h5[text()='Elements']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementsHeading);

        // Click on elements card
        mainPage.elemetsCard.click();
        // Click on checkbox
        mainPage.radioButton.click();

        // click on yes radio button
        mainPage.yesRadio.click();

        // Validate the result text
        WebElement radioButtonValidation = driver.findElement(By.xpath("//p[@class='mt-3']"));
        assertEquals("You have selected Yes",radioButtonValidation.getText());

    }

    @Test
    public void testCase4() {
        // Scroll to the "Elements" section
        WebElement elementsHeading = driver.findElement(By.xpath("//h5[text()='Elements']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementsHeading);

        // Click on elements card
        mainPage.elemetsCard.click();
        // Click on checkbox
        mainPage.buttonItem.click();

        //perform a double click on a button
        ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new MouseEvent('dblclick', {bubbles: true}));", driver.findElement(By.xpath("//button[@id='doubleClickBtn']")));


        // Validate the result text
        WebElement buttonValidation = driver.findElement(By.xpath("//p[@id='doubleClickMessage']"));
        assertEquals("You have done a double click",buttonValidation.getText());

    }

    @Test
    public void testCase5() {
        // Scroll to the "Widgets" section
        WebElement widgetsHeading = driver.findElement(By.xpath("//h5[text()='Widgets']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", widgetsHeading);

        // Click on widgets card
        mainPage.widgetsCard.click();

        // Click on date picker heading
        mainPage.datePickerHeading.click();

        // Click on date picker input field
        mainPage.datePickerInput.click();

        // Select the 15th of the current month
        WebElement dateElement = driver.findElement(By.xpath("//div[@class='react-datepicker__month']//div[text()='15']"));
        dateElement.click();

        // Validate that the correct date is displayed in the input field
        String selectedDate = mainPage.datePickerInput.getAttribute("value");
        assertEquals("09/15/2024", selectedDate); // Update the expected date format accordingly
    }

    @Test
    public void testCase6() {
        // Scroll to the "Alerts, Frame & Windows" section
        WebElement alertsHeading = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", alertsHeading);

        // Click on the alerts card
        mainPage.altertCard.click();

        // Scroll to the 'Modal Dialogs' option
        WebElement scrollToModalDialogs = driver.findElement(By.xpath("//span[text()='Modal Dialogs']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollToModalDialogs);

        // Click on the 'Modal Dialogs' heading
        mainPage.modelDialogs.click();

        // Click on the 'Small modal' button to open the modal
        mainPage.smallModal.click();

        // Validate that the modal has appeared (e.g., by checking the modal title or text content)
        WebElement modalText = driver.findElement(By.xpath("//div[@class='modal-body']"));
        assertEquals("This is a small modal. It has very less content", modalText.getText());

        // Click on the 'Close' button within the modal
        WebElement closeModalButton = driver.findElement(By.xpath("//button[@id='closeSmallModal']"));
        closeModalButton.click();

    }

    @Test
    public void testCase7() {
        // Scroll to the "Elements" section
        WebElement elementsHeading = driver.findElement(By.xpath("//h5[text()='Elements']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementsHeading);

        mainPage.elemetsCard.click(); // click on elements card
        mainPage.links.click(); // click on links heading

        // Click on the 'Home' link
        mainPage.homeLink.click();

        // Switch to the new window or tab (if applicable)
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus to the new tab or window
        }

        // Verify if the URL is correct after clicking the 'Home' link
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://demoqa.com/"; // Update with the actual home page URL

        Assert.assertEquals(currentUrl, expectedUrl, "The user was not redirected to the expected home page.");
    }

}
