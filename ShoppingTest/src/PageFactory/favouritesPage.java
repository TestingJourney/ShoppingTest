package PageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class favouritesPage {
	
	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	
	WebDriver driver;	
	
	@FindBy (id="favorites_count")
	WebElement favouritesCount;
	
	public favouritesPage(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	public void checkFavourites(int count) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(Integer.parseInt(favouritesCount.getText()), count);		
	}
}