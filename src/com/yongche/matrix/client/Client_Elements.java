package com.yongche.matrix.client;

import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.yongche.matrix.util.log;
import com.yongche.matrix.util.util;

import io.appium.java_client.AppiumDriver;

public class Client_Elements 
{
	public AppiumDriver driver = null;

	public Client_Elements(AppiumDriver ad)
	{
		this.driver = ad;
	}

	public WebElement get_canleupdrade_btn()
	{
		WebElement btn = null;
		try
		{
			btn = util.waitForVisible(this.driver, By.id("com.yongche.android:id/btn_cancle"), 10);
		}catch(Exception e)
		{
			log.e(e);
		}
		return btn;
	}

	public WebElement get_upgrade_details_btn()
	{
		WebElement tv = null;
		try
		{
			tv = util.waitForVisible(this.driver, By.id("com.yongche.android:id/tv_update_content"), 10);
		}catch(Exception e)
		{
			log.e(e);
		}
		
		return tv;
	}

	public WebElement get_terminal_editor()
	{
		WebElement editor = null;
		editor = util.waitForVisible(driver, By.name("ÄúÒªÈ¥ÄÄ£¿"), 5);
		return editor;
	}
	
	public WebElement get_start_editor()
	{
		WebElement editor = null;
		editor = util.waitForVisible(driver, By.name(""), 5);
		return editor;
	}
	
	public WebElement get_home_tag()
	{
		WebElement home = null;
		home = util.waitForVisible(driver, By.id("com.yongche.android:id/commont_home_rl"), 3);
		return home;
	}
	
	public WebElement get_submit_btn()
	{
		WebElement btn = null;
		btn = util.waitForVisible(driver, By.id("com.yongche.android:id/order_submit_btn"), 5);
		return btn;
	}
	
	public WebElement get_raiseprice_btn()
	{
		WebElement btn = null;
		try
		{
			btn = util.waitForVisible(driver, By.id("com.yongche.android:id/btn_allow_raise_price"), 5);
		}catch(Exception e)
		{
			log.e(e);
		}

		return btn;
	}
	
	public WebElement get_Cartype_Entrance()
	{
		WebElement btn = null;
		try
		{
			btn = util.waitForVisible(this.driver, By.id("com.yongche.android:id/order_cartype"), 1);
		}catch (Exception e)
		{
			log.e(e);
		}
		
		return btn;
	}
	
	public WebElement get_cartype_btn(String cartype)
	{
		WebElement target = null;
		
		target = util.scrollToFind(driver, By.id("com.yongche.android:id/lv_select_car"), cartype, "com.yongche.android:id/rl_select_car_bg", "com.yongche.android:id/tv_car_type_name", false);
	
		return target;
	}
	
}
