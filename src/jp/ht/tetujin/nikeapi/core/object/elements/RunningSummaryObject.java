package jp.ht.tetujin.nikeapi.core.object.elements;

import org.json.JSONException;
import org.json.JSONObject;

public class RunningSummaryObject {
	
	public static final String EXPERIENCE_TYPE = "RUNNING";
	
	private int level;
	private String lifetimeDuration;
	private int lifetimeGpsRuns;
	private int lifetimeHeartActivities;
	private double lifetimeAveragePace;
    
	public KeyNames key;
	
    public RunningSummaryObject(JSONObject json){	
    	this.key = new KeyNames();
    	try {
			if(!json.isNull(key.LEVEL))this.level = json.getInt(key.LEVEL);
	    	if(!json.isNull(key.LIFETIME_DURATION))this.lifetimeDuration = json.getString(key.LIFETIME_DURATION);
	    	if(!json.isNull(key.LIFETIME_GPS_RUNS))this.lifetimeGpsRuns = json.getInt(key.LIFETIME_GPS_RUNS);
	    	if(!json.isNull(key.LIFETIME_HEART_ACTIVITIES))this.lifetimeHeartActivities = json.getInt(key.LIFETIME_HEART_ACTIVITIES);
	    	if(!json.isNull(key.LIFETIME_AVERAGE_PACE))this.lifetimeAveragePace = json.getDouble(key.LIFETIME_AVERAGE_PACE);
		} catch (JSONException e) {
			e.printStackTrace();
		}
    }
    
    
	public int getLevel(){
		return this.level;
	}
	
	public String getLifetimeDuration(){
		return this.lifetimeDuration;
	}
	
	public int getLifetimeGpsRuns(){
		return this.lifetimeGpsRuns;
	}
	
	public int getLifetimeHeartActivities(){
		return this.lifetimeHeartActivities;
	}
	
	public double getLifetimeAveragePace(){
		return this.lifetimeAveragePace;
	}
    
    protected class KeyNames{
    	public final String LEVEL = "level";
    	public final String LIFETIME_DURATION = "lifetimeDuration";
    	public final String LIFETIME_GPS_RUNS = "lifetimeGpsRuns";
    	public final String LIFETIME_HEART_ACTIVITIES = "lifetimeHeartActivities";
    	public final String LIFETIME_AVERAGE_PACE = "lifetimeAveragePace";
    }
}
