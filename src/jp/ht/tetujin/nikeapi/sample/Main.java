package jp.ht.tetujin.nikeapi.sample;

import org.json.JSONException;

import jp.ht.tetujin.nikeapi.core.JNikeAPIClient;
import jp.ht.tetujin.nikeapi.core.JNikeLowLevelAPI;
import jp.ht.tetujin.nikeapi.object.ListActivitiesObject;
/*
 * JFuelのサンプルプログラム
 * 	1) JFuelをインスタンス化．引数としてNike+ API(https://developer.nike.com/)より発行されるaccess_tokenを渡す．
 *  	2) Nike+ APIには4つのAPIがある． 対応するメソッドを呼び出す事で各APIに対応したObjectを取得できる．JSONObject形式での値の取得も可能．
 *  		- Aggregate Sport Data : Provides a list of the Nike+ experiences in which the user participates and a summary of the user’s statistics for each sport category.
 *  		- List Activities : Provides details of the user’s activities, beginning with the most recent, as a paginated list. Activity details include the type of activity, its time and duration, calories burned, NikeFuel earned, and the Nike+ device on which the activity was recorded.
 *  		- Activity Detail : Provides details of one of the user’s activities, specified by its Activity ID. Activity details include the type of activity, its time and duration, calories burned, NikeFuel earned, and the Nike+ device on which the activity was recorded.
 *  		- GPS Data : Provides GPS data for one of the user’s activities, specified by its Activity ID. GPS details include 3D coordinates expressed as latitude, longitude, and elevation.
 */

public class Main{
	public static void main(String[] args) throws JSONException{
		//JNikeLowLevelAPI nike = new JNikeLowLevelAPI("your access token");
		JNikeAPIClient client = new JNikeAPIClient("your access token");
	}
}
