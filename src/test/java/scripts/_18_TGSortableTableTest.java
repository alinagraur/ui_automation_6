package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TableHandler;
import utils.Waiter;

import java.util.ArrayList;
import java.util.List;

public class _18_TGSortableTableTest extends Base {

    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-18")).click();
    }

    /**
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Sortable Tables" card
     * Click on the Quantity sort button to toggle Ascending Order
     * Verify that the Quantity column of the table is sorted in ascending order
     */
    @Test
    public void validateSortAscByQuantity() {
        WebElement ascByQuantity = driver.findElement(By.id("quantity_asc"));
        ascByQuantity.click();

        List<WebElement> quantityColumnElements = TableHandler.getTableColumn(1);
        List<Integer> quantityColumn = new ArrayList<>();

        for (WebElement element : quantityColumnElements) {
            quantityColumn.add(Integer.parseInt(element.getText()));
        }

        Waiter.pause(2);

        for (int i = 1; i < quantityColumn.size(); i++) {
            Assert.assertTrue(quantityColumn.get(i) >= quantityColumn.get(i - 1));
        }
    }

               /*
               TEST CASE 2
           Go to https://techglobal-training.com/frontend/
           Click on the "Sortable Tables" card
           Click on the Quantity sort button to toggle descending order
           Verify that the Quantity column of the table is sorted in descending order

           TEST CASE 3
           Go to https://techglobal-training.com/frontend/
           Click on the "Sortable Tables" card
           Click on the Price sort button to toggle Ascending Order
           Verify that the Price column of the table is sorted in ascending order

           TEST CASE 4
           Go to https://techglobal-training.com/frontend/
           Click on the "Sortable Tables" card
           Click on the Price Sort button to toggle descending order
           Verify that the Price column of the table is sorted in descending order
                */

    @Test
    public void validateSortDescByQuantity() {
       WebElement descByQuantity = driver.findElement(By.id("quantity_desc"));
       descByQuantity.click();

        List<WebElement> quantityColumnElements = TableHandler.getTableColumn(1);
        List<Integer> quantityColumn = new ArrayList<>();

        for (WebElement element : quantityColumnElements) {
            quantityColumn.add(Integer.parseInt(element.getText()));
        }

        Waiter.pause(2);

        for (int i = 1; i < quantityColumn.size(); i++) {
            Assert.assertTrue(quantityColumn.get(i) <= quantityColumn.get(i - 1));
        }

    }

    @Test
    public void validateSortAscByPrice() {
       WebElement ascByPrice = driver.findElement(By.id("price_asc"));
       ascByPrice.click();

        List<WebElement> priceColumnElements = TableHandler.getTableColumn(3);
        List<Integer> priceColumn = new ArrayList<>();

        for (WebElement element : priceColumnElements) {
            priceColumn.add(Integer.parseInt(element.getText()));
        }

        Waiter.pause(2);

        for (int i = 1; i < priceColumn.size(); i++) {
            Assert.assertTrue(priceColumn.get(i) >= priceColumn.get(i - 1));
        }

    }@Test
    public void validateSortDescByPrice() {
       WebElement ascByPrice = driver.findElement(By.id("price_desc"));
       ascByPrice.click();

        List<WebElement> priceColumnElements = TableHandler.getTableColumn(3);
        List<Integer> priceColumn = new ArrayList<>();

        for (WebElement element : priceColumnElements) {
            priceColumn.add(Integer.parseInt(element.getText()));
        }

        Waiter.pause(2);

        for (int i = 1; i < priceColumn.size(); i++) {
            Assert.assertTrue(priceColumn.get(i) <= priceColumn.get(i - 1));
        }

    }


}