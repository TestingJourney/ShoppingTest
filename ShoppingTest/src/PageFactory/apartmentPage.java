package PageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;

public class apartmentPage {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	
	WebDriver driver;	
	
	@FindBy(id="f_bigtext")
	WebElement search;
	
	
	public apartmentPage(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	public void setSearch(String searchValue) {
		search.sendKeys(Keys.CONTROL + "a");
		search.sendKeys(Keys.DELETE);
		search.sendKeys(searchValue);
	}
	
	public void searchAds() {
		search.sendKeys(Keys.ENTER);
	}

	public void searchApartments(String searchValue){
		//Fill search fields
		this.setSearch(searchValue);
		//
		this.searchAds();
				
	}
}
