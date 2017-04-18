package com.yongche.matrix.testscript;

import static org.junit.Assert.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.appium.java_client.AppiumDriver;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.yongche.matrix.client.Client_Step;
import com.yongche.matrix.globaldefine.Create_Connection;
import com.yongche.matrix.globaldefine.GlobalDefine;
import com.yongche.matrix.host.Host_Step;
import com.yongche.matrix.util.log;
import com.yongche.matrix.util.util;


public class Test_Demo 
{
	public AppiumDriver host_driver = null;
	public AppiumDriver client_driver = null;
	
	public Host_Step hostStep = null;
	public Client_Step clientStep = null;
	
	@Before
	public void setUp() throws Exception
	{		
		Create_Connection cc = new Create_Connection();
		//host driver
		this.host_driver = cc.host_driver;
		//host driver 传递进入产品封装
		this.hostStep = new Host_Step(this.host_driver);
		//client driver
		this.client_driver = cc.client_driver;
		//client driver 传递进入产品封装
		this.clientStep = new Client_Step(this.client_driver);
	}
	
	@After
	public void tearDown() throws Exception
	{
		this.client_driver.quit();
		this.host_driver.quit();
	}
	
	@Test
	public void interaction_demo() throws InterruptedException
	{
		assertTrue("未能进入首页", hostStep.close_cover_slide());
		assertTrue("未能进入听单页面", hostStep.goto_listenOrder_page());
		assertTrue("开始听单失败", hostStep.listen_order());
		clientStep.cancel_upgrade();
		assertTrue("创建订单失败", clientStep.set_terminal("Young车型"));
		this.accept_order();
	}
	
	public void accept_order()
	{
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
                clientStep.price_raise_forasync();
			}
			
		}).start();
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
          	  hostStep.show_order_details();
			}
			
		}).start();
		
	}
}



