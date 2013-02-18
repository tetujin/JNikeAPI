package jp.ht.tetujin.nikeapi.core.object.elements;

import org.json.JSONException;
import org.json.JSONObject;

public class FuelSummaryObject {
	
	public final static String EXPERIENCE_TYPE = "FUELBAND";
	
	private int dailyGoalTargetValue;
    private int currentStreak;
    private int totalDailyGoalsAchieved;
    private int lifetimeAverageFuelDay;
    private int lifetimeAverageFuelWeek;
    private int lifetimeAverageFuelMonth;
    private int numOfActivities;
    
    public KeyNames key;
    
    public FuelSummaryObject(JSONObject json){
    	
    	this.key = new KeyNames();
    	try {
			if(!json.isNull(key.DAILY_GOAL_TARGET_VALUE))this.dailyGoalTargetValue = json.getInt(key.DAILY_GOAL_TARGET_VALUE);
	    	if(!json.isNull(key.CURRENT_STREAK))this.currentStreak = json.getInt(key.CURRENT_STREAK);
	    	if(!json.isNull(key.TOTAL_DAILY_GOALS_ACHIEVED))this.totalDailyGoalsAchieved = json.getInt(key.TOTAL_DAILY_GOALS_ACHIEVED);
	    	if(!json.isNull(key.LIFETIME_AVERAGE_FUEL_DAY))this.lifetimeAverageFuelDay = json.getInt(key.LIFETIME_AVERAGE_FUEL_DAY);
	    	if(!json.isNull(key.LIFETIME_AVERAGE_FUEL_WEEK))this.lifetimeAverageFuelWeek = json.getInt(key.LIFETIME_AVERAGE_FUEL_WEEK);
	    	if(!json.isNull(key.LIFETIME_AVERAGE_FUEL_MONTH))this.lifetimeAverageFuelMonth = json.getInt(key.LIFETIME_AVERAGE_FUEL_MONTH);
	    	if(!json.isNull(key.NUM_OF_ACTIVITIES))this.numOfActivities= json.getInt(key.NUM_OF_ACTIVITIES);
		} catch (JSONException e) {
			e.printStackTrace();
		}
    }
    
	public int getDailyGoalTargetValue(){
		return this.dailyGoalTargetValue;
	}
	
    public int getCurrentStreak(){
    	return this.currentStreak;
    }
    
    public int getTotalDailyGoalsAchieved(){
    	return this.totalDailyGoalsAchieved;
    }
    
    public int getLifetimeAverageFuelDay(){
    	return this.lifetimeAverageFuelDay;
    }
    
    public int getLifetimeAverageFuelWeek(){
    	return this.lifetimeAverageFuelWeek;
    }
    
    public int lifetimeAverageFuelMonth(){
    	return this.lifetimeAverageFuelMonth;
    }
    
    public int getNumOfActivities(){
    	return this.numOfActivities;
    }
    

    protected class KeyNames{
    	public final String DAILY_GOAL_TARGET_VALUE = "dailyGoalTargetValue";
    	public final String CURRENT_STREAK = "currentStreak";
    	public final String TOTAL_DAILY_GOALS_ACHIEVED = "totalDailyGoalsAchieved";
    	public final String LIFETIME_AVERAGE_FUEL_DAY =  "lifetimeAverageFuelDay";
    	public final String LIFETIME_AVERAGE_FUEL_WEEK = "lifetimeAverageFuelWeek";
    	public final String LIFETIME_AVERAGE_FUEL_MONTH ="lifetimeAverageFuelMonth";
    	public final String NUM_OF_ACTIVITIES = "numOfActivities" ;
    }
}
