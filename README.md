JNikeAPI
========
A Java client for the Nike+ API. 

Install
--------
case of using this code in Eclipse:

1. download this code
2. start the Eclipse and import this code ("file"->"import"->select this folder)

case of using jar file:

1. download jar files. 
 - <a href="./lib">JNikeAPIClient.jar</a> 
 - <a href="./lib">JSON.jar</a>. (This jar file made by this <a href="http://www.json.org/java/">site</a>)
2. setting class pass

Preparation
--------
You have to get Access_Token from Nike developer site

    https://developer.nike.com/

1. login to the site of nike+ developer
2. go to "API CONSOLE"
3. select "Get My Access Token"
4. wirte nike+ account information (email & password) and push the "Go" button
5. you can get your Access_Token. 

How to use
--------
[javadoc](http://www.ht.sfc.keio.ac.jp/~tetujin/javadoc/JNikeAPI/)
<br>

<b>First step:</b>
 The JNikeAPIClient needs instantiate with your access_token.

    JNikeAPIClient nikeApi = new JNikeAPIClient("your access_token");


<b>Scond step:</b>
 You can use the Nike APIs. The Nike APIs has 4 kind of methods. 
 1. Aggregate Sport Data
 2. List Activities
 3. Activity Detail
 4. GPS Data
 
If you use this APIs, you can receive data type of [JSONObject](https://github.com/douglascrockford/JSON-java).
 
1) Aggregate Sport Data

    AggregateSportDataObject values = nikeApi.getAggregateSportDataObject();

2) List Activities.
    
    ListActivitiesObject value = nikeApi.getListActivitiesObject();

3) Activity Detail
    
    DetailActivityObject value = nikeApi.getDetailActivityObject("activityID");
    
4) GPS Data
    
    GPSDataObject value = nikeApi.getGPSDataObject("activityID");



