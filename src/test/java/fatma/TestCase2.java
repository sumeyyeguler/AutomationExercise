package fatma;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
public class TestCase2 extends TestBase {
    @Test
    public void name() {
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");
        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']")).isDisplayed());
        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        //5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed());
        //6. Doğru e-posta adresini ve şifreyi girin
        Actions actions=new Actions(driver);
        Faker fkr=new Faker();
        actions.click(driver.findElement(By.xpath("//*[@name='email']")))
                .sendKeys("rex.welch@gmail.com")
                .sendKeys(Keys.TAB).sendKeys("enxujk10phu40vm")
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //7. 'Giriş' düğmesini tıklayın
        //8. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());
        //9. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();
        //10. 'HESAP SİLİNDİ!' görünür
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());
    }
}