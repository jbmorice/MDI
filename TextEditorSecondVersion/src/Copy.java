public class Copy implements Command {
	
	private TextBuffer textBuffer;
	
	public Copy(TextBuffer textBuffer) {
		this.textBuffer = textBuffer;
	}

	public void execute() {
		this.textBuffer.getClipboard().setContent(this.textBuffer.getSelectionContent());
	}

}
