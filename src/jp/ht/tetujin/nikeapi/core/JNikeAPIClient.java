package jp.ht.tetujin.nikeapi.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONException;
import org.json.JSONObject;


/*
Copyright (c) 2013 tetujin

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

The Software shall be used for Good, not Evil.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 * 
 */

/**
 * This code is java client of Nike+ API. 
 * 
 * Nike+ API is used HTTP GET method and it have 4 methods.
 * 
 * 
 * <ul>
 * 	<li>1) [Aggregate Sport Data]  GET https://api.nike.com/me/sport?access_token={access_token}</li>
 *  <li>2) [List Activities]  GET https://api.nike.com/me/sport/activities?access_token={access_token}</li>
 * 	<li>3) [Activity Detail]  GET https://api.nike.com/me/sport/activities/104019031?access_token={access_token}</li>
 *  <li>4) [GPS Data]  GET https://api.nike.com/me/sport/activities/104019031/gps?access_token={access_token}</li>
 * </ul>
 * 
 * @author tetujin
 * @since 2013-02-09
 * @version 1.2
 */

public class JNikeAPIClient {
	//access token
	private String access_token;
	
	//http
	private String method = "GET";
	private String lang = "jp"; 
	private String appid = "nike";
	private String accept = "application/json";
	
	//API
	public final String BASIC_URL = "https://api.nike.com";
	public final String API_AGGREAGETE = "/me/sport";
	public final String API_LIST_ACT = "/me/sport/activities";
	public final String API_ACT_DETAIL = "/me/sport/activities/";
	public final String API_ACT_GPS = "/gps";
	public final String TOKEN = "?access_token=";
	public final String OPTION_OFFSET = "&offset=";
	public final String OPTION_COUNT = "&count=";
	public final String OPTION_START = "&startDate=";
	public final String OPTION_END = "&endDate=";
	
	
	/**
	 * @param access_token <a href="http://developer.nike.com/">Nike Developer Site</a> より取得したアクセストークン
	 */
	public JNikeAPIClient(final String access_token){
		this.access_token = access_token;
	}
	
	/**
	 * 
	 * @param access_token <a href="http://developer.nike.com/">Nike+ Developer Site</a> より取得したアクセストークン
	 * @param appid Http Headerへ挿入する Request Headers(<a href="http://developer.nike.com/">Nike Developer Site</a>を参照)
	 * @param accept Http Headerへ挿入する Request Headers (<a href="http://developer.nike.com/">Nike Developer Site</a>を参照)
	 */
	public JNikeAPIClient(final String access_token, String appid, String accept){
		this.access_token = access_token;
		this.appid = appid;
		this.accept = accept;
	}
	
