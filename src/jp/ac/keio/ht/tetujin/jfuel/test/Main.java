package jp.ac.keio.ht.tetujin.jfuel.test;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import jp.ac.keio.sfc.ht.tetujin.jfuel.main.JFuel;

/*
 * JFuelのサンプルプログラム
 * 	1) JFuelをインスタンス化．引数として，Nike+ API(http://nike.api)より発行されるaccess_tokenを渡す．
 *  2) Nike+ APIには4つのAPI()がある．メソッドを呼び出す事で，JSONObject形式を値を取得できる．
 *  3) JsonObjectとして結果がかえされるので，分解して表示する．
 */

public class Main{

	public static void main(String[] args) throws JSONException{
		JFuel nike = new JFuel("26bdceba6b0851bfafb467da4efffba0");
		JSONObject result = nike.getAgreageSportData();
//		JSONObject result = nike.getListActivites();
//		JSONObject result = nike.getListActivites(0,0,"2012-12-03","2012-12-04");
//		JSONObject result = nike.getActivityDetail("caf41be4-b92e-4655-a5e1-0c6d2464cfdb");
		
		//Json形式データの表示
		System.out.println("\n--------ここけらJSONの中身の表示---------------");
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
