package sumeyye;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class TestCase1 extends TestBase {
    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        String actualUrl = driver.getCurrentUrl();
        String expectedlUrl = "https://automationexercise.com/";
        Assert.assertEquals(expectedlUrl, actualUrl);
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[3]")).isDisplayed());
        //6. Enter name and email address
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("sumeyye");
        driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("sumgul@gmail.com");
        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]")).isDisplayed());
        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//label[@for='id_gender2']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        //date of birthday (DAY)
        WebElement ddmDay=driver.findElement(By.xpath("//select[@id='days']"));
        Select options1=new Select(ddmDay);
        ddmDay.findElement(By.xpath("//option[@value='24']")).click();
        //date of birthday (MOUNTH)
        WebElement ddmMount=driver.findElement(By.xpath("//select[@id='months']"));
        Select options2=new Select(ddmMount);
        ddmMount.findElement(By.xpath("(//option[@value='11'])[2]")).click();
        //date of birthday (YEAR)
        WebElement ddmYear=driver.findElement(By.xpath("//select[@id='years']"));
        Select options3=new Select(ddmYear);
        ddmYear.findElement(By.xpath("//option[@value='1994']")).click();
        //10. Select checkbox 'Sign up for our newsletter!'
       driver.findElement(By.xpath("(//label[@for='newsletter']")).click();

        //11. Select checkbox 'Receive special offers from our partners!'

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //13. Click 'Create Account button'
        //            14. Verify that 'ACCOUNT CREATED!' is visible
        //15. Click 'Continue' button
        //16. Verify that 'Logged in as username' is visible
        //17. Click 'Delete Account' button
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    }

}
