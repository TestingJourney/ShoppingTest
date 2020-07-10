package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFactory.homePage;
import PageFactory.apartmentPage;
import PageFactory.favouritesPage;
import PageFactory.adsPage;
import PageFactory.adPage;
import PageFactory.favouritesPage;

public class adAddToFavourite {
	
	String driverPath = "C:\\Users\\HP\\Desktop\\set-up\\chromedriver.exe";
	WebDriver driver;
	
	homePage objhomePage;
	apartmentPage objapartmentPage;
	adsPage objadsPage;
	adPage objadPage;
	favouritesPage objfavouritesPage;
	
	@BeforeTest
	public void setup(){
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://reklama.bb.lv/");
	}

	/**
	 * This test go to https://reklama.bb.lv/
	 * Opens Dzivokli section
	 * Search for text Riga
	 * Opens first ad
	 * Ads ad to favourites
	 */
	@Test(priority=0)
	public void open_apartments(){
		//Create Login Page object
		objhomePage = new homePage(driver);			
		objhomePage.goToApartments();	
	}
	
	@Test(priority=1)
	public void search_Ad() {
		objapartmentPage = new apartmentPage(driver);	
		objapartmentPage.searchApartments("Riga");
	}
	
	@Test(priority=2)
	public void open_Ad() {
		objadsPage = new adsPage(driver);
		objadsPage.openAd();
	}
	
	@Test(priority=3)
	public void add_Add_To_Favourite() {
		objadPage = new adPage(driver);
		objadPage.scrollToFavorite();
		objadPage.addToFavourite();
	    objadPage.openFavourites();
	}
	
	@Test(priority=4)
	public void check_favourites() throws InterruptedException {
		objfavouritesPage = new favouritesPage(driver);
		objfavouritesPage.checkFavourites(1);
	}
}
