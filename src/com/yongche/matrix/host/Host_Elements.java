package com.yongche.matrix.host;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.yongche.matrix.globaldefine.GlobalDefine;
import com.yongche.matrix.util.log;
import com.yongche.matrix.util.util;

import io.appium.java_client.AppiumDriver;

public class Host_Elements 
{
	public AppiumDriver driver = null;
	
	public Host_Elements(AppiumDriver ad)
	{
		this.driver = ad;
	}
	
	public WebElement get_close_cover_btn()
	{
		WebElement btn = null;
		try{
			btn = util.waitForVisible(driver, By.id("com.yongche:id/btn_close_vp"), 10);
		}catch(Exception e)
		{
			log.e(e);
		}
		
		return btn;
	}
	
	public WebElement get_order_btn()
	{
		WebElement btn = null;
		try{
			btn = util.waitForVisible(driver, By.id("com.yongche:id/button_order"), 10);
		}catch(Exception e)
		{
			log.e(e);
		}
		
		return btn;
	}
	
	public WebElement get_goto_neworder_btn()
	{
		WebElement btn = null;
		try{
			btn = util.waitForVisible(driver, By.id("com.yongche:id/rb_neworderfragment"), 10);
		}catch(Exception e)
		{
			log.e(e);
		}
		return btn;
	}
	
	public WebElement get_notlisten_textview()
	{
		WebElement tv = null;
		try {
			tv = util.waitForVisible(driver, By.name("已收车，养精蓄锐吧"), 10);
		}catch(Exception e)
		{
			log.e(e);
		}
		return tv;
	}
	
	public WebElement get_listen_textview()
	{
		WebElement tv = null;
		try {
			tv = util.waitForVisible(driver, By.name("正在为您派单..."), 10);
		}catch(Exception e)
		{
			log.e(e);
		}
		return tv;
	}
	
	public WebElement get_accept_btn()
	{
		WebElement btn = null;
		btn = util.waitForVisible(driver, By.id("com.yongche:id/tv_assign_accept"), 2);
		return btn;
	}
	
	public WebElement get_terminal_address()
	{
		WebElement terminal_address_tv = null;
		try
		{
			terminal_address_tv = util.waitForVisible(driver, By.name(GlobalDefine.end_address), 10);
		}catch(Exception e)
		{
			log.e(e);
		}
		return terminal_address_tv;
		
	}
}
