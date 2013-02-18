package jp.ht.tetujin.nikeapi.core.object.elements;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TagsModel {

	public final String TAG_TYPES= "tagType";
	public final String TAG_VALUE= "tagValue";
	
	public String tagTypes;
	public String tagValue;
	
	public TagsModel(String tagTypes, String tagVlue){
		this.tagTypes = tagTypes;
		this.tagValue = tagVlue;
	}
	
	public TagsModel(JSONObject json){
		try {
			//TODO ここの設計は微妙
//			JSONArray names = json.names();
//			if(names.length() == 1){
//				this.tagTypes = json.getString(this.TAG_TYPES);
//			}else if(names.length() == 2){
//				this.tagValue = json.getString(this.TAG_VALUE);
//			}
			if(json.isNull(this.TAG_TYPES)!=true)this.tagTypes = json.getString(this.TAG_TYPES);
			if(json.isNull(this.TAG_VALUE)!=true)this.tagValue = json.getString(this.TAG_VALUE);
		} catch (JSONException e) {
			e.printStackTrace();
		} finally{
			System.out.println(this.tagTypes +", "+ this.tagValue);
		}
	}
}
