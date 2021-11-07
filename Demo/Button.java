import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Button {
    WebDriver driver;

    // Login Page
    By btnLogin = By.xpath("//button[@class='fhs-btn-login']");
    By emailTextbox = By.id("login_username");
    By passTextbox = By.id("login_password");


    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    public void TC_01_Button() {
        driver.get("https://www.fahasa.com/customer/account/create?attempt=1");

        driver.findElement(By.xpath("//a[text()='Đăng nhập']")).click();

        // Verify btn is disabled
        Assert.assertFalse(isElementEnable(btnLogin));

        driver.findElement(emailTextbox).sendKeys("thu@mailinator.com");
        driver.findElement(passTextbox).sendKeys("123456");

        // Verify btn is enabled
        Assert.assertTrue(isElementEnable(btnLogin));

        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[text()='Đăng nhập']")).click();

        // Verify btn is disabled
        Assert.assertFalse(isElementEnable(btnLogin));

        // Remove Disabled Attribute of Login button
        removeDisableAttributeByJS(btnLogin);
        sleepInSecond(3);

        //Verify login button is enabled
        Assert.assertTrue(isElementEnable(btnLogin));

        driver.findElement(btnLogin).click();

        String emailError = driver.findElement(By.xpath("//label[text()='Số điện thoại/Email']/following-sibling::div[@class='fhs-input-alert']")).getText();
        String passwordError = driver.findElement(By.xpath("//label[text()='Mật khẩu']/following-sibling::div[@class='fhs-input-alert']")).getText();

        sleepInSecond(3);
        Assert.assertEquals(emailError,"Thông tin này không thể để trống");
        Assert.assertEquals(passwordError,"Thông tin này không thể để trống");

    }


    public void TC_02_Checkbox_RadioButton_Default() {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");

        //Default
//        WebElement dualZoneCheckbox = driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::input"));
//        dualZoneCheckbox.click();
//        sleepInSecond(5);
//        Assert.assertTrue(isElementSelected(dualZoneCheckbox));

        // Wait _ Checkbox
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement dualZoneCheckbox = driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::input"));
        wait.until(ExpectedConditions.elementToBeClickable(dualZoneCheckbox)).click();
        sleepInSecond(6);
        Assert.assertTrue(isElementSelected(dualZoneCheckbox));

        dualZoneCheckbox.click();
        sleepInSecond(6);
        Assert.assertFalse(isElementSelected(dualZoneCheckbox));

        // Wait _ Radio button
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        WebElement petroRadio = driver.findElement(By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::input"));
        wait1.until(ExpectedConditions.elementToBeClickable(petroRadio)).click();
        sleepInSecond(6);
        Assert.assertTrue(isElementSelected(petroRadio));


    }

    @Test
    public void TC_02_Checkbox_RadioButton_Custom() {
        driver.get("https://material.angular.io/components/radio/examples");

        // span -> Click
//        WebElement autumRadioText = driver.findElement(By.xpath("//span[text()=' Autumn ']"));
//        autumRadioText.click();
//        sleepInSecond(5);

        WebElement autumRadionInput = driver.findElement(By.xpath("//span[text()=' Autumn ']/preceding-sibling::span/input"));
        clickByJS(autumRadionInput);
        sleepInSecond(6);
        Assert.assertTrue(isElementSelected(autumRadionInput));


        driver.get("https://material.angular.io/components/checkbox/examples");
        WebElement checkedCheckbox = driver.findElement(By.xpath("//span[text()='Checked']/preceding-sibling::span/input"));
        clickByJS(checkedCheckbox);
        sleepInSecond(6);
        Assert.assertTrue(isElementSelected(checkedCheckbox));

        WebElement inderterCheckbox = driver.findElement(By.xpath("//span[text()='Indeterminate']/preceding-sibling::span/input"));
        clickByJS(inderterCheckbox);
        sleepInSecond(6);
        Assert.assertTrue(isElementSelected(inderterCheckbox));


    }

    public void clickByJS(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }

    public boolean isElementSelected(WebElement element) {
        if(element.isSelected()) {
            System.out.println("Element is selected");
            return true;
        } else {
            System.out.println("Element is not Selected");
            return false;
        }
    }

    public boolean isElementEnable(By by) {
        WebElement element = driver.findElement(by);
        if(element.isEnabled()) {
            System.out.println("Element is Enable " + by);
            return true;
        } else {
            System.out.println("Element is not Enable " + by);
            return false;
        }
    }

    // Bi an (ko work voi element bi Disable)
    public void removeDisableAttributeByJS(By by) {
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor)driver).executeScript("arguments[0].removeAttribute('disabled')", element);
    }

    public void sleepInSecond(long time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void cleanData() {
        // close browser after run all test case
        driver.quit();

    }
}