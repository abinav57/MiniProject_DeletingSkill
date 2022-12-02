package cts.deletingSkillSet.miniproject;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Webpage {

	static WebElement uName=null;
	static WebElement password=null;
	static String userName=null;
	static String pd=null;
	/**
	 * @param driver
	 * read the excel file 
	 * take the value from cell 1 as username
	 * take the value from cell 2 as password
	 * click Enter
	 */

	public void excelRead(String filePath) {
		@SuppressWarnings("resource")
		XSSFWorkbook wBook;
		try {
			wBook = new XSSFWorkbook(filePath);
			XSSFSheet sheet= wBook.getSheetAt(0);
			XSSFRow row=sheet.getRow(1);
			XSSFCell cell= row.getCell(0);
			userName = cell.getStringCellValue();
			XSSFCell ncell= row.getCell(1);
			pd = ncell.getStringCellValue();
			System.out.println("Reading input value from Excel sheet for Username & password of LOGIN page ");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	/**
	 * @param driver
	 * sign in using username and password which are read from excel
	 */
	public  void signin(WebDriver driver) {

		uName = driver.findElement(By.name("username"));
		System.out.println("Getting the input value from Excel sheet for and put it in placeholder of username :"+userName);
		uName.sendKeys(userName);
		password= driver.findElement(By.name("password"));
		System.out.println("Getting the input value from Excel sheet for and put it in placeholder of password :"+pd+" ,Press Enter to log");
		password.sendKeys(pd);
		password.sendKeys(Keys.ENTER);

	}


	/**
	 * @param driver
	 * 	ADMIN -> Qualifications -> Skills  -> Add -> "Testing Demo" as skill name
	 */
	public  void addingSkillProcess(WebDriver driver) {

		//clicking adminbutton 
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Admin"))).perform();
		driver.findElement(By.linkText("Admin")).click();	
		System.out.println("clicking Admin button");

		//clicking qualifications button and add button
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("//span[text()='Qualifications ']"))).perform();
		driver.findElement(By.xpath("//span[text()='Qualifications ']")).click();
		System.out.println("clicking Qualifications button");
		//clicking skill & add skills
		driver.findElement(By.linkText("Skills")).click();
		System.out.println("clicking skills button");
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();
		System.out.println("clicking ADD button");
		//testing skill added 
		WebElement skilladd=driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input"));
		skilladd.click();
		skilladd.sendKeys("Testing Demo");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Testing Skill are added successfully ");
	}

	/**
	 * @param driver
	 * deleting process are done by clicking the delete and press the confirmation yes button
	 */
	public  void deletingSkillProcess(WebDriver driver) {

		driver.findElement(By.xpath("//div[contains(text(),'Testing')]/following::button")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Yes, Delete']")).click();
		System.out.println("Testing Skill are deleted successfully ");
	}

	/**
	 * @param driver
	 *   "TESTING DEMO" is removed or not is verified by below code
	 */
	public  void verification(WebDriver driver) {
		if(driver.findElement(By.xpath("(//div[@class='oxd-layout-context'])[1]")).getText().contains("Testing demo")  ) {
			System.out.println("Testing Demo Skill is Still present!!");
		}else {
			System.out.println("Testing demo is deleted succesfully after performing deleting process!!");
		}
	}

	/**
	 * @param driver
	 * automate the log out process by clicking logout button
	 */
	public  void logoutProcess(WebDriver driver) {

		driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("Clicking Log Out button");

	}


}
