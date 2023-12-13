import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static WebDriver driver = new FirefoxDriver();
    static Actions actions = new Actions(driver);

    public static void main(String[] args) throws InterruptedException {
        String username = "username";
        String password = "password";

        driver.get("https://humanbenchmark.com/");
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/a[2]")).click();
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/form/p[3]/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='/tests/chimp']")).click();


        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div[4]/div[1]/div/div[1]/div[2]/button")).click();

        int Number = 4;
        List<WebElement> buttonList = new ArrayList<>();


        while(Number < 41)
        {
            for(int i = 0; i < Number; i++)
            {
                buttonList.add(driver.findElement(By.xpath("//*[text()='" + (i+1) + "']")));
            }
            for(int j = 0; j < Number; j++)
            {
                actions.moveToElement(buttonList.get(j)).click().perform();
            }
            buttonList.clear();
            if(Number < 40) {
                driver.findElement(By.xpath("//*[text()='Continue']")).click();
            }
            System.out.println(Number);
            Number++;

        }
    }
}