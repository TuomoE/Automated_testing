package seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class etuovitesting {
    
    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        driver.manage().window().maximize();
        driver.get("http://www.etuovi.com");
        // haetaan asuntotyypiksi omakotitalo
        driver.findElement(By.cssSelector("#ddcl-input-subCategory > span")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#ddcl-input-subCategory-i1"))).click();
        // asetetaan sijainniksi Oulu
        driver.findElement(By.xpath("//*[@id=\"id8\"]")).sendKeys("Oulu");
        // asetetaan min hinnaksi 500 000
        driver.findElement(By.xpath("//*[@id=\"minPrice\"]")).sendKeys("500");
        // Painetaan hae nappia
        driver.findElement(By.cssSelector("#id25 > strong > span")).click();
        // listataan halvimmat ensin
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Halvimmat ensin')]"))).click();
        // haetaan toiseksi halvin
        WebElement a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='pos=2'][class='facts']")));
        // tulostetaan osoite
        String title = a.getAttribute("title");
        System.out.print(title);
        // suljetaan selainikkuna
        driver.close();
       }
}
