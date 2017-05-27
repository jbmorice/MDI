/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/

/**
 * Description of TextBuffer.
 * 
 * @author jean-baptiste
 */
public class TextBuffer {

	private String characters;
	private int cursorIndex;
	private int startSelectionIndex;
	private int endSelectionIndex;
	public Clipboard clipboard;
	
	private static final String CARET = "‸";

	public TextBuffer() {
		super();
		this.characters = CARET;
		this.cursorIndex = 0;
		this.startSelectionIndex = -1;
		this.endSelectionIndex = -1;
		this.clipboard = new Clipboard(this);	
	}

	public void append(String text) {
		String newCharacters = this.getContentWithoutCaret() + text + CARET;
		this.characters = newCharacters;
		this.cursorIndex += text.length();
	}

	public void delete(int begin, int end) {
		String newCharacters = this.getContentWithoutCaret().substring(0, begin)
							 + this.getContentWithoutCaret().substring(end, this.characters.length() -1)
							 + CARET;
		this.characters = newCharacters;
	}

	public void insert(Integer position, String content) {
		String newCharacters = this.getContentWithoutCaret().substring(0, position) 
							 + content
							 + CARET
							 + this.getContentWithoutCaret().substring(position, this.characters.length() -1);
		this.characters = newCharacters;
	}

	public void replace(Integer begin, Integer end, String content) {
		this.delete(begin, end);
		this.insert(begin, content);
	}
	
	private String getContentWithoutCaret() {
		return this.characters.replace(CARET, "");
	}
	
	public String getContent() {
		return this.characters;
	}
	
	public int getLenght() {
		return this.getContentWithoutCaret().length();
	}

	public int getCursorIndex() {
		return this.cursorIndex;
	}

	public void setCursorIndex(int newCursorIndex) {
		assert(newCursorIndex >= 0 && newCursorIndex < this.getLenght());
		this.cursorIndex = newCursorIndex;
		String newCharacters = this.getContentWithoutCaret().substring(0, newCursorIndex)
							 + CARET
							 + this.getContentWithoutCaret().substring(newCursorIndex, this.characters.length() - 1);
		this.characters = newCharacters;
		System.out.println("cursor index "+this.cursorIndex);
	}
	
	public int getStartSelectionIndex() {
		return this.startSelectionIndex;
	}

	public void setStartSelectionIndex(int newStartSelectionIndex) {
		this.startSelectionIndex = newStartSelectionIndex;
	}

	public int getEndSelectionIndex() {
		return this.endSelectionIndex;
	}

	public void setEndSelectionIndex(int newEndSelectionIndex) {
		this.endSelectionIndex = newEndSelectionIndex;
	}
	
	public boolean isSelectionSet() {
		if(this.getStartSelectionIndex() != -1 && this.getEndSelectionIndex() != -1) {
			return true;
		}
		return false;
	}

	public Clipboard getClipboard() {
		return this.clipboard;
	}

	public void setClipboard(Clipboard newClipboard) {
		if (this.clipboard != null) {
			this.clipboard.setTextBuffer(null);
		}
		this.clipboard.setTextBuffer(this);
	}

}
