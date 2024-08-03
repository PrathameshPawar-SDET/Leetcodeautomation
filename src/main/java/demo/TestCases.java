package demo;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.System.*;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }


    public void testCase01() throws InterruptedException {
        out.println("Start Test case: testCase01");
        driver.get("https://leetcode.com/");

        Thread.sleep(2000);
        String URL = driver.getCurrentUrl();
        if(URL.contains("leetcode")){
            out.println("Test case 1 is passed");
        }
        else{
            out.println("Test case 1 is failed");
        }

        out.println("end Test case: testCase01");
    }

    public void testCase02(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        out.println("Start Test case: testCase02");
        driver.get("https://leetcode.com/");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='View Questions ']")));
        WebElement Questions = driver.findElement(By.xpath("//p[text()='View Questions ']"));

        if(Questions.isDisplayed()){
            Questions.click();
        }
        else{
            out.println("View Questions button is not displayed");
        }

        wait.until(ExpectedConditions.urlContains("problemset"));

        String currenturl = driver.getCurrentUrl();

        if(currenturl.contains("problemset")){
            out.println("Test case has been Passed for verification of Problemset url");
        }
        else{
            out.println("Test case has been Failed for verification of Problemset url");
        }
// "//div[@role='row']/div[@role='cell'][2]"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='row']/div[@role='cell'][2]")));
        List<WebElement> QuestionTitles = driver.findElements(By.xpath("//div[@role='row']/div[@role='cell'][2]"));

        for(int i=1;i<=5;i++){
            if(i<QuestionTitles.size()){
                out.println((QuestionTitles.get(i).getText()));
            }
            else{
                out.println("Less than 5 questions are found");
                break;
            }


        }
        System.out.println("end Test case: testCase02");


    }

    public void testCase03() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        out.println("Start Test case: testCase03");
        driver.get("https://leetcode.com/");

        WebElement Questions = driver.findElement(By.xpath("//p[text()='View Questions ']"));

        if(Questions.isDisplayed()){
            Questions.click();
        }
        else{
            out.println("View Questions button is not displayed");
        }

        wait.until(ExpectedConditions.urlContains("problemset"));

        String currenturl = driver.getCurrentUrl();

        if(currenturl.contains("problemset")){
            out.println("Test case has been Passed for verification of Problemset url");
        }
        else{
            out.println("Test case has been Failed for verification of Problemset url");
        }

        Thread.sleep(2000);
        List<WebElement> questionTitles = driver.findElements(By.xpath("//div[@role='row']/div[@role='cell'][2] //a"));

        boolean questionFound = false;
        Thread.sleep(2000);
        for (WebElement titleElement : questionTitles) {
            if (titleElement.getText().contains("Two Sum")) {
                out.println(titleElement.getText());
                titleElement.click();
                System.out.println("Two Sum question has been clicked");

                // Wait for the URL to contain "two-sum"
                wait.until(ExpectedConditions.urlContains("two-sum"));

                // Verify the URL
                String currentQuestionUrl = driver.getCurrentUrl();
                if (currentQuestionUrl.contains("two-sum")) {
                    System.out.println("Test case 3 has been passed");
                } else {
                    System.out.println("Test case 3 has been failed");
                }

                questionFound = true;
                break; // Exit loop after finding and clicking "Two Sum"
            }
        }

        if (!questionFound) {
            System.out.println("Question 'Two Sum' not found in the list.");
        }
        System.out.println("end Test case: testCase03");
    }





    public void testCase04() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        out.println("Start Test case: testCase04");
        driver.get("https://leetcode.com/");
        WebElement Questions = driver.findElement(By.xpath("//p[text()='View Questions ']"));
        wait.until(ExpectedConditions.visibilityOf(Questions));
        if(Questions.isDisplayed()){
            Questions.click();
        }
        else{
            out.println("View Questions button is not displayed");
        }

        wait.until(ExpectedConditions.urlContains("problemset"));

        String currenturl = driver.getCurrentUrl();

        if(currenturl.contains("problemset")){
            out.println("Test case has been Passed for verification of Problemset url");
        }
        else{
            out.println("Test case has been Failed for verification of Problemset url");
        }

        Thread.sleep(2000);
        List<WebElement> questionTitles = driver.findElements(By.xpath("//div[@role='row']/div[@role='cell'][2] //a"));

        boolean questionFound = false;
        Thread.sleep(2000);
        for (WebElement titleElement : questionTitles) {
            if (titleElement.getText().contains("Two Sum")) {
                out.println(titleElement.getText());
                titleElement.click();
                System.out.println("Two Sum question has been clicked");

                questionFound = true;
                break; // Exit loop after finding and clicking "Two Sum"

            }
        }
        Thread.sleep(2000);

        WebElement Submission = driver.findElement(By.xpath("//div[@class='normal absolute left-0 top-0 whitespace-nowrap font-normal'][normalize-space()='Submissions']"));
        Submission.click();
        out.println("Submission button has been clicked");


        WebElement Regsignbutton = driver.findElement(By.xpath("//a[normalize-space()='Register or Sign In']"));
        wait.until(ExpectedConditions.visibilityOf(Regsignbutton));

        if(Regsignbutton.isDisplayed()){
            out.println("Test case 4 has been passed" +Regsignbutton.getText());
        }
        else{
            out.println("Test case 4 has been failed");
        }
        System.out.println("end Test case: testCase04");

    }


}
