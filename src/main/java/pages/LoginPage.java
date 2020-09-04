package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends PageBase{
    String mailInputId="fEmailx";
    String passwordInputId="LoginModel_Password";
    String loginButtonId="loginSubmitButton";

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.trendyol.com/login");

    }

    public boolean isLoginSuccess(String userEmail,String userPassword){
        writeText(By.id(mailInputId),userEmail);
        writeText(By.id(passwordInputId),userPassword);
        click(By.id(loginButtonId));
        if(driver.getCurrentUrl().contains("https://www.trendyol.com/")){
            return true;
        }
        else {
            return false;
        }
    }
}
