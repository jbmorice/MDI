/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of ApplicationView.
 * 
 * @author jean-baptiste
 */
public interface ApplicationView {
	// Start of user code (user defined attributes for ApplicationView)

	// End of user code

	/**
	 * Description of the method moveCursorLeft.
	 */
	public void moveCursorLeft();

	/**
	 * Description of the method moveCursorRight.
	 */
	public void moveCursorRight();

	/**
	 * Description of the method beginSelection.
	 * @return 
	 */
	public Integer beginSelection();

	/**
	 * Description of the method endSelection.
	 * @return 
	 */
	public Integer endSelection();

	/**
	 * Description of the method append.
	 * @param newChar 
	 */
	public void append(char newChar);

	/**
	 * Description of the method copy.
	 */
	public void copy();

	/**
	 * Description of the method cut.
	 */
	public void cut();

	/**
	 * Description of the method paste.
	 */
	public void paste();

	// Start of user code (user defined methods for ApplicationView)

	// End of user code

}
