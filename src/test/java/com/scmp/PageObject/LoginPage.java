package com.scmp.PageObject;
import org.openqa.selenium.WebDriver;
import com.scmp.Core.ActionDriver;
import com.scmp.PageElements.LoginPageElements;
public class LoginPage extends ActionDriver
{
LoginPageElements lp= new LoginPageElements();
public LoginPage(WebDriver driver)
{
	super(driver);
}
public LoginPage typeusername(String username)
{
	type(LoginPageElements.UserName(),username);
	return this;
}
public LoginPage typepassword(String password)
{
	
	type(LoginPageElements.Password(),password);
	return this;
}
public LoginPage clicksubmit()
{
	click(LoginPageElements.Submit());
	return this;
}
}
