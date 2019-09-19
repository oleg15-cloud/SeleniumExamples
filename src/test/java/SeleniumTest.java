import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class SeleniumTest {
    private WebDriver driver;
    private String url;
    String word = "fight1";
    String phone = "666777888";
    @Before
    public void beforeMethod() {
        driver = new ChromeDriver();
        url = "http://37.59.228.229:3000/";

    }
    @Test
    public void testMethod() {
        driver.get(url);
        driver.findElement(By.cssSelector("i.mdi-content-add")).click();
        driver.findElement(By.cssSelector("div.main-content input#icon_prefix")).clear();
        driver.findElement(By.cssSelector("div.main-content input#icon_prefix")).sendKeys(word);
        driver.findElement(By.cssSelector("div.main-content input#icon_telephone")).clear();
        driver.findElement(By.cssSelector("div.main-content input#icon_telephone")).sendKeys(phone);
        driver.findElement(By.cssSelector("div.main-content a.save-btn")).click();
        driver.get(url);
        List<WebElement> elements = driver.findElements(By.cssSelector("div.list ul li"));
        for (WebElement el:elements) {
            Assert.assertTrue(el.getText().toLowerCase().contains(word.toLowerCase()));

        }


    }
    @After
    public void afterMethod() {
        driver.quit();
    }

}
