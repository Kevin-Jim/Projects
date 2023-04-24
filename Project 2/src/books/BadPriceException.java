
package books;

public class BadPriceException extends Exception {
	/**
	 * This is the BadPriceException that has the message that will be displayed in the error file
	 */
	private static final long serialVersionUID = 1L;
	public BadPriceException() {
        super("Error: invalid price");
    }
	public BadPriceException(String message)
	{
	super(message);
	}

}
