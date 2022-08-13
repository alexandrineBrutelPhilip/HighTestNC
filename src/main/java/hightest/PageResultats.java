package hightest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageResultats {

	private WebDriver driver;
	
	private static final String emailAddress = "alex.hightest@yopmail.com";

	@FindBy(id = "email")
	private static WebElement champAdresseMail;

	@FindBy(id = "submitMail")
	private static WebElement boutonOK;
	
	@FindBy(xpath = "//h2[contains(text(),\"Parfait\")]")
	private static WebElement messageParfait;


	public PageResultats(WebDriver driver) {
		this.driver = driver;
	}
	
	
	/**
	 * Envoie les résultats sur une boîte mail
	 */
	public void sendResults() {
		champAdresseMail.isEnabled();
		champAdresseMail.isDisplayed();
		champAdresseMail.sendKeys(emailAddress);
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
				.elementToBeClickable(boutonOK));
		boutonOK.click();
		messageParfait.isDisplayed();
	}
}
