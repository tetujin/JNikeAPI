package jp.ht.tetujin.nikeapi.core;

public class JNikeAPIClient extends JNikeAPIConnecter{

	public JNikeAPIClient(String access_token) {
		super(access_token);
	}
	
	public JNikeAPIClient(String access_token, String appId, String acsept) {
		super(access_token, appId, acsept);
	}
	

}
