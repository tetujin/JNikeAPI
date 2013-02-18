package jp.ht.tetujin.nikeapi.core.object.elements;

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
	
	public String activityId;
    public int calories;
    public int fuel;
    public double distance;
    public int steps;
    public String duration;
    public String activityType;
    public String startTime;
    public String activityTimeZone;
    public String status;
    public String deviceType;
    public TagsObject[] tags;
    public String[] metrics;
    
    public KeyNames key;
    	
    public ActivityObject(JSONObject obj) {
    	this.key = new KeyNames();
		try {
		//Tagの分解
			JSONArray tags = obj.getJSONArray(this.key.TAGS);
			int tagsSize = tags.length();
			TagsObject[] tagsmodel = new TagsObject[tagsSize];
			for(int j=0; j<tagsSize; j++){
				JSONObject tagObj = tags.getJSONObject(j);
				tagsmodel[j]= new TagsObject(tagObj);
			}
			
			
			this.activityId = obj.getString(this.key.ACTIVITY_ID);
			this.calories = obj.getInt(this.key.CALORIES);
			this.fuel = obj.getInt(this.key.FUEL);
			this.distance = obj.getDouble(this.key.DISTANCE);
			this.steps = obj.getInt(this.key.STEPS);
			this.duration = obj.getString(this.key.DURATION);
			this.activityType = obj.getString(this.key.ACTIVITY_TYPE);
			this.startTime = obj.getString(this.key.START_TIME);
			this.activityTimeZone = obj.getString(this.key.ACTIVITY_TIME_ZONE);
			this.status = obj.getString(this.key.STATUS);
			this.deviceType = obj.getString(this.key.DEVICE_TYPE);
			this.tags = tagsmodel;
			this.metrics = new String[3];
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
    
	protected class KeyNames{
    	public final String STATUS = "status";
        public final String STEPS = "steps";
        public final String ACTIVITY_ID = "activityId";
        public final String START_TIME = "startTime";
        public final String ACTIVITY_TIME_ZONE = "activityTimeZone";
        public final String DISTANCE = "distance";
        public final String DURATION = "duration";
        public final String METRICS= "metrics";
        public final String DEVICE_TYPE = "deviceType";
        public final String CALORIES = "calories";
        public final String FUEL= "fuel";
        public final String ACTIVITY_TYPE = "activityType";
        public final String TAGS = "tags";
    }
}
