package hightest;

import java.time.Duration;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageTestISTQBFoundation {

	Hashtable<String, String> quizzAnswers = new Hashtable<String, String>();
//	ArrayList<String> listAnswers = new ArrayList<>();

	private WebDriver driver;

	@FindBy(id = "submit")
	private static WebElement boutonTermine;

	public PageTestISTQBFoundation(WebDriver driver) {
		this.driver = driver;
	}

	/*
	private void provisionAnswers() {
		quizzAnswers.put("QU'EST-CE QUE LE DÉBOGAGE ?",
				"Le débogage est l'activité de développement qui consiste à trouver, analyser et corriger les défauts.");
		listAnswers.add("QU'EST-CE QUE LE DÉBOGAGE ?");

		quizzAnswers.put("LORS DE LA PHASE DE CONCEPTION DES SPÉCIFICATIONS, QUELLE PRATIQUE EST LA PLUS ADÉQUATE ?",
				"Le testeur effectue une revue des spécifications afin de détecter au plus tôt les points à éclaircir ou à corriger");
		listAnswers.add("LORS DE LA PHASE DE CONCEPTION DES SPÉCIFICATIONS, QUELLE PRATIQUE EST LA PLUS ADÉQUATE ?");

		quizzAnswers.put("UN TEST AUTOMATISÉ EST EN ERREUR, POURTANT L’APPLICATION FONCTIONNE CORRECTEMENT. COMMENT CELA S’APPELLE-T-IL ?",
				"Un faux positif");
		listAnswers.add("UN TEST AUTOMATISÉ EST EN ERREUR, POURTANT L’APPLICATION FONCTIONNE CORRECTEMENT. COMMENT CELA S’APPELLE-T-IL ?");

		quizzAnswers.put("LA VOCATION DES TESTS FONCTIONNELS DYNAMIQUES AUTOMATISÉS EST DE :",
				"Se prémunir contre les régressions des fonctionnalités entre deux versions du produit");
		listAnswers.add("LA VOCATION DES TESTS FONCTIONNELS DYNAMIQUES AUTOMATISÉS EST DE :");

		quizzAnswers.put("LORS DE L’EXÉCUTION D’UNE CAMPAGNE DE TEST, LES CAS DE TEST FOURNISSENT UNE LIGNE DIRECTRICE QU'IL FAUT SUIVRE À LA LETTRE.",
				"Faux. S'éloigner des cas de tests permet de couvrir des cas non prévus et ainsi d'améliorer la couverture des tests.");
		listAnswers.add("LORS DE L’EXÉCUTION D’UNE CAMPAGNE DE TEST, LES CAS DE TEST FOURNISSENT UNE LIGNE DIRECTRICE QU'IL FAUT SUIVRE À LA LETTRE.");

		quizzAnswers.put("COMMENT SE CALCULE UN RISQUE ?",
				"Risque = Probabilité d’occurrence x Impact en cas d’occurrence");
		listAnswers.add("COMMENT SE CALCULE UN RISQUE ?");

		quizzAnswers.put("QU’EST-CE QU’UNE PARTITION D’ÉQUIVALENCE ?",
				"Une plage de données qui, lorsqu’elles sont utilisées dans un même test, doivent générer le même comportement.");
		listAnswers.add("QU’EST-CE QU’UNE PARTITION D’ÉQUIVALENCE ?");

		quizzAnswers.put("UNE BORNE D’ACHAT DE TICKETS DE BUS INTERDIT LE PAIEMENT EN ESPÈCE, SAUF SI L’UTILISATEUR LUI PRÉSENTE UNE CARTE D’ABONNÉ ACTIVÉE ET NON PÉRIMÉE. QUEL OUTIL EST TOUT INDIQUÉ POUR ANALYSER LES DIFFÉRENTS COMPORTEMENTS POSSIBLES DE L’APPLICATION ?",
				"Une table de décisions");
		listAnswers.add("UNE BORNE D’ACHAT DE TICKETS DE BUS INTERDIT LE PAIEMENT EN ESPÈCE, SAUF SI L’UTILISATEUR LUI PRÉSENTE UNE CARTE D’ABONNÉ ACTIVÉE ET NON PÉRIMÉE. QUEL OUTIL EST TOUT INDIQUÉ POUR ANALYSER LES DIFFÉRENTS COMPORTEMENTS POSSIBLES DE L’APPLICATION ?");

		quizzAnswers.put("UN TEST UNITAIRE EXÉCUTE LA FONCTION SUIVANTE AVEC L’ARGUMENT $SOLDES = TRUE.",
				"I et II");
		listAnswers.add("UN TEST UNITAIRE EXÉCUTE LA FONCTION SUIVANTE AVEC L’ARGUMENT $SOLDES = TRUE.");

		quizzAnswers.put("L’INDÉPENDANCE DE L’ÉQUIPE DE TEST VIS-À-VIS DE L’ÉQUIPE DE DÉVELOPPEMENT FAVORISE L’IMPARTIALITÉ DES TESTS. MAIS ELLE PRÉSENTE AUSSI DES RISQUES. LEQUEL N’EN FAIT PAS DIRECTEMENT PARTIE ?",
				"Risque pour l’équipe de test de manquer de légitimité auprès du client");
		listAnswers.add("L’INDÉPENDANCE DE L’ÉQUIPE DE TEST VIS-À-VIS DE L’ÉQUIPE DE DÉVELOPPEMENT FAVORISE L’IMPARTIALITÉ DES TESTS. MAIS ELLE PRÉSENTE AUSSI DES RISQUES. LEQUEL N’EN FAIT PAS DIRECTEMENT PARTIE ?");

		quizzAnswers.put("TOUT PROJET DE TEST EST SOUMIS À DEUX GRANDES FAMILLES DE RISQUES. LESQUELS ?",
				"Les risques projet et les risques produit");
		listAnswers.add("TOUT PROJET DE TEST EST SOUMIS À DEUX GRANDES FAMILLES DE RISQUES. LESQUELS ?");

		quizzAnswers.put("PARMI LES ACTIVITÉS SUIVANTES, LESQUELLES PEUVENT ÊTRE RÉALISÉES DE MANIÈRE INFORMELLE ?",
				"Les revues de code");
		listAnswers.add("PARMI LES ACTIVITÉS SUIVANTES, LESQUELLES PEUVENT ÊTRE RÉALISÉES DE MANIÈRE INFORMELLE ?");

		quizzAnswers.put("QU’EST-CE QU’UNE EXIGENCE NON-FONCTIONNELLE ?",
				"Une exigence ne se rapportant pas aux fonctionnalités");
		listAnswers.add("QU’EST-CE QU’UNE EXIGENCE NON-FONCTIONNELLE ?");

		quizzAnswers.put("L’ÉQUIPE DE DÉVELOPPEMENT VIENT DE FINALISER LE DÉVELOPPEMENT D’UN SITE CONTENANT BEAUCOUP D’ANIMATIONS (CARROUSEL D’IMAGES, POPUPS…) LE CLIENT SOUHAITE S’ASSURER QUE CE GRAND NOMBRE D’ANIMATION NE RALENTIT PAS TROP LE CHARGEMENT DU SITE. QUEL TYPE DE TEST EST TOUT INDIQUÉ DANS CE CAS-LÀ ?",
				"Test de performance");
		listAnswers.add("L’ÉQUIPE DE DÉVELOPPEMENT VIENT DE FINALISER LE DÉVELOPPEMENT D’UN SITE CONTENANT BEAUCOUP D’ANIMATIONS (CARROUSEL D’IMAGES, POPUPS…) LE CLIENT SOUHAITE S’ASSURER QUE CE GRAND NOMBRE D’ANIMATION NE RALENTIT PAS TROP LE CHARGEMENT DU SITE. QUEL TYPE DE TEST EST TOUT INDIQUÉ DANS CE CAS-LÀ ?");

		quizzAnswers.put("LA QUALITÉ EST DÉFINIE COMME...",
				"le degré par lequel un composant, système ou processus atteint des exigences spécifiées et/ou des besoins ou attentes des clients ou utilisateurs");
		listAnswers.add("LA QUALITÉ EST DÉFINIE COMME...");

		quizzAnswers.put("COCHEZ LA FORMULATION JUSTE.",
				"Un développeur introduit un bug dans son code. Ce bug est susceptible de générer une défaillance du système.");
		listAnswers.add("COCHEZ LA FORMULATION JUSTE.");

		quizzAnswers.put("LES RAPPORTS D'INCIDENTS PEUVENT AVOIR PLUSIEURS OBJECTIFS. LEQUEL N'EN FAIT PAS PARTIE ?",
				"Fournir aux chefs de projet des métriques de performance relatives à chaque développeur");
		listAnswers.add("LES RAPPORTS D'INCIDENTS PEUVENT AVOIR PLUSIEURS OBJECTIFS. LEQUEL N'EN FAIT PAS PARTIE ?");

		quizzAnswers.put("DANS QUEL ORDRE SE DÉROULENT EN PRINCIPE LES DIFFÉRENTS NIVEAUX DE TESTS ?",
				"Tests de composants, tests d'intégration, tests système, tests d'acceptation");
		listAnswers.add("DANS QUEL ORDRE SE DÉROULENT EN PRINCIPE LES DIFFÉRENTS NIVEAUX DE TESTS ?");

		quizzAnswers.put("L'AGILITÉ S'OPPOSE-T-ELLE AU TEST ?",
				"Non. L'agilité favorise une exécution fréquente des tests afin d'éviter les régressions d'une itération à l'autre.");
		listAnswers.add("L'AGILITÉ S'OPPOSE-T-ELLE AU TEST ?");

		quizzAnswers.put("QUAND FAUT-IL COMMENCER À TESTER ?",
				"Dès qu'il existe un brouillon de spécification. Des bugs peuvent déjà exister dans la documentation.");
		listAnswers.add("QUAND FAUT-IL COMMENCER À TESTER ?");


	}*/
	
	/**
	 * Prépare les réponses au questionnaire
	 */
	private void provisionAnswers() {
		quizzAnswers.put("0","1");
		quizzAnswers.put("1","2");
		quizzAnswers.put("2","1");
		quizzAnswers.put("3","2");
		quizzAnswers.put("4","2");
		quizzAnswers.put("5","3");
		quizzAnswers.put("6","2");
		quizzAnswers.put("7","4");
		quizzAnswers.put("8","1");
		quizzAnswers.put("9","3");
		quizzAnswers.put("10","4");
		quizzAnswers.put("11","2");
		quizzAnswers.put("12","3");
		quizzAnswers.put("13","2");
		quizzAnswers.put("14","4");
		quizzAnswers.put("15","3");
		quizzAnswers.put("16","3");
		quizzAnswers.put("17","1");
		quizzAnswers.put("18","2");
		quizzAnswers.put("19","2");	
	}
	
	
	/**
	 * Répond au questionnaire avec toutes les bonnes réponses, puis le valide
	 */
	public void answerQuestions() {		
		this.provisionAnswers();

		//		Enumeration<String> answers;
		//		answers = this.quizzAnswers.keys();

		//		while(answers.hasMoreElements()) {
		//			String key = (String) answers.nextElement();
		//			System.out.println("Key: " +key+ " & Value: " +
		//					quizzAnswers.get(key));
		//			String locator = "//input[@name='"+key+"' and @value='"+quizzAnswers.get(key)+"']";
		//			System.out.println(locator);
		//			driver.findElement(By.xpath(locator)).click();
		//		}

		//*[contains(text(),"Le débogage est l'activité de développement qui consiste à trouver, analyser et corriger les défauts.")]

		//		driver.findElement(By.xpath("//*[contains(text(),\"Le débogage est l'activité de développement qui consiste à trouver, analyser et corriger les défauts.\")]"));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		int nbAnswers = quizzAnswers.size();
		
		for(int i=0; i<nbAnswers; i++) {
			String key = Integer.toString(i);
			String locator = "//input[@name='"+key+"' and @value='"+quizzAnswers.get(key)+"']";
			WebElement obj = driver.findElement(By.xpath(locator));
			try {
				new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
						.elementToBeClickable(obj));
				obj.click();
			}catch (ElementClickInterceptedException e) {
				executor.executeScript("arguments[0].scrollIntoView(true);", obj);
				new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
						.elementToBeClickable(obj));
				obj.click();
			}
		}

//		for(String key: listAnswers) {
//			String locator = "//input[@name='"+key+"' and @value='"+quizzAnswers.get(key)+"']";
//			WebElement obj = driver.findElement(By.xpath(locator));
//			try {
//				obj.isEnabled();
//				obj.isDisplayed();
//				obj.click();
//			}catch (ElementClickInterceptedException e) {
//				executor.executeScript("arguments[0].scrollIntoView(true);", obj);
//				obj.isEnabled();
//				obj.isDisplayed();
//				obj.click();
//			}
//		}

		executor.executeScript("arguments[0].scrollIntoView(true);", boutonTermine);

		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
				.elementToBeClickable(boutonTermine));
		boutonTermine.click();
	}
}
