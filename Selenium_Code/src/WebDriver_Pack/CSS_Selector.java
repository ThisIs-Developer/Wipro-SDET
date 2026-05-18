package WebDriver_Pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSS_Selector {

	public static void main(String[] args) {

	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
//	    driver.get("http://zero.webappsecurity.com/login.html");
//
//	    // Locate by link text
//	    driver.findElement(By.linkText("Forgot your password ?")).click();
//	    // Locate by partial link text
//	    driver.findElement(By.partialLinkText("Forgot your")).click();

	    
	    // CSS Selector Examples
	    driver.get("https://demoqa.com/automation-practice-form");

	    // CSS by ID
	    // Syntax => tagname[id='value']
	    driver.findElement(By.cssSelector("input[id='firstName']")).click();
	    driver.findElement(By.cssSelector("input[id='firstName']")).sendKeys("Neeva");

	    // CSS by Class
	    // Syntax => tagname[class='value']
	    driver.findElement(By.cssSelector("input[class='mr-sm-2 form-control']")).click();
	    driver.findElement(By.cssSelector("input[class='mr-sm-2 form-control']")).sendKeys("Sharma");

	    // CSS by Attribute
	    // Syntax => tagname[attribute='value']
	    driver.findElement(By.cssSelector("input[placeholder='name@example.com']")).click();
	    driver.findElement(By.cssSelector("input[placeholder='name@example.com']")).sendKeys("abc@gmail.com");

	    // CSS by Multiple Attributes
	    // Syntax => tagname[attr1='value'][attr2='value']
	    driver.findElement(By.cssSelector("input#gender-radio-2[name='gender']")).click();

	    // CSS Parent-Child
	    // Syntax => parenttag > childtag[attribute='value']
	    driver.findElement(By.cssSelector("input[id=\"dateOfBirthInput\"]")).click();
        driver.findElement(By.cssSelector("select>option[value=\"2017\"]")).click();
        driver.findElement(By.cssSelector("select>option[value=\"5\"]")).click();
        driver.findElement(By.cssSelector("div[class=\"react-datepicker_day react-datepicker_day--020\"]")).click();
        //class="react-datepicker_day react-datepickerday--020 react-datepicker_day--selected"

	    driver.quit();
	}

}
