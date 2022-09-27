package sumeyye;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase2 extends TestBase {
    @Test
    public void test01() {
       //1. Launch browser
       //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
       //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='carousel-inner'])[1]")).isDisplayed());
       //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
       //5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed());
       //6. Enter correct email address and password
        //7. Click 'login' button
        //sumgule@gmail.com   123456
        Actions actions=new Actions(driver);
        WebElement emailElementi=driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[1]"));
        actions.click(emailElementi)
                .sendKeys("sumgule@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("123456")
                .sendKeys(Keys.ENTER).perform();
        //8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='fa fa-user']")).isDisplayed());
       //9. Click 'Delete Account' button
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[2]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
       //10. Verify that 'ACCOUNT DELETED!' is visible
        //**************(BU KISIM BENDE ÇIKMADI, VE HESABIM SİLİNMEDİ)****************

    }
}
