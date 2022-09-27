package sumeyye;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
        driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("sumgule@gmail.com");
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
        options1.selectByValue("25");
        //date of birthday (MOUNTH)
        WebElement ddmMount=driver.findElement(By.xpath("//select[@id='months']"));
        Select options2=new Select(ddmMount);
        options2.selectByValue("11");
        //date of birthday (YEAR)
        WebElement ddmYear=driver.findElement(By.xpath("//select[@id='years']"));
        Select options3=new Select(ddmYear);
        options3.selectByValue("1994");
        //10. Select checkbox 'Sign up for our newsletter!'
        //driver.findElement(By.xpath("(//input[@id='newsletter']")).click();
        //*********(CHECKBOX1 ÇALIŞTIRAMADIM)**********
        //11. Select checkbox 'Receive special offers from our partners!'
        //driver.findElement(By.xpath("(//input[@id='optin']")).click();
        //***********(CHECKBOX2 ÇALIŞTIRAMADIM)***********
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.id("first_name")).sendKeys("sumeyye");
        driver.findElement(By.id("last_name")).sendKeys("guler");
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("techproed");
        driver.findElement(By.id("address1")).sendKeys("lale mahallesi");
        driver.findElement(By.id("address2")).sendKeys("cicek caddesi");
        //country
        WebElement ddmCountry=driver.findElement(By.xpath("//select[@id='country']"));
        Select options4=new Select(ddmCountry);
        options4.selectByValue("Canada");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("kavunici sokak");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("istanbul");
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("34110");
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("09123456789");
        //13. Click 'Create Account button'
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[1]")).click();
        //14. Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b[text()='Account Created!']")).isDisplayed());
        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        //16. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='fa fa-user']")).isDisplayed());
        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[2]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        //**************(BU KISIM BENDE ÇIKMADI, VE HESABIM SİLİNMEDİ)****************
        //github deneme için bu satırı yazdım

    }

}
