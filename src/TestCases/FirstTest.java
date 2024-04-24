package TestCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTest extends Parameters {

	@BeforeTest
	public void MySetup() {

		driver.manage().window().maximize();
	}

	@Test()
	public void testlogin() throws InterruptedException {
		login();
	}

	@Test()
	public void testadd() throws InterruptedException {
		login();
		SpecificName("Fleece", "Light", "Onesie");
		logOut();
		
		login();
		SpecificName("Fleece", "Light");
	}

	@AfterTest
	public void post() {
	}

}
