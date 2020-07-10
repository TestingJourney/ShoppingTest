package PageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;

public class adPage {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	
	WebDriver driver;	
	
	@FindBy (id="favs-link")
	WebElement favouriteLink;
	
	@FindBy (id="favorites-link")
	WebElement favouritesLink;
	
	public adPage(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	public void scrollToFavorite() {
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", favouriteLink);
	}
	
	public void addToFavourite() {
		favouriteLink.click();
	}
	
	public void openFavourites() {
		favouritesLink.click();
	}
	
}
