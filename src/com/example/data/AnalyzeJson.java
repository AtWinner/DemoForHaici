package com.example.data;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.example.model.Sens;
import com.example.model.Word;
import com.example.model.sentence;
import com.example.model.vocabulary;

public class AnalyzeJson
{
	private String JsonStr;
	
	public AnalyzeJson(String json)
	{
		JsonStr = json;
		JsonStr = "{'item':'as','phonetic':{'ap':{'yp':'əz','sy':'nec_1_78872_1'},'ep':{'yp':'əz','sy':'nec_1_78872_0'}},'base_def':[{'cx':'adv.','def':'同样地；例如；被认为'},{'cx':'prep.','def':'作为；如同'},{'cx':'conj.','def':'因为；像；当...之时；像...一样；结果；尽管'},{'cx':'n.','def':'阿斯（古罗马重量单位，约373克；古罗马铜币名）'}],'sentence':[{'cx':'adv.','sens':[{'text':'Many things pollute water, such as tires, trash, and plastic bags.','trans':'很多东西使水污染，例如轮胎、垃圾和塑胶袋。','s':32,'l':2},{'text':'This cathedral was regarded as a miracle in architectural history.','trans':'这座大教堂被认为是建筑史上的奇迹。','s':28,'l':2}]},{'cx':'prep.','sens':[{'text':'As a cub reporter he would learn the facts of life in the newspaper world.','trans':'作为一名初出茅庐的记者，他要了解报界生涯的内幕。','s':0,'l':2},{'text':'Just as writing a fiction,programming is a process of creating art.','trans':'如同写小说一样，程序设计也是一个艺术创造的过程。','s':5,'l':2}]}],'vocabulary':[{'cx':'adv.','v':[{'title':'～+形容词+as+名词','v':[{'text':'as alike as chalk and cheese','trans':'本质上完全两样的，截然不同的'},{'text':'as big as life','trans':'(画像等)与原物一样大的；千真万确的'},{'text':'as black as a raven','trans':'像乌鸦一般黑'}]},{'title':'～+副词+as','v':[{'text':'as much as','trans':'像…那么多，多达；实际上差不多'},{'text':'as much...as','trans':'和…同样多的；和…一样，正如'}]}]},{'cx':'prep.','v':[{'title':'动词+～','v':[{'text':'mutton dressed as lamb','trans':'打扮得像少妇一样的老妇人（或中年妇女）'},{'text':'pass as','trans':'充作，被看作，被当作'},{'text':'pass as a watch in the night','trans':'很快被忘却'}]},{'title':'动词+副词+～','v':[{'text':'come across as','trans':'〈非正〉似乎是，看上去好像是'},{'text':'pass sb off as','trans':'使假扮成，使冒充'}]}]}]}";
	}
	public Word GetTencentInfoByJson()
	{
		Word word = new Word();
		try 
		{
			JSONObject myJson = new JSONObject(JsonStr);
			word.item = myJson.getString("item");
			JSONObject phoneticJson = myJson.getJSONObject("phonetic");
			word.myPhonetic.ap_yp = phoneticJson.getJSONObject("ap").getString("yp");
			word.myPhonetic.ap_sy = phoneticJson.getJSONObject("ap").getString("sy");
			word.myPhonetic.ep_yp = phoneticJson.getJSONObject("ep").getString("yp");
			word.myPhonetic.ep_sy = phoneticJson.getJSONObject("ep").getString("sy");
			JSONArray base_defJson = myJson.getJSONArray("base_def");
			int count_base_def = base_defJson.length();
			//初始化
			word.setBaseDef(count_base_def);
			for(int base_defIndex = 0; base_defIndex < count_base_def; base_defIndex++)
			{
				word.mybase_def[base_defIndex].cx = base_defJson.getJSONObject(base_defIndex).getString("cx");
				word.mybase_def[base_defIndex].def = base_defJson.getJSONObject(base_defIndex).getString("def");
			}
			JSONArray sentenceJson = myJson.getJSONArray("sentence");
			int count_sentence = sentenceJson.length();
			//初始化 下面是例句
			word.setmySentence(count_sentence);
			ArrayList<Sens> list = new ArrayList<Sens>();
			for(int sentenceIndex = 0; sentenceIndex < count_sentence; sentenceIndex++)
			{
				word.mySentence[sentenceIndex].cx = sentenceJson.getJSONObject(sentenceIndex).getString("cx");
				Sens sen0 = new Sens();
				sen0.text = sentenceJson.getJSONObject(sentenceIndex).getString("cx");
				list.add(sen0);
				
				JSONArray sentence_sensJson =sentenceJson.getJSONObject(sentenceIndex).getJSONArray("sens");
				int count_sentence_sensJson = sentence_sensJson.length();
				//初始化
				word.mySentence[sentenceIndex].setSens(count_sentence_sensJson);
				for(int sentence_sensIndex = 0; sentence_sensIndex < count_sentence_sensJson; sentence_sensIndex++)
				{
					word.mySentence[sentenceIndex].sens[sentence_sensIndex].text=sentence_sensJson.getJSONObject(sentence_sensIndex).getString("text");
					word.mySentence[sentenceIndex].sens[sentence_sensIndex].trans=sentence_sensJson.getJSONObject(sentence_sensIndex).getString("trans");
					word.mySentence[sentenceIndex].sens[sentence_sensIndex].l=sentence_sensJson.getJSONObject(sentence_sensIndex).getString("l");
					word.mySentence[sentenceIndex].sens[sentence_sensIndex].s=sentence_sensJson.getJSONObject(sentence_sensIndex).getString("s");
					word.mySentence[sentenceIndex].sens[sentence_sensIndex].num = sentence_sensIndex + 1;
					list.add(word.mySentence[sentenceIndex].sens[sentence_sensIndex]);
				}
			}
			word.setSentenceList(list);
			//下面是讲解
			JSONArray vocabularyJson = myJson.getJSONArray("vocabulary");
			int count_vocabulary = vocabularyJson.length();
			ArrayList< vocabulary> vocabularyList = new ArrayList<vocabulary>();
			for(int vocabularyFirst = 0; vocabularyFirst < count_vocabulary; vocabularyFirst++)
			{
				vocabulary cx = new vocabulary();
				cx.layer = 0;
				cx.num = 0;
				cx.text = vocabularyJson.getJSONObject(vocabularyFirst).getString("cx");
				vocabularyList.add(cx);
				JSONArray vocabulary_v_Json = vocabularyJson.getJSONObject(vocabularyFirst).getJSONArray("v");
				int count_vocabulary_v = vocabulary_v_Json.length();
				for(int vocabularySecond = 0; vocabularySecond < count_vocabulary_v; vocabularySecond++)
				{
					vocabulary title = new vocabulary();
					title.layer = 1;
					title.num = 0;
					title.text = vocabulary_v_Json.getJSONObject(vocabularySecond).getString("title");
					vocabularyList.add(title);
					JSONArray vocabulary_v_v_Json = vocabulary_v_Json.getJSONObject(vocabularySecond).getJSONArray("v");
					int count_vocabulary_v_v = vocabulary_v_v_Json.length();
					for(int vocabularyThird = 0; vocabularyThird < count_vocabulary_v_v; vocabularyThird++)
					{
						vocabulary innerText = new vocabulary();
						innerText.layer = 2;
						innerText.num = vocabularyThird + 1;
						innerText.text = vocabulary_v_v_Json.getJSONObject(vocabularyThird).getString("text");
						innerText.trans = vocabulary_v_v_Json.getJSONObject(vocabularyThird).getString("trans");
						vocabularyList.add(innerText);
					}
				}
			}
			word.setVocabularyList(vocabularyList);
		}
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
		
		return word;
		
	}
}
