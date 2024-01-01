package Pom;

import lombok.Data;
import org.openqa.selenium.By;
@Data
public final class InventoryPom {
    private final By addCartBtn = By.className("btn_inventory");
    private final By shopCartNum = By.className("shopping_cart_badge");
    private final By removeBtn = By.className("btn_secondary");
    private final By inventoryItemName = By.className("inventory_item_name");
    private final By invenDetailName = By.className("inventory_details_name");
    private final By basketBtn = By.className("shopping_cart_link");
    private final By menuBtn = By.id("react-burger-menu-btn");
    private final By logoutBtn = By.id("logout_sidebar_link");
    private final By loginLogo = By.className("login_logo");
    private final By resetAppBtn = By.id("reset_sidebar_link");
    private final By checkoutBtn = By.id("checkout");
    private final By continueBtn = By.id("continue");
    private final By finishBtn = By.id("finish");
    private final By completeText = By.className("complete-text");
    private final By productSortCont = By.className("product_sort_container");
    private final By inventoryItemPrice = By.className("inventory_item_price");



    private InventoryPom(){

    }

    private static InventoryPom Instance;

    public static InventoryPom getInstance(){
        if (Instance == null){
            Instance = new InventoryPom();
            return Instance;
        }else {
            return Instance;
        }
    }

}
