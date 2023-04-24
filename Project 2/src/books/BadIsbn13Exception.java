
package books;

public class BadIsbn13Exception extends Exception {
	/**
	 * This is the BadIsbn13Exception that has the message that will be displayed in the error file
	 */
	private static final long serialVersionUID = -3013837792022330646L;
	public BadIsbn13Exception() {
        super("Error: invalid ISBN-13");
    }
	public BadIsbn13Exception(String message)
	{
	super(message);
	}
}
