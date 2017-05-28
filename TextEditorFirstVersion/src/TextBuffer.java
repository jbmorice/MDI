public class TextBuffer {

	private String content;
	private int caretPosition;
	private int startSelectionIndex;
	private int endSelectionIndex;
	private int selectionType;
	public Clipboard clipboard;
	
	private static final String CARET = "‸";
	public static final int UNSET_INDEX = -1;

	public TextBuffer() {
		super();
		this.content = CARET;
		this.caretPosition = 0;
		this.startSelectionIndex = UNSET_INDEX;
		this.endSelectionIndex = UNSET_INDEX;
		this.clipboard = new Clipboard(this);	
	}

	public void append(String text) {
		String newCharacters = this.getContentWithoutCaret() + text + CARET;
		this.content = newCharacters;
		this.caretPosition += text.length();
	}

	public void delete(int begin, int end) {
		String newContent = this.getContentWithoutCaret().substring(0, begin)
							 + this.getContentWithoutCaret().substring(end, this.content.length() -1)
							 + CARET;
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
		if(this.startSelectionIndex != UNSET_INDEX && this.endSelectionIndex != UNSET_INDEX) {
			return true;
		}
		return false;
	}
	
	public String getSelectionContent() {
		System.out.println("start : " + this.startSelectionIndex + " end : " + this.endSelectionIndex);
		if(this.endSelectionIndex > this.startSelectionIndex) {
			return this.content.substring(this.startSelectionIndex, this.endSelectionIndex);
		}
		else {
			return this.content.substring(this.endSelectionIndex + 1, this.startSelectionIndex + 1);
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
