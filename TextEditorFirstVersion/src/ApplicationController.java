import java.util.ArrayList;
import java.util.List;

/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of ApplicationController.
 * 
 * @author jean-baptiste
 */
public class ApplicationController {
	/**
	 * Description of the property commands.
	 */
	public List<Command> commands = new ArrayList<Command>();

	/**
	 * Description of the property applicationView.
	 */
	public ApplicationView applicationView = null;

	/**
	 * Description of the property textBuffer.
	 */
	public TextBuffer textBuffer = null;

	// Start of user code (user defined attributes for ApplicationController)

	// End of user code

	/**
	 * The constructor.
	 */
	public ApplicationController() {
		// Start of user code constructor for ApplicationController)
		super();
		textBuffer = new TextBuffer();
		textBuffer.append('a');
		textBuffer.append('a');
		textBuffer.append('b');
		textBuffer.append('b');
		textBuffer.append('c');
		textBuffer.append('c');
		textBuffer.append('d');
		textBuffer.append('d');
		textBuffer.append('e');
		textBuffer.append('e');
		textBuffer.delete(0,0);
		
		System.out.println(textBuffer.getCharacters());
		
		// End of user code
	}

	/**
	 * Description of the method moveCursorLeft.
	 */
	public void moveCursorLeft() {
		
	}

	/**
	 * Description of the method moveCursorRight.
	 */
	public void moveCursorRight() {
		// Start of user code for method moveCursorRight
		// End of user code
	}

	/**
	 * Description of the method beginSelection.
	 * @return 
	 */
	public Integer beginSelection() {
		// Start of user code for method beginSelection
		Integer beginSelection = Integer.valueOf(0);
		return beginSelection;
		// End of user code
	}

	/**
	 * Description of the method endSelection.
	 * @return 
	 */
	public Integer endSelection() {
		// Start of user code for method endSelection
		Integer endSelection = Integer.valueOf(0);
		return endSelection;
		// End of user code
	}

	/**
	 * Description of the method append.
	 * @param char 
	 */
	public void append(char newChar) {
		textBuffer.append(newChar);
	}

	/**
	 * Description of the method cut.
	 */
	public void cut() {
		
	}

	/**
	 * Description of the method paste.
	 */
	public void paste() {
		
	}

	/**
	 * Description of the method copy.
	 */
	public void copy() {
		// Start of user code for method copy
		// End of user code
	}

	// Start of user code (user defined methods for ApplicationController)

	// End of user code
	/**
	 * Returns commands.
	 * @return commands 
	 */
	public List<Command> getCommands() {
		return this.commands;
	}

	/**
	 * Returns applicationView.
	 * @return applicationView 
	 */
	public ApplicationView getApplicationView() {
		return this.applicationView;
	}

	/**
	 * Sets a value to attribute applicationView. 
	 * @param newApplicationView 
	 */
	public void setApplicationView(ApplicationView newApplicationView) {
//		if (this.applicationView != null) {
//			this.applicationView.set(null);
//		}
//		this.applicationView.set(this);
	}

	/**
	 * Returns textBuffer.
	 * @return textBuffer 
	 */
	public TextBuffer getTextBuffer() {
		return this.textBuffer;
	}

	/**
	 * Sets a value to attribute textBuffer. 
	 * @param newTextBuffer 
	 */
	public void setTextBuffer(TextBuffer newTextBuffer) {
		this.textBuffer = newTextBuffer;
	}

}
