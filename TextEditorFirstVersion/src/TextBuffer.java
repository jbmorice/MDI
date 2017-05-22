/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/

/**
 * Description of TextBuffer.
 * 
 * @author jean-baptiste
 */
public class TextBuffer {
	private int cursorIndex;
	private int startSelectionIndex;
	private int endSelectionIndex;
	private String characters;
	public Clipboard clipboard;

	/**
	 * The constructor.
	 */
	public TextBuffer() {
		super();
		this.cursorIndex = 0;
		this.startSelectionIndex = -1;
		this.endSelectionIndex = -1;
		this.clipboard = new Clipboard();
	}

	/**
	 * Description of the method append.
	 * @param newChar 
	 */
	public void append(char newChar) {
		this.characters += newChar;
	}

	/**
	 * Description of the method delete.
	 * @param begin 
	 * @param end 
	 */
	public void delete(int begin, int end) {
		assert(begin > -1 && begin < this.characters.length());
		CharSequence target = this.characters.subSequence(begin, end);
		this.characters.replace(target, null);
		
	}

	/**
	 * Description of the method insert.
	 * @param position 
	 * @param content 
	 */
	public void insert(int position, String content) {

	}

	/**
	 * Description of the method replace.
	 * @param begin 
	 * @param end 
	 * @param content 
	 */
	public void replace(int begin, int end, String content) {

	}
	
	/**
	 * Returns cursorIndex.
	 * @return cursorIndex 
	 */
	public Integer getCursorIndex() {
		return this.cursorIndex;
	}

	/**
	 * Sets a value to attribute cursorIndex. 
	 * @param newCursorIndex 
	 */
	public void setCursorIndex(Integer newCursorIndex) {
		this.cursorIndex = newCursorIndex;
	}

	/**
	 * Returns startSelelctionIndex.
	 * @return startSelelctionIndex 
	 */
	public int getStartSelelctionIndex() {
		return this.startSelectionIndex;
	}

	/**
	 * Sets a value to attribute startSelelctionIndex. 
	 * @param newStartSelelctionIndex 
	 */
	public void setStartSelectionIndex(int newStartSelelctionIndex) {
		this.startSelectionIndex = newStartSelelctionIndex;
	}

	/**
	 * Returns endSelectionIndex.
	 * @return endSelectionIndex 
	 */
	public int getEndSelectionIndex() {
		return this.endSelectionIndex;
	}

	/**
	 * Sets a value to attribute endSelectionIndex. 
	 * @param newEndSelectionIndex 
	 */
	public void setEndSelectionIndex(Integer newEndSelectionIndex) {
		this.endSelectionIndex = newEndSelectionIndex;
	}
	
	/**
	 * Description of the method isSelectionSet.
	 * @return 
	 */
	public boolean isSelectionSet() {
		if(this.startSelectionIndex > -1 && this.endSelectionIndex > -1) {
			return true;
		}
		return false;
	}

	/**
	 * Returns characters.
	 * @return characters 
	 */
	public String getCharacters() {
		return this.characters;
	}

	/**
	 * Sets a value to attribute characters. 
	 * @param newCharacters 
	 */
	public void setCharacters(String newCharacters) {
		this.characters = newCharacters;
	}

	/**
	 * Returns clipboard.
	 * @return clipboard 
	 */
	public Clipboard getClipboard() {
		return this.clipboard;
	}

	/**
	 * Sets a value to attribute clipboard. 
	 * @param newClipboard 
	 */
	public void setClipboard(Clipboard newClipboard) {

	}

}
