package jp.ht.tetujin.nikeapi.object;

import java.awt.List;

import jp.ht.tetujin.nikeapi.object.elements.ActivityObject;
import jp.ht.tetujin.nikeapi.object.elements.TagsObject;

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
public class ListActivitiesObject extends List{
	
	private static final long serialVersionUID = 1L;
	private ActivityObject[] activityObjectList;
	
	public ListActivitiesObject(JSONObject json){
		try {
			JSONArray data = json.getJSONArray("data");
			int size = data.length();
			this.activityObjectList = new ActivityObject[size];
			for(int i=0; i<size; i++){
				JSONObject obj = data.getJSONObject(i);
				this.activityObjectList[i] = new ActivityObject(obj);
			}			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public String getActivityId(int index){
		return this.activityObjectList[index].getActivityId();
	}
    
	public int getCalories(int index){
		return this.activityObjectList[index].getCalories();
	}
    
	public int getFuel(int index){
		return this.activityObjectList[index].getFuel();
	}
    
	public double getDistance(int index){
		return this.activityObjectList[index].getDistance();
	}
    
	public int getSteps(int index){
		return this.activityObjectList[index].getSteps();
	}
    
	public String getDuration(int index){
		return this.activityObjectList[index].getDuration();
	}
    
	public String getActivityType(int index){
		return this.activityObjectList[index].getActivityType();
	}
    
	public String getStartTime(int index){
		return this.activityObjectList[index].getStartTime();
	}
    
	public String getActivityTimeZone(int index){
		return this.activityObjectList[index].getActivityTimeZone();
	}
    
	public String getStatus(int index){
		return this.activityObjectList[index].getStatus();
	}
    
	public String getDeviceType(int index){
		return this.activityObjectList[index].getDeviceType();
	}
    
	public TagsObject[] getTags(int index){
		return this.activityObjectList[index].getTags();
	}
    
	public String[] getMetrics(int index){
		return this.activityObjectList[index].getMetrics();
	}
    
    public ActivityObject[] getActivityObjectList(){
    	return this.activityObjectList;
    }
    
    public ActivityObject getActivityObject(int i){
    	return this.activityObjectList[i];
    }
    
}

