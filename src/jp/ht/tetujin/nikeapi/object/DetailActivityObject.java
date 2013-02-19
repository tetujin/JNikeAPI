package jp.ht.tetujin.nikeapi.object;

import jp.ht.tetujin.nikeapi.object.elements.MetricsObject;
import jp.ht.tetujin.nikeapi.object.elements.TagsObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * @author tetujin
 * @version 1.0
 * @since 2013-02-18
 */

public class DetailActivityObject {
	
    private double distance;
    private int steps;
    private int calories;
    private int fuel;
    private String status;
    private String duration;
    private String deviceType;
    private String activityId;
    private String startTime;
    private String activityTimeZone;
    private String activityType;    
    private MetricsObject[] metrics;
    private TagsObject[] tags;
    
    public KeyNames key;
    
	public DetailActivityObject(JSONObject json) {
		this.key = new KeyNames();
		try {
			if (!json.isNull(key.DISTANCE)) 	this.distance = json.getDouble(key.DISTANCE);
			if (!json.isNull(key.STEPS)) 		this.steps = json.getInt(key.STEPS);
			if (!json.isNull(key.CALORIES)) 	this.calories = json.getInt(key.CALORIES);
			if (!json.isNull(key.FUEL)) 		this.fuel = json.getInt(key.FUEL);
			if (!json.isNull(key.STATUS))		this.status = json.getString(key.STATUS);
			if (!json.isNull(key.DURATION)) 	this.duration = json.getString(key.DURATION);
			if (!json.isNull(key.DEVICE_TYPE)) 	this.deviceType = json.getString(key.DEVICE_TYPE);
			if (!json.isNull(key.ACTIVITY_ID)) 	this.activityId = json.getString(key.ACTIVITY_ID);
			if (!json.isNull(key.START_TIME)) 	this.startTime = json.getString(key.START_TIME);
			if (!json.isNull(key.ACTIVITY_TYPE))this.activityType = json.getString(key.ACTIVITY_TYPE);
			if (!json.isNull(key.ACTIVITY_TIME_ZONE)) this.activityTimeZone = json.getString(key.ACTIVITY_TIME_ZONE);
			//metrics
			if (!json.isNull(key.METRICS)){
				JSONArray array = json.getJSONArray(key.METRICS);
				int size = array.length();
				this.metrics = new MetricsObject[size];
				for(int i=0; i<size; i++){
					this.metrics[0] = new MetricsObject(array.getJSONObject(i));
				}
			}
			//tags
			if (!json.isNull(key.TAGS)){
				JSONArray array = json.getJSONArray(key.TAGS);
				int size = array.length();
				this.tags = new TagsObject[size];
				for(int i=0; i<size; i++){
					this.tags[0] = new TagsObject(array.getJSONObject(i));
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

    public TagsObject[] getTags(){return this.tags;}
    public MetricsObject[] getMetrics(){return this.metrics; }
    public int 		   getSteps(){return this.steps; }
    public int 		   getCalories(){return this.calories;}
    public int 		   getFuel(){return this.fuel;}
    public double 	   getDistance(){return this.distance; }
    public String 	   getStatus(){return this.status;}
    public String 	   getActivityId(){return this.activityId; }
    public String 	   getStartTime(){return this.startTime; }
    public String 	   getActivityTimeZone(){return this.activityTimeZone; }
    public String 	   getDuration(){return this.duration; }
    public String 	   getDeviceType(){return this.deviceType; }
    public String 	   getActivityType(){return this.activityType;}
	
	
	protected class KeyNames{
		public final String TAGS = "tags";
	    public final String STATUS = "status";
	    public final String STEPS = "steps";
	    public final String ACTIVITY_ID = "activityId";
	    public final String START_TIME = "startTime";
	    public final String ACTIVITY_TIME_ZONE = "activityTimeZone";
	    public final String DISTANCE = "distance";
	    public final String DURATION = "duration";
	    public final String METRICS = "metrics";
	    public final String DEVICE_TYPE = "deviceType";
	    public final String CALORIES = "calories";
	    public final String FUEL =  "fuel";
	    public final String ACTIVITY_TYPE = "activityType";	
	}
}
