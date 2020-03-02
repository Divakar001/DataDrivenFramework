package loginTestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class FromExcel {
	WebDriver driver;

	String[][] data= null;

	
	@DataProvider(name="logindata")
	public String[][] loginDataProvider() throws BiffException, IOException {
		data=getExcelData();
		return data;
	}

public String[][] getExcelData() throws BiffException, IOException {
	
	FileInputStream excel= new FileInputStream("C:\\Users\\Divakar\\Documents\\TestData.xls");
	Workbook workbook= Workbook.getWorkbook(excel);
	Sheet sheet=workbook.getSheet(0);
	int rowcount=sheet.getRows();
	int columncount=sheet.getColumns();
	String testdata[][]	= new String[rowcount-1][columncount];

	for(int i=1;i<rowcount;i++) {
		for(int j=0;j<columncount;j++) {
		testdata[i-1][j]=	sheet.getCell(j, i).getContents();	}
		}
	return testdata;
	}

@BeforeTest
public void beforetest() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Divakar\\Downloads\\chromedriver\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/");
}
@AfterTest
public void aftertest() {
	driver.quit();
  }

@Test(dataProvider="logindata")
	public void loginwithbothcorrect(String uname, String pword) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Divakar\\Downloads\\chromedriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		//enter username and password
		WebElement username=driver.findElement(By.id("txtUsername"));
		username.sendKeys(uname);


		WebElement password=driver.findElement(By.id("txtPassword"));
		password.sendKeys(pword);

		//btnLogin
		WebElement loginbutton=driver.findElement(By.id("btnLogin"));
		loginbutton.click();

		



	}
}



