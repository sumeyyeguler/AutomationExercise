package tulay;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase2 extends TestBase {
    @Test
    public void test01() {

        //1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[@alt='Website for automation practice']")).isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed());

        //6. Enter correct email address and password
        //7. Click 'login' button
        Actions actions=new Actions(driver);
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("tulay28@gmail.com");
        actions.sendKeys(Keys.TAB).sendKeys("123456")
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        //8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());

        //9. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-danger']")).click();

        //10. Verify that 'ACCOUNT DELETED!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//*[text()='Delete Account'])[2]")).isDisplayed());

    }
}