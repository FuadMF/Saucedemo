package Pom;

import lombok.Data;
import org.openqa.selenium.By;
import stepdefinitions.BaseMethods;

@Data
public class YourInformationPom {
    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By postalCodeInput = By.id("postal-code");
    private final By pageTitle = By.className("title");
    private final By errorMessage = By.cssSelector("[data-test = error]");

    private YourInformationPom(){

    }

    private static YourInformationPom Instance;

    public static YourInformationPom getInstance(){
        if (Instance == null){
            Instance = new YourInformationPom();
            return Instance;
        }else {
            return Instance;
        }
    }

}
