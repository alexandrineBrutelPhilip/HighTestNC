package yopmail;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAccueilWebmail {
	
	private WebDriver driver;
	private static final String url = "https://yopmail.com/fr/";	
	private static final String emailAddress = "alex.hightest@yopmail.com";

	@FindBy(id = "login")
	private static WebElement champEmail;
	
	@FindBy(id = "refreshbut")
	private static WebElement boutonValidationEmail;
	
	@FindBy(id = "accept")
	private static WebElement boutonAutorisationCookies;
	
	
	public PageAccueilWebmail(WebDriver driver) {
		this.driver = driver;
	}
	
	
	/**
	 * Ouvre un nouvel onglet et se dirige sur la boîte mail yopmail choisie
	 */
	public void goToMailBox() {
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(url);
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
				.elementToBeClickable(boutonAutorisationCookies));
		boutonAutorisationCookies.click();
		
		champEmail.isEnabled();
		champEmail.sendKeys(emailAddress);
		
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
				.elementToBeClickable(boutonValidationEmail));
		boutonValidationEmail.click();
	}
}
