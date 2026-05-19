package WebDriver_Pack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_Code {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demoqa.com/buttons");
		
		//Double click btn
		WebElement dc = driver.findElement(By.id("doubleClickBtn"));
		Actions ac = new Actions(driver);
		ac.doubleClick(dc).perform();
		Thread.sleep(2000);
		
		//Right click btn
		WebElement rc = driver.findElement(By.id("rightClickBtn"));
//		Actions ac = new Actions(driver);
		ac.contextClick(rc).perform();
		Thread.sleep(2000);
		
		//Dynamic click btn
		WebElement dyc = driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div[1]/div[3]/button"));
//		Actions ac = new Actions(driver);
		ac.moveToElement(dyc).click().perform();
		Thread.sleep(2000);
		
		// Drag And Drop
        WebElement sr=driver.findElement(By.id("draggable"));
        WebElement tg=driver.findElement(By.id("droppable"));
//        Actions ac=new Actions(driver);
        Thread.sleep(2000);
        ac.dragAndDrop(sr, tg).perform();
        Thread.sleep(2000);
        
        // Slide
        driver.get("https://testautomationpractice.blogspot.com/");
        WebElement sr1=driver.findElement(By.xpath("(//span[@class=\"ui-slider-handle ui-corner-all ui-state-default\"])[1]"));
//        Actions ac=new Actions(driver);
        Thread.sleep(2000);
        ac.dragAndDropBy(sr1, 0, 200).perform();// move right
        Thread.sleep(2000);
        ac.dragAndDropBy(sr1, -20, 0).perform();// move left
        Thread.sleep(2000);
        
        // Mouse Hover
        WebElement moc=driver.findElement(By.xpath("//*[@id=\"HTML3\"]/div[1]/div/button"));
        Thread.sleep(2000);
        ac.moveToElement(moc).perform();
        Thread.sleep(2000);
        
        driver.quit();
	}

}
