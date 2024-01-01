package Pom;


import lombok.Data;
import org.openqa.selenium.By;
@Data
public class LoginPom {


    private LoginPom(){

    }

    private static LoginPom Instance;

    public static LoginPom getInstance(){
        if (Instance == null){
            Instance = new LoginPom();
            return Instance;
        }
        return Instance;
    }






    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By loginError = By.cssSelector("[data-test = 'error']");
    private final By homepageLogo = By.className("app_logo");


}
