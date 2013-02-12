package jp.ac.keio.sfc.ht.tetujin.nike.sample;

import jp.ac.keio.sfc.ht.tetujin.nike.api.core.JNikeAPI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
		JNikeAPI nike = new JNikeAPI("26bdceba6b0851bfafb467da4efffba0");
		JSONObject result = nike.getAggregateSportData();
//		JSONObject result = nike.getListActivites();
//		JSONObject result = nike.getListActivites(0,0,"2012-12-03","2012-12-04");
//		JSONObject result = nike.getActivityDetail("caf41be4-b92e-4655-a5e1-0c6d2464cfdb");
//		JSONObject result = nike.getGPSData("caf41be4-b92e-4655-a5e1-0c6d2464cfdb");
		
		//Json形式データの表示
		System.out.println("\n--------ここからJSONの中身の表示---------------");
		try {
			JSONArray names = result.names();
			for(int i=0; i<result.length(); i++){
				System.out.println(result.get((String)names.get(i)));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
