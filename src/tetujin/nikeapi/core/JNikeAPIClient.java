package tetujin.nikeapi.core;

import tetujin.nikeapi.model.AggregateSportData;
import tetujin.nikeapi.model.DetailActivity;
import tetujin.nikeapi.model.GPSData;
import tetujin.nikeapi.model.ListActivities;

/**
 * Java API client for Nike plus
 * 
 * @author tetujin
 * @since 2012-02-18
 * @version 2.0
 *
 */
public class JNikeAPIClient{

	private JNikeLowLevelAPI nikeApi;
	
	/**
	 * 
	 * @param access_token
	 */
	public JNikeAPIClient(String access_token) {
		this.nikeApi = new JNikeLowLevelAPI(access_token);
	}
	
	
	/**
	 * 
	 * @param access_token
	 * @param appId
	 * @param acsept
	 */
	public JNikeAPIClient(String access_token, String appId, String acsept) {
		this.nikeApi = new JNikeLowLevelAPI(access_token,appId,acsept);
	}
	
	/**
	 * 
	 * @return　AggregateSportData
	 */
	public AggregateSportData getAggregateSportData(){
		return new AggregateSportData(nikeApi.getAggregateSportData());
	}
	
	/**
	 * Get result of List Activities that form is original object. 
	 * @return ListActivities 
	 */
	public ListActivities getListActivities(){
		return new ListActivities(nikeApi.getListActivities());
	}
	
	/**
	 * Get result of List Activities that form is original object. This method is needed option(count).
	 * @param count
	 * @return ListActivities
	 */
	public ListActivities getListActivities(final int count){
		return new ListActivities(nikeApi.getListActivities(count));
	}
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public ListActivities getListActivities(final String start, final String end){
		return new ListActivities(nikeApi.getListActivities(start,end));
	}
	
	/**
	 * 
	 * @param offset
	 * @param count
	 * @param start
	 * @param end
	 * @return
	 */
	public ListActivities getListActivities(final int offset, final int count, final String start, final String end){
		return new ListActivities(nikeApi.getListActivities(offset,count,start,end));
	}
	
	
	/**
	 * 
	 * @param activityId
	 * @return
	 */
	public DetailActivity getDetailActivity(final String activityId){
		return new DetailActivity(nikeApi.getActivityDetail(activityId));
	}
	
	
	/**
	 * 
	 * @param activityId
	 * @return
	 */
	public GPSData getGPSData(final String activityId){
		return new GPSData(nikeApi.getGPSData(activityId));
	}
	
	
	/**
	 * 
	 * @return
	 */
	public JNikeLowLevelAPI getLowLevelAPI(){
	    return this.nikeApi;
	}
	
}
