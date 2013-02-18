package jp.ht.tetujin.nikeapi.core.object;

import jp.ht.tetujin.nikeapi.core.object.elements.AllSummaryObject;
import jp.ht.tetujin.nikeapi.core.object.elements.FuelSummaryObject;
import jp.ht.tetujin.nikeapi.core.object.elements.RunningSummaryObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * @author tetujin
 * @version 2.0
 * @since 2013-02-16
 *
 */
public class AggregateSportDataObject{
	
	private String[] experienceType;
	
	public KeyNames key;
	
	private AllSummaryObject allSummaries;
	private FuelSummaryObject fuelSummaries;
	private RunningSummaryObject runningSummaries;
	

	public AggregateSportDataObject(JSONObject json){
		this.key = new KeyNames();
		//main
		try {
			JSONArray main = json.getJSONArray(this.key.EXPERIENCE_TYPES);
			int size = main.length();
			this.experienceType = new String[size];
			for(int i=0; i<size; i++){
				this.experienceType[i] = main.getString(i);
			}
		
			//sub
			JSONArray sub = json.getJSONArray(this.key.SUMMARIES);
			//all
			JSONObject all = sub.getJSONObject(0);
			if(all.getString(key.EXPERIENCE_TYPE).equals(AllSummaryObject.EXPERIENCE_TYPE)){
				this.allSummaries = new AllSummaryObject(all);
			}
			//fuel
			JSONObject fuel = sub.getJSONObject(1);
			if(fuel.getString(key.EXPERIENCE_TYPE).equals(FuelSummaryObject.EXPERIENCE_TYPE)){
				this.fuelSummaries = new FuelSummaryObject(fuel);
			}
			//funning
			JSONObject run = sub.getJSONObject(2);
			if(fuel.getString(key.EXPERIENCE_TYPE).equals(RunningSummaryObject.EXPERIENCE_TYPE)){
				this.runningSummaries = new RunningSummaryObject(run);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	
	public AllSummaryObject getAllSummaries(){
		return this.allSummaries;
	}
	
	public FuelSummaryObject getFuelSummaries(){
		return this.fuelSummaries;
	}
	
	public RunningSummaryObject getRunningSummaries(){
		return this.runningSummaries;
	}
	
	public String[] getExperienceTypeList(){
		return this.experienceType;
	}
	
	public int getExperienceTypeSize(){
		return this.experienceType.length;
	}

	
	protected class KeyNames {
		//experienceTypes
		public final String EXPERIENCE_TYPES = "experienceTypes";
		public final String SUMMARIES = "summaries";
		
		//summaries
		public final String EXPERIENCE_TYPE = "experienceType";
	}
}
