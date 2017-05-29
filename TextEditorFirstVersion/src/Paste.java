public class Paste implements Command {

	private TextBuffer textBuffer;
	
	public Paste(TextBuffer textBuffer) {
		this.textBuffer = textBuffer;
	}

	public void execute() {
		if(this.textBuffer.isSelectionSet()) {
			if(this.textBuffer.getStartSelectionPosition() < this.textBuffer.getEndSelectionPosition()){
				this.textBuffer.replace(this.textBuffer.getStartSelectionPosition(), this.textBuffer.getEndSelectionPosition(), this.textBuffer.getClipboard().getContent());				
			}
			else {
				this.textBuffer.replace(this.textBuffer.getEndSelectionPosition(), this.textBuffer.getStartSelectionPosition(), this.textBuffer.getClipboard().getContent());
			}
		}
		else {
			this.textBuffer.insert(this.textBuffer.getCaretPosition(), this.textBuffer.getClipboard().getContent());
			
		}
		this.textBuffer.setCaretPosition(this.textBuffer.getCaretPosition() + this.textBuffer.getClipboard().getContent().length());
		this.textBuffer.resetSelection();
	}
}
