package Testing_Pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Registration {

    WebDriver driver;

    JavascriptExecutor js;

    @BeforeTest
    public void beforeTest() {

        driver = new ChromeDriver();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(15));

        driver.manage().window().maximize();

        driver.get("https://demo.automationtesting.in/Register.html");
    }

    @DataProvider(name = "data")
    public Object[][] data() {

        return new Object[][]{

                {"User1", "Test1", "Address1",
                        "user1test101@gmail.com", "9876543210",
                        "Male", "Cricket", "English",
                        "C", "1999", "January", "10",
                        "Pass@123", "Pass@123"},

                {"User2", "Test2", "Address2",
                        "user2test102@gmail.com", "9876543211",
                        "Female", "Movies", "Hindi",
                        "C++", "2000", "February", "11",
                        "Pass@234", "Pass@234"},

                {"User3", "Test3", "Address3",
                        "user3test103@gmail.com", "9876543212",
                        "Male", "Hockey", "English",
                        "API", "2001", "March", "12",
                        "Pass@345", "Pass@345"},

                {"User4", "Test4", "Address4",
                        "user4test104@gmail.com", "9876543213",
                        "Female", "Cricket", "English",
                        "Java", "2002", "April", "13",
                        "Pass@456", "Pass@456"},

                {"User5", "Test5", "Address5",
                        "user5test105@gmail.com", "9876543214",
                        "Male", "Movies", "Hindi",
                        "Linux", "2003", "May", "14",
                        "Pass@567", "Pass@567"}
        };
    }

    @Test(dataProvider = "data")
    public void registrationTest(String firstName,
                                 String lastName,
                                 String address,
                                 String email,
                                 String phone,
                                 String gender,
                                 String hobby,
                                 String language,
                                 String skill,
                                 String year,
                                 String month,
                                 String day,
                                 String password,
                                 String confirmPassword)
            throws InterruptedException {

        driver.findElement(
                By.xpath("//input[@placeholder='First Name']"))
                .sendKeys(firstName);

        driver.findElement(
                By.xpath("//input[@placeholder='Last Name']"))
                .sendKeys(lastName);

        driver.findElement(
                By.xpath("//textarea[@ng-model='Adress']"))
                .sendKeys(address);

        driver.findElement(
                By.xpath("//input[@type='email']"))
                .sendKeys(email);

        driver.findElement(
                By.xpath("//input[@type='tel']"))
                .sendKeys(phone);

        if (gender.equalsIgnoreCase("Male")) {

            driver.findElement(
                    By.xpath("//input[@value='Male']"))
                    .click();

        } else {

            driver.findElement(
                    By.xpath("//input[@value='FeMale']"))
                    .click();
        }

        driver.findElement(
                By.xpath("//input[@value='" + hobby + "']"))
                .click();

        driver.findElement(By.id("msdd")).click();

        driver.findElement(
                By.xpath("//a[text()='" + language + "']"))
                .click();

        driver.findElement(
                By.xpath("//label[text()='Skills']"))
                .click();

        WebElement skills =
                driver.findElement(By.id("Skills"));

        Select skillDropdown =
                new Select(skills);

        skillDropdown.selectByVisibleText(skill);

        driver.findElement(
                By.xpath("//span[@role='combobox']"))
                .click();

        driver.findElement(
                By.xpath("//input[@type='search']"))
                .sendKeys("India");

        driver.findElement(
                By.xpath("//li[contains(text(),'India')]"))
                .click();

        WebElement yearDrop =
                driver.findElement(By.id("yearbox"));

        Select yearSelect =
                new Select(yearDrop);

        yearSelect.selectByVisibleText(year);

        WebElement monthDrop =
                driver.findElement(
                        By.xpath("//select[@ng-model='monthbox']"));

        Select monthSelect =
                new Select(monthDrop);

        monthSelect.selectByVisibleText(month);

        WebElement dayDrop =
                driver.findElement(By.id("daybox"));

        Select daySelect =
                new Select(dayDrop);

        daySelect.selectByVisibleText(day);

        driver.findElement(By.id("firstpassword"))
                .sendKeys(password);

        driver.findElement(By.id("secondpassword"))
                .sendKeys(confirmPassword);

        js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,500)");

        driver.findElement(By.id("submitbtn"))
                .click();

        Thread.sleep(3000);

        driver.navigate().refresh();
    }

    @AfterTest
    public void afterTest() {

        if (driver != null) {

            driver.quit();
        }
    }
}