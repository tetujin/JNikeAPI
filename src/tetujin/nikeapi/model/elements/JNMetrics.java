package tetujin.nikeapi.model.elements;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JNMetrics {
	
	private int intervalMetric;
	private String intervalUnit;
	private String metricType;
	private double[] values;
	
	private KeyNames key;
	
	public JNMetrics(JSONObject json){
		this.key = new KeyNames();
		try {
			if(json.isNull(key.INTERVAL_METRIC)!=true) this.intervalMetric = json.getInt(key.INTERVAL_METRIC);
			if(json.isNull(key.INTERVAL_UNIT)!=true) this.intervalUnit = json.getString(key.INTERVAL_UNIT);
			if(json.isNull(key.METRIC_TYPE)!=true) this.metricType = json.getString(key.METRIC_TYPE);
			if(json.isNull(key.VALUES)!= true){
				JSONArray valArray = json.getJSONArray(key.VALUES);
				int size = valArray.length();
				this.values = new double[size];
				for(int i=0; i<size; i++){
					this.values[i] = valArray.getDouble(i);
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public int getIntervalMetric(){
		return this.intervalMetric;
	}
	
	public String getIntervalUnit(){
		return this.intervalUnit;
	}
	
	public String getMetricType(){
		return this.metricType;
	}
	
	public double[] getValues(){
		return this.values;
	}
	
	public KeyNames getKeyNames(){
	    return this.key;
	}
	
	private class KeyNames{
	    public final String INTERVAL_METRIC = "intervalMetric";
	    public final String INTERVAL_UNIT = "intervalUnit";
		public final String METRIC_TYPE= "metricType";
		public final String VALUES = "values";
	}
}
