package Testing_Pratice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Amazon_Automation {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void beforeTest() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.amazon.in/");
    }

    @Test(priority = 1)
    public void registration() throws InterruptedException {

        try {
            WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nav-link-accountList\"]/a")));
            login.click();

            WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_email_login")));
            email.sendKeys("baivabbandel@gmail.com");
            email.sendKeys(Keys.ENTER);
            Thread.sleep(2000);

            WebElement crtBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"intention-submit-button\"]/span/input")));
            crtBtn.click();
            Thread.sleep(1000);

            WebElement phoneNo = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_phone_number")));
            phoneNo.sendKeys("9876543210");
            phoneNo.sendKeys(Keys.ENTER);
            Thread.sleep(1000);

            WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_customer_name")));
            name.sendKeys("Hello Testing");
            name.sendKeys(Keys.ENTER);
            Thread.sleep(1000);

            try {
                WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password")));
                password.sendKeys("Hello@123");
            } catch (Exception e) {
                System.out.println("Password field not found");
            }
            Thread.sleep(1000);

            WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
            continueBtn.click();
            Thread.sleep(20000);

            try {
                WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"proceed-with-mobile-conflict\"]/div/div[1]/label/i")));
                checkbox.click();

                WebElement verifyNo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"auth-create-account-btn\"]/span/input")));
                verifyNo.click();
            } catch (Exception e) {
                System.out.println("Verification option not found");
            }
        } catch (Exception e) {
            System.out.println("Registration failed : " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void login() throws InterruptedException {
        try {
            driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");

            WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_email_login")));
            email.sendKeys("baivabsarkar@gmail.com");
            email.sendKeys(Keys.ENTER);
            Thread.sleep(2000);

            WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_password")));
            password.sendKeys("baivab@bandel");
            password.sendKeys(Keys.ENTER);

            try {
                Thread.sleep(2000);
                WebElement whatsappOTP = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"auth-send-code\"]/span/input")));
                whatsappOTP.click();
            } catch (Exception e) {
                System.out.println("WhatsApp OTP option not found");
            }
            Thread.sleep(15000);

            try {
                WebElement otpSubmit = wait.until(ExpectedConditions.elementToBeClickable(By.id("auth-signin-button")));
                otpSubmit.sendKeys(Keys.ENTER);
            } catch (Exception e) {
                System.out.println("OTP submit button not found");
            }
        } catch (Exception e) {
            System.out.println("Login failed : " + e.getMessage());
        }
    }

    @Test(priority = 3)
    public void search_Engine() throws InterruptedException {
        String[] products = {
                "wireless headphones",
                "Kitchen Product",
                "Party Product"
        };

        for (String item : products) {
            try {
                WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
                search.click();
                search.sendKeys(Keys.CONTROL + "a");
                search.sendKeys(Keys.DELETE);
                search.sendKeys(item);
                search.sendKeys(Keys.ENTER);
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Search failed for : " + item);
            }
        }
    }

    @Test(priority = 4)
    public void add_to_cart() throws InterruptedException {
        String[] products = {
                "wireless headphones",
                "laptop",
                "smart watch"
        };
        for (String item : products) {
            try {
                WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
                search.click();
                search.sendKeys(Keys.CONTROL + "a");
                search.sendKeys(Keys.DELETE);
                search.sendKeys(item);
                search.sendKeys(Keys.ENTER);
                Thread.sleep(2000);
                
                WebElement addCart = wait.until(ExpectedConditions.elementToBeClickable(By.id("a-autoid-3-announce")));
                addCart.click();
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println("Unable to add product : " + item);
            }
        }

        try {
            WebElement goCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/a[2]")));
            goCart.click();

        } catch (Exception e) {
            System.out.println("Cart button not found");
        }
    }

    @Test(priority = 5)
    public void viewProduct() throws InterruptedException {
        String parentWindow = driver.getWindowHandle();
        int totalProducts = driver.findElements(By.cssSelector("span.a-truncate-cut")).size();
        
        for (int i = 0; i < totalProducts; i++) {
            List<WebElement> products = driver.findElements(By.cssSelector("span.a-truncate-cut"));

            WebElement product = products.get(i);
            product.click();
            Thread.sleep(3000);

            for (String window : driver.getWindowHandles()) {
                if (!window.equals(parentWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }

            Thread.sleep(3000);
            driver.close();
            driver.switchTo().window(parentWindow);
            Thread.sleep(2000);
        }
    }

    @Test(priority = 6)
    public void remove_from_cart() throws InterruptedException {
        try {
            WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Delete']")));
            deleteBtn.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Delete button not found");
        }
    }

    @Test(priority = 7)
    public void updateAddress() throws InterruptedException {
    	WebElement goCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/a[2]")));
        goCart.click();

        try {
            WebElement proceedToCheckout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"checkout-deliveryAddressPanel\"]/div/div[2]/span/a")));
            proceedToCheckout.click();

            WebElement changeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"select-destination-on-sasp-desktop-panel-id-QL5IM22MZZU6RO2Q4JHYG126KM8TWKZWUA1GUWZKWT8MK6OPXTQ2EIA2OXOZPPOH\"]/div/label/i")));
            changeBtn.click();

            wait.until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            By.id("delivery-addresses-section-header-id")));

            WebElement alterAddress = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//*[@id=\"select-destination-on-sasp-desktop-panel-id-QL5IM22MZZU6RO2Q4JHYG126KM8TWKZWUA1GUWZKWT8MK6OPXTQ2EIA2OXOZPPOH\"]/div/label/input")));
            alterAddress.click();

            WebElement cfmAddress = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.id("checkout-primary-continue-shipaddressselect")));
            cfmAddress.click();
            Thread.sleep(2000);
        } catch (Exception e) {

            System.out.println("Address update failed");
        }
    }

    @AfterTest
    public void afterTest() {
    	driver.quit();
    }
}