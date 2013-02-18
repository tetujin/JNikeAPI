package jp.ht.tetujin.nikeapi.core.object.elements;



/**
 * 
 * @author tetujin
 * @since 2013-02-18
 * @version 1.0
 *
 */
public class ActivityObject {
	
	public String activityId;
    public int calories;
    public int fuel;
    public double distance;
    public int steps;
    public String duration;
    public String activityType;
    public String startTime;
    public String activityTimeZone;
    public String status;
    public String deviceType;
    public TagsModel[] tags;
    public String[] metrics;
    
	public ActivityObject(String activityId,
							  int calories,
							  int fuel,
							  double distance,
							  int steps,
							  String duration,
							  String activityType,
							  String startTime,
							  String activityTimeZone,
							  String status,
							  String deviceType,
							  TagsModel[] tags,
							  String[] metrics){
		this.activityId = activityId;
	    this.calories = calories;
	    this.fuel = fuel;
	    this.distance = distance;
	    this.steps = steps;
	    this.duration = duration;
	    this.activityType = activityType;
	    this.startTime = startTime;
	    this.activityTimeZone = activityTimeZone;
	    this.status = status;
	    this.deviceType = deviceType;
	    this.tags = tags;
	    this.metrics = metrics;
	}
}
