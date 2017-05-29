public class TextBuffer {

	private String content;
	private int caretPosition;
	private int startSelectionPosition;
	private int endSelectionPosition;
	private int selectionType;
	public Clipboard clipboard;
	
	private static final String CARET = "‸";
	public static final int UNSET_INDEX = -1;

	public TextBuffer() {
		super();
		this.content = CARET;
		this.caretPosition = 0;
		this.startSelectionPosition = UNSET_INDEX;
		this.endSelectionPosition = UNSET_INDEX;
		this.clipboard = new Clipboard(this);	
	}

	public void append(String text) {
		String newCharacters = this.getContentWithoutCaret() + text + CARET;
		this.content = newCharacters;
		this.caretPosition = this.content.length() - 1;
	}

	public void delete(int begin, int end) {
		String newContent;
		if(begin < end) {
			newContent = this.content.substring(0, begin + 1)
					 + this.content.substring(end, this.content.length() - 1);
		}
		else {
			newContent = this.content.substring(0, end + 1)
					 + this.getContentWithoutCaret().substring(begin, this.content.length() -1);
		}
		this.content = newContent;
		
	}

	public void insert(Integer position, String content) {
		String newContent = this.getContentWithoutCaret().substring(0, position) 
							 + content
							 + CARET
							 + this.getContentWithoutCaret().substring(position, this.content.length() -1);
		this.content = newContent;
	}

	public void replace(Integer begin, Integer end, String content) {

		this.delete(begin, end);
		this.insert(begin, content);

	}
	
	private String getContentWithoutCaret() {
		return this.content.replace(CARET, "");
	}
	
	public String getContent() {
		return this.content;
	}
	
	public int getLenght() {
		return this.getContent().length();
	}

	public int getCaretPosition() {
		return this.caretPosition;
	}

	public void setCaretPosition(int newPosition) {
		assert(newPosition >= 0 && newPosition < this.getLenght());
		this.caretPosition = newPosition;
		String newContent = this.getContentWithoutCaret().substring(0, newPosition)
							 + CARET
							 + this.getContentWithoutCaret().substring(newPosition, this.content.length() - 1);
		this.content = newContent;
	}
	
	public int getStartSelectionPosition() {
		return this.startSelectionPosition;
	}

	public void setStartSelectionPosition(int newStartSelectionPosition) {
		this.startSelectionPosition = newStartSelectionPosition;
	}

	public int getEndSelectionPosition() {
		return this.endSelectionPosition;
	}

	public void setEndSelectionPosition(int newEndSelectionPosition) {
		this.endSelectionPosition = newEndSelectionPosition;
	}
	
	public boolean isSelectionSet() {
		if(this.startSelectionPosition != UNSET_INDEX && this.endSelectionPosition != UNSET_INDEX) {
			return true;
		}
		return false;
	}
	
	public void resetSelection() {
		this.startSelectionPosition = this.UNSET_INDEX;
		this.endSelectionPosition = this.UNSET_INDEX;
	}
	
	public String getSelectionContent() {
		System.out.println("start : " + this.startSelectionPosition + " end : " + this.endSelectionPosition);
		if(this.endSelectionPosition > this.startSelectionPosition) {
			return this.content.substring(this.startSelectionPosition, this.endSelectionPosition);
		}
		else {
			return this.content.substring(this.endSelectionPosition + 1, this.startSelectionPosition + 1);
		}
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
