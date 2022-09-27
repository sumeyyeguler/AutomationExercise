package nurettin;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class TestCase2 {


        static WebDriver driver;
        @BeforeClass
        public static void setup(){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        @Test
        public void test1() {
            //2. Navigate to url 'http://automationexercise.com'
            driver.get("http://automationexercise.com");
            //3. Verify that home page is visible successfully
            Assert.assertEquals("https://automationexercise.com/", driver.getCurrentUrl());
        }
        @Test
        public void test2(){
            test1();
            //4. Click on 'Signup / Login' button
            driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
            //5. Verify 'Login to your account' is visible
            Assert.assertTrue(driver.findElement(By.xpath("(//h2)[1]")).isDisplayed());
            //6. Enter correct email address and password
            driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys("nurettin@gmail.com");
            driver.findElement(By.xpath("//*[@type='password']")).sendKeys("123");
            //7. Click 'login' button
            driver.findElement(By.xpath("//*[text()='Login']")).click();
            //8. Verify that 'Logged in as username' is visible
            Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());
            //9. Click 'Delete Account' button
            driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();
            //10. Verify that 'ACCOUNT DELETED!' is visible
        }
    }


