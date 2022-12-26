package Screenshots;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

class Capturescreenshots {

	WebDriver driver = null;

	@Test(priority=1)
	public void captureAsFile() throws IOException {

		driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		// FileUtils.copyFile(source, new File("./"+"ScreenShots/ss.png"));
		FileUtils.copyFile(source, new File(System.getProperty("user.dir") + "/ScreenShots/ss1.png"));
	}

	@Test(priority=2)
	public void captureAsBytes() throws IOException {

		driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] source = ts.getScreenshotAs(OutputType.BYTES);

		FileUtils.writeByteArrayToFile(new File("./" + "ScreenShots/ss2.png"), source);
	}

	@Test(priority=3)
	public void captureAsBase64() throws IOException {

		driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		TakesScreenshot ts = (TakesScreenshot) driver;
		String source = ts.getScreenshotAs(OutputType.BASE64);
	byte[] sourcenew=Base64.getDecoder().decode(source);
	
FileUtils.writeByteArrayToFile(new File("./"+"ScreenShots/ss3.png"), sourcenew);
	}

}