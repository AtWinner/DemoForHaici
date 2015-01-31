package com.example.adapter;

import com.example.demoforhaici.R;
import com.example.model.Word;
import com.example.values.myColor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FragmentPage2_ListViewAdapter extends BaseAdapter
{
	private LayoutInflater inFlater;
	private Word word = new Word();
	private int resource;// 绑定的一个条目界面的id，此例中即为item.xml
	private int ScreenWidth;
	ViewHolder holder = null;
	
	public FragmentPage2_ListViewAdapter(Context context, int res, int Width, Word word)
	{
		inFlater = LayoutInflater.from(context);
		resource = res;
		ScreenWidth = Width;
		this.word = word;
	}
	
	@Override
	public int getCount() {
		if(word != null)
		{
			return word.vocabularyList.size();
		}
		return 0;
	}

	@Override
	public Object getItem(int position) {
		if(word != null)  
            return word.vocabularyList.get(position);
        else 
            return null;  
	}

	@Override
	public long getItemId(int arg0) {
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
			holder.vocabulary_item_number = (TextView)contentView.findViewById(R.id.vocabulary_item_number);
			holder.vocabulary_item_text = (TextView)contentView.findViewById(R.id.vocabulary_item_text);
			holder.vocabulary_item_trans = (TextView)contentView.findViewById(R.id.vocabulary_item_trans);
			contentView.setTag(holder);
		}
		else
		{
			holder = (ViewHolder)contentView.getTag();
		}
		if(word != null)
		{
			switch (word.vocabularyList.get(position).layer) {
			case 1:
				holder.vocabulary_item_number.setTextColor(myColor.myGreen);
			case 0:
				holder.vocabulary_item_number.setText(word.vocabularyList.get(position).text);
				holder.vocabulary_item_text.setVisibility(View.GONE);
				holder.vocabulary_item_trans.setVisibility(View.GONE);
				break;
			case 2:
				holder.vocabulary_item_number.setText(word.vocabularyList.get(position).num +". ");
				holder.vocabulary_item_number.setTextColor(myColor.myDarkGray);
				holder.vocabulary_item_text.setText(word.vocabularyList.get(position).text);
				holder.vocabulary_item_trans.setText(word.vocabularyList.get(position).trans);
				holder.vocabulary_item_trans.setTextColor(myColor.myDarkGray);
				holder.vocabulary_item_number.setVisibility(View.VISIBLE);
				holder.vocabulary_item_text.setVisibility(View.VISIBLE);
				holder.vocabulary_item_trans.setVisibility(View.VISIBLE);
				
				break;
			}
		}
		return contentView;
	}
	private class ViewHolder
	{
		public TextView vocabulary_item_number;
		public TextView vocabulary_item_text;
		public TextView vocabulary_item_trans;
	}
}
