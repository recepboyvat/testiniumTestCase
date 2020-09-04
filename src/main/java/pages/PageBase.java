package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import org.openqa.selenium.Keys;

public abstract class PageBase {

    public WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }
    public void click(By element){
        driver.findElement(element).click();
    }

    public void writeText(By element,String text){
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(text);
    }
    public void writeTextandGo(By element,String text){
        driver.findElement(element).sendKeys(text);
        driver.findElement(element).sendKeys(Keys.ENTER);
    }

    public String readText(By element){
        return driver.findElement(element).getText();
    }
    public List<WebElement> getElements(By element){
        return driver.findElements(element);
    }
    public WebElement getElement(By element){
        return driver.findElement(element);
    }
}
