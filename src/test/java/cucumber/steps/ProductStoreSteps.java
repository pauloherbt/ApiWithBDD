package cucumber.steps;

import cucumber.SpringIntegrationTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductStoreSteps extends SpringIntegrationTest {
    @Given("have more than {int} products in store")
    public void haveMoreThanProductsInStore(int productQuantity) {
        assertTrue(productController.findAll().size()>productQuantity,"have more than {int} products in store");
    }
    @And("one of these products is a {string}")
    public void oneOfTheseProductsIsA(String product) {
        assertTrue(productExists(product),"one of these products is a {string}");
    }
    @Then("All products should be returned")
    public void allProductsShouldBeReturned() {
        assertFalse(productController.findAll().isEmpty(),"All products should be returned");
    }


}
