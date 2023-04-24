
package books;

public class TooFewFieldsException extends Exception{
	/**
	 * This is the TooFewFieldsException that has the message that will be displayed in the error file
	 */
	private static final long serialVersionUID = 3670911509186440985L;
	public TooFewFieldsException() {
        super("Error: Too few fields");
    }
	public TooFewFieldsException(String message)
	{
	super(message);
	}

}
