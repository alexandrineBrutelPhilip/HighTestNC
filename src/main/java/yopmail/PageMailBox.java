package yopmail;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageMailBox {

	private WebDriver driver;

	@FindBy(xpath = "//*[contains(text(),\"répondu à 20 question(s) sur 20, soit 100\")]")
	private static WebElement message100;

	@FindBy(id = "refresh")
	private static WebElement boutonRefresh;

	@FindBy(id = "ifinbox")
	private static WebElement inbox;


	public PageMailBox(WebDriver driver) {
		this.driver = driver;
	}


	/**
	 * Raffraîchi la boîte de réception et attend l'apparition du mail
	 */
	private void refreshMailBox() {
		driver.switchTo().defaultContent();
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
				.elementToBeClickable(boutonRefresh));
		boutonRefresh.click();
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
				.attributeToBe(inbox, "state", "full"));
	}
	
	/**
	 * Cherche la mention affirmant que 100% des réponses sont correctes
	 */
	private void checkMessage() {
		System.out.println("Vérification du mail...");
		driver.switchTo().frame("ifmail");
		message100.isDisplayed();
		System.out.println("Le mail reçu contient bien 100% de bonnes réponses.");
	}

	
	/**
	 * Cherche la mention affirmant que 100% des réponses sont correctes,
	 * si le mail n'est pas trouvé, rafraîchi la boîte de réception
	 * et cherche à nouveau la mention
	 */
	public void checkMailMessage() {
		try {
			checkMessage();
		} catch (NoSuchElementException e) {
			refreshMailBox();
			checkMessage();
		}
	}
}
