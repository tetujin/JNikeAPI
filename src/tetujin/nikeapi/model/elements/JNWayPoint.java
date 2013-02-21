package tetujin.nikeapi.model.elements;

import org.json.JSONException;
import org.json.JSONObject;

public class JNWayPoint {
	
	private double elevation;
	private double longitude;
	private double latitude;
	
	private KeyNames key;
	
	public JNWayPoint(JSONObject json) {
		this.key = new KeyNames();
		try {
			if(!json.isNull(key.ELEVATION))this.elevation = json.getDouble(key.ELEVATION);
			if(!json.isNull(key.LATITUDE))this.latitude = json.getDouble(key.LATITUDE);
			if(!json.isNull(key.LONGITUDE))this.longitude = json.getDouble(key.LONGITUDE);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public double getElevation(){
		return this.elevation;
	}
	
	public double getLongitude(){
		return this.longitude;
	}
	
	public double getLatitude(){
		return this.latitude;
	}
	
	public KeyNames getKeyNames(){
	    return this.key;
	}
	
	private class KeyNames{
        public final String ELEVATION = "elevation";
        public final String LONGITUDE = "longitude";
        public final String LATITUDE  = "latitude";
	}
}
