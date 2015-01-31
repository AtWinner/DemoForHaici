package com.example.adapter;

import android.util.Log;

/**
 * 适配的最大分辨率是1080p
 * 如果更大的就不做处理了，现在这些机型还不多
 * @author Coder
 *
 */
public class AdjustPageLayout {
	public static int AdjustListTitleTextSize(int screenWidth)
	{
		return AdjustText(screenWidth, 30);
	}
	public static int AdjustTextSize(int screenWidth)
	{
		return AdjustText(screenWidth, 26);
	}
	private static int AdjustText(int screenWidth, int MaxSize)
	{
		if (screenWidth <= 240) 
		 {        // 240X320 屏幕
			 return MaxSize-8;
		 }
		 else if (screenWidth <= 320)
		 {   // 320X480 屏幕
		 
			 return MaxSize-7;
		 
		 }else if (screenWidth <= 480)
		 {   // 480X800 或 480X854 屏幕
		 
			 return MaxSize-6;
		 
		 }
		 else if (screenWidth <= 540)
		 {   // 540X960 屏幕
		 
			 return MaxSize-5;
		         
		 }
		 else if(screenWidth <= 720)
		 {    // 800X1280 屏幕
		 
			 return MaxSize-4;
		         
		 }
		 else if(screenWidth <= 800)
		 {    // 800X1280 屏幕
		 
			 return MaxSize-3;
		         
		 }
		 else if(screenWidth <= 1080)
		 {   
		 
			 return MaxSize-2;
		         
		 }
		 else
		 {                          // 大于 1080p
			 return MaxSize;
		 }
	}
	
}
