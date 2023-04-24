
package books;

public class TooManyFieldsException extends Exception{
	/**
	 * This is the TooManyFieldsException that has the message that will be displayed in the error file
	 */
	private static final long serialVersionUID = 8583919711124824390L;
	public TooManyFieldsException() {
        super("Error: Too many fields");
       
    }
	public TooManyFieldsException(String message)
	{
	super(message);
	}

}
