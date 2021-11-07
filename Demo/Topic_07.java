import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_07 {
    WebDriver driver;
    String loginPageURL, getUserID, getPasswordID, getCustomerID;

    //Login page
    By userName = By.xpath("//input[@name='uid']");
    By passwordTexbox = By.xpath("//input[@name='password']");
    By btnLogin = By.xpath("//input[@name='btnLogin']");

    //Register Page
    By loginPage = By.xpath("//a[text()='here']");
    By emailTextbox = By.xpath("//input[@name='emailid']");
    By btnSubmit = By.xpath("//input[@name='btnLogin']");
    By userID = By.xpath("//td[text()='User ID :']/following-sibling::td");
    By passwordID = By.xpath("//td[text()='Password :']/following-sibling::td");

    // Managerome page
    By getWelcomeText = By.xpath("//marquee[@class='heading3']");

    // Locator Create / Edit Account
    By goNewAccountPage = By.xpath("//a[text()='New Customer']");
    By nameTextbox = By.name("name");
    By DOBTextbox = By.name("dob");
    By addressTextbox = By.name("addr");
    By cityTextbox = By.name("city");
    By stateTextbox = By.name("state");
    By pinTextbox = By.name("pinno");
    By phoneTextbox = By.name("telephoneno");
    By email1Textbox = By.name("emailid");
    By passwordTextbox = By.name("password");
    By btnSubmit1 = By.name("sub");
    By getMessage = By.xpath("//p[@class='heading3']");

    // Get Output New Customer
    By locatorCustomerName = By.xpath("//td[text()='Customer Name']/following-sibling::td");
    By locatorDayofBirth = By.xpath("//td[text()='Birthdate']/following-sibling::td");
    By locatorAddress = By.xpath("//td[text()='Address']/following-sibling::td");
    By locatorCity = By.xpath("//td[text()='City']/following-sibling::td");
    By locatorState = By.xpath("//td[text()='State']/following-sibling::td");
    By locatorPin = By.xpath("//td[text()='Pin']/following-sibling::td");
    By locatorPhone = By.xpath("//td[text()='Mobile No.']/following-sibling::td");
    By locatorEmail = By.xpath("//td[text()='Email']/following-sibling::td");
    By locatorCustomerID = By.xpath("//td[text()='Customer ID']/following-sibling::td");


    // input data in Create new account page
    String customerName = "trung thu";
    String date = "11";
    String month = "09";
    String year = "1998";
    String dateOfBirthInput = month + "/" + date + "/" + year;
    String DateOfBirthOutput = year + "-" + date + "-" + month;
    String addressInput = "434 nguyen Trai\nQuan 3\nHo Chi Minh";
    String addressOutput = addressInput.replace("\n", " ");
    String city = "Da nang";
    String state = "Hai Chau";
    String pin = "123456";
    String phone = "0988889999";
    String email = "thu" + getRamdomNuber() + "@mailinator.com";

    // Edit Account
    By goEditPage = By.xpath("//a[text()='Edit Customer']");
    By nameID = By.name("cusid");
    By btnSubmit2 = By.name("AccSubmit");



    //Input data in Edit Customer
    String update = "434 Nguyen tri phuong\nQuan 10\nHo Chi Minh";
    String update1 = update.replace("\n", " ");
    String city1 = "Ho Chi Minh";
    String state1 = "Quan 10";
    String pin1 = "567891";
    String phone1 = "0988881111";
    String email1 = "thu" + getRamdomNuber() + "@mailinator.com";



    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Register() {
        driver.get("https://demo.guru99.com/v4/");

        loginPageURL = driver.getCurrentUrl();

        driver.findElement(loginPage).click();
        driver.findElement(emailTextbox).sendKeys("thu@mailinator.com");
        driver.findElement(btnSubmit).click();

        // get text UserID and Password
        getUserID = driver.findElement(userID).getText();
        getPasswordID = driver.findElement(passwordID).getText();

    }

    @Test
    public void TC_02_Login() {
        driver.get(loginPageURL);

        driver.findElement(userName).sendKeys(getUserID);
        driver.findElement(passwordTexbox).sendKeys(getPasswordID);

        driver.findElement(btnLogin).click();

        String getWelcome = driver.findElement(getWelcomeText).getText();
        Assert.assertEquals(getWelcome, "Welcome To Manager's Page of Guru99 Bank");

    }

    @Test
    public void TC_03_Create_New_Account() throws InterruptedException {
        driver.findElement(goNewAccountPage).click();

        driver.findElement(nameTextbox).sendKeys(customerName);
        driver.findElement(DOBTextbox).sendKeys(dateOfBirthInput);
        driver.findElement(addressTextbox).sendKeys(addressInput);
        driver.findElement(cityTextbox).sendKeys(city);
        driver.findElement(stateTextbox).sendKeys(state);
        driver.findElement(pinTextbox).sendKeys(pin);
        driver.findElement(phoneTextbox).sendKeys(phone);
        driver.findElement(email1Textbox).sendKeys(email);
        driver.findElement(passwordTextbox).sendKeys(getPasswordID);

        driver.findElement(btnSubmit1).click();


        String getMessageSuccess = driver.findElement(getMessage).getText();
        Assert.assertEquals(getMessageSuccess,"Customer Registered Successfully!!!");


        //Get Output
        String getCustomeName = driver.findElement(locatorCustomerName).getText();
        String getBrithday = driver.findElement(locatorDayofBirth).getText();
        String getAddress = driver.findElement(locatorAddress).getText();
        String getCity = driver.findElement(locatorCity).getText();
        String getState = driver.findElement(locatorState).getText();
        String getPin = driver.findElement(locatorPin).getText();
        String getPhone = driver.findElement(locatorPhone).getText();
        String getEmail = driver.findElement(locatorEmail).getText();

        // Verify Output
        Assert.assertEquals(getCustomeName,customerName);
        Assert.assertEquals(getBrithday,DateOfBirthOutput);
        Assert.assertEquals(getAddress,addressOutput);
        Assert.assertEquals(getCity,city);
        Assert.assertEquals(getState,state);
        Assert.assertEquals(getPin,pin);
        Assert.assertEquals(getPhone,phone);
        Assert.assertEquals(getEmail,email);

        // Get Customer ID
        getCustomerID = driver.findElement(locatorCustomerID).getText();
    }

    @Test
    public void TC_04_Edit_Account() throws InterruptedException {
        clickToElement(goEditPage);

        driver.findElement(nameID).sendKeys(getCustomerID);
        clickToElement(btnSubmit2);

        //Verify Name / DOB is Disable field
        Assert.assertFalse(driver.findElement(nameTextbox).isEnabled());
        Assert.assertFalse(driver.findElement(DOBTextbox).isEnabled());


        // Get Output
        String getCustomer = driver.findElement(nameTextbox).getAttribute("value");
        String getDOB1 = driver.findElement(DOBTextbox).getAttribute("value");
        String getAddress1 = driver.findElement(addressTextbox).getText();
        String getCity1 = driver.findElement(cityTextbox).getAttribute("value");
        String getState1 = driver.findElement(stateTextbox).getAttribute("value");
        String getPin1 = driver.findElement(pinTextbox).getAttribute("value");
        String getPhone1 = driver.findElement(phoneTextbox).getAttribute("value");
        String getEmail1 = driver.findElement(emailTextbox).getAttribute("value");

        //Verify Output
        Assert.assertEquals(getCustomer,customerName);
        Assert.assertEquals(getDOB1,DateOfBirthOutput);
        Assert.assertEquals(getAddress1,addressInput);
        Assert.assertEquals(getCity1,city);
        Assert.assertEquals(getState1,state);
        Assert.assertEquals(getPin1,pin);
        Assert.assertEquals(getPhone1,phone);
        Assert.assertEquals(getEmail1,email);


        // Update Edit Customer
        driver.findElement(addressTextbox).clear();
        driver.findElement(addressTextbox).sendKeys(update);
        driver.findElement(cityTextbox).clear();
        driver.findElement(cityTextbox).sendKeys(city1);
        driver.findElement(stateTextbox).clear();
        driver.findElement(stateTextbox).sendKeys(state1);
        driver.findElement(pinTextbox).clear();
        driver.findElement(pinTextbox).sendKeys(pin1);
        driver.findElement(phoneTextbox).clear();
        driver.findElement(phoneTextbox).sendKeys(phone1);
        driver.findElement(emailTextbox).clear();
        driver.findElement(emailTextbox).sendKeys(email1);

        clickToElement(btnSubmit1);


        // Get Update Customer
        String getUpdateAddress = driver.findElement(locatorAddress).getText();
        String getUpdateCity = driver.findElement(locatorCity).getText();
        String getUpdateState = driver.findElement(locatorState).getText();
        String getUpdatePin = driver.findElement(locatorPin).getText();
        String getUpdatePhone = driver.findElement(locatorPhone).getText();
        String getUpdateEmail = driver.findElement(locatorEmail).getText();


        // Verify Update Edit Customer
        Assert.assertEquals(getUpdateAddress,update1);
        Assert.assertEquals(getUpdateCity,city1);
        Assert.assertEquals(getUpdateState,state1);
        Assert.assertEquals(getUpdatePin,pin1);
        Assert.assertEquals(getUpdatePhone,phone1);
        Assert.assertEquals(getUpdateEmail,email1);

    }

    public int getRamdomNuber() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }

    public void clickToElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    @AfterClass
    public void cleanData() {
        // close browser after run all test case
        driver.quit();

    }

}
