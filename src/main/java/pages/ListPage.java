package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;


public class ListPage extends PageBase{
    String inputFormClassName="search-box";
    String searchButtonClassName="search-icon";
    String addCartButtonClassName="add-to-bs";
    String priceClassName="prc-slg";
    List<WebElement> elements;
    WebElement chosenElement;
    String chosenElementLink;
    Random random;

    public ListPage(WebDriver driver) {
        super(driver);
    }
    public void searchKey(String key)
    {
        writeText(By.className(inputFormClassName),key);
        click(By.className(searchButtonClassName));
        System.out.println(driver.getCurrentUrl());

    }
    public void choseProduct()
    {
        int productCount=getElements(By.className("p-card-wrppr")).size();
        elements=getElements(By.className("p-card-wrppr"));
        random=new Random();
        chosenElement=elements.get(random.nextInt(productCount));
        chosenElementLink=chosenElement.getAttribute("a");
        driver.get(chosenElementLink);
    }
    public void addToChart(){
        

    }



}
