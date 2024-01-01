import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
     features = {"classpath:features"}





)


public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void beforeClass(){
        System.out.println("Test Basladi");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Test Bitdi");
    }
}
