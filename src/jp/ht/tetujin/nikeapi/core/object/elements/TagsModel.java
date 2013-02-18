package jp.ht.tetujin.nikeapi.core.object.elements;

import org.json.JSONException;
import org.json.JSONObject;

public class TagsModel {

	
	private String tagTypes;
	private String tagValue;
	
	public KeyNames key;
	
	public TagsModel(String tagTypes, String tagVlue){
		this.tagTypes = tagTypes;
		this.tagValue = tagVlue;
	}
	
	public TagsModel(JSONObject json){
		this.key = new KeyNames();
		try {
			if(json.isNull(key.TAG_TYPES)!=true)this.tagTypes = json.getString(key.TAG_TYPES);
			if(json.isNull(key.TAG_VALUE)!=true)this.tagValue = json.getString(key.TAG_VALUE);
		} catch (JSONException e) {
			e.printStackTrace();
		} finally{
			System.out.println(this.tagTypes +", "+ this.tagValue);
		}
	}
	
	public String getTagTypes(){
		return this.tagTypes;
	}
	
	public String getTagValue(){
		return this.tagValue;
	}
	
	
	protected class KeyNames{
		public final String TAG_TYPES= "tagType";
		public final String TAG_VALUE= "tagValue";
	}
}
