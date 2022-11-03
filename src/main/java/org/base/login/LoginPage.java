package org.base.login;

import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
                      //Inheritance-extends
public class LoginPage extends BaseClass {
	//purpose of webdriver initilization we use constructor
		public LoginPage() {
			PageFactory.initElements(driver, this);//static
		}
		
		
		@CacheLookup     //cache is a temporary memory to find webelement again and again
		@FindBy(id="email")       //find by is only find one webelement
		private WebElement txtUsername;
		
		@FindBys({@FindBy(id="pass"),@FindBy(xpath="//input[@type='password']")})  //findbys is used to find more webelement , working in And operator
		private WebElement txtPassword;
		
		@FindAll({@FindBy(name="login"),@FindBy(xpath="//button[@type='submit']")}) //findall --wroking in Or operator
		private WebElement btnLogin;
		
		
	   //using encapsulation-getter for return the webelement
		public WebElement getTxtUsername() {
			return txtUsername;
		}

		public WebElement getTxtPassword() {
			return txtPassword;
		}

		public WebElement getBtnLogin() {
			return btnLogin;
		}
		
		
	
	
	

}
