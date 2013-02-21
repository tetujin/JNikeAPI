package tetujin.nikeapi.model;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import tetujin.nikeapi.model.elements.JNAllSummary;
import tetujin.nikeapi.model.elements.JNFuelSummary;
import tetujin.nikeapi.model.elements.JNRunningSummary;

/**
 * 
 * @author tetujin
 * @version 2.0
 * @since 2013-02-16
 *
 */
public class AggregateSportData{
	
	private String[] experienceType;
	
	private KeyNames key;
	
	private JNAllSummary allSummaries;
	private JNFuelSummary fuelSummaries;
	private JNRunningSummary runningSummaries;
	

	public AggregateSportData(JSONObject json){
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
			if(all.getString(key.EXPERIENCE_TYPE).equals(JNAllSummary.EXPERIENCE_TYPE)){
				this.allSummaries = new JNAllSummary(all);
			}
			//fuel
			JSONObject fuel = sub.getJSONObject(1);
			if(fuel.getString(key.EXPERIENCE_TYPE).equals(JNFuelSummary.EXPERIENCE_TYPE)){
				this.fuelSummaries = new JNFuelSummary(fuel);
			}
			//funning
			JSONObject run = sub.getJSONObject(2);
			if(fuel.getString(key.EXPERIENCE_TYPE).equals(JNRunningSummary.EXPERIENCE_TYPE)){
				this.runningSummaries = new JNRunningSummary(run);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	
	public JNAllSummary getAllSummaries(){
		return this.allSummaries;
	}
	
	public JNFuelSummary getFuelSummaries(){
		return this.fuelSummaries;
	}
	
	public JNRunningSummary getRunningSummaries(){
		return this.runningSummaries;
	}
	
	public String[] getExperienceTypeList(){
		return this.experienceType;
	}
	
	public int getExperienceTypeSize(){
		return this.experienceType.length;
	}
	
	public KeyNames getKeyNames(){
	    return this.key;
	}

	
	private class KeyNames {
		//experienceTypes
		public final String EXPERIENCE_TYPES = "experienceTypes";
		public final String SUMMARIES = "summaries";
		
		//summaries
		public final String EXPERIENCE_TYPE = "experienceType";
	}
}
