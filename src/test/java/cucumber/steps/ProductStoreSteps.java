package cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
public class ProductStoreSteps {
    @Given("have more than {int} products in store")
    public void haveMoreThanProductsInStore(int productQuantity) {

    }

    @And("one of these products is a Notebook")
    public void oneOfTheseProductsIsANotebook() {

    }

    @Then("All products should be returned")
    public void allProductsShouldBeReturned() {

    }
}
