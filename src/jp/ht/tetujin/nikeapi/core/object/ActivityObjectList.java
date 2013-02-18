package jp.ht.tetujin.nikeapi.core.object;

import java.awt.List;

import jp.ht.tetujin.nikeapi.core.object.elements.ActivityObject;
import jp.ht.tetujin.nikeapi.core.object.elements.TagsModel;

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
public class ActivityObjectList extends List{


/*
 * 
 * {"tags":[{"tagType":"TEMPERATURE","tagValue":"TEMPERATURE"},{"tagType":"EMOTION","tagValue":"GREAT"}],"status":"COMPLETE","steps":0,"activityId":"2103207964","startTime":"2013-02-17T15:49:16Z","activityTimeZone":"Asia/Tokyo","distance":0.09698000335693359,"duration":"0:00:27.194","metrics":[],"deviceType":"IPHONE","calories":7,"fuel":17,"activityType":"RUN"}
 * {"tags":[{"tagType":"NOTE","tagValue":"Home"},{"tagType":"EMOTION","tagValue":"UNSTOPPABLE"}],"status":"IN_PROGRESS","steps":9835,"activityId":"c0c6baf4-84d7-4648-b9b1-d78ad4f2734c","startTime":"2013-02-16T15:00:00Z","activityTimeZone":"Asia/Tokyo","distance":7.744079,"duration":"13:21:00.000","metrics":[],"deviceType":"FUELBAND","calories":1440,"fuel":4439,"activityType":"ALL_DAY"}
 * 
 * 
 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//public final String[] activityElements = { "activityId", "calories", "fuel", "distance", "steps", "duration", "activityType", "startTime", "activityTimeZone", "status", "deviceType", "tags", "streams"};
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
	
	public ActivityObject[] activityObjectList;
	
	public ActivityObjectList(JSONObject json){
		try {
			JSONArray data = json.getJSONArray("data");
			int size = data.length();
			this.activityObjectList = new ActivityObject[size];
			for(int i=0; i<size; i++){
				JSONObject obj = data.getJSONObject(i);
				
				//Tagの分解
				JSONArray tags = obj.getJSONArray(this.TAGS);
				int tagsSize = tags.length();
				TagsModel[] tagsmodel = new TagsModel[tagsSize];
				for(int j=0; j<tagsSize; j++){
					JSONObject tagObj = tags.getJSONObject(0);
					TagsModel tag = new TagsModel(tagObj);
					tagsmodel[j] = tag;
				}
				//TODO metricsの分解
				
				ActivityObject act = new ActivityObject(obj.getString(this.ACTIVITY_ID),
														obj.getInt(this.CALORIES),
														obj.getInt(this.FUEL),
														obj.getDouble(this.DISTANCE),
														obj.getInt(this.STEPS),
														obj.getString(this.DURATION),
														obj.getString(this.ACTIVITY_TYPE),
														obj.getString(this.START_TIME),
														obj.getString(this.ACTIVITY_TIME_ZONE),
														obj.getString(this.STATUS),
														obj.getString(this.DEVICE_TYPE),
														tagsmodel, 
														new String[3]);
				this.activityObjectList[i] = act;
			}			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getActivityId(int index){return this.activityObjectList[index].activityId;}
    public int getCalories(int index){return this.activityObjectList[index].calories;}
    public int getFuel(int index){return this.activityObjectList[index].fuel;};
    public double getDistance(int index){return this.activityObjectList[index].distance;}
    public int getSteps(int index){return this.activityObjectList[index].steps;}
    public String getDuration(int index){return this.activityObjectList[index].duration;}
    public String getActivityType(int index){return this.activityObjectList[index].activityType;}
    public String getStartTime(int index){return this.activityObjectList[index].startTime;}
    public String getActivityTimeZone(int index){return this.activityObjectList[index].activityTimeZone;}
    public String getStatus(int index){return this.activityObjectList[index].status;}
    public String getDeviceType(int index){return this.activityObjectList[index].deviceType;}
    public TagsModel[] getTags(int index){return this.activityObjectList[index].tags;}
    public String[] getMetrics(int index){return this.activityObjectList[index].metrics;}
}

