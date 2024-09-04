@Test
public void testUIElements() {
    WebElement searchBar = driver.findElement(By.id("search_query_top"));
    WebElement navigationMenu = driver.findElement(By.id("block_top_menu"));
    WebElement footer = driver.findElement(By.id("footer"));

    Assert.assertTrue(searchBar.isDisplayed(), "Search bar is not displayed");
    Assert.assertTrue(navigationMenu.isDisplayed(), "Navigation menu is not displayed");
    Assert.assertTrue(footer.isDisplayed(), "Footer is not displayed");
}
