package com.yongche.matrix.host;

import org.openqa.selenium.WebElement;

import com.yongche.matrix.util.log;

import io.appium.java_client.AppiumDriver;

public class Host_Action 
{
	public AppiumDriver driver = null;
	public Host_Elements getElement = null;
	
	public Host_Action(AppiumDriver ad)
	{
		this.driver = ad;
		this.getElement = new Host_Elements(this.driver);
	}
	
	public void close_cover()
	{
		WebElement close_cover_btn = getElement.get_close_cover_btn();
		if(null == close_cover_btn)
		{
			log.out("检查SlideCover", "CoverSlide没有显示");
		}else
		{
			close_cover_btn.click();
			log.out("检查SlideCover", "点击close btn完成");
		}
	}
	
	public boolean check_if_mainActivity()
	{
		WebElement order_btn = getElement.get_order_btn();
		if(null == order_btn)
		{
			log.out("首页状态校验", "未能在页面找到听单按钮， 当前不在首页");
			return false;
		}else
		{
			String listening_status = order_btn.getText();
			if((listening_status.equals("停止听单"))||(listening_status.equals("开始听单")))
			{
				log.out("首页状态校验", "听单按钮： "+listening_status);
				return true;
			}else
			{
				log.out("首页状态校验", "听单按钮： "+listening_status);
				return false;
			}
		}
	}
	
	public void goto_ordering_page()
	{
		if(null == getElement.get_goto_neworder_btn())
		{
			log.out("首页听单FragMent", "未找到");
		}else
		{
			getElement.get_goto_neworder_btn().click();
			log.out("首页听单Fragment", "点击按钮， 进入听单页面");
		}
	}
	
	public boolean check_in_listenOrder()
	{
		if((getElement.get_listen_textview()==null)&&(getElement.get_notlisten_textview()==null))
		{
			log.out("检查听单页面状态", "未能找到正在派单和当前已经收车，判定不在听单页面");
			return false;
		}else
		{
			log.out("检查听单页面状态", "当前在订单页面");
			return true;
		}
	}
	
	public boolean activate_listen_order()
	{
		if(null == getElement.get_order_btn())
		{
			log.out("听单按钮状态", "未找到听单按钮， 当前可能不在首页或者听单页面");
			return false;
		}else
		{
			if(getElement.get_order_btn().getText().equals("停止听单"))
			{
				log.out("听单按钮状态", "停止听单： 当前正在听单");
				return true;
			}else
			{
				getElement.get_order_btn().click();
				log.out("听单按钮状态", "点击开始听单按钮");
				if(getElement.get_listen_textview() != null)
				{	
//					log.a("Debug", getElement.get_listen_textview().getText());
					log.out("听单按钮状态", "正在为您派单...");
					return true;
				}else
				{
					log.out("听单按钮状态", "启动听单失败");
					return false;
				}
			}
		}
	}
	
	public boolean show_order_details()
	{
		WebElement order = this.getElement.get_terminal_address();
		if(null == order)
		{
			log.out("准备接受订单", "未找到相关订单");
			return false;
		}else
		{
			log.out("准备接受订单", "找到相关订单");
			order.click();
			return true;
		}
	}
	
}
