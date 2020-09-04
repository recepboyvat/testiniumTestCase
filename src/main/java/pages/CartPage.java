package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends PageBase{
    String addCartBtnxPath="//*[@id=\"partial-basket\"]/div/div[2]/div[2]/div[3]/div[1]/div/button[2]";
    String increaseXpath="//*[@id=\"partial-basket\"]/div/div[2]/div[2]/div[3]/button";
    public CartPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.trendyol.com/sepetim#/basket");
    }
    public int orderCount()
    {
        return Integer.parseInt(getElement(By.className("counter-content")).getAttribute("value"));

    }
    public void addToCartAgain()
    {
        click(By.xpath(addCartBtnxPath));
    }
    public boolean IsIncreaseOrderCount(int oldCount)
    {
        int newOrderCount=Integer.parseInt(getElement(By.className("counter-content")).getAttribute("value"));
        if((oldCount-1)==newOrderCount)
        {
            return true;
        }
        else{
            return false;
        }
    }

    public void deleteProducts()
    {
        click(By.xpath(increaseXpath));
        click(By.className("btn-remove"));
    }


}
