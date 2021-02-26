package PageTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import Pages.DemoRegistration;

public class DemoRegistrationTest extends BaseTest {
	 //WebDriver driver=null;
	@Test
	public void TestRegistration() {
		DemoRegistration registration = new DemoRegistration(driver);

		registration.clickaccountBy();
		registration.clickregisterBy();
		registration.setfirstnameBy(data.getProperty("firstname"));
		registration.setmiddlenameBy(data.getProperty("middlename"));
		registration.setlastnameBy(data.getProperty("lastname"));
		registration.setemailidBy(data.getProperty("emailid"));
		registration.setpasswordBy(data.getProperty("password"));
		registration.setconfirmpasswordBy(data.getProperty("password"));
		registration.setregistrationBy();

		Assert.assertEquals(registration.assertcheckBy(), "Hello, sai I srikar!");
	}
}
