package com.example.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.data.AnalyzeJson;
import com.example.demoforhaici.R;
import com.example.model.Word;

@SuppressLint("ValidFragment")
public class FragmentPage0 extends Fragment
{
	public final int ARG_SECTION_NUMBER =0;
	
	private Word myWord;

    public FragmentPage0() {
    }
    public FragmentPage0(int a) {
    }
    /**
     * 设置Word对象
     * @param word
     */
    public void setWord(Word word)
    {
    	myWord = word;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	Log.e("OnCreateView", this.toString());
        View rootView = inflater.inflate(R.layout.fragment_page0, container, false);
        Context context = getActivity();
        ListView fragment_page0_List = (ListView)rootView.findViewById(R.id.fragment_page0_List);
        AnalyzeJson json = new AnalyzeJson("");
        myWord = json.GetTencentInfoByJson();
        fragment_page0_List.setAdapter(new FragmentPage0_ListViewAdapter(context, R.layout.base_def_list_item, 1024, myWord));
        
        return rootView;
    }
    
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		Log.e("OnActivityCreated", this.toString());
		super.onActivityCreated(savedInstanceState);
	}
	@Override
	public void onAttach(Activity activity) {
		Log.e("OnAttach", this.toString());
		super.onAttach(activity);
	}
	@Override
	public void onDestroyView() {
		Log.e("OnDestroyView", this.toString());
		super.onDestroyView();
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.e("OnCreate", this.toString());
		super.onCreate(savedInstanceState);
	}
	@Override
	public void onDestroy() {
		Log.e("OnDestroy", this.toString());
		super.onDestroy();
	}
	@Override
	public void onDetach() {
		Log.e("OnDetach", this.toString());
		super.onDetach();
	}
	@Override
	public void onPause() {
		Log.e("OnPause", this.toString()); 
		super.onPause();
	}
	@Override
	public void onResume() {
		Log.e("OnResume", this.toString());
		super.onResume();
	}
	@Override
	public void onStart() {
		Log.e("OnStart", this.toString());
		super.onStart();
	}
	@Override
	public void onStop() {
		Log.e("OnStop", this.toString());
		super.onStop();
	}
    
}
