package cts.deletingSkillSet.miniproject;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class InvokeAndClose {

	static String baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";


	/**
	 * @return driver so by launch the browser as requested type
	 */
	public static WebDriver userInputForBrowser() {

		System.out.println("Select your browser 1. chrome 2. Edge");
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		int choiceOfInt=sc.nextInt();
		switch(choiceOfInt) {
		case 1:
			System.out.println("Launching Chrome browser as requested");
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			ChromeDriver driver1 = new ChromeDriver();
			driver1.get(baseURL);
			System.out.println("URL is getting launched");
			return driver1;
		case 2 :
			System.out.println("Launching Edge browser as requested");
			System.setProperty("webdriver.edge.driver","./drivers/msedgedriver.exe");
			EdgeDriver driver2 = new EdgeDriver();
			driver2.get(baseURL);
			System.out.println("URL is getting launched");
			return driver2;
		default:
			System.out.println("Please enter valid Input");
			return null;
		}
	}
	/**
	 * @param driver
	 */
	public static void closingBroswer(WebDriver driver) {
		System.out.println("Closing the browser after log out");
		driver.quit();
	}

}
