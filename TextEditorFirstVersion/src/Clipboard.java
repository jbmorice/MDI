/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Clipboard.
 * 
 * @author jean-baptiste
 */
public class Clipboard {
	/**
	 * Description of the property textBuffer.
	 */
	public TextBuffer textBuffer = null;

	/**
	 * Description of the property content.
	 */
	private String content;
	
	// Start of user code (user defined attributes for Clipboard)
	
	// End of user code

	/**
	 * The constructor.
	 */
	public Clipboard() {
		// Start of user code constructor for Clipboard)
		super();
		// End of user code
	}


	// Start of user code (user defined methods for Clipboard)

	// End of user code
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
//		if (this.textBuffer != null) {
//			this.textBuffer.set(null);
//		}
//		this.textBuffer.set(this);
	}

	/**
	 * Returns content.
	 * @return content 
	 */
	public Object getContent() {
		return this.content;
	}

	/**
	 * Sets a value to attribute content. 
	 * @param newContent 
	 */
	public void setContent(String newContent) {
		this.content = newContent;
	}

}
