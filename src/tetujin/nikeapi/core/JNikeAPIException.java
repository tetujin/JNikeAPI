package tetujin.nikeapi.core;

/**
 * The JFuelException is thrown by the JFuel classes when things are amiss.
 * @author tetujin
 * @version 2013-02-09
 */
public class JNikeAPIException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4638914920328046850L;
	private Throwable cause;
	
	public JNikeAPIException(String message){
		super(message);
	}
	
	public JNikeAPIException(Throwable cause){
		super(cause.getMessage());
		this.cause = cause;
	}
	
	public Throwable getCause(){
		return this.cause;
	}
	
}
