package com.example.demoforhaici;

import java.util.Locale;

import com.example.adapter.AdjustPageLayout;
import com.example.adapter.FragmentPage0;
import com.example.adapter.FragmentPage1;
import com.example.adapter.FragmentPage2;
import com.example.data.AnalyzeJson;
import com.example.model.Word;
import com.example.values.myColor;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

	private final int PagesCount = 3;//保存页面数量
	private Button[] mBtnTabs = new Button[PagesCount];//Tab页中的Button

	private Word myWord;
	
	private int Width;
	/**
	 * Tab页的标签
	 */
	private TabWidget tabWidgetMiddle;
	
	private ViewPager bodyPager;
	private TextView wordValue;
	private TextView txEnglish;
	private TextView txAmerican;
	private ImageView ImageEnglish1;
	private ImageView ImageEnglish2;
	private ImageView ImageAmerican1;
	private ImageView ImageAmerican2;
	
	private SectionsPagerAdapter mSectionsPagerAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		setParams();
		setTab();
		bindEvent();
	}
	/**
	 * 页面控件的获取
	 */
	private void init()
	{
		Width  = getWindowManager().getDefaultDisplay().getWidth();
		wordValue = (TextView)findViewById(R.id.wordValue);
		tabWidgetMiddle = (TabWidget)findViewById(R.id.tabWidgetMiddle);
		bodyPager = (ViewPager)findViewById(R.id.bodyPager);
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
		bodyPager.setAdapter(mSectionsPagerAdapter);
		txEnglish  = (TextView)findViewById(R.id.txEnglish) ;
		txAmerican = (TextView)findViewById(R.id.txAmerican);
		ImageEnglish1 = (ImageView)findViewById(R.id.ImageEnglish1) ;
		ImageEnglish2 = (ImageView) findViewById(R.id.ImageEnglish2);
		ImageAmerican1 = (ImageView)findViewById(R.id.ImageAmerican1) ;
		ImageAmerican2 = (ImageView)findViewById(R.id.ImageAmerican2) ;
		AnalyzeJson json = new AnalyzeJson("");
        myWord = json.GetTencentInfoByJson();
        txEnglish.setText("英[" + myWord.myPhonetic.ep_yp + "]");
        txAmerican.setText("美[" + myWord.myPhonetic.ap_yp + "]");
        wordValue.setText(myWord.item);
	}
	/**
	 * 页面布局设置
	 */
	private void setParams()
	{
		LinearLayout.LayoutParams paramsImage = (LinearLayout.LayoutParams)ImageEnglish1.getLayoutParams();
		paramsImage.setMargins(20, 20, 0, 20);
		ImageAmerican1.setLayoutParams(paramsImage);
		ImageAmerican2.setLayoutParams(paramsImage);
		ImageEnglish1.setLayoutParams(paramsImage);
		ImageEnglish2.setLayoutParams(paramsImage);
		
		LinearLayout.LayoutParams paramsText = (LinearLayout.LayoutParams)txAmerican.getLayoutParams();
		paramsText.setMargins(40, 20, 0, 20);
		txAmerican.setLayoutParams(paramsText);
		LinearLayout.LayoutParams paramsTextEnglish = (LinearLayout.LayoutParams)txEnglish.getLayoutParams();
		paramsTextEnglish.setMargins(0, 20, 0, 20);
		txEnglish.setLayoutParams(paramsTextEnglish);
		wordValue.setTextSize(AdjustPageLayout.AdjustListTitleTextSize(Width));
		
		Typeface type = Typeface.createFromAsset(getAssets(), "Lucida.ttf");
		txAmerican.setTypeface(type);
		txEnglish.setTypeface(type);
	}
	/**
	 * 绑定事件
	 */
	private void bindEvent()
	{
		bodyPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				for(int i = 0; i < PagesCount; i++)
				{
					mBtnTabs[i].setTextColor(myColor.myDarkGray);
				}
				mBtnTabs[position].setTextColor(myColor.myBlack); 
			}
		});
		
	}
	/**
	 * 设置Tab标签
	 */
	private void setTab()
	{
		tabWidgetMiddle.setStripEnabled(false);
		addButton(0, R.string.base_def);
		addButton(1, R.string.sentence);
		addButton(2, R.string.vocabulary);
	}
	private void addButton(int index, int string)
	{
		mBtnTabs[index] = new Button(MainActivity.this);
		mBtnTabs[index].setFocusable(true);
		mBtnTabs[index].setText(string);
		mBtnTabs[index].setTextColor(index == 0 ? myColor.myBlack : myColor.myDarkGray);
		mBtnTabs[index].setId(index);
		mBtnTabs[index].setBackgroundColor(myColor.myWhite);
		tabWidgetMiddle.addView(mBtnTabs[index]);
		mBtnTabs[index].setOnClickListener(new myOnClickListener());
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return false;
		}
		return false;
	}
	//重写OnClickListener
	private class myOnClickListener implements OnClickListener
	{
		@Override
		public void onClick(View arg0) {
			bodyPager.setCurrentItem(arg0.getId());			
		}
		
	}
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragmentPage0 = new FragmentPage0();
			Fragment fragmentPage1 = new FragmentPage1();
			Fragment fragmentPage2 = new FragmentPage2();
			switch (position) {
			case 0:
				return fragmentPage0;
			case 1:
				return fragmentPage1;
			default:
				return fragmentPage2;
			
			}
		}

		@Override
		public int getCount() {
			return PagesCount;
		}
		
	}
	
	
}
