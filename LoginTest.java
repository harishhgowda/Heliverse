@Test
public void testLogin() {
    WebElement signInButton = driver.findElement(By.className("login"));
    signInButton.click();

    WebElement emailField = driver.findElement(By.id("email"));
    WebElement passwordField = driver.findElement(By.id("passwd"));
    WebElement submitButton = driver.findElement(By.id("SubmitLogin"));

    emailField.sendKeys("valid_email@example.com");
    passwordField.sendKeys("valid_password");
    submitButton.click();

    WebElement accountPage = driver.findElement(By.className("account"));
    Assert.assertTrue(accountPage.isDisplayed(), "Login failed with valid credentials");


    // Test invalid credentials
    emailField.clear();
    passwordField.clear();
    emailField.sendKeys("invalid_email@example.com");
    passwordField.sendKeys("invalid_password");
    submitButton.click();

    WebElement errorMessage = driver.findElement(By.cssSelector(".alert-danger"));
    Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed for invalid credentials");
}
