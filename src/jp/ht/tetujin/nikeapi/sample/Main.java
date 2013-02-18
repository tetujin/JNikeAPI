package jp.ht.tetujin.nikeapi.sample;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import jp.ht.tetujin.nikeapi.core.JNikeAPIConnecter;
import jp.ht.tetujin.nikeapi.core.object.ActivityObjectList;
import jp.ht.tetujin.nikeapi.core.object.AggregateSportDataObject;

/*
 * JFuelのサンプルプログラム
 * 	1) JFuelをインスタンス化．引数としてNike+ API(https://developer.nike.com/)より発行されるaccess_tokenを渡す．
 *  2) Nike+ APIには4つのAPIがある． 対応するメソッドを呼び出す事で値(JSON形式)を取得できる．
 *  	- Aggregate Sport Data : Provides a list of the Nike+ experiences in which the user participates and a summary of the user’s statistics for each sport category.
 *  	- List Activities : Provides details of the user’s activities, beginning with the most recent, as a paginated list. Activity details include the type of activity, its time and duration, calories burned, NikeFuel earned, and the Nike+ device on which the activity was recorded.
 *  	- Activity Detail : Provides details of one of the user’s activities, specified by its Activity ID. Activity details include the type of activity, its time and duration, calories burned, NikeFuel earned, and the Nike+ device on which the activity was recorded.
 *  	- GPS Data : Provides GPS data for one of the user’s activities, specified by its Activity ID. GPS details include 3D coordinates expressed as latitude, longitude, and elevation.
 *  3) JsonObjectとして結果がかえされるので，分解して表示する．
 */

public class Main{

	public static void main(String[] args) throws JSONException{
		JNikeAPIConnecter nike = new JNikeAPIConnecter("3f19b66c677334c1b79e792996db0c3a");
//		JSONObject result = nike.getAggregateSportData();
//		JSONObject result = nike.getListActivities(10);
//		JSONObject result = nike.getListActivites(0,0,"2012-12-03","2012-12-04");
		JSONObject result = nike.getActivityDetail("3d155e19-9ee9-4fd0-b569-e8c0864eee6e");
//		JSONObject result = nike.getGPSData("activity_id");
		
		//Json形式データの表示
		System.out.println("\n--------JSON---------------");
		//System.out.println(result.toString(4));
		System.out.println(result.names().toString(6));
//		System.out.println(result.getJSONArray("metrics").getJSONObject(0).getJSONArray("values").toString(4));
//		System.out.println(result.getJSONArray("metrics").getJSONObject(0).names().toString(4));
		//System.out.println(result.getJSONArray("metrics").getJSONObject(1).getJSONArray("values").length());
		//AggregateSportDataObject data = new AggregateSportDataObject(result);
//		 ActivityObjectList data = new ActivityObjectList(result);
//		try {
//			JSONArray names = result.names();
//			for(int i=0; i<result.length(); i++){
//				System.out.println(result.get((String)names.get(i)));
//			}
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
	}
}
