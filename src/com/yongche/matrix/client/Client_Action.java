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
			log.out("�ر�������ʾ", "������ʾδչʾ");
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
			log.out("����༭Ŀ�ĵ�","δ���ҵ�Ŀ�ĵر༭��");
			return false;
		}else
		{
			log.out("����༭Ŀ�ĵ�", "���");
			ter.click();
			if(this.getElement.get_home_tag()==null)
			{
				log.out("Ŀ�ĵر༭ҳ��", "δ�ҵ����ҡ���ǩ");
				return false;
			}else
			{
				log.out("Ŀ�ĵر༭ҳ��", "�ҵ����ҡ���ǩ");
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
		log.out("�ύ�ó�����", "����ύ������ť");
		this.getElement.get_submit_btn().click();
	}
	
	public void accept_raise_price()
	{
		WebElement btn = this.getElement.get_raiseprice_btn();
		if(null == btn)
		{
			log.out("���۸��ϸ�", "û�м۸��ϸ��� ����");
		}else
		{
			log.out("���۸��ϸ�", "�۸��ϸ�������");
			btn.click();
		}
		
	}

	
	public void enter_Cartype_list()
	{
		WebElement cartype_entrance = this.getElement.get_Cartype_Entrance();
		if(null == cartype_entrance)
		{
			log.out("���ö�������", "δ�ҵ�����ѡ���б����");
		}else
		{
			cartype_entrance.click();
			log.out("���ö�������", "�������");
		}
	}
	
	public void select_cartype(String cartype)
	{
		WebElement cartype_btn = this.getElement.get_cartype_btn(cartype);
		if(null == cartype_btn)
		{
			log.out("���ö�������","δ���ҵ���Ӧ���ͣ� "+cartype);
		}else
		{
			cartype_btn.click();
			log.out("���ö�������", "�ҵ���Ӧ���ͣ� "+cartype);
		}
	}
	
}
