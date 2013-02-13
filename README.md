JNikeAPI
========
A Java client for the Nike+ API. 

Install
--------
case of using this code in Eclipse:

1. download this code
2. start the Eclipse and import this code ("file"->"import"->select this folder)


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
<b>First step:</b>
 The JNikeAPI needs instantiate with your access_token.

    JNikeAPI nike = new JNikeAPI("your access_token");


<b>Scond step:</b>
 You can use the Nike APIs. The Nike APIs has 4 kind of methods. 
 1. Aggregate Sport Data
 2. List Activities
 3. Activity Detail
 4. GPS Data
 
If you use this APIs, you can receive data type of [JSONObject](https://github.com/douglascrockford/JSON-java).
 
1) Aggregate Sport Data

    JSONObject values = nike.getAggregateSportData();

2) List Activities.
    
    JSONObject value = nike.getListActivities();

3) Activity Detail
    
    JSONObject value = nike.getActivityDetail("activityID");
    
4) GPS Data
    
    JSONObject value = nike.getGPSData("activityID");


Futer work
--------

