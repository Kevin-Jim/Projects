
package books;

public class BadYearException extends Exception {
	/**
	 * This is the BadYearException that has the message that will be displayed in the error file
	 */
	private static final long serialVersionUID = -7667483852383046187L;
	public BadYearException() {
        super("Error: invalid year");
    }
	public BadYearException(String message)
	{
	super(message);
	}
}
