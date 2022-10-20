import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test1 {
private WebDriver driver;
@BeforeClass
public void setUp(){
    String projectPath = System.getProperty("user.dir");
    System.setProperty("webdriver.chrome.driver", projectPath +"/driver/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

}
@Test
public void test1() throws InterruptedException {
    driver.get("https://www.saucedemo.com/");
    driver.manage().window().maximize();
    driver.findElement(By.id("user-name")).sendKeys("standard_user");
    driver.findElement(By.id("password")).sendKeys("secret_sauce");
    Thread.sleep(1000);
    driver.findElement(By.id("login-button")).click();
}
@AfterClass
public void tearDown(){
    driver.quit();
}
}
