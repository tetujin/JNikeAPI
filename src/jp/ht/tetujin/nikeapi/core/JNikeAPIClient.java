package jp.ht.tetujin.nikeapi.core;

import jp.ht.tetujin.nikeapi.object.AggregateSportDataObject;
import jp.ht.tetujin.nikeapi.object.DetailActivityObject;
import jp.ht.tetujin.nikeapi.object.GPSDataObject;
import jp.ht.tetujin.nikeapi.object.ListActivitiesObject;

public class JNikeAPIClient extends JNikeAPIConnecter{

	
	public JNikeAPIClient(String access_token) {
		super(access_token);
	}
	
	public JNikeAPIClient(String access_token, String appId, String acsept) {
		super(access_token,appId,acsept);
	}
	
	public AggregateSportDataObject getAggregateSportDataObject(){
		return new AggregateSportDataObject(super.getAggregateSportData());
	}
	
	public ListActivitiesObject getListActivitiesObject(){
		return new ListActivitiesObject(super.getListActivities());
	}
	
	public ListActivitiesObject getListActivitiesObject(final int count){
		return new ListActivitiesObject(super.getListActivities(count));
	}
	
	public ListActivitiesObject getListActivitiesObject(final String start, final String end){
		return new ListActivitiesObject(super.getListActivities(start,end));
	}
	
	public ListActivitiesObject getListActivitiesObject(final int offset, final int count, final String start, final String end){
		return new ListActivitiesObject(super.getListActivities(offset,count,start,end));
	}
	
	public DetailActivityObject getDetailActivityObject(final String activityId){
		return new DetailActivityObject(super.getActivityDetail(activityId));
	}
	
	public GPSDataObject getGPSDataObject(final String activityId){
		return new GPSDataObject(super.getGPSData(activityId));
	}
	
}
