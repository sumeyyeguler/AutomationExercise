package fatma;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase4 extends TestBase {
    @Test
    public void test() {
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");
        //    //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertEquals("https://automationexercise.com/",driver.getCurrentUrl());
        //    //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        //5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed());
        //6. Doğru e-posta adresini ve şifreyi girin
        //7. 'Giriş' düğmesini tıklayın
        Actions actions=new Actions(driver);
        Faker fkr=new Faker();
        actions.click(driver.findElement(By.xpath("//*[@name='email']")))
                .sendKeys("rex.welch@gmail.com")
                .sendKeys(Keys.TAB).sendKeys("enxujk10phu40vm")
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //8. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());
        //9. 'Çıkış' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()=' Logout']")).click();
        //10. Kullanıcının oturum açma sayfasına yönlendirildiğini doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed());
    }
}
