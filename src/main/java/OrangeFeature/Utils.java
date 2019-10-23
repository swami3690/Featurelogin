package OrangeFeature;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utils extends BasePage {
    public static void clickElement(By by) {

        driver.findElement(by).click();

    }
    public void enterText (By by,String text){

        driver.findElement(by).sendKeys(text);


    }

    public String getText (By by){

        String text = driver.findElement(by).getText();

        return text;
    }


    public void selectByValue(By by, String value) {

        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(driver.findElement(by));
        select.selectByValue(value);
        select.getFirstSelectedOption();

    }

    public void selectByIndex(By by, int i) {

        WebElement mySelectElm = driver.findElement(by);
        org.openqa.selenium.support.ui.Select mySelect = new Select(mySelectElm);
        mySelect.selectByIndex(i);

    }

    public void waitForClickable(By by, long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }


    public void waitForElementVisible(By by, long time) {

        WebDriverWait wait = new WebDriverWait(driver, time);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

    }

    public void waitForAlertPresent(long time) {

        WebDriverWait wait = new WebDriverWait(driver, time);

        wait.until(ExpectedConditions.alertIsPresent());


    }


    //Random email generator
    public String generateEmail(String startValue) {

        String email = startValue.concat(new Date().toString());
        return email;

    }

    //Random Date generator
    public static String randomDate() {
        DateFormat format = new SimpleDateFormat("ddmmyyHummss");
        return format.format(new Date());

    }

    //To get Attribute
    public String getAttributeValue(By by, String text) {
        return driver.findElement(by).getAttribute(text);
    }

    //To get Css Value
    public String getCssValue(By by, String value) {
        return driver.findElement(by).getCssValue(value);
    }

    // To wait
    public static void sleep(final long millis, By by) {
        System.out.println((String.format("sleeping %d ms", millis)));
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    // To extract text from element
    public String extractText(By by) {
        String text = driver.findElement(by).getText();
        return text;
    }

    public  static String validateURL (String expected){

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,expected);
        return url;
    }


    public void randgenerate() {

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
    }

    public void AssertByText(By by, String expectedResult, String Error){

        Assert.assertEquals(driver.findElement(by).getText(),expectedResult,Error);

    }

    public void takeAScreenShort(ITestResult res){
        if(ITestResult.FAILURE == res.getStatus()){
        }try {
            TakesScreenshot ts = (TakesScreenshot)driver;
            File src= ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src,new File("src\\test\\java\\Resources\\Screenshot" +res.getName()+ randomDate()+".png"));
        }

        catch (Exception e){

            System.out.println("");
        }
    }



}
