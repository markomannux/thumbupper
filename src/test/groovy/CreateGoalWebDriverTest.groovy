import groovyx.gaelyk.spock.*
import com.google.appengine.api.datastore.*
import static com.google.appengine.api.datastore.FetchOptions.Builder.*

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.firefox.FirefoxDriver

class CreateGoalWebDriverTest extends GaelykUnitSpec {
    
    WebDriver driver
    
    def setup() {
        driver = new FirefoxDriver();
    }

    def "a new goal is created"() {
        given: "the initialised groovlet is invoked and data is persisted"

        when: "the datastore is queried for data"
        driver.get("http://localhost:8080");
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.name("action")).click();
        driver.findElement(By.linkText("Create Goal")).click();

        then: "the persisted data is found in the datastore"

    }

}
