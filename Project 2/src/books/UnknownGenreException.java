
package books;

public class UnknownGenreException extends Exception{
	/**
	 * This is the UnknwoGenreException that has the message that will be displayed in the error file
	 */
	private static final long serialVersionUID = 6639263841787130491L;
	public UnknownGenreException() {
        super("Error: unknown genre");
    }
	public UnknownGenreException(String message)
	{
	super(message);
	}

}
