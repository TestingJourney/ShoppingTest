package PageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;

public class homePage {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	
	WebDriver driver;	
	
	@FindBy(xpath = "//*[@id=\"main_div\"]/table/tbody/tr/td/ul/li[3]/span[1]/a")
	WebElement apartments;
	
	public homePage(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	//Click on Dzivokli section
	public void goToApartments(){
		apartments.click();
	}
}
