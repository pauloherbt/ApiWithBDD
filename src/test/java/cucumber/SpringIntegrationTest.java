package cucumber;

import com.demobdd.DemoBddApplication;
import com.demobdd.controllers.ProductController;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = DemoBddApplication.class)
public class SpringIntegrationTest {
    public ProductController productController = new ProductController();
    public boolean productExists(String name){
        return productController.findAll().contains(name);
    }
}
