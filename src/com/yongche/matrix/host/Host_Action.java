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
			log.out("���SlideCover", "CoverSlideû����ʾ");
		}else
		{
			close_cover_btn.click();
			log.out("���SlideCover", "���close btn���");
		}
	}
	
	public boolean check_if_mainActivity()
	{
		WebElement order_btn = getElement.get_order_btn();
		if(null == order_btn)
		{
			log.out("��ҳ״̬У��", "δ����ҳ���ҵ�������ť�� ��ǰ������ҳ");
			return false;
		}else
		{
			String listening_status = order_btn.getText();
			if((listening_status.equals("ֹͣ����"))||(listening_status.equals("��ʼ����")))
			{
				log.out("��ҳ״̬У��", "������ť�� "+listening_status);
				return true;
			}else
			{
				log.out("��ҳ״̬У��", "������ť�� "+listening_status);
				return false;
			}
		}
	}
	
	public void goto_ordering_page()
	{
		if(null == getElement.get_goto_neworder_btn())
		{
			log.out("��ҳ����FragMent", "δ�ҵ�");
		}else
		{
			getElement.get_goto_neworder_btn().click();
			log.out("��ҳ����Fragment", "�����ť�� ��������ҳ��");
		}
	}
	
	public boolean check_in_listenOrder()
	{
		if((getElement.get_listen_textview()==null)&&(getElement.get_notlisten_textview()==null))
		{
			log.out("�������ҳ��״̬", "δ���ҵ������ɵ��͵�ǰ�Ѿ��ճ����ж���������ҳ��");
			return false;
		}else
		{
			log.out("�������ҳ��״̬", "��ǰ�ڶ���ҳ��");
			return true;
		}
	}
	
	public boolean activate_listen_order()
	{
		if(null == getElement.get_order_btn())
		{
			log.out("������ť״̬", "δ�ҵ�������ť�� ��ǰ���ܲ�����ҳ��������ҳ��");
			return false;
		}else
		{
			if(getElement.get_order_btn().getText().equals("ֹͣ����"))
			{
				log.out("������ť״̬", "ֹͣ������ ��ǰ��������");
				return true;
			}else
			{
				getElement.get_order_btn().click();
				log.out("������ť״̬", "�����ʼ������ť");
				if(getElement.get_listen_textview() != null)
				{	
//					log.a("Debug", getElement.get_listen_textview().getText());
					log.out("������ť״̬", "����Ϊ���ɵ�...");
					return true;
				}else
				{
					log.out("������ť״̬", "��������ʧ��");
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
			log.out("׼�����ܶ���", "δ�ҵ���ض���");
			return false;
		}else
		{
			log.out("׼�����ܶ���", "�ҵ���ض���");
			order.click();
			return true;
		}
	}
	
}
