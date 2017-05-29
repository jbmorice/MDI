
public class TextBufferMemento {

	private String content;
	private int caretPosition;
	private int startSelectionPosition;
	private int endSelectionPosition;
	private String clipboardContent;

	public TextBufferMemento(String content, int caretPosition, int startSelectionPosition, int endSelectionPosition,
			String clipboardContent) {
		super();
		this.content = content;
		this.caretPosition = caretPosition;
		this.startSelectionPosition = startSelectionPosition;
		this.endSelectionPosition = endSelectionPosition;
		this.clipboardContent = clipboardContent;
	}

	public String getContent() {
		return content;
	}

	public int getCaretPosition() {
		return caretPosition;
	}

	public int getStartSelectionPosition() {
		return startSelectionPosition;
	}

	public int getEndSelectionPosition() {
		return endSelectionPosition;
	}

	public String getClipboardContent() {
		return clipboardContent;
	}

}
