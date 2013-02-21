package tetujin.nikeapi.core;

import tetujin.nikeapi.model.AggregateSportData;
import tetujin.nikeapi.model.DetailActivity;
import tetujin.nikeapi.model.GPSData;
import tetujin.nikeapi.model.ListActivities;

public class JNikeAPIClient{

	private JNikeLowLevelAPI nikeApi;
	
	public JNikeAPIClient(String access_token) {
		this.nikeApi = new JNikeLowLevelAPI(access_token);
	}
	
	public JNikeAPIClient(String access_token, String appId, String acsept) {
		this.nikeApi = new JNikeLowLevelAPI(access_token,appId,acsept);
	}
	
	public AggregateSportData getAggregateSportData(){
		return new AggregateSportData(nikeApi.getAggregateSportData());
	}
	
	public ListActivities getListActivities(){
		return new ListActivities(nikeApi.getListActivities());
	}
	
	public ListActivities getListActivities(final int count){
		return new ListActivities(nikeApi.getListActivities(count));
	}
	
	public ListActivities getListActivities(final String start, final String end){
		return new ListActivities(nikeApi.getListActivities(start,end));
	}
	
	public ListActivities getListActivities(final int offset, final int count, final String start, final String end){
		return new ListActivities(nikeApi.getListActivities(offset,count,start,end));
	}
	
	public DetailActivity getDetailActivity(final String activityId){
		return new DetailActivity(nikeApi.getActivityDetail(activityId));
	}
	
	public GPSData getGPSData(final String activityId){
		return new GPSData(nikeApi.getGPSData(activityId));
	}
	
}
