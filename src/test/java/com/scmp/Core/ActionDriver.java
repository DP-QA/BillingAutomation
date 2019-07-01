package com.scmp.Core;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionDriver 
{
	protected WebDriver driver;
	String parent;
	public ActionDriver(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void type(By loc, String value)
	{
		driver.findElement(loc).sendKeys(value);
	}
	
	public void click(By loc)
	{
		driver.findElement(loc).click();
	}
	
	public String gettext(By loc)
	{
		return driver.findElement(loc).getText();
	}
	
	public void DropDown(By loc, String value)
	{
		List<WebElement> list=driver.findElements(loc);
		System.out.println(list.size());
		for(WebElement BHK: list)
		{
			//System.out.println(BHK.getText());
			if(BHK.getText().equals(value))
			{
				BHK.click();
			}
		}
	}
	
	public void WindowSwitch(By loc)
	{
		 parent=driver.getWindowHandle();
		System.out.println(driver.getTitle());
		click(loc);
		Set<String> ALLwin=driver.getWindowHandles();
		for(String ChildWin: ALLwin )
		{
			if(!ChildWin.equals(parent))
			{
				driver.switchTo().window(ChildWin);
			}
		}
		System.out.println(driver.getTitle());
	}
	
	public void BackToParentwin()
	{
		driver.switchTo().window(parent);
	}
	
	public void FrameSwitching(By loc)
	{
		WebElement iframe=driver.findElement(loc);
		driver.switchTo().frame(iframe);
	}
	
	public void AlertSwitchandAccept()
	{
		Alert alt=driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
	}
	
	public void AlertSwitchandDismiss()
	{
		Alert alt=driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.dismiss();
	}
	public void DragandDropBy(By loc, int value1, int value2)
	{
		WebElement pointer=driver.findElement(loc);
		System.out.println(pointer.getLocation());
		Actions act1=new Actions(driver);
		act1.dragAndDropBy(pointer,value1,value2).build().perform();
		System.out.println(pointer.getLocation());
	}
	
	public void DragandDrop( By loc1, By loc2)
	{
		WebElement From=driver.findElement(loc1);
		WebElement To=driver.findElement(loc2);
		Actions act1=new Actions(driver);
		act1.dragAndDrop(From, To).build().perform();
	}
	
	public void Navigate(String value)
	{
		driver.navigate().to(value);
	}
	
	public void PageRefresh()
	{
		//driver.navigate().refresh();
		//driver.navigate().to(driver.getCurrentUrl()); 
		driver.get(driver.getCurrentUrl());
	}
	
	public void MouseHoverandClick(By loc, By loc1)
	{
		WebElement MoveTo=driver.findElement(loc);
		Actions act1= new Actions(driver);
		act1.moveToElement(MoveTo).build().perform();
		click(loc1);
	}
	
	public void DoubleMouseHoverandClick(By loc, By loc1, By loc2)
	{
		WebElement MoveOnce=driver.findElement(loc);
		WebElement MoveTwice=driver.findElement(loc1);
		Actions act1=new Actions(driver);
		act1.moveToElement(MoveOnce).build().perform();
		act1.moveToElement(MoveTwice).build().perform();
		click(loc2);
	}
	
	public void Check(By loc)
	{
		WebElement checkbox=driver.findElement(loc);
		if(!checkbox.isSelected())
		{
			checkbox.click();
		}
	}
	
	public void Uncheck(By loc)
	{
		WebElement checkbox=driver.findElement(loc);
		if(checkbox.isSelected())
		{
			checkbox.click();
		}
	}
	
	public void RightClick(By loc)
	{
		WebElement element=driver.findElement(loc);
		Actions act1=new Actions(driver);
		act1.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
	}
	
	public void FindLinks(By loc)
	{
	  List<String> values=new ArrayList<String>();	
	  List<WebElement> links=driver.findElements(loc);
	  System.out.println("No. of Links are :"+ links.size());
	  for(WebElement linkValue: links)
	  {
		  values.add(linkValue.getAttribute("href"));
		  System.out.println(linkValue.getText()+"="+linkValue.getAttribute("href"));
	  }
	}
	

}

