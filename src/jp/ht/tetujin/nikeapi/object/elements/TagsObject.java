package jp.ht.tetujin.nikeapi.object.elements;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * @author tetujin
 * @since 2013-02-18
 * @version 1.0
 */
public class TagsObject {
	public KeyNames key;
	private String tagTypes;
	private String tagValue;
	
	/**
	 * 
	 * @param tagTypes
	 * @param tagVlue
	 */
	public TagsObject(String tagTypes, String tagVlue){
		this.tagTypes = tagTypes;
		this.tagValue = tagVlue;
	}
	
	/**
	 * 
	 * @param json
	 */
	public TagsObject(JSONObject json){
		this.key = new KeyNames();
		try {
			if(json.isNull(key.TAG_TYPES)!=true)this.tagTypes = json.getString(key.TAG_TYPES);
			if(json.isNull(key.TAG_VALUE)!=true)this.tagValue = json.getString(key.TAG_VALUE);
		} catch (JSONException e) {
			e.printStackTrace();
		} finally{
			//System.out.println(this.tagTypes +", "+ this.tagValue);
		}
	}
	
	/**
	 * 
	 * @return tagType
	 */
	public String getTagTypes(){
		return this.tagTypes;
	}
	
	/**
	 * 
	 * @return tagValue
	 */
	public String getTagValue(){
		return this.tagValue;
	}
	
	/**
	 * 
	 * @author tetujin
	 *
	 */
	protected class KeyNames{
		public final String TAG_TYPES= "tagType";
		public final String TAG_VALUE= "tagValue";
	}
}
