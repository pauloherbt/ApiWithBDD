package cucumber.steps;

import cucumber.SpringIntegrationTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.BeforeEach;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ProductStoreExceptionSteps extends SpringIntegrationTest {
    private Exception exception;
    private String retrievedProduct;
    private String existingProduct = "CellPhone";
    @BeforeEach
    void setup(){
        exception=null;
        retrievedProduct=null;
    }
    @And("the product with name {string} doesnt exist")
    public void theProductWithNameDoesntExist(String arg0) {
        assertFalse(productExists(arg0),"the product with name " +arg0 + " doesnt exist");
    }

    @When("trying to get product with name {string}")
    public void tryingToGetTheProductWithName(String arg0) {
        try{
            retrievedProduct = productController.findByName(arg0);
        } catch (Exception e) {
            exception = e;
        }
    }
    @Then("one product should be returned")
    public void oneProductShouldBeReturnedSuccessfully() {
        assertNotNull("one product should be returned",retrievedProduct);
        assertEquals(retrievedProduct, existingProduct, "Expected the correct product");
        assertNull(exception);
    }
    @Then("should be thrown an exception")
    public void shouldBeThrownAnException() {
        assertInstanceOf(NoSuchElementException.class, exception, "should be thrown an exception");
        assertNull(retrievedProduct,"should not retrieve a product");
    }
}
