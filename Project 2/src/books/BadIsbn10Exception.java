
package books;

public class BadIsbn10Exception extends Exception {
	/**
	 * This is the BadIsbn10Exception that has the message that will be displayed in the error file
	 */
	private static final long serialVersionUID = 5174274880657757702L;
	public BadIsbn10Exception() {
        super("Error: invalid ISBN-10");
    }
	public BadIsbn10Exception(String message)
	{
	super(message);
	}
}
