package jp.ac.keio.ht.tetujin.jfuel.test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import jp.ac.keio.sfc.ht.tetujin.jfuel.main.JFuel;

/**
 * 
 * 
 * @author tetujin
 * @version 1.0
 * @since 2013.2.7
 *
 */
public class Main{
	private final String ACCESS_TOKEN = "26bdceba6b0851bfafb467da4efffba0";
	private final String BASIC_URL = "https://api.nike.com";
	private final String API = "/me/sport";
	private final String APP_ID = "nike";
	private final String METHOD = "GET";
	/**
	 * mainメソッド
	 * @param args
	 * @throws JSONException 
	 */
	public static void main(String[] args) throws JSONException{
		JFuel nike = new JFuel("26bdceba6b0851bfafb467da4efffba0");
//		JSONObject result = nike.getAgreageSportData();
//		JSONObject result = nike.getListActivies();
		JSONObject result = nike.getActivityDetail("caf41be4-b92e-4655-a5e1-0c6d2464cfdb");
		try {
			JSONArray names = result.names();
			//json object
			for(int i=0; i<result.length(); i++){
				System.out.println(result.get((String)names.get(i)));
			}
			
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  コンストラクタ
	 */
	public Main(){
		try {
			URL url = new URL(this.BASIC_URL+API+"?access_token="+this.ACCESS_TOKEN);
	        HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
	        con.setRequestMethod(this.METHOD);    // POST or GET
	        con.setDoOutput(true);             	  // POST
	        con.setInstanceFollowRedirects(false);
	        
	        con.setRequestProperty("Accept-Language", "jp");      
	        con.setRequestProperty("Accept","application/json");
	        con.setRequestProperty("appid",this.APP_ID);
	        System.out.println("Accept: " + con.getRequestProperty("Accept"));
	        System.out.println("appid: " + con.getRequestProperty("appid"));
	        //ヘッダ情報を出力
	        System.out.println("");
			System.out.println("---------http header---------- ");
	        Map headers =con.getHeaderFields();
	        for (Object key : headers.keySet()) {
	            System.out.println(key + ": " + headers.get(key));
	        }
	        con.connect();
	        
	        
	        /*---------body内容の取得---------*/
	        System.out.println("");
			String contentType = con.getHeaderField("Content-Type");
			String charSet = "Shift-JIS";// "ISO-8859-1";
			for (String elm : contentType.replace(" ", "").split(";")) {
				if (elm.startsWith("charset=")) {
					charSet = elm.substring(8);
					break;
				}
			}
			
			/*---------body内容の表示----------*/
			System.out.println("---------body内容の表示----------");
			BufferedReader br;
			try {
				br = new BufferedReader(new InputStreamReader( con.getInputStream(), charSet));
			} catch (Exception e_) {
				System.out.println(con.getResponseCode() + " " + con.getResponseMessage());
				br = new BufferedReader( new InputStreamReader(con.getErrorStream(), charSet));
			}
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line + "\n");
			}
			br.close();
			con.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}
		//System.out.println(".....fin");
		System.exit(0);
	}
}
