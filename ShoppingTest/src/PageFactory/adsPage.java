package PageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;

public class adsPage {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	
	WebDriver driver;	
	
	@FindBy(xpath="//*[@id=\"posts\"]/tbody/tr[1]/td[7]/div/a")
	WebElement firstAd;	
	
	public adsPage(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}	
	
	public void openAd() {
		firstAd.click();
	}
	
}
