import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class ExtentReportDemo {
    ExtentReports extent =new ExtentReports();

    @BeforeTest
    public void config(){
        //Extentreports,extentsparkreporter

      String path=  System.getProperty("user.dir")+"/reports/index.html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Sai Berde");
    }

    @Test
    public void intialDemo(){
        ExtentTest test= extent.createTest("Initial Demo");
        System.setProperty("Webdriver.chrome.driver","C://chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        driver.close();
        test.fail("Result do not match");
        extent.flush();


    }
}
