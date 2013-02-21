package tetujin.nikeapi.model.elements;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * @author tetujin
 * @since 2013-02-18
 * @version 1.0
 *
 */
public class JNAllSummary {
	
	public final static String EXPERIENCE_TYPE = "ALL";
	
	private int lifetimeFuel;
	private KeyName key;
	
	public JNAllSummary(JSONObject json){
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
	
	public KeyName getKeyNames(){
	    return this.key;
	}
	
	
	private class KeyName{
		public final String LIFETIME_FUEL = "lifetimeFuel";
	}
	
	private class HeadKeyName{
		public final String EXPERIENCE_TYPE = "experienceType";
		public final String RECORDS = "records";
	}

}
