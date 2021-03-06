package tetujin.nikeapi.model.elements;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * @author tetujin
 * @since 2013-02-18
 * @version 1.0
 */
public class JNTags {
	private KeyNames key;
	private String tagTypes;
	private String tagValue;
	
	/**
	 * 
	 * @param tagTypes
	 * @param tagVlue
	 */
	public JNTags(String tagTypes, String tagVlue){
		this.tagTypes = tagTypes;
		this.tagValue = tagVlue;
	}
	
	/**
	 * 
	 * @param json
	 */
	public JNTags(JSONObject json){
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
	 * @return ClassOfKeyNames
	 */
	public KeyNames getKeyNames(){
	    return this.key;
	}
	
	/**
	 * 
	 * @author tetujin
	 *
	 */
	private class KeyNames{
		public final String TAG_TYPES= "tagType";
		public final String TAG_VALUE= "tagValue";
	}
}
