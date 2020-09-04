import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ListPage;
import pages.LoginPage;

import java.io.File;

public class Main {
    protected static String ChromePath = "C:\\chromedriver.exe";

    protected static ChromeDriverService service;

    protected static WebDriver driver;
    @Test
    public static void main() throws InterruptedException {
        service = new ChromeDriverService.Builder().usingDriverExecutable(new File(ChromePath)).
                usingAnyFreePort().build();
        try {
            service.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.setProperty("webdriver.chrome.driver", ChromePath);
        driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
        driver.manage().window().maximize();

        HomePage homePage=new HomePage(driver);
        if(driver.getCurrentUrl().equals("https://www.trendyol.com/"))
        {
            System.out.println("Anasayfaya giris basarili");
        }
        else{
            System.out.println("Anasayfaya gidilemedi");
        }
        LoginPage loginPage=new LoginPage(driver);
        if(loginPage.isLoginSuccess("rcpbyvt@gmail.com","Rcpbyvt16."))
        {
            System.out.println("Giris basarili");
        }
        else{
            System.out.println("Giris basarisiz");
        }
        ListPage listPage=new ListPage(driver);
        listPage.searchAndGo("bilgisayar");
        System.out.println("Bilgisayar kelimesi aratildi");
        Thread.sleep(3000);
        listPage.choseProduct();
        System.out.println("Urun secildi");
        String firstPrice=listPage.firstPrice();
        listPage.addToChart();
        Thread.sleep(3000);
        System.out.println("Urun Sepete Eklendi");
        if(listPage.IsPricesEqual(firstPrice)){
            System.out.println("Fiyatlar karsilastirildi.Esitler");
        }
        else{
            System.out.println("Fiyatlar karsilastirildi.Farklilar");
        }

        CartPage cartPage=new CartPage(driver);
        int firstOrderCount=cartPage.orderCount();
        cartPage.addToCartAgain();
        Thread.sleep(3000);
        if(cartPage.IsIncreaseOrderCount(firstOrderCount))
        {
            System.out.println("Ürün arttirimi basarili");
        }
        else{
            System.out.println("Urun arttirimi basarisiz");
        }
        Thread.sleep(3000);
        cartPage.deleteProducts();
        System.out.println("Urunler silindi");
        System.out.println("Test bitti");
    }

    }

