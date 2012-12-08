package exception;

public class BadBookingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
public BadBookingException()
{
	super("The booking details are not valid");
}
public BadBookingException(String s)
{
super(s);
}
}
