package tetujin.nikeapi.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import tetujin.nikeapi.model.elements.JNWayPoint;

/**
 * 
 * @author tetujin
 * @since 2013-02-21
 * @version 1.2
 *
 */

public class GPSData {

	private double elevationGain;
	private double elevationLoss;
	private double elevationMin;
	private double elevationMax;
	private int intervalMetric;
	private String intervalUnit;
	private JNWayPoint[] waypoints;
	
	private KeyNames key;
	
	public GPSData(JSONObject json){
		this.key = new KeyNames();
		try {
			if(!json.isNull(key.ELEVATION_GAIN)) this.elevationGain=json.getDouble(key.ELEVATION_GAIN);
			if(!json.isNull(key.ELEVATION_LOSS)) this.elevationLoss=json.getDouble(key.ELEVATION_LOSS);
			if(!json.isNull(key.ELEVATION_MAX)) this.elevationMax = json.getDouble(key.ELEVATION_MAX);
			if(!json.isNull(key.ELEVATION_MIN)) this.elevationMin = json.getDouble(key.ELEVATION_MIN);
			if(!json.isNull(key.INTERVAL_METRIC)) this.intervalMetric = json.getInt(key.INTERVAL_METRIC);
			if(!json.isNull(key.INTERVAL_UNIT)) this.intervalUnit = json.getString(key.INTERVAL_UNIT);
			if(!json.isNull(key.WAYPOINTS)){
				JSONArray array = json.getJSONArray(key.WAYPOINTS);
				int size = array.length();
				this.waypoints = new JNWayPoint[size];
				for(int i=0; i<size; i++){
					this.waypoints[i] = new JNWayPoint(array.getJSONObject(i));
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public double getElevationGain(){
		return this.elevationGain;
	}
	
	public double getElevationLoss(){
		return this.elevationLoss;
	}
	
	public double getElevationMin(){
		return this.elevationMin;
	}
	
	public double getElevationMax(){
		return this.elevationMax;
	}
	
	public int getIntervalMetric(){
		return this.intervalMetric;
	}
	
	public String getIntervalUnit(){
		return this.intervalUnit;
	}
	
	public JNWayPoint[] getWaypoints(){
		return this.waypoints;
	}
	
	public KeyNames getKeyNames(){
	    return this.key;
	}
	
	private class KeyNames{
	    public final String ELEVATION_GAIN = "elevationGain";
	    public final String ELEVATION_LOSS = "elevationLoss";
	    public final String INTERVAL_METRIC = "intervalMetric";
	    public final String WAYPOINTS = "waypoints";
	    public final String ELEVATION_MIN = "elevationMin";
	    public final String ELEVATION_MAX = "elevationMax";
	    public final String INTERVAL_UNIT = "intervalUnit";
	}
}
