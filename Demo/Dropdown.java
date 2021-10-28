import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Dropdown {
    WebDriver driver;
    Select select;

    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

   @Test
   public void TC_01_Handle_Dropdown_List() {
       driver.get("https://www.rode.com/wheretobuy");

       // Verify Country is not Muilt-drop
       select = new Select(driver.findElement(By.xpath("//select[@id=\"where_country\"]")));
       Assert.assertFalse(select.isMultiple());

       //Choose value
       select.selectByVisibleText("Vietnam");

       // Verify choose success
       Assert.assertEquals(select.getFirstSelectedOption().getText(),"Vietnam");

       driver.findElement(By.xpath("//input[@value=\"Search\"]")).click();

       String getResultDistance = driver.findElement(By.xpath("//div[@class=\"result_count\"]/span")).getText();
       Assert.assertEquals(getResultDistance,"29");

   }

    @Test
    public void TC_02_Register() {
        driver.get("https://demo.nopcommerce.com");

        driver.findElement(By.xpath("//a[text()='Register']")).click();

        // Locator Register Page
        By dayTextbox = By.xpath("//select[@name='DateOfBirthDay']");
        By monthTextbox = By.xpath("//select[@name='DateOfBirthMonth']");
        By yearTextbox = By.xpath("//select[@name='DateOfBirthYear']");
        By genderTextbox = By.xpath("//input[@id='gender-male']");
        By firstNameTextbox = By.id("FirstName");
        By lasttNameTextbox = By.id("LastName");
        By emailTextbox = By.id("Email");
        By companyTextbox = By.id("Company");
        By passwordTextbox = By.id("Password");
        By conPasswordTextbox = By.id("ConfirmPassword");
        By getMessage = By.xpath("//div[@class='result']");
        By btnRegister = By.id("register-button");

        //Data in Register Page
        String firstName = "Thu";
        String lastName = "Nguyen";
        String email = "thu" + getRandomNum() + "@mailinator.com";
        String company = "ABCD Company";
        String password = "123456";
        String day = "1";
        String month = "May";
        String year = "1997";

        //My Account Page
        By goMyAccountPage = By.xpath("//div[@class='header-links']//a[text()='My account']");


        //Input data
        driver.findElement(genderTextbox).click();
        driver.findElement(firstNameTextbox).sendKeys(firstName);
        driver.findElement(lasttNameTextbox).sendKeys(lastName);
        driver.findElement(emailTextbox).sendKeys(email);
        driver.findElement(companyTextbox).sendKeys(company);
        driver.findElement(passwordTextbox).sendKeys(password);
        driver.findElement(conPasswordTextbox).sendKeys(password);
        Select selectDay = new Select(driver.findElement(dayTextbox));
        selectDay.selectByVisibleText(day);
        Select selectMonth = new Select(driver.findElement(monthTextbox));
        selectMonth.selectByVisibleText(month);
        Select selectYear = new Select(driver.findElement(yearTextbox));
        selectYear.selectByVisibleText(year);


        //Verify Day = 32
        Assert.assertEquals(selectDay.getOptions().size(),32);

        // Verify Month = 12
        Assert.assertEquals(selectMonth.getOptions().size(),13);

        // Verify Year = 112
        Assert.assertEquals(selectYear.getOptions().size(),112);


        driver.findElement(btnRegister).click();

        // Verify Message with Register Success
        String message = driver.findElement(getMessage).getText();
        Assert.assertEquals(message,"Your registration completed");

        // Go to the My Account Page
        driver.findElement(goMyAccountPage).click();


        // Get data in the my account page
        String getFirstName = driver.findElement(firstNameTextbox).getAttribute("value");
        String getLastName = driver.findElement(lasttNameTextbox).getAttribute("value");
        String getEmail = driver.findElement(emailTextbox).getAttribute("value");
        String getCompany = driver.findElement(companyTextbox).getAttribute("value");
        Select selectDay1 = new Select(driver.findElement(dayTextbox));
        Select selectMonth1 = new Select(driver.findElement(monthTextbox));
        Select selectYear1 = new Select(driver.findElement(yearTextbox));


        // Verify Output = Input
        Assert.assertEquals(selectDay1.getFirstSelectedOption().getText(),day);
        Assert.assertEquals(selectMonth1.getFirstSelectedOption().getText(),month);
        Assert.assertEquals(selectYear1.getFirstSelectedOption().getText(),year);
        Assert.assertEquals(getFirstName,firstName);
        Assert.assertEquals(getLastName,lastName);
        Assert.assertEquals(getEmail,email);
        Assert.assertEquals(getCompany,company);


    }

    public int getRandomNum() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }

    @AfterClass
    public void cleanData() {
        // close browser after run all test case
        driver.quit();

    }

}
