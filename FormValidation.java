@Test
public void testFormValidation() {
    WebElement signInButton = driver.findElement(By.className("login"));
    signInButton.click();

    WebElement emailCreateField = driver.findElement(By.id("email_create"));
    WebElement createAccountButton = driver.findElement(By.id("SubmitCreate"));

    emailCreateField.sendKeys("new_email@example.com");
    createAccountButton.click();

    WebElement firstNameField = driver.findElement(By.id("customer_firstname"));
    WebElement lastNameField = driver.findElement(By.id("customer_lastname"));
    WebElement passwordField = driver.findElement(By.id("passwd"));
    WebElement registerButton = driver.findElement(By.id("submitAccount"));

    firstNameField.sendKeys("");
    lastNameField.sendKeys("Doe");
    passwordField.sendKeys("password");
    registerButton.click();

    WebElement errorMessage = driver.findElement(By.cssSelector(".alert-danger"));
    Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed for missing required fields");
}
