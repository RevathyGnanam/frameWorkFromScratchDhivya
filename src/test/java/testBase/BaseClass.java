package testBase;

import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	static public WebDriver driver;
	public Properties p;

	@BeforeClass(groups= {"Regression","Sanity"})
	@Parameters({"browser"})
	public void setUp(String br) throws Exception {
		
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p= new Properties();
		p.load(file);
		
		
		switch(br.toLowerCase()) {
		case "chrome":  driver= new ChromeDriver(); break;
		case "edge":  driver= new EdgeDriver(); break;
		default: System.err.println("No browser launched");return;
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appUrl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@AfterClass(groups= {"Regression","Sanity"})
	public void tearDown() {
		driver.quit();
	}
	
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomAlphaNumeric() {
		String generatedAlphaNumericString = RandomStringUtils.randomAlphabetic(5)+"@"+RandomStringUtils.randomNumeric(3);
		return generatedAlphaNumericString;
	}
	
	public String randomAlphaNumerics() {
		String generatedAlphaNumericsString = RandomStringUtils.randomAlphabetic(5)+RandomStringUtils.randomNumeric(3);
		return generatedAlphaNumericsString;
	}
	
	public String captureScreen(String tname) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		TakesScreenshot screenShot = (TakesScreenshot)driver;
		File srcFile = screenShot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\" + tname +"_" + timeStamp;
		File targetFile = new File(targetFilePath);

		srcFile.renameTo(targetFile);

		return targetFilePath;



		}
}
