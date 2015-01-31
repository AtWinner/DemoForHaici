package com.example.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
        View rootView = inflater.inflate(R.layout.fragment_page1, container, false);
        AnalyzeJson json = new AnalyzeJson("");
        myWord = json.GetTencentInfoByJson();
        Context context = getActivity();
        ListView fragment_page1_List = (ListView)rootView.findViewById(R.id.fragment_page1_List);
        FragmentPage1_ListViewAdapter adapter = new FragmentPage1_ListViewAdapter(context, R.layout.sentence_item, 1024, myWord);
        fragment_page1_List.setAdapter(adapter);
        
        return rootView;
    }
}