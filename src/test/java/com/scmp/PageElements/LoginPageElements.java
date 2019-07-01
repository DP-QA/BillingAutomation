package com.scmp.PageElements;

import org.openqa.selenium.By;

public class LoginPageElements {
	  static String userName ="edit-name--2";
	  static String passWord ="edit-pass--2";
	  static String Submit= "edit-submit--2";
	  
	  public static By UserName()
	  {
		  return By.id(userName);
	  }
	  public static By Password()
	  {
		  return By.id(passWord);
	  }
	  public static By Submit()
	  {
		  return By.id(Submit);
	  }
	}

