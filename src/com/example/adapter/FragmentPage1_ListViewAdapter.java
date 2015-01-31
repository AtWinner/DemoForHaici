package com.example.adapter;

import com.example.demoforhaici.R;
import com.example.model.Word;
import com.example.values.myColor;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FragmentPage1_ListViewAdapter extends BaseAdapter {

	private LayoutInflater inFlater;
	private Word word = new Word();
	private int resource;// 绑定的一个条目界面的id，此例中即为item.xml
	private int ScreenWidth;
	ViewHolder holder = null;
	
	public FragmentPage1_ListViewAdapter(Context context, int res, int Width, Word word)
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
			return word.sentenceList.size();
		}
		return 0;
	}

	@Override
	public Object getItem(int position) {
		if(word != null)  
            return word.sentenceList.get(position);
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
			holder.sentence_item_number = (TextView)contentView.findViewById(R.id.sentence_item_number);
			holder.sentence_item_text = (TextView)contentView.findViewById(R.id.sentence_item_text);
			holder.sentence_item_trans = (TextView)contentView.findViewById(R.id.sentence_item_trans);
			contentView.setTag(holder);
		}
		else
		{
			holder = (ViewHolder)contentView.getTag();
		}
		if(word != null)
		{
			if(word.sentenceList.get(position).num == 0)
			{
				holder.sentence_item_number.setText(word.sentenceList.get(position).text);
				holder.sentence_item_text.setVisibility(View.GONE);
				holder.sentence_item_trans.setVisibility(View.GONE);
			}
			else
			{
				holder.sentence_item_number.setText(word.sentenceList.get(position).num+". ");
				holder.sentence_item_number.setTextColor(myColor.myDarkGray);
				int start = Integer.parseInt(word.sentenceList.get(position).s);
				int end = start + Integer.parseInt(word.sentenceList.get(position).l);
				SpannableString ss = new SpannableString(word.sentenceList.get(position).text);
				ss.setSpan(new ForegroundColorSpan(myColor.myGreen), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
				holder.sentence_item_text.setText(ss);
				
				holder.sentence_item_trans.setText(word.sentenceList.get(position).trans);
				holder.sentence_item_trans.setTextColor(myColor.myDarkGray);
			}
		}
		return contentView;
	}
	private class ViewHolder
	{
		public TextView sentence_item_number;
		public TextView sentence_item_text;
		public TextView sentence_item_trans;
	}
}