	/**
	 * 
	 * @param strURL リクエスト用のURL
	 * @return jsonStr JSON形式の文字列
	 */
	protected String sendHttpRequest(final String strURL){
		String jsonStr = "";
		try {
			URL url = new URL(strURL);
	        /*---------make and set HTTP header-------*/
			//HttpsURLConnection baseConnection = (HttpsURLConnection)url.openConnection();
			HttpsURLConnection con = setHttpHeader((HttpsURLConnection)url.openConnection());
			
	        /*---------show HTTP header information-------*/
			System.out.println("\n ---------http header---------- ");
	        Map headers =con.getHeaderFields();
	        for (Object key : headers.keySet()) {
	            System.out.println(key + ": " + headers.get(key));
	        }
	        con.connect();
	        
	        
	        /*---------get HTTP body information---------*/
			String contentType = con.getHeaderField("Content-Type");
			//String charSet = "Shift-JIS";// "ISO-8859-1";
			String charSet = "UTF-8";// "ISO-8859-1";
			for (String elm : contentType.replace(" ", "").split(";")) {
				if (elm.startsWith("charset=")) {
					charSet = elm.substring(8);
					break;
				}
			}
				
			/*---------show HTTP body information----------*/
			BufferedReader br;
			try {
				br = new BufferedReader(new InputStreamReader( con.getInputStream(), charSet));
			} catch (Exception e_) {
				System.out.println(con.getResponseCode() + " " + con.getResponseMessage());
				br = new BufferedReader( new InputStreamReader(con.getErrorStream(), charSet));
			}
			System.out.println("\n ---------show HTTP body information----------");
			String line = "";
			while ((line = br.readLine()) != null) {
				jsonStr += line;
			}
			br.close();
			con.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(jsonStr);
		return jsonStr;
	}
	
	/**
	 * 
	 * @param con ベーシックなHttpsURLConnection 
	 * @return con optionを追加したHttpsURLConnection
	 */
	protected HttpsURLConnection setHttpHeader(HttpsURLConnection con) {
		try {
			con.setRequestMethod(this.method);
			con.setDoOutput(true);
			con.setInstanceFollowRedirects(false);
			con.setRequestProperty("Accept-Language", this.lang);      
	        con.setRequestProperty("Accept",this.accept);
	        con.setRequestProperty("appid",this.appid);
	        System.out.println("Accept: " + con.getRequestProperty("Accept"));
	        System.out.println("appid: " + con.getRequestProperty("appid"));
	        return con;
		} catch (ProtocolException e) {
			e.printStackTrace();
			return con;
		}
	}

	/**
	 * API: The method of Aggregate Sport Data
	 * @return A JSONObject
	 */
	public JSONObject getAggregateSportData(){
		String url = this.BASIC_URL + this.API_AGGREAGETE + TOKEN + this.access_token; 
		//https://api.nike.com/me/sport?access_token={access_token}
		String jsonStr = sendHttpRequest(url);
		return getJsonObj(jsonStr);
	}
	
	
	/**
	 * API: The method of List Activities
	 * @return A JSONObject
	 */
	public JSONObject getListActivities(){
		return getListActivities(0, 0, null, null);
	}
	
	/**
	 * API: The method of List Activities with limit of count option
	 * @param count
	 * @return A JSONObject
	 */
	public JSONObject getListActivities(int count){
		return getListActivities(0, count, null, null);
	}

	/**
	 * API: The method of List Activities with option of start date and end date. 
	 * @param start
	 * @param end
	 * @return A JSONObject
	 */
	public JSONObject getListActivities(String start, String end){
		return getListActivities(0,0, start, end);
	}
	
	/**
	 * API: The method of List activities with option of start date & end date and limit of count
	 * @param offset
	 * @param count
	 * @param start
	 * @param end
	 * @return A JSONObject
	 */
	public JSONObject getListActivities(int offset, int count, String start, String end){
		String url = this.BASIC_URL + this.API_LIST_ACT + this.TOKEN + this.access_token;
		if(count!= 0) 	url += this.OPTION_COUNT  + count;
		if(offset != 0) url += this.OPTION_OFFSET + offset;
		if(start!=null && dateformatChecker(start))	url += this.OPTION_START  + start;
		if(end!=null && dateformatChecker(end))		url += this.OPTION_END    + end;
		System.out.println(url);
		String jsonStr = sendHttpRequest(url);
		return getJsonObj(jsonStr);
	}
	
	/*
	* Name	Type	Required?	Description
	* access_token	String	Y	User's oAuth token
	* offset	Integer	N	Pagination – first record to retrieve (starts at 1)
	* count	Integer	N	Pagination – number of records to retrieve (default 5)
	* startDate	String	N	The Activity's start date in ISO8601 standard format, 'yyyy-mm-dd'
	* endDate	String	N	The Activity's end date in ISO8601 standard format, 'yyyy-mm-dd'
	 */
	
	/**
	 * API: The method of Activity Detail. This method need activity id from List Activities.
	 * @param activityId
	 * @return A JSONObject
	 */
	public JSONObject getActivityDetail(final String activityId){
		//GET https://api.nike.com/me/sport/activities/104019031?access_token={access_token}
		String url = this.BASIC_URL + this.API_ACT_DETAIL + activityId + TOKEN + access_token;
		String jsonStr = sendHttpRequest(url);
		return getJsonObj(jsonStr);
	}
	
	/**
	 *  API: The method of GPS data. This method need activity id from List Activities.
	 * @param activityId 
	 * @return A JSONObject
	 */
	public JSONObject getGPSData(final String activityId){
	    //GET https://api.nike.com/me/sport/activities/104019031/gps?access_token={access_token}
		String url = this.BASIC_URL + this.API_ACT_GPS + activityId + this.API_ACT_GPS + this.TOKEN +this.access_token;
		String jsonStr = sendHttpRequest(url);
		return getJsonObj(jsonStr);
	}
	
	/**
	 * 
	 * @return The registered access token
	 */
	public String getAccessToken(){
		return this.access_token;
	}
	
	/**
	 * 
	 * @return　The registered language in http header
	 */
	public String getLang(){
		return this.lang; 
	}
	
	/**
	 * 
	 * @return The registered appID in http header
	 */
	public String getAppId(){
		return this.appid;
	}
	
	/**
	 * 
	 * @return The registered accept in http header
	 */
	public String getAccept(){
		return this.accept; 
	}
	
	/**
	 * 
	 * @param access_token 
	 */
	public void setAccessToken(final String access_token){
		this.access_token = access_token;
	}
	
	/**
	 * 
	 * @param lang
	 */
	public void setLang(final String lang){
		this.lang = lang;
	}
	
	/**
	 * 
	 * @param appid
	 */
	public void setAppId(final String appid){
		this.appid = appid;
	}
	
	/**
	 * 
	 * @param accept
	 */
	public void setAccept(final String accept){
		this.accept = accept;
	}
	
	/**
	 * 
	 * @param method
	 * @return correct format or illegal format
	 */
	public boolean setMethod(final String method){
		if(method.equals("GET") || method.equals("POST")){
			this.method = method;
			return true;
		}else{
			System.out.println("ERROR");
			return false;
		}
	}
	
	/**
	 * 
	 * @return A message about access token
	 */
	public String toString(){
		return "Accesstoken is " + this.access_token;
	}
	
	/**
	 * JSON形式の文字列をJSONObjectに変換するメソッド
	 * @param jsonStr 
	 * @return A JSONObject
	 */
	protected JSONObject getJsonObj(String jsonStr) {
		try {
			JSONObject jsonObj = new JSONObject(jsonStr);
			return jsonObj;
		} catch (JSONException e) {
			e.printStackTrace();
			System.err.println("error!");
			return null;
		}
	}
	
	/**
	 * 
	 * @param dateStr
	 * @return　correct format or illegal format
	 */
	protected boolean dateformatChecker(String dateStr){
		if(dateStr.charAt(4)!='-' || dateStr.charAt(7)!='-'){
			System.out.println("bad date format");
			return false;
		}else if(dateStr.length() != 10){
			System.out.println("bad date format");
			return false;
		}else{
			return true;
		}
	}
	
}
