package jp.ht.tetujin.nikeapi.core;

import jp.ht.tetujin.nikeapi.object.AggregateSportDataObject;
import jp.ht.tetujin.nikeapi.object.DetailActivityObject;
import jp.ht.tetujin.nikeapi.object.GPSDataObject;
import jp.ht.tetujin.nikeapi.object.ListActivitiesObject;

public class JNikeAPIClient{

	private JNikeLowLevelAPI nikeApi;
	
	public JNikeAPIClient(String access_token) {
		this.nikeApi = new JNikeLowLevelAPI(access_token);
	}
	
	public JNikeAPIClient(String access_token, String appId, String acsept) {
		this.nikeApi = new JNikeLowLevelAPI(access_token,appId,acsept);
	}
	
	public AggregateSportDataObject getAggregateSportData(){
		return new AggregateSportDataObject(nikeApi.getAggregateSportData());
	}
	
	public ListActivitiesObject getListActivities(){
		return new ListActivitiesObject(nikeApi.getListActivities());
	}
	
	public ListActivitiesObject getListActivities(final int count){
		return new ListActivitiesObject(nikeApi.getListActivities(count));
	}
	
	public ListActivitiesObject getListActivities(final String start, final String end){
		return new ListActivitiesObject(nikeApi.getListActivities(start,end));
	}
	
	public ListActivitiesObject getListActivities(final int offset, final int count, final String start, final String end){
		return new ListActivitiesObject(nikeApi.getListActivities(offset,count,start,end));
	}
	
	public DetailActivityObject getDetailActivity(final String activityId){
		return new DetailActivityObject(nikeApi.getActivityDetail(activityId));
	}
	
	public GPSDataObject getGPSData(final String activityId){
		return new GPSDataObject(nikeApi.getGPSData(activityId));
	}
	
}
