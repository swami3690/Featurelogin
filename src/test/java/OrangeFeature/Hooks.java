package OrangeFeature;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.util.concurrent.TimeUnit;

public class Hooks  extends BasePage{

    BrowserSelector browserSelector = new BrowserSelector();
    LoadProp loadProp = new LoadProp();

    @Before
    public void setBrowserSelector() {
        browserSelector.setUpBrowser();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");


    }

    @After

    public void closeBrowser() {
        driver.quit();

    }

}
