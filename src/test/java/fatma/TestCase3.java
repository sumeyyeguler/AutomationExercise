package fatma;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase3 extends TestBase {
    @Test
    public void name() {
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");
        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']")).isDisplayed());
        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        //5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed());
        //6. Yanlış e-posta adresi ve şifre girin
        //7. 'Giriş' düğmesini tıklayın
        Actions actions=new Actions(driver);
        Faker fkr=new Faker();
        actions.click(driver.findElement(By.xpath("//*[@name='email']")))
                .sendKeys(fkr.internet().emailAddress())
                .sendKeys(Keys.TAB).sendKeys(fkr.internet().password())
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //8. 'E-postanız veya şifreniz yanlış!' hatasını doğrulayın. görünür
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']")).isDisplayed());
    }
}
