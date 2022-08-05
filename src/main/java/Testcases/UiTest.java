//package Testcases;
//
//import java.util.regex.Pattern;
//import java.util.concurrent.TimeUnit;
//import org.testng.annotations.*;
//import static org.testng.Assert.*;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//
//public class UiTest {
//  private WebDriver driver;
//  private String baseUrl;
//  private boolean acceptNextAlert = true;
//  private StringBuffer verificationErrors = new StringBuffer();
//
//  @BeforeClass(alwaysRun = true)
//  public void setUp() throws Exception {
//	System.setProperty("webdriver.chrome.driver","C:\\Users\\UNITS\\Documents\\BitBucket\\chromedriver\\chromedriver.exe");
//	driver = new ChromeDriver();
//    baseUrl = "https://www.blazedemo.com/";
//    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//  }
//
//  @Test
//  public void testUi() throws Exception {
//    // Label: Test
//    // ERROR: Caught exception [ERROR: Unsupported command [resizeWindow | 1366,625 | ]]
//    driver.get(baseUrl + "chrome://newtab/");
//    driver.get("https://storefront:Frantic98@development.rockdevelop.com/");
//    driver.findElement(By.xpath("//span[text()='No']")).click();
//    driver.findElement(By.cssSelector("a.user-account.not-logged-in > span")).click();
//    driver.findElement(By.id("dwfrm_login_username_d0nqtvwwnffl")).click();
//    driver.findElement(By.id("secondary")).click();
//    driver.findElement(By.xpath("//div[@id='main']/div[3]")).click();
//    driver.findElement(By.name("dwfrm_login_login")).click();
//    driver.findElement(By.cssSelector("button.search-toggle > span")).click();
//    driver.findElement(By.id("q")).clear();
//    driver.findElement(By.id("q")).sendKeys("book");
//    driver.findElement(By.cssSelector("img[alt=\"Lyric Book - 3rd Edition, , hi-res\"]")).click();
//    driver.findElement(By.id("add-to-cart")).click();
//    driver.findElement(By.cssSelector("a.button.mini-cart-link-view-cart.button--cta")).click();
//  }
//
//  @AfterClass(alwaysRun = true)
//  public void tearDown() throws Exception {
//    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
//  }
//
//  private boolean isElementPresent(By by) {
//    try {
//      driver.findElement(by);
//      return true;
//    } catch (NoSuchElementException e) {
//      return false;
//    }
//  }
//
//  private boolean isAlertPresent() {
//    try {
//      driver.switchTo().alert();
//      return true;
//    } catch (NoAlertPresentException e) {
//      return false;
//    }
//  }
//
//  private String closeAlertAndGetItsText() {
//    try {
//      Alert alert = driver.switchTo().alert();
//      String alertText = alert.getText();
//      if (acceptNextAlert) {
//        alert.accept();
//      } else {
//        alert.dismiss();
//      }
//      return alertText;
//    } finally {
//      acceptNextAlert = true;
//    }
//  }
//}
