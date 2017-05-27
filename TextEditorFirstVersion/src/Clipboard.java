/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/

/**
 * Description of Clipboard.
 * 
 * @author jean-baptiste
 */
public class Clipboard {

	public TextBuffer textBuffer;
	private String content;

	public Clipboard(TextBuffer textBuffer) {
		super();
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String newContent) {
		this.content = newContent;
	}
	
	public TextBuffer getTextBuffer() {
		return this.textBuffer;
	}

	public void setTextBuffer(TextBuffer newTextBuffer) {
		if (this.textBuffer != null) {
			this.textBuffer.setClipboard(null);
		}
		this.textBuffer.setClipboard(this);
	}

}
