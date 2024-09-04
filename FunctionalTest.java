import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FunctionalTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
    }

    @Test
    public void testAddToCart() {
        WebElement searchBox = driver.findElement(By.id("search_query_top"));
        searchBox.sendKeys("dress");
        searchBox.submit();

        WebElement product = driver.findElement(By.cssSelector(".product_img_link"));
        product.click();

        WebElement addToCartButton = driver.findElement(By.id("add_to_cart"));
        addToCartButton.click();

        WebElement proceedToCheckoutButton = driver.findElement(By.cssSelector(".button-medium[title='Proceed to checkout']"));
        proceedToCheckoutButton.click();

        WebElement cartSummary = driver.findElement(By.id("cart_summary"));
        Assert.assertTrue(cartSummary.isDisplayed(), "Cart summary is not displayed");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
