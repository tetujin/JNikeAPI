package jp.ht.tetujin.nikeapi.core.object;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * @author tetujin
 * @version 1.0
 * @since 2013-02-16
 *
 */
public class AggregateSportDataObject{
	
	public final String[] MAIN = {"experienceTypes","summaries"};
	public final String[] SUB = {"experienceType","records"};
	//public final String[] EXPERIENECE_TYPE = {"ALL","FUELBAND", "RUNNING"};
	public final String[] ALL_RECORD = {"lifetimeFuel"};
	public final String[] FUEL_RECORD = {"dailyGoalTargetValue",
										 "currentStreak",
										 "totalDailyGoalsAchieved",
										 "lifetimeAverageFuelDay",
										 "lifetimeAverageFuelWeek",
										 "lifetimeAverageFuelMonth",
										 "numOfActivities" };
	public final String[] RUNNING_RECORD = { "level",
		     								 "lifetimeDuration",
		     								 "lifetimeGpsRuns",
		     								 "lifetimeHeartActivities",
		     								 "lifetimeAveragePace"};
	
	private final AllSummaries allSummaries;
	private final FuelSummaries fuelSummaries;
	private final RunningSummaries runningSummaries;
	
	public AggregateSportDataObject(JSONObject json) throws JSONException{
		//main
		JSONArray main = json.getJSONArray(MAIN[0]);
		System.out.println(main.toString(4));
		
		//sub
		JSONArray sub = json.getJSONArray(MAIN[1]);
		JSONObject all = sub.getJSONObject(0);
		JSONObject fuel = sub.getJSONObject(1);
		JSONObject run = sub.getJSONObject(2);
		
		//ALL
		JSONObject allRecord = all.getJSONObject(SUB[1]);
		this.allSummaries = new AllSummaries(allRecord.getInt(ALL_RECORD[0]));
		
		//FUEL
		JSONObject fuelRecord = fuel.getJSONObject(SUB[1]);
		this.fuelSummaries = new FuelSummaries(fuelRecord.getInt(FUEL_RECORD[0]),
											   fuelRecord.getInt(FUEL_RECORD[1]),
											   fuelRecord.getInt(FUEL_RECORD[2]),
											   fuelRecord.getInt(FUEL_RECORD[3]),
											   fuelRecord.getInt(FUEL_RECORD[4]),
											   fuelRecord.getInt(FUEL_RECORD[5]),
											   fuelRecord.getInt(FUEL_RECORD[6]));
		
		//RUNNING
		JSONObject runRecord = run.getJSONObject(SUB[1]);
		this.runningSummaries = new RunningSummaries(runRecord.getInt(RUNNING_RECORD[0]),
												     runRecord.getString(RUNNING_RECORD[1]),
												     runRecord.getInt(RUNNING_RECORD[2]),
													 runRecord.getInt(RUNNING_RECORD[3]),
													 runRecord.getDouble(RUNNING_RECORD[4]));
	}
	
	 //ALL
	 public int getLifeTimeFuel(){return allSummaries.lifetimeFuel;}
	 //FUEL
	 public int getDailyGoaltargetValue(){return fuelSummaries.dailyGoalTargetValue;}
	 public int getCurrentStreak(){return fuelSummaries.currentStreak;}
	 public int getTotalDailyGoalAchieved(){return fuelSummaries.totalDailyGoalsAchieved;}
	 public int getLifeTimeAverageFuelDay(){return fuelSummaries.lifetimeAverageFuelDay;}
	 public int getLifeTimeAverageFuelWeek(){return fuelSummaries.lifetimeAverageFuelWeek;}
	 public int getLifeTimeAverageFuelMonth(){return fuelSummaries.lifetimeAverageFuelMonth;}
	 public int getNumOfActivities(){return fuelSummaries.numOfActivities; }
	 //RUN
	 public int getLevel(){return runningSummaries.level;}
	 public String getLifetimeDuration(){return runningSummaries.lifetimeDuration;}
	 public int getLifetimeGpsRuns(){return runningSummaries.lifetimeGpsRuns;}
	 public int getLifetimeHeartActivities(){return runningSummaries.lifetimeHeartActivities;}
	 public double getLifetimeAveragePace(){return runningSummaries.lifetimeAveragePace;}
	  

	private class AllSummaries{
		public int lifetimeFuel;
		public AllSummaries(int lifetimeFuel){
			this.lifetimeFuel = lifetimeFuel;
		}
	}
	
	private class FuelSummaries{
		public int dailyGoalTargetValue;
        public int currentStreak;
        public int totalDailyGoalsAchieved;
        public int lifetimeAverageFuelDay;
        public int lifetimeAverageFuelWeek;
        public int lifetimeAverageFuelMonth;
        public int numOfActivities;
        
        public FuelSummaries(int dailyGoalTargetValue,
        					 int currentStreak,
        					 int totalDailyGoalsAchieved,
        					 int lifetimeAverageFuelDay,
        					 int lifetimeAverageFuelWeek,
        					 int lifetimeAverageFuelMonth,
        					 int numOfActivities){
        	this.dailyGoalTargetValue = dailyGoalTargetValue;
        	this.currentStreak = currentStreak;
        	this.totalDailyGoalsAchieved = totalDailyGoalsAchieved;
        	this.lifetimeAverageFuelDay = lifetimeAverageFuelDay;
        	this.lifetimeAverageFuelWeek = lifetimeAverageFuelWeek;
        	this.lifetimeAverageFuelMonth = lifetimeAverageFuelMonth;
        	this.numOfActivities= numOfActivities;
        }
	}
	
	
	private class RunningSummaries{
		//private final String TYPE = "RUNNING";
		public int level;
		public String lifetimeDuration;
		public int lifetimeGpsRuns;
		public int lifetimeHeartActivities;
		public double lifetimeAveragePace;
	    
	    public RunningSummaries(int level,
	    						String lifetimeDuration,
	    						int lifetimeGpsRuns,
	    						int lifetimeHeartActivities,
	    						double lifetimeAveragePace){
	    	this.level = level;
	    	this.lifetimeDuration = lifetimeDuration;
	    	this.lifetimeGpsRuns = lifetimeGpsRuns;
	    	this.lifetimeHeartActivities = lifetimeHeartActivities;
	    	this.lifetimeAveragePace = lifetimeAveragePace;
	    }
	}
}
