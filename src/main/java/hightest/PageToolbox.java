package hightest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageToolbox {

	private WebDriver driver;

	@FindBy(xpath = "//*[.=\"Quiz ISTQB niveau Foundation\"]/..//a[.=\"Français\"]")
	private static WebElement btnQuizzISTQBFoundFR;


	public PageToolbox(WebDriver driver) {
		this.driver = driver;
	}

	
	/**
	 * Se dirige vers le Quiz ISTQB niveau Foundation en français
	 */
	public void goToQuizz() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(false);", btnQuizzISTQBFoundFR);

		// récupération du handle de la fenêtre active
		String currentWindow = driver.getWindowHandle();


		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
				.elementToBeClickable(btnQuizzISTQBFoundFR));
		btnQuizzISTQBFoundFR.click();

		new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.numberOfWindowsToBe(2));

		Set<String> listWindows = driver.getWindowHandles();
		listWindows.remove(currentWindow);

		Object[] listWindowsToGet = listWindows.toArray();
		String newWindow = (String) listWindowsToGet[0];

		driver.switchTo().window(newWindow);
	}
}
