package jp.ac.keio.sfc.ht.tetujin.jfuel.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
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
 * This code is Nike+ API  
 * 
 * query sample:
 * 	1) [Aggregate Sport Data]  GET https://api.nike.com/me/sport?access_token={access_token}
 *  2) [List Activities]  GET https://api.nike.com/me/sport/activities?access_token={access_token}
 * 	3) [Activity Detail]  GET https://api.nike.com/me/sport/activities/104019031?access_token={access_token}
 *  4) [GPS Data]  GET https://api.nike.com/me/sport/activities/104019031/gps?access_token={access_token}
 * @author tetujin
 * @since 2013-02-09
 * @version 1.0
 */

public class JFuel {
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
	public final String API_ACT_DETAIL = "/me/sport/activities/";//この後ろにIDが入る
	public final String API_ACT_GPS = "/gps";
	public final String TOKEN = "?access_token=";
	public final String OPTION_OFFSET = "&offset=";
	public final String OPTION_COUNT = "&count=";
	public final String OPTION_START = "&start=";
	public final String OPTION_END = "&end=";
	
	
	/**
	 * 
	 * @param ACCESS_TOKEN
	 */
	public JFuel(final String access_token){
		this.access_token = access_token;
		//this.ACCESS_TOKEN = this.TOKEN + ACCESS_TOKEN;
	}
	
	/**
	 * 
	 * @param ACCESS_TOKEN
	 * @param appid
	 * @param accept
	 */
	public JFuel(final String access_token, String appid, String accept){
		this.access_token = access_token;
		this.appid = appid;
		this.accept = accept;
	}
	
	/**
	 * 
	 * @param strURL
	 * @return
	 */
	protected String sendHttpRequest(final String strURL){
		String jsonStr = "";
		try {
			URL url = new URL(strURL);
			HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
			con.setRequestMethod(this.method);
			con.setDoOutput(true);
			con.setInstanceFollowRedirects(false);
			
			con.setRequestProperty("Accept-Language", this.lang);      
	        con.setRequestProperty("Accept",this.accept);
	        con.setRequestProperty("appid",this.appid);
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
			BufferedReader br;
			try {
				br = new BufferedReader(new InputStreamReader( con.getInputStream(), charSet));
			} catch (Exception e_) {
				System.out.println(con.getResponseCode() + " " + con.getResponseMessage());
				br = new BufferedReader( new InputStreamReader(con.getErrorStream(), charSet));
			}
			System.out.println("---------body内容の表示----------");
			String line = "";
			while ((line = br.readLine()) != null) {
				//System.out.println(line);
				jsonStr += line;
				//System.out.println(jsonStr);
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
	 * @return
	 */
	public JSONObject getAgreageSportData(){
		String url = this.BASIC_URL + this.API_AGGREAGETE + TOKEN + this.access_token; 
		//https://api.nike.com/me/sport?access_token={access_token}
		String jsonStr = sendHttpRequest(url);
		return getJsonObj(jsonStr);
	}
	
	
	/**
	 * 
	 * @return
	 */
	public JSONObject getListActivites(){
		return getListActivites(0, 0, null, null);
//		String url = this.BASIC_URL + this.API_LIST_ACT + this.ACCESS_TOKEN;
//		String jsonStr = sendHttpRequest(url);
//		//https://api.nike.com/me/sport/activities?access_token={access_token}
//		return getJsonObj(jsonStr);
	}
	
	public JSONObject getListActivites(int count){
		return getListActivites(0, count, null, null);
	}

	public JSONObject getListActivites(String start, String end){
		return getListActivites(0,0, start, end);
	}
	
	public JSONObject getListActivites(int offset, int count, String start, String end){
		String url = this.BASIC_URL + this.API_LIST_ACT + this.TOKEN + this.access_token;
		if(offset!= 0) url += this.OPTION_COUNT  + count;
		if(count != 0)		url += this.OPTION_OFFSET + offset;
		if(start!=null && dateformatChecker(start))	url += this.OPTION_START  + start;
		if(end!=null && dateformatChecker(end))	url += this.OPTION_END    + end;
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
	 * 
	 * @param id
	 * @return
	 */
	public JSONObject getActivityDetail(final String activityId){
		//GET https://api.nike.com/me/sport/activities/104019031?access_token={access_token}
		String url = this.BASIC_URL + this.API_ACT_DETAIL + activityId + TOKEN + access_token;
		String jsonStr = sendHttpRequest(url);
		return getJsonObj(jsonStr);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public JSONObject getGPSData(final String activityId){
	    //GET https://api.nike.com/me/sport/activities/104019031/gps?access_token={access_token}
		String url = this.BASIC_URL + this.API_ACT_GPS + activityId + this.API_ACT_GPS + this.TOKEN +this.access_token;
		String jsonStr = sendHttpRequest(url);
		return getJsonObj(jsonStr);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAccessToken(){
		return this.access_token;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getLang(){
		return this.lang; 
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAppId(){
		return this.appid;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAccept(){
		return this.accept; 
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
	 * @return
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
	 */
	public String toString(){
		return "Accesstoken is " + this.access_token;
	}
	
	/**
	 * 
	 * @param jsonStr
	 * @return
	 */
	protected JSONObject getJsonObj(String jsonStr) {
		try {
			JSONObject jsonObj = new JSONObject(jsonStr);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("error!");
		return null;
	}
	
	/**
	 * 
	 * @param dateStr
	 * @return
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
