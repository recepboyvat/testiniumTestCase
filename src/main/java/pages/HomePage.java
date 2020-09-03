package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get("https://www.trendyol.com/");
    }
    public String linkControl(String button){
        click(By.id(button));
        return driver.getCurrentUrl();
    }
}
