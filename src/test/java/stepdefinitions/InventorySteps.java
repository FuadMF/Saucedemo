package stepdefinitions;

import Pom.InventoryPom;
import Pom.LoginPom;
import enums.ExpectedConditionType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InventorySteps extends BaseMethods{
InventoryPom inventoryPom;



public InventorySteps(){
    inventoryPom = InventoryPom.getInstance();
}


String inventoryItemName;

//Case1

    @And("Click to add to card button for {int} elements")
    public void clickToAddToCardButtonForElements(int arg0) {
        List<WebElement>elements = getElements(inventoryPom.getAddCartBtn());
        int expected = 4;
        for (int i = 0;i<expected;i++){
            elements.get(i).click();
        }
    }

    @Then("Basket number should be matched with added elements")
    public void basketNumberShouldBeMatchedWithAddedElements() {
         WebElement element = getElement(inventoryPom.getShopCartNum());
         String s = element.getText();
         int actual = Integer.parseInt(s);
         int expected = 4;
        Assert.assertEquals(actual,expected);

    }
//Case2
    @And("Click remove button for two of them")
    public void clickRemoveButtonForTwoOfThem() {
         List<WebElement>elements = getElements(inventoryPom.getRemoveBtn());
         int k = 2;
         for (int i = 0;i<k;i++){
             elements.get(i).click();
         }
    }

    @Then("Basket number should be decreased")
    public void basketNumberShouldBeDecreased() {
         int expected = 4-2;
         WebElement element = getElement(inventoryPom.getShopCartNum());
         String s = element.getText();
         int actual = Integer.parseInt(s);
         Assert.assertEquals(actual,expected);
    }
//Case3 bu case de break yazmasan error verir.sebebi nedir?
    @And("Click to selected product name for seeing its about page")
    public void clickToSelectedProductNameForSeeingItsAboutPage() {
        List<WebElement>elements =  getElements(inventoryPom.getInventoryItemName());
        for (WebElement element:elements){
           if (element.getText().contains("Sauce Labs Backpack")){
               element.click();
               break;
           }
        }
    }

    @Then("Product’s details page should be displayed")
    public void productSDetailsPageShouldBeDisplayed() {
         String expected = "Sauce Labs Backpack";
         WebElement element = getElement(inventoryPom.getInvenDetailName());
         String actual = element.getText();
         Assert.assertEquals(actual,expected);
    }

//Case4
    @And("User clicks add to the card button for any item")
    public void userClicksAddToTheCardButtonForAnyItem() {
        List<WebElement>addToCartBtn = getElements(inventoryPom.getAddCartBtn());
        List<WebElement>textList = getElements(inventoryPom.getInventoryItemName());
        int randomNum = generateRanNum(addToCartBtn.size());
        addToCartBtn.get(randomNum).click();
        inventoryItemName = textList.get(randomNum).getText();

    }

    @And("Clicks to basket button")
    public void clicksToBasketButton() {
         getElement(inventoryPom.getBasketBtn()).click();
    }

    @Then("User should see that item in the basket")
    public void userShouldSeeThatItemInTheBasket() {
        String actualText = getElement(inventoryPom.getInventoryItemName()).getText();
        Assert.assertEquals(actualText,inventoryItemName);
    }
//Case5
    @And("Clicks menu button")
    public void clicksMenuButton() {
         getElement(inventoryPom.getMenuBtn()).click();
    }

    @And("Clicks logout btn")
    public void clicksLogoutBtn() {
         explicitWait(inventoryPom.getLogoutBtn(), ExpectedConditionType.VISIBLE,10);
         getElement(inventoryPom.getLogoutBtn()).click();
    }
//Case6
    @And("Clicks to delete button")
    public void clicksToDeleteButton() {
         getElement(inventoryPom.getRemoveBtn()).click();
    }

    @Then("Item in the basket should be deleted")
    public void itemInTheBasketShouldBeDeleted() {
         List<WebElement>elements = getElements(inventoryPom.getInventoryItemName());
         Assert.assertTrue(elements.isEmpty());
    }

//Case7
    @Then("User should be navigated to login page")
    public void userShouldBeNavigatedToLoginPage() {
         WebElement element = getElement(inventoryPom.getLoginLogo());
         Assert.assertTrue(element.isDisplayed());
    }
//Case8
    @And("Click reset app state button")
    public void clickResetAppStateButton() {
         explicitWait(inventoryPom.getResetAppBtn(),ExpectedConditionType.VISIBLE,3);
         getElement(inventoryPom.getResetAppBtn()).click();
    }

    @Then("App state should be resetted")
    public void appStateShouldBeResetted() {
         List<WebElement>elements = getElements(inventoryPom.getShopCartNum());
         Assert.assertTrue(elements.isEmpty());
         List<WebElement>removes = getElements(inventoryPom.getRemoveBtn());
         Assert.assertTrue(removes.isEmpty());
    }
//Case9
    @And("Clicks to checkout button")
    public void clicksToCheckoutButton() {
         getElement(inventoryPom.getCheckoutBtn()).click();
    }


    @And("Clicks continue button")
    public void clicksContinueButton() {
         getElement(inventoryPom.getContinueBtn()).click();
    }

    @And("Clicks finish button")
    public void clicksFinishButton() {
         getElement(inventoryPom.getFinishBtn()).click();
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
         String expectedText = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
         WebElement element = getElement(inventoryPom.getCompleteText());
         String actualText = element.getText();
         Assert.assertEquals(actualText,expectedText);
    }
//Case10
    @And("User Click A - to Z filter")
    public void userClickAToZFilter() {
        WebElement element = getElement(inventoryPom.getProductSortCont());
        Select selection = new Select(element);
        selection.selectByValue("az");

    }

    @Then("Items should be ordered as a to z")
    public void itemsShouldBeOrderedAsAToZ() {
         List<WebElement>elements = getElements(inventoryPom.getInventoryItemName());
         List<String>texts = new ArrayList<>();
         for (WebElement element:elements){
             String elementText = element.getText();
             texts.add(elementText);
         }
         List<String>sortedText = new ArrayList<>();
         sortedText.addAll(texts);
        Collections.sort(sortedText);
        Assert.assertTrue(texts.equals(sortedText));
    }
//Case11
    @And("User Click Z - to A filter")
    public void userClickZToAFilter() {
        WebElement element = getElement(inventoryPom.getProductSortCont());
        Select selection = new Select(element);
        selection.selectByValue("za");
    }

    @Then("Items should be ordered as z to a")
    public void itemsShouldBeOrderedAsZToA() {
        List<WebElement>elements = getElements(inventoryPom.getInventoryItemName());
        List<String>texts = new ArrayList<>();
        for (WebElement element:elements){
            String elementText = element.getText();
            texts.add(elementText);
        }
        List<String>sortedText = new ArrayList<>();
        sortedText.addAll(texts);
        sortedText.sort(Comparator.reverseOrder());
        Assert.assertTrue(texts.equals(sortedText));
    }

//Case12
    @And("User Click low to high filter")
    public void userClickLowToHighFilter() {
        WebElement element = getElement(inventoryPom.getProductSortCont());
        Select selection = new Select(element);
        selection.selectByValue("lohi");
    }

    @Then("Items should be ordered as low to high price")
    public void itemsShouldBeOrderedAsLowToHighPrice() {
        List<WebElement>elements = getElements(inventoryPom.getInventoryItemPrice());
        List<Double>itemPrice = new ArrayList<>();
        for (WebElement element1:elements){
            String elementText = element1.getText().substring(1);
            double d = Double.valueOf(elementText);
            itemPrice.add(d);
        }
        List<Double>sortedItem = new ArrayList<>();
        sortedItem.addAll(itemPrice);
        Collections.sort(sortedItem);
        Assert.assertTrue(itemPrice.equals(sortedItem));
    }

//Case13
    @And("User Click high to low filter")
    public void userClickHighToLowFilter() {
        WebElement element = getElement(inventoryPom.getProductSortCont());
        Select selection = new Select(element);
        selection.selectByValue("hilo");
    }

    @Then("Items should be ordered as high to low price")
    public void itemsShouldBeOrderedAsHighToLowPrice() {
         List<WebElement> elements = getElements(inventoryPom.getInventoryItemPrice());
         List<Double>itemPrice = new ArrayList<>();
         for (WebElement element:elements){
             String elementText = element.getText().substring(1);
             double d = Double.parseDouble(elementText);
             itemPrice.add(d);
         }
         List<Double>sortedItem = new ArrayList<>();
         sortedItem.addAll(itemPrice);
         sortedItem.sort(Comparator.reverseOrder());
         Assert.assertTrue(itemPrice.equals(sortedItem));
    }
}
