package com.example.model;

import java.util.ArrayList;

public class Word 
{
	public String item;
	public phonetic myPhonetic;
	public base_def [] mybase_def;
	public sentence [] mySentence;
	public ArrayList<Sens> sentenceList;
	public ArrayList<vocabulary>vocabularyList;
	public Word()
	{
		item = "";
		myPhonetic = new phonetic();
	}
	/**
	 * 初始化mybase_def
	 * @param count
	 */
	public void setBaseDef(int count)
	{
		mybase_def = new base_def[count];
		for(int i = 0; i < count; i++)
		{
			mybase_def[i] = new base_def();
		}
	}
	public void setmySentence(int count)
	{
		mySentence = new sentence[count];
		for(int i = 0; i < count; i++)
		{
			mySentence[i] = new sentence();
		}
	}
	public void setSentenceList(ArrayList<Sens> list)
	{
		sentenceList = list;
	}
	public void setVocabularyList(ArrayList<vocabulary> list)
	{
		vocabularyList = list;
	}
}
