package stepdefinitions;

import driverSession.CucumberHook;
import enums.ExpectedConditionType;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseMethods {

    WebDriverWait wait;
    public WebDriver driver = CucumberHook.driver;



    protected int generateRanNum(int size){
        return (int) (Math.random()*size);
    }

    protected void explicitWait(By locator, ExpectedConditionType conditionType,int time){
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        switch(conditionType){
            case VISIBLE :{
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                break;
            }
            case INVISIBLE:{
                wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
                break;
            }
            case PRESENCE:{
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                break;
            }
            case CLICKABLE:{
                wait.until(ExpectedConditions.elementToBeClickable(locator));
                break;
            }
            default: throw new  IllegalArgumentException("wrong condition type");
        }
    }

    protected WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    protected List<WebElement> getElements(By locator){
        return driver.findElements(locator);
    }

    protected WebElement searchInsideDiv(By locator,String text){
        List<WebElement> elements = getElements(locator);
        for (WebElement element:elements){
            if (element.getText().contains(text)){
                return element;
            }
        }
        return null;
    }



}
