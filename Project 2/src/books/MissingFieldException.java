
package books;

public class MissingFieldException extends Exception{
	/**
	 * This is the MissingFieldsException that has the message that will be displayed in the error file
	 */
	private static final long serialVersionUID = -6674577247351833602L;
	public MissingFieldException() {
        super("Error: Missing ");
    }
	public MissingFieldException(String message)
	{
	super(message);
	}
}
