package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.data.AnalyzeJson;
import com.example.demoforhaici.R;
import com.example.model.Word;

public class FragmentPage1 extends Fragment
{
	public final int ARG_SECTION_NUMBER =1;
	
	private Word myWord;

    public FragmentPage1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	Log.e("OnCreateView", this.toString());
        View rootView = inflater.inflate(R.layout.fragment_page1, container, false);
        AnalyzeJson json = new AnalyzeJson("");
        myWord = json.GetTencentInfoByJson();
        Context context = getActivity();
        ListView fragment_page1_List = (ListView)rootView.findViewById(R.id.fragment_page1_List);
        FragmentPage1_ListViewAdapter adapter = new FragmentPage1_ListViewAdapter(context, R.layout.sentence_item, 1024, myWord);
        fragment_page1_List.setAdapter(adapter);
        
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