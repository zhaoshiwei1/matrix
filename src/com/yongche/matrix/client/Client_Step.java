package com.yongche.matrix.client;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.yongche.matrix.util.util;

import io.appium.java_client.AppiumDriver;

public class Client_Step 
{
	public AppiumDriver driver;
	public Client_Action clientAction;
	
	public Client_Step(AppiumDriver ad)
	{
		this.driver = ad;
		clientAction = new Client_Action(this.driver);
	}
	
	public void cancel_upgrade()
	{
		clientAction.cancel_upgrade();
	}
	
	public boolean set_terminal(String cartype) throws InterruptedException
	{
		if(clientAction.set_terminal())
		{
			this.clientAction.enter_Cartype_list();

			WebElement target = null;
			
			this.clientAction.select_cartype(cartype);
			
			clientAction.submit_order();
			
			return true;
		}else
		{
			return false;
		}
	}
	
	public void price_raise_forasync()
	{
		for(int i = 0; i < 10; i ++)
		{
			this.clientAction.accept_raise_price();
		}

	}
	
}
