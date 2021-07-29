package Testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class Cartpage_TNG {
  @Test(dataProvider = "")
  public void cart_productDetail(String d, String s) {
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] cartpage() {
    return new Object[][] {{  }, {  },
    };
  }
}
