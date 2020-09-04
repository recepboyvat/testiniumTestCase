package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;


public class ListPage extends PageBase{
    String inputFormClassName="search-box";
    String searchButtonClassName="search-icon";
    String elementsClassName="p-card-chldrn-cntnr";
    String addCartButtonClassName="add-to-bs";
    String priceClassName="prc-slg";
    String addToCartXpath="//*[@id=\"product-detail-app\"]/div/div[2]/div[2]/div[2]/div[1]/button[1]";
    List<WebElement> elements;
    WebElement chosenElement;
    String chosenElementLink;
    Random random;


    public ListPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.trendyol.com/");
    }
    public void searchKey(String key)
    {
        writeText(By.className(inputFormClassName),key);
        click(By.className(searchButtonClassName));
        //    System.out.println(driver.getCurrentUrl());

    }
    public void searchAndGo(String key){

        writeTextandGo(By.className(inputFormClassName),key);
    }

    public void choseProduct()
    {
        int productCount=getElements(By.className(elementsClassName)).size();
        elements=getElements(By.className(elementsClassName));
    /*    for(int i=0;i<elements.size();i++){
            System.out.println(elements.get(i));
        }
            */
        random=new Random();
        System.out.println("Random sayi"+String.valueOf(random.nextInt(productCount)));
        chosenElement=elements.get(random.nextInt(productCount));

        System.out.println("Chosen element:"+chosenElement);
        WebElement linkelement=chosenElement.findElement(By.xpath("//*[@id=\"search-app\"]/div/div/div[2]/div[2]/div/div[1]/div[1]/a"));
        System.out.println("href:"+linkelement.getAttribute("href"));
        driver.get(linkelement.getAttribute("href"));
    }
    public String firstPrice()
    {
        String price=getElement(By.className("prc-slg")).getText().replaceAll("\\s", "");
        price=price.replaceAll("TL","");
        System.out.println("First Price:"+price);
        return price;
    }
    public boolean IsPricesEqual(String firstPrice)
    {
        String basketPrice=getElement(By.className("total-price")).getText().replaceAll("\\s", "");
        basketPrice=basketPrice.replaceAll("TL", "");
        System.out.println("Basket Price:"+basketPrice);
        if(basketPrice.equals(firstPrice))
        {

            return true;
        }
        else{

            return false;
        }
    }
    public void addToChart(){

        click(By.xpath(addToCartXpath));
        driver.get("https://www.trendyol.com/sepetim#/basket");
    }





}
