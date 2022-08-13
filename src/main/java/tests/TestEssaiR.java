package tests;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import hightest.PageAccueil;
import hightest.PageTestISTQBFoundation;
import hightest.PageToolbox;
import hightest.PageResultats;
import yopmail.PageAccueilWebmail;
import yopmail.PageMailBox;


public class TestEssaiR {
	private ChromeDriver driver;
	
	@BeforeEach
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Test
	public void scenarioISTQB() throws InterruptedException{
		PageFactory.initElements(driver, PageAccueil.class).goToToolbox();
		PageFactory.initElements(driver, PageToolbox.class).goToQuizz();
		PageFactory.initElements(driver, PageTestISTQBFoundation.class).answerQuestions();
		PageFactory.initElements(driver, PageResultats.class).sendResults();
		PageFactory.initElements(driver, PageAccueilWebmail.class).goToMailBox();
		PageFactory.initElements(driver, PageMailBox.class).checkMailMessage();
	}

	@AfterEach
	public void tearDown(){
		driver.quit();
	}
}