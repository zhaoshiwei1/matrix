package com.yongche.matrix.globaldefine;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Create_Connection 
{
	public AppiumDriver host_driver = null;
	public AppiumDriver client_driver = null;
	
	public Create_Connection() throws MalformedURLException
	{
        DesiredCapabilities host_capabilities = new DesiredCapabilities();
        host_capabilities.setCapability(CapabilityType.BROWSER_NAME, GlobalDefine.host_BrowserName);
        host_capabilities.setCapability("platformName", GlobalDefine.host_platformName);
        host_capabilities.setCapability("deviceName", GlobalDefine.host_deviceName);
        host_capabilities.setCapability("platformVersion", GlobalDefine.host_platformVersion);
        host_capabilities.setCapability("appPackage", GlobalDefine.host_appPackage);
        host_capabilities.setCapability("appActivity", GlobalDefine.host_appActivity);
        host_capabilities.setCapability("udid", GlobalDefine.host_udid);
        host_capabilities.setCapability("newCommandTimeout", GlobalDefine.host_newCommandTimeout);
        this.host_driver = new AndroidDriver(new URL("http://127.0.0.1:"+GlobalDefine.host_port+"/wd/hub"),host_capabilities);
	
        DesiredCapabilities client_capabilities = new DesiredCapabilities();
        client_capabilities.setCapability(CapabilityType.BROWSER_NAME, GlobalDefine.client_BrowserName);
        client_capabilities.setCapability("platformName", GlobalDefine.client_platformName);
        client_capabilities.setCapability("deviceName", GlobalDefine.client_deviceName);
        client_capabilities.setCapability("platformVersion", GlobalDefine.client_platformVersion);
        client_capabilities.setCapability("appPackage", GlobalDefine.client_appPackage);
        client_capabilities.setCapability("appActivity", GlobalDefine.client_appActivity);
        client_capabilities.setCapability("udid", GlobalDefine.client_udid);
        client_capabilities.setCapability("newCommandTimeout", GlobalDefine.client_newCommandTimeout);
        this.client_driver = new AndroidDriver(new URL("http://127.0.0.1:"+GlobalDefine.client_port+"/wd/hub"),client_capabilities);
        
	}
}
