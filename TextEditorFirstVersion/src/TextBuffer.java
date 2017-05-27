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

	public TextBuffer() {
		super();
		this.characters = "";
		this.cursorIndex = 0;
		this.startSelectionIndex = -1;
		this.endSelectionIndex = -1;
		this.clipboard = new Clipboard(this);
		
	}

	public void append(String text) {
		this.characters += text;
	}

	public void delete(int begin, int end) {
		String newCharacters = this.characters.substring(0, begin)
							 + this.characters.substring(end, this.characters.length() -1);
		this.setCharacters(newCharacters);
	}

	public void insert(Integer position, String content) {
		String newCharacters = this.characters.substring(0, position) 
							 + content
							 + this.characters.substring(position, this.characters.length() -1);
		this.setCharacters(newCharacters);
	}

	public void replace(Integer begin, Integer end, String content) {
		this.delete(begin, end);
		this.insert(begin, content);
	}

	private void setCharacters(String newCharacters) {
		this.characters = newCharacters;
	}
	
	public String getCharacters() {
		return this.characters;
	}
	
	public int getLenght() {
		return this.characters.length();
	}

	public int getCursorIndex() {
		return this.cursorIndex;
	}

	public void setCursorIndex(int newCursorIndex) {
		this.cursorIndex = newCursorIndex;
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
