/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of TextBuffer.
 * 
 * @author jean-baptiste
 */
public class TextBuffer {
	private int startSelectionIndex;
	private int endSelectionIndex;
	private String characters;
	public Clipboard clipboard;
	private int cursorIndex;

	// Start of user code (user defined attributes for TextBuffer)

	// End of user code

	/**
	 * The constructor.
	 */
	public TextBuffer() {
		// Start of user code constructor for TextBuffer)
		super();
		// End of user code
	}

	/**
	 * Description of the method setStartSelectionIndex.
	 * @param cursorIndex 
	 * @return 
	 */
	public boolean setStartSelectionIndex(int cursorIndex) {
		// Start of user code for method setStartSelectionIndex
		return false;
		// End of user code
	}

	/**
	 * Description of the method setEndSelectionIndex.
	 * @param cursorIndex 
	 * @return 
	 */
	public boolean setEndSelectionIndex(int cursorIndex) {
		// Start of user code for method setEndSelectionIndex
		return false;
		// End of user code
	}

	/**
	 * Description of the method getStartSelectionIndex.
	 * @return 
	 */
	public int getStartSelectionIndex() {
		// Start of user code for method getStartSelectionIndex
		return 0;
		// End of user code
	}

	/**
	 * Description of the method isSelectionSet.
	 * @return 
	 */
	public boolean isSelectionSet() {
		// Start of user code for method isSelectionSet
		return false;
		// End of user code
	}

	/**
	 * Description of the method append.
	 * @param newChar 
	 */
	public void append(char newChar) {
		// Start of user code for method append
		// End of user code
	}

	/**
	 * Description of the method delete.
	 * @param begin 
	 * @param end 
	 */
	public void delete(int begin, int end) {
		// Start of user code for method delete
		// End of user code
	}

	/**
	 * Description of the method insert.
	 * @param position 
	 * @param content 
	 */
	public void insert(int position, String content) {
		// Start of user code for method insert
		// End of user code
	}

	/**
	 * Description of the method replace.
	 * @param begin 
	 * @param end 
	 * @param content 
	 */
	public void replace(int begin, int end, String content) {
		// Start of user code for method replace
		// End of user code
	}

	// Start of user code (user defined methods for TextBuffer)

	// End of user code
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
	public void setStartSelelctionIndex(int newStartSelelctionIndex) {
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
//		if (this.clipboard != null) {
//			this.clipboard.set(null);
//		}
//		this.clipboard.set(this);
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

}
