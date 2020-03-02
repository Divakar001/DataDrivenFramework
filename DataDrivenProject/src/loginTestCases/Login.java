package loginTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login {

	String[][] data= {
			{"admin1","admin123"},
			{"admin","nevergiveup"},
			{"admin","admin123"},
			{"admin1","admin1234"},

	};
	@DataProvider(name="logindata")
	public String[][] loginDataProvider() {
		return data;
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

		driver.quit();



	}
}
