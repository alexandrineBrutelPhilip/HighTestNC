package hightest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAccueil {

	private WebDriver driver;
	private static final String url = "https://hightest.nc";

	@FindBy(id = "cookie_action_close_header")
	private static WebElement boutonAccepte;

	@FindBy(xpath = "//*[@id=\"popmake-468\"]/button")
	private static WebElement boutonDeclinerNewsletter;

	@FindBy(xpath = "//a[@title='Toolbox']")
	private static WebElement goToolbox;


	public PageAccueil(WebDriver driver) {
		this.driver = driver;
	}

	
	/**
	 * Accepte les cookies, refuse la newsletter et se dirige vers la page Toolbox
	 */
	public void goToToolbox() {
		driver.get(url);
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
				.elementToBeClickable(boutonAccepte));
		boutonAccepte.click();
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
				.elementToBeClickable(boutonDeclinerNewsletter));
		boutonDeclinerNewsletter.click();
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
				.elementToBeClickable(goToolbox));
		goToolbox.click();
	}
}
