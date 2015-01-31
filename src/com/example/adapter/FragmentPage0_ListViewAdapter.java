package com.example.adapter;

import com.example.demoforhaici.R;
import com.example.model.Word;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FragmentPage0_ListViewAdapter extends BaseAdapter {

	private LayoutInflater inFlater;
	private Word word = new Word();
	private int resource;// 绑定的一个条目界面的id，此例中即为item.xml
	private int ScreenWidth;
	ViewHolder holder = null;
	
	public FragmentPage0_ListViewAdapter(Context context, int res, int Width, Word word)
	{
		inFlater = LayoutInflater.from(context);
		resource = res;
		ScreenWidth = Width;
		this.word = word;
	}
	@Override
	public int getCount() {
		if(word!=null)  
            return word.mybase_def.length;
        else 
            return 0;  
	}

	@Override
	public Object getItem(int position) {
		if(word!=null)  
            return word.mybase_def[position];
        else 
            return null;  
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View contentView, ViewGroup parent) 
	{
		if (contentView == null)
		{// 显示第一页的时候convertView为空
			contentView = inFlater.inflate(resource, null);// 生成条目对象
			holder = new ViewHolder();
			holder.base_def_cx = (TextView)contentView.findViewById(R.id.base_def_cx);
			holder.base_def_def = (TextView)contentView.findViewById(R.id.base_def_def);
			contentView.setTag(holder);
		}
		else
		{
			holder = (ViewHolder)contentView.getTag();
		}
		holder.base_def_cx.setText(word.mybase_def[position].cx);
		holder.base_def_def.setText(word.mybase_def[position].def);
		
		return contentView;
	}
	private class ViewHolder
	{
		public TextView base_def_cx;
		public TextView base_def_def;
	}
}
