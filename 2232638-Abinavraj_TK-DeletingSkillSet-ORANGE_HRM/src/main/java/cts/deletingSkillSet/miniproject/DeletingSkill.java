package cts.deletingSkillSet.miniproject;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class DeletingSkill  {
	public static void main(String[] args) {
		
		String filePath = "./Test-data/login-data.xlsx";
		Webpage obj = new Webpage();
		WebDriver driver=InvokeAndClose.userInputForBrowser();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		obj.excelRead(filePath);
		obj.signin(driver);
		obj.addingSkillProcess(driver);
		obj.deletingSkillProcess(driver);
		obj.verification(driver);
		obj.logoutProcess(driver);
		InvokeAndClose.closingBroswer(driver);
	}

}
