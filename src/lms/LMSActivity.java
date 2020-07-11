package lms;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class LMSActivity {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {

		//Initializing the firefox driver
		driver = new FirefoxDriver();
		//Launching the OrangHRM application
		driver.get("https://alchemy.hguy.co/lms");
		driver.manage().window().maximize();

	}

	@Test
	public void TestCase1() {

		System.out.println("Activity1 : Verify the website title ");
		//Get the page title
		String pagetitle="Alchemy LMS – An LMS Application";

		String actualTitle=driver.getTitle();
		System.out.println("actualTitle: "+actualTitle);

		Assert.assertEquals(pagetitle, actualTitle);
		
		Reporter.log("Website Title is verified");
	}

	@Test
	public void TestCase2() {

		System.out.println("Activity2 : Verify the website heading ");
		//Get the page title
		String pageHeader="Learn from Industry Experts";

		String actualHeader=driver.findElement(By.xpath("//h1[@class='uagb-ifb-title']")).getText();
		System.out.println("actualHeader: "+actualHeader);

		Assert.assertEquals(pageHeader, actualHeader);
		
		Reporter.log("Verified the website heading");
	}

	@Test
	public void TestCase3() {

		System.out.println("Activity3 : Verify the title of the first info box");
		//Get the page title
		String firstInfobox="Actionable Training";

		String actualInfoBox=driver.findElement(By.xpath("//h3[@class='uagb-ifb-title']")).getText();
		System.out.println("actualInfoBox: "+actualInfoBox);

		Assert.assertEquals(firstInfobox, actualInfoBox);
		Reporter.log("Verified the title of the first info box");
	}


	@Test
	public void TestCase4() {


		System.out.println("Activity4 : Verify the title of the second most popular course");

		//Get the page title
		String popularcourse="Email Marketing Strategies";

		String actualpopularcourse=driver.findElement(By.xpath("//h3[text()='Email Marketing Strategies']")).getText();
		System.out.println("actualpopularcourse: "+actualpopularcourse);

		Assert.assertEquals(popularcourse, actualpopularcourse);
		Reporter.log("Verified the title of the second most popular course");

	}

	@Test
	public void TestCase5() {


		try {
			System.out.println("Activity5 : Navigate to the “My Account” page on the site");

			//click on My Account link
			driver.findElement(By.linkText("My Account")).click();
			Thread.sleep(5000);
			String accountPage = driver.findElement(By.xpath("//h1[@class='uagb-ifb-title']")).getText();
			//Get the page title
			String pagetitleforAccountPage="My Account";
			System.out.println("accountPage: "+accountPage);

			Assert.assertEquals(pagetitleforAccountPage, accountPage);
			Reporter.log("Navigated to the “My Account” page on the site");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void TestCase6() {


		try {
			System.out.println("Activity6 : Open the website and log-in using the provided credentials");

			//click on My Account link
			driver.findElement(By.linkText("My Account")).click();
			Thread.sleep(5000);
			String accountPage = driver.findElement(By.xpath("//h1[@class='uagb-ifb-title']")).getText();
			//Get the page title
			String pagetitleforAccountPage="My Account";
			System.out.println("accountPage: "+accountPage);

			Assert.assertEquals(pagetitleforAccountPage, accountPage);
			System.out.println(" We are in Account Page");

			//click on logn button
			driver.findElement(By.xpath("//a[text()='Login']")).click();
			Thread.sleep(3000);
			//entering the username
			driver.findElement(By.id("user_login")).sendKeys("root");
			//entering the password
			driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
			//click on login button
			driver.findElement(By.id("wp-submit")).click();
			Thread.sleep(5000);
			String displayName = "root";
			String actualdisplayeName = driver.findElement(By.xpath("//span[@class='display-name']")).getText();
			System.out.println("actualdisplayeName: "+actualdisplayeName);
			Reporter.log("Opened the website and logged-in using the provided credentials");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Test
	public void TestCase7() {


		try {
			System.out.println("Activity7 : Count the number of courses");

			//click on All Courses link
			driver.findElement(By.linkText("All Courses")).click();
			Thread.sleep(5000);

			//Identify the course list
			WebElement courseList = driver.findElement(By.id("ld_course_list"));
			List<WebElement> courses = courseList.findElements(By.xpath("//div[contains(@class,'ld_course_grid col-sm-8 col-md-4')]"));
			int noOfcourses = courses.size();
			System.out.println("noOfcourses: "+noOfcourses);

			for(int i=1;i<=noOfcourses;i++) {

				System.out.println("index"+i);
				WebElement vtitlecours= courseList.findElement(By.xpath("//div[contains(@class,'ld_course_grid col-sm-8 col-md-4')]["+i+"]//h3"));
				String titlecourse = vtitlecours.getText();
				System.out.println("titlecourse: "+titlecourse);
				Reporter.log("Counted the number of courses");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Test
	public void TestCase8() {


		try {
			System.out.println("Activity8 : Contact the admin");

			//click on Contact link
			driver.findElement(By.linkText("Contact")).click();
			Thread.sleep(5000);

			//fill the form 
			driver.findElement(By.id("wpforms-8-field_0")).sendKeys("Rakhi");
			driver.findElement(By.id("wpforms-8-field_1")).sendKeys("en.rakhi@gmail.com");
			driver.findElement(By.id("wpforms-8-field_3")).sendKeys("Hi");
			driver.findElement(By.id("wpforms-8-field_2")).sendKeys("Hi Welcome to LMS");
			driver.findElement(By.id("wpforms-submit-8")).submit();
			Thread.sleep(3000);
			//Confirmation box
			String confirmation = driver.findElement(By.id("wpforms-confirmation-8")).getText();
			System.out.println(confirmation);
			
			Reporter.log("Contacted the admin");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void TestCase9() {


		try {
			System.out.println("Activity9 : Complete a simple lesson");

			//click on All Courses link
			driver.findElement(By.linkText("All Courses")).click();
			Thread.sleep(5000);

			WebElement seemore = driver.findElement(By.xpath("//article[@id='post-69']//a[@class='btn btn-primary'][contains(text(),'See more...')]"));
			System.out.println(seemore.isDisplayed());
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", seemore);
			//click on lesson
			seemore.click();
			driver.findElement(By.xpath("//a[text()='Login to Enroll']")).click();

			driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
			driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");
			driver.findElement(By.xpath("//input[@id='wp-submit']")).submit();


			Thread.sleep(5000);
			//click on expamd button
			driver.findElement(By.xpath("//div[@id='ld-expand-85']//span[@class='ld-icon-arrow-down ld-icon ld-primary-background']")).click();
			Thread.sleep(3000);

			driver.findElement(By.xpath("//div[@id='ld-table-list-item-200']//a[contains(@class,'ld-table-list-item-preview ld-primary-color-hover ld-topic-row learndash-incomplete')]")).click();
			driver.findElement(By.xpath("//div[@id='learndash_post_200']//input[@class='learndash_mark_complete_button']")).click();


			Thread.sleep(3000);
			
			Reporter.log("Lesson is sucessfuly marked.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}




	@AfterMethod
	public void afterMethod() {
		//closing the driver
		driver.close();
	}

}
