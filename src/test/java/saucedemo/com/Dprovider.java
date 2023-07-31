package saucedemo.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dprovider {
	
	
WebDriver  driver;
	
	@BeforeClass
	void initialization() {
		
		System.out.println("initiating the driver");
		
        driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		
		
	}
	
	

	@Test(dataProvider = "logindata")
	void login(String username , String password)
	{
	
	driver.get("https://www.saucedemo.com/v1/");
		driver.findElement(By.xpath("//input[@class = 'form_input' and @name= 'user-name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@class = 'form_input' and @name= 'password']")).sendKeys(password);
	
		driver.findElement(By.xpath("//input[@class = 'btn_action']")).click();
		
		
	}
	
	@DataProvider(name = "logindata")
	Object [] [] dprovider(){
		
	Object [] [] data =	{{"standard_user", "secret_sauce"},{"locked_out_user","secret_sauce"},{"problem_user","secret_sauce"},{"performance_glitch_user", "secret_sauce"}};
		
		
		return data;
		
		
	}
	

}
