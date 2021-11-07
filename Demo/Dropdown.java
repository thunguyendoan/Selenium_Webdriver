import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    WebDriverWait explicitWait;
    JavascriptExecutor jsExecutor;

    String expectedText = "";
    String[] months = {"January", "March", "June"};
    String[] newMonths = {"January", "March", "June", "October", "December"};
    String[] eightMonths = {"January", "March", "June", "October", "December", "April", "May", "July"};
    String[] allMonths = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();

        explicitWait = new WebDriverWait(driver, 30);
        jsExecutor = (JavascriptExecutor) driver;

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }


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


    public void TC_04_JQuery() {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        selectTheItemInCustomDropdown("//span[@id='number-button']","//ul[@id='number-menu']//div","19");
        sleepInSecond(3);
        Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']/span[text()='19']")).isDisplayed());
    }


    public void TC_05_ReachJs() {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

        selectTheItemInCustomDropdown("//div[@id='root']","//div[@id='root']//div[@class='item']","Stevie Feliciano");
        sleepInSecond(3);
        String getName = driver.findElement(By.xpath("//div[@id='root']//div[@class='divider text']")).getText();
        Assert.assertEquals(getName,"Stevie Feliciano");
    }


    public void TC_06_VueJs() {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");

         //loi
        selectTheItemInCustomDropdown("//li[@class='dropdown-toggle']","//ul[@class='dropdown-menu']//a","\n" +"Second Option");
        sleepInSecond(2);
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(),"Second Option");
    }


    public void TC_07_Angular() {
        driver.get("https://ej2.syncfusion.com/angular/demos/?_ga=2.262049992.437420821.1575083417-524628264.1575083417#/material/drop-down-list/data-binding");

            //loi
        selectTheItemInCustomDropdown("//ejs-dropdownlist[@id='games']//span[contains(@class,'e-search-icon')]","//ul[@id='games_options']//li","\n" + "Basketball");
        sleepInSecond(3);
        System.out.println(getHiddenText("select[id='games_hidden']>option"));
        Assert.assertEquals(getHiddenText("select[id='games_hidden']>option"),"Basketball");

    }


    public void TC_08_EditDropdwon() {
        driver.get("http://indrimuska.github.io/jquery-editable-select/");

        selectTheItemInEditDropdown("//div[@id='default-place']/input","//div[@id='default-place']//li","Audi");
        sleepInSecond(3);
        Assert.assertEquals(getHiddenText("div[id='default-place'] li[class='es-visible']"), "Audi");
    }

    @Test
    public void TC_09_Multiple_Select() {
        driver.get("https://multiple-select.wenzhixin.net.cn/templates/template.html?v=189&url=basic.html");

        selectMultiItemInDropdown("(//button[@class='ms-choice'])[1]", "(//div[@class='ms-drop bottom'])[1]//span",months);
        sleepInSecond(2);
        Assert.assertTrue(areItemSelected(months));

        driver.navigate().refresh();

        selectMultiItemInDropdown("(//button[@class='ms-choice'])[1]", "(//div[@class='ms-drop bottom'])[1]//span",newMonths);
        sleepInSecond(2);
        Assert.assertTrue(areItemSelected(newMonths));

        driver.navigate().refresh();

        selectMultiItemInDropdown("(//button[@class='ms-choice'])[1]", "(//div[@class='ms-drop bottom'])[1]//span",eightMonths);
        sleepInSecond(2);
        Assert.assertTrue(areItemSelected(eightMonths));

        driver.navigate().refresh();

        selectMultiItemInDropdown("(//button[@class='ms-choice'])[1]", "(//div[@class='ms-drop bottom'])[1]//span",allMonths);
        sleepInSecond(2);
        Assert.assertTrue(allItemSelected(allMonths));

    }

    public void selectMultiItemInDropdown(String parentXpath, String allItemXpath, String[] expectedValueItem) {
        // 1: Click vao dropdown xo ra het cac gia tri
        driver.findElement(By.xpath(parentXpath)).click();

        // 2: Cho cho tat ca cac gia tri trong dropdown load thanh cong
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));

        List<WebElement> allItems = driver.findElements(By.xpath(allItemXpath));


        //4- Duyet qua cai List này từng Item
        for (WebElement childElement : allItems) {

            // "Janary", "April", "July"
            for(String item : expectedValueItem) {

                if(childElement.getText().equals(item)) {
                    // 3: scroll den item can chon (neu nhu item can con co the nhin thay thi khong can scroll)
                    jsExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
                    sleepInSecond(1);

                    // 4: Click vao item can chon
                    childElement.click();
                    sleepInSecond(1);

                    List<WebElement> itemSelected = driver.findElements(By.xpath("//li[@class='selected']//input"));
                    System.out.println("Item selected = " + itemSelected.size());
                    if(expectedValueItem.length == itemSelected.size()) {
                        break;
                    }
                }
            }
        }
    }

    public boolean areItemSelected(String[] itemSelectedText) {
        List<WebElement> itemSelected = driver.findElements(By.xpath("//li[@class='selected']//input"));
        int numberItemSelected = itemSelected.size();

        String allItemSelectedText = driver.findElement(By.xpath("(//button[@class='ms-choice']/span)[1]")).getText();
        System.out.println("Text da chon = " + allItemSelectedText);

        // January, March, June

        if(numberItemSelected <= 3 && numberItemSelected > 0) {
            for (String item : itemSelectedText) {
                if(allItemSelectedText.contains(item)) {
                    break;
                }
            }
            return true;
        } else {
            return driver.findElement(By.xpath("//button[@class='ms-choice']/span[text()='" + numberItemSelected + " of 12 selected']")).isDisplayed();
        }
    }

    public boolean allItemSelected(String[] itemSelectedText) {
        List<WebElement> itemSelected = driver.findElements(By.xpath("//li[@class='selected']//input"));
        int numberItemSelected = itemSelected.size();

        String allItemSelectedText = driver.findElement(By.xpath("(//button[@class='ms-choice']/span)[1]")).getText();
        System.out.println("Text da chon = " + allItemSelectedText);

        // January, March, June

        if(numberItemSelected <= 3 && numberItemSelected > 0) {
            for (String item : itemSelectedText) {
                if(allItemSelectedText.contains(item)) {
                    break;
                }
            }
            return true;
        } else {
            return driver.findElement(By.xpath("//button[@class='ms-choice']/span")).isDisplayed();
        }
    }

    public void selectTheItemInCustomDropdown(String parentXpath, String childXpath, String expectedItem) {
        //1 - Click vào thẻ (cha) để nó xổ ra tất cả các item
        driver.findElement(By.xpath(parentXpath)).click();
        sleepInSecond(1);

        //2- chờ cac item load ra het
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));

        //3-lay tat cả cac item dua vào List Element
        List<WebElement> childItems = driver.findElements(By.xpath(childXpath));

        //4- Duyet qua cai List này từng Item
        for (WebElement actualItem : childItems) {

            //5-Mỗi lần duyệt kiểm tra cái item text của nó có bằng vs Item mình cần chọn
            if(actualItem.getText().trim().equals(expectedItem)) {

                //6- tìm thấy Item cần Click thì scroll xuống Item đó(nằm bên dưới)
                jsExecutor.executeScript("arguments[0].scrollIntoView(true)",actualItem);
                sleepInSecond(2);

                //7-Click vào Item
                actualItem.click();

                //8-thoát khỏi vòng lặp
                break;
            }
        }
    }

    public void selectTheItemInEditDropdown(String parentXpath, String childXpath, String expectedItem) {
        driver.findElement(By.xpath(parentXpath)).clear();
        sleepInSecond(1);

        driver.findElement(By.xpath(parentXpath)).sendKeys(expectedItem);
        sleepInSecond(1);

        //2- chờ cac item load ra het
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));

        //3-lay tat cả cac item dua vào List Element
        List<WebElement> childItems = driver.findElements(By.xpath(childXpath));

        //4- Duyet qua cai List này từng Item
        for (WebElement actualItem : childItems) {

            //5-Mỗi lần duyệt kiểm tra cái item text của nó có bằng vs Item mình cần chọn
            if(actualItem.getText().trim().equals(expectedItem)) {

                //6- tìm thấy Item cần Click thì scroll xuống Item đó(nằm bên dưới)
                jsExecutor.executeScript("arguments[0].scrollIntoView(true)",actualItem);
                sleepInSecond(2);

                //7-Click vào Item
                actualItem.click();

                //8-thoát khỏi vòng lặp
                break;
            }
        }
    }

    //
    public String getHiddenText(String cssLocator) {
        return (String) jsExecutor.executeScript("return document.querySelector(\"" +cssLocator + "\").textContent");
    }

    public void sleepInSecond(long second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
