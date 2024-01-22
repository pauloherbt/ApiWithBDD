package cucumber.steps;

import com.demobdd.controllers.ProductController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@CucumberContextConfiguration
public class ProductStoreSteps {
    private ProductController productController = new ProductController();
    @Given("have more than {int} products in store")
    public void haveMoreThanProductsInStore(int productQuantity) {
        assertTrue(productController.findAll().size()>productQuantity,"have more than {int} products in store");
    }
    @And("one of these products is a {string}")
    public void oneOfTheseProductsIsA(String product) {
        assertTrue(productController.findAll().contains(product),"one of these products is a {string}");
    }
    @Then("All products should be returned")
    public void allProductsShouldBeReturned() {
        assertFalse(productController.findAll().isEmpty(),"All products should be returned");
    }
    @Then("one product should be returned")
    public void oneProductShouldBeReturned() {
        String productName = "CellPhone";
        assertEquals(productController.findByName(productName), productName, "one product should be returned");
    }
    @And("none of these products is a {string}")
    public void noneOfTheseProductsIsA(String arg) {
        assertFalse(productController.findAll().contains(arg),"none of these products is a {string}");
    }
    @Then("should be throw an error")
    public void shouldBeThrowAnError() {
        assertThrows(NoSuchElementException.class,()->productController.findByName("NonExistentProduct"),"should be throw a error");
    }


}
