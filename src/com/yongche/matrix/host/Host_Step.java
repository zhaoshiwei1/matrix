package com.yongche.matrix.host;

import org.eclipse.jetty.util.log.Log;

import com.yongche.matrix.util.log;

import io.appium.java_client.AppiumDriver;

public class Host_Step 
{
	public AppiumDriver driver = null;
	public Host_Action hostAction = null;
	
	public Host_Step(AppiumDriver ad)
	{
		this.driver = ad;
		this.hostAction = new Host_Action(this.driver);
	}
	
	public boolean close_cover_slide ()
	{
		hostAction.close_cover();
		return hostAction.check_if_mainActivity();
	}
	
	public boolean goto_listenOrder_page()
	{
		hostAction.goto_ordering_page();
		return hostAction.check_in_listenOrder();
	}
	
	public boolean listen_order()
	{
		return hostAction.activate_listen_order();
	}
	
	public void show_order_details()
	{
		for(int i = 0; i < 10; i++)
		{
			this.hostAction.show_order_details();
		}
	}
	
}
