
package stepDefinitions;
 
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageFactory.adPage;
import PageFactory.adsPage;
import PageFactory.apartmentPage;
import PageFactory.homePage;
import PageFactory.favouritesPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
 
public class addToFavourites {
 
	String driverPath = "C:\\Users\\HP\\Desktop\\set-up\\chromedriver.exe";
	public static WebDriver driver;
	
	homePage objhomePage;
	apartmentPage objapartmentPage;
	adsPage objadsPage;
	adPage objadPage;
	favouritesPage objfavouritesPage;

@Given("^Open chrome browser and navigate to reklama\\.bb\\.lv web page$")
public void open_chrome_browser_and_navigate_to_reklama_bb_lv_web_page() throws Throwable {
	System.setProperty("webdriver.chrome.driver", driverPath);
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://reklama.bb.lv/");
}

@When("^Go to Dzivokli category$")
public void go_to_Dzivokli_category() throws Throwable {
	objhomePage = new homePage(driver);			
	objhomePage.goToApartments();	
}

@When("^Search for an ad$")
public void search_for_an_ad() throws Throwable {
	objapartmentPage = new apartmentPage(driver);	
	objapartmentPage.searchApartments("Riga");
}

@When("^Open an ad$")
public void open_an_ad() throws Throwable {
	objadsPage = new adsPage(driver);
	objadsPage.openAd();
}

@When("^Scroll down to \"([^\"]*)\" and click \"([^\"]*)\"$")
public void scroll_down_to_and_click(String arg1, String arg2) throws Throwable {
	objadPage = new adPage(driver);
	objadPage.scrollToFavorite();
	objadPage.addToFavourite();
}


@When("^Open \"([^\"]*)\" section$")
public void open_section(String arg1) throws Throwable {
	objadPage = new adPage(driver);
    objadPage.openFavourites();
}

@Then("^Check added ad$")
public void check_added_ad() throws Throwable {
	objfavouritesPage = new favouritesPage(driver);
	objfavouritesPage.checkFavourites(1);
}

}