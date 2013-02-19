package jp.ht.tetujin.nikeapi.object.elements;

import org.json.JSONException;
import org.json.JSONObject;

public class WayPointObject {
	
	private double elevation;
	private double longitude;
	private double latitude;
	
	public KeyNames key;
	
	public WayPointObject(JSONObject json) {
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
	
	protected class KeyNames{
        public final String ELEVATION = "elevation";
        public final String LONGITUDE = "longitude";
        public final String LATITUDE  = "latitude";
	}
}
