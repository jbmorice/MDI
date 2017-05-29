public class Cut implements Command {
	
	private TextBuffer textBuffer;
	
	public Cut(TextBuffer textBuffer) {
		this.textBuffer = textBuffer;
	}

	public void execute() {
		this.textBuffer.getClipboard().setContent(this.textBuffer.getSelectionContent());
		this.textBuffer.delete(this.textBuffer.getStartSelectionPosition(), this.textBuffer.getEndSelectionPosition());
		this.textBuffer.resetSelection();
		this.textBuffer.setCaretPosition(this.textBuffer.getLenght() - 1);
	}

}
