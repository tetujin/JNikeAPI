package jp.ht.tetujin.nikeapi.object.elements;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



/**
 * 
 * @author tetujin
 * @since 2013-02-18
 * @version 1.0
 *
 */
public class ActivityObject {
	
	private String activityId;
    private int calories;
    private int fuel;
    private double distance;
    private int steps;
    private String duration;
    private String activityType;
    private String startTime;
    private String activityTimeZone;
    private String status;
    private String deviceType;
    private TagsObject[] tags;
    private String[] metrics;
    
    public KeyNames key;
    	
    public ActivityObject(JSONObject obj) {
    	this.key = new KeyNames();
		try {		
			if(!obj.isNull(key.ACTIVITY_ID))		this.activityId 	= obj.getString(this.key.ACTIVITY_ID);
			if(!obj.isNull(key.DURATION))			this.duration 		= obj.getString(this.key.DURATION);
			if(!obj.isNull(key.ACTIVITY_TYPE))		this.activityType	= obj.getString(this.key.ACTIVITY_TYPE);
			if(!obj.isNull(key.START_TIME))			this.startTime 		= obj.getString(this.key.START_TIME);
			if(!obj.isNull(key.ACTIVITY_TIME_ZONE))	this.activityTimeZone = obj.getString(this.key.ACTIVITY_TIME_ZONE);
			if(!obj.isNull(key.STATUS))				this.status 		= obj.getString(this.key.STATUS);
			if(!obj.isNull(key.DEVICE_TYPE))		this.deviceType 	= obj.getString(this.key.DEVICE_TYPE);
			if(!obj.isNull(key.CALORIES))			this.calories 		= obj.getInt(this.key.CALORIES);
			if(!obj.isNull(key.FUEL))				this.fuel 			= obj.getInt(this.key.FUEL);
			if(!obj.isNull(key.STEPS))				this.steps 			= obj.getInt(this.key.STEPS);
			if(!obj.isNull(key.DISTANCE))			this.distance 		= obj.getDouble(this.key.DISTANCE);
			if(!obj.isNull(key.TAGS)){
				//Tagの分解
				JSONArray tags = obj.getJSONArray(this.key.TAGS);
				int tagsSize = tags.length();
				TagsObject[] tagsmodel = new TagsObject[tagsSize];
				for(int j=0; j<tagsSize; j++){
					JSONObject tagObj = tags.getJSONObject(j);
					tagsmodel[j]= new TagsObject(tagObj);
				}
				this.tags = tagsmodel;
			}
			this.metrics = new String[3];
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
    
	public String getActivityId(){
		return this.activityId;
	}
	
    public int getCalories(){
    	return this.calories;
    }
    
    public int getFuel(){
    	return this.fuel;
    }
    
    public double getDistance(){
    	return this.distance;
    }
    
    public int getSteps(){
    	return this.steps;
    }
    
    public String getDuration(){
    	return this.duration;
    }
    
    public String getActivityType(){
    	return this.activityType;
    }
    
    public String getStartTime(){
    	return this.startTime;
    }
    
    public String getActivityTimeZone(){
    	return this.activityTimeZone;
    }
    
    public String getStatus(){
    	return this.status;
    }
    
    public String getDeviceType(){
    	return this.deviceType;
    }
    public TagsObject[] getTags(){
    	return this.tags;
    }
    
    public String[] getMetrics(){
    	return this.metrics;
    }
    
    
	protected class KeyNames{
    	private final String STATUS = "status";
        private final String STEPS = "steps";
        private final String ACTIVITY_ID = "activityId";
        private final String START_TIME = "startTime";
        private final String ACTIVITY_TIME_ZONE = "activityTimeZone";
        private final String DISTANCE = "distance";
        private final String DURATION = "duration";
        private final String METRICS= "metrics";
        private final String DEVICE_TYPE = "deviceType";
        private final String CALORIES = "calories";
        private final String FUEL= "fuel";
        private final String ACTIVITY_TYPE = "activityType";
        private final String TAGS = "tags";
    }
}
