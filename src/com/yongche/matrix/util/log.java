package com.yongche.matrix.util;

import com.yongche.matrix.globaldefine.GlobalDefine;

public class log 
{
	public static void e(Exception e)
	{
		if(GlobalDefine.EXCEPTION_OUT)
		{
			e.printStackTrace();
			System.out.print("\n\n");
		}
	}
	
	public static void a(String tag,String msg)
	{
		if(GlobalDefine.A)
		{
			String t = tag_format(tag);
			System.out.print(t);
			System.out.print(msg+"\n");
		}
	}
	
	public static void out(String tag,String msg)
	{
		if(GlobalDefine.OUT)
		{
			String t = tag_format(tag);
			System.out.print(t);
			System.out.print(msg+"\n");
		}
	}
	
	public static String tag_format(String tag)
	{
		int l = tag.length();
		tag = tag + ":";
		if(25>l)
		{
			for(int i=0;i<(25-l); i++)
			{
				tag = tag+" ";
			}
		}
		return tag;
	}
}
