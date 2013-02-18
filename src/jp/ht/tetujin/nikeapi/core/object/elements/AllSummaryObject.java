package jp.ht.tetujin.nikeapi.core.object.elements;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * @author tetujin
 * @since 2013-02-18
 * @version 1.0
 *
 */
public class AllSummaryObject {
	
	public final static String EXPERIENCE_TYPE = "ALL";
	
	private int lifetimeFuel;
	public KeyName key;
	
	public AllSummaryObject(JSONObject json){
		this.key = new KeyName();
		try {
			if(!json.isNull(key.LIFETIME_FUEL))this.lifetimeFuel = json.getInt(key.LIFETIME_FUEL);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public int getLifetimeFuel(){
		return this.lifetimeFuel;
	}
	
	protected class KeyName{
		public final String LIFETIME_FUEL = "lifetimeFuel";
	}
	
	protected class HeadKeyName{
		public final String EXPERIENCE_TYPE = "experienceType";
		public final String RECORDS = "records";
	}

}
