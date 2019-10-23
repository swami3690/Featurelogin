package OrangeFeature;

import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends Utils {
    LoadProp loadProp = new LoadProp();


    private By _UserName = By.id("txtUsername");
    private By _Password = By.id("txtPassword");
    private By _Login = By.id("btnLogin");
    private By _Massage = By.linkText("Dashboard");
    private By _userName1 = By.id("txtUsername");
    private By _Password1 = By.id("txtPassword");
    private By _Login1 = By.id("btnLogin");


    public void credentials() {

        enterText(_UserName, loadProp.getProperty("username"));
        enterText(_Password, loadProp.getProperty("password"));

    }

    public void Login() {
        clickElement(_Login);


    }

    public  void massage (){

        Assert.assertEquals(getText(_Massage),"Dashboard");


    }

public void failLogin (){
    enterText(_userName1, loadProp.getProperty("username1"));
    enterText(_Password1, loadProp.getProperty("password1"));



}



}



