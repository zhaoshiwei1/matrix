package com.yongche.matrix.client;

import org.openqa.selenium.WebElement;

import com.yongche.matrix.util.log;

import io.appium.java_client.AppiumDriver;

public class Client_Action 
{
	public AppiumDriver driver ;
	public Client_Elements getElement;
	
	public Client_Action(AppiumDriver ad)
	{
		this.driver = ad;
		this.getElement = new Client_Elements(this.driver);
	}
	
	public void cancel_upgrade()
	{
		WebElement btn = this.getElement.get_canleupdrade_btn();
		WebElement upgrade_content = this.getElement.get_upgrade_details_btn();
		if(null == upgrade_content)
		{
			log.out("关闭升级提示", "升级提示未展示");
		}else
		{
			if(btn != null)
			{
				btn.click();	
			}
		}
	}
	
	public boolean set_terminal()
	{
		WebElement ter = this.getElement.get_terminal_editor();
		if(null == ter)
		{
			log.out("点击编辑目的地","未能找到目的地编辑栏");
			return false;
		}else
		{
			log.out("点击编辑目的地", "点击");
			ter.click();
			if(this.getElement.get_home_tag()==null)
			{
				log.out("目的地编辑页面", "未找到“家”标签");
				return false;
			}else
			{
				log.out("目的地编辑页面", "找到“家”标签");
				this.getElement.get_home_tag().click();
				return true;
			}
		}

	}
	
	public boolean set_start()
	{
		return false;
	}
	
	public void submit_order()
	{
		log.out("提交用车订单", "点击提交订单按钮");
		this.getElement.get_submit_btn().click();
	}
	
	public void accept_raise_price()
	{
		WebElement btn = this.getElement.get_raiseprice_btn();
		if(null == btn)
		{
			log.out("检查价格上浮", "没有价格上浮， 跳过");
		}else
		{
			log.out("检查价格上浮", "价格上浮，接受");
			btn.click();
		}
		
	}

	
	public void enter_Cartype_list()
	{
		WebElement cartype_entrance = this.getElement.get_Cartype_Entrance();
		if(null == cartype_entrance)
		{
			log.out("配置订单车型", "未找到订单选择列表入口");
		}else
		{
			cartype_entrance.click();
			log.out("配置订单车型", "点击进入");
		}
	}
	
	public void select_cartype(String cartype)
	{
		WebElement cartype_btn = this.getElement.get_cartype_btn(cartype);
		if(null == cartype_btn)
		{
			log.out("配置订单车型","未能找到对应车型： "+cartype);
		}else
		{
			cartype_btn.click();
			log.out("配置订单车型", "找到对应车型： "+cartype);
		}
	}
	
}
