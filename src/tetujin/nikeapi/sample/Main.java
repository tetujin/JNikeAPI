package tetujin.nikeapi.sample;

import tetujin.nikeapi.core.JNikeAPIClient;

public class Main{
	public static void main(String[] args){
		JNikeAPIClient client = new JNikeAPIClient("your access token");
		client.getAggregateSportData();
	}
}
