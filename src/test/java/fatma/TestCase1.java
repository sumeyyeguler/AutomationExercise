package fatma;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class TestCase1 extends TestBase {

    @Test
    public void name() {
        ////HELLÖ
        //    //1. Tarayıcıyı başlatın
        //    //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");
        //    //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertEquals("https://automationexercise.com/",driver.getCurrentUrl());
        //    //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        //    //5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed());
        //    //6. Adı ve e-posta adresini girin
        Faker fkr=new Faker();
        Actions actions=new Actions(driver);
        String email=fkr.internet().emailAddress();
        System.out.println(email);
        String password=fkr.internet().password();
        System.out.println(password);
        WebElement x=driver.findElement(By.xpath("//*[@type='text']"));

        actions.click(x).sendKeys(fkr.name().name()).sendKeys(Keys.TAB)
                .sendKeys(email).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //    //7. 'Kaydol' düğmesini tıklayın
        //    //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Enter Account Information']")).isDisplayed());
        //    //9. Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi

        actions.click(driver.findElement(By.xpath("(//input[@name='title'])[2]"))).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(password).sendKeys(Keys.TAB).sendKeys("1").sendKeys(Keys.TAB)
                .sendKeys("January").sendKeys(Keys.TAB).sendKeys("2020").perform();
        //    //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        driver.findElement(By.cssSelector("#newsletter")).click();
        //    //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        driver.findElement(By.cssSelector("#optin")).click();
        //    //12. Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        actions.sendKeys(Keys.TAB).sendKeys(fkr.name().firstName())
                .sendKeys(Keys.TAB).sendKeys(fkr.name().lastName())
                .sendKeys(Keys.TAB).sendKeys(fkr.company().bs())
                .sendKeys(Keys.TAB).sendKeys(fkr.address().fullAddress())
                .sendKeys(Keys.TAB).sendKeys(fkr.address().fullAddress())
                .sendKeys(Keys.TAB).sendKeys("Canada")
                .sendKeys(Keys.TAB).sendKeys(fkr.address().state())
                .sendKeys(Keys.TAB).sendKeys(fkr.address().city())
                .sendKeys(Keys.TAB).sendKeys(fkr.address().zipCode())
                .sendKeys(Keys.TAB).sendKeys(fkr.phoneNumber().phoneNumber())
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //    //13. 'Hesap Oluştur düğmesini' tıklayın
        //    //14. 'HESAP OLUŞTURULDU!' görünür
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Account Created!']")).isDisplayed());
        //    //15. 'Devam' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
        //    //16. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());
        //    //17. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[2]")).click();
        //    //18. 'HESAP SİLİNDİ!' görünür ve 'Devam' düğmesini tıklayın
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());
        driver.findElement(By.xpath("//button[@type='button']")).click();
    }
}
