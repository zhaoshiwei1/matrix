package com.yongche.matrix.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.yongche.matrix.util.log;;

public class util 
{
	 public static WebElement waitForVisible(WebDriver driver, final By by, int waitTime) {  
	        WebDriverWait wait = new WebDriverWait(driver, waitTime);  
	        for (int attempt = 0; attempt < waitTime; attempt++) {  
	            try {  
	                driver.findElement(by);  
	                break;  
	            } catch (Exception e) {  
	                driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);  
	            }  
	        }  
	      return wait.until(ExpectedConditions.visibilityOfElementLocated(by));  
	    }  
	 
	 public static List getFieldsValue(Object obj) 
	    {
	    	  Field[] fields = obj.getClass().getDeclaredFields();
	    	  String[] types = {"java.lang.Integer",
	    	        "java.lang.Double",
	    	        "java.lang.Float",
	    	        "java.lang.Long",
	    	        "java.lang.Short",
	    	        "java.lang.Byte",
	    	        "java.lang.Boolean",
	    	        "java.lang.Character",
	    	        "java.lang.String",
	    	        "int","double","long","short","byte","boolean","char","float"};
	         List list = new ArrayList();
	    	  
	  		 Map infoMap = null;
	  		
	    	  for(Field f : fields)
	    	  {
	    	   f.setAccessible(true);
	    	   try{
	    		   for(String str : types) 
		    	    {
	    			   if(f.getType().getName().equals(str))
	    			   {
	    			  		infoMap = new HashMap();
	    			  		infoMap.put("name", f.getName());
	    			  		infoMap.put("value", f.get(obj));
	    			  		log.a(f.getName(),(f.get(obj)).toString());
	    			  		list.add(infoMap);
	    			   }
		    	    	 //System.out.println("字段："+f.getName()+" 类型为："+f.getType().getName()+" 值为："+ f.get(obj));
		    	     
		    	    }
	    	      } 
	    	   catch (IllegalArgumentException e) 
	    	   {
	    		   e.printStackTrace();
	    	   } 
	    	   catch (IllegalAccessException e) 
	    	   {
	    	    e.printStackTrace();
	    	   }
	    	  }
	    
	    	  return list;
	    }

	 //driver: 传递进来的驱动
	 //by: 传递要滚动查找的父定义
	 //str: 要查找的目标字符串
	 //id: 父的子成员的id
	 //tag_id: 标识父的子成员列表是否没有变化的标签
	 public static WebElement scrollToFind(AppiumDriver driver, final By by, String str, String id, String tag_id, boolean ifUp)
	 {		 
		 WebElement parent = null;
		 try{
			 parent = driver.findElement(by);
		 }catch(Exception e)
		 {
			log.e(e);
		 }
		 
		 if(null == parent)
		 {
			 return null;
		 }else
		 {
			 scroll(driver, parent, ifUp);
			 String temp1 = parent.findElements(By.id(id)).get(0).findElement(By.id(tag_id)).getText();
			 String temp2 = "";
			 while((!findElement(driver,By.name(str)))&&(!(temp1.equals(temp2))))
				 {
				 	 temp1 = parent.findElements(By.id(id)).get(0).findElement(By.id(tag_id)).getText();
					 scrollStep(driver, parent, id, ifUp);
					 temp2 = parent.findElements(By.id(id)).get(0).findElement(By.id(tag_id)).getText();
				 }
			 
			 WebElement target = null;
			 try{
				 target = driver.findElementByName(str);
			 }catch(Exception e)
			 {
				 log.e(e);
			 }
			 
			 return target;
		 }
		 
	}
	 
	 public static void scroll(AppiumDriver driver, WebElement parent, boolean ifUp)
	 {
		 int x = parent.getLocation().x;
		 int y = parent.getLocation().y;
		 
		 int width = parent.getSize().width;
		 int height = parent.getSize().height;
		 
		 int always_x = (x + x + width)/2;
		 
		 int start_y = 0;
		 int terminal_y = 0;
		 if(ifUp)
		 {
			 start_y = y + height;
			 terminal_y = y;
		 }else
		 {
			 start_y = y;
			 terminal_y = y + height;
		 }
			 driver.swipe(always_x, start_y, always_x, terminal_y,5000);//
	 }
	 

	 public static void scrollStep(AppiumDriver driver, WebElement parent,String child_id, boolean ifup)
	 {
			 List <WebElement>elements = parent.findElements(By.id(child_id));
			 scroll(driver, elements.get(0), false);
	 }
	 
	 public static boolean findElement(AppiumDriver driver, final By by)
	 {
		 WebElement temp = null;
		 try
		 {
			 temp = driver.findElement(by);
		 }catch(Exception e)
		 {
			 log.e(e);
		 }
		 if(null == temp)
		 {
			 return false;
		 }else
		 {
			 return true;
		 }
	 }
	 
}
