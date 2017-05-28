import java.util.HashSet;

public class ApplicationController {

	private TextBuffer textBuffer;
	private HashSet<Command> commands = new HashSet<Command>();
	private ApplicationView applicationView;

	
	public ApplicationController() {
		super();
		this.textBuffer = new TextBuffer();
	}
	
	public ApplicationController(ApplicationView view) {
		this();
		this.setApplicationView(view);
		this.applicationView.updateBufferContent(this.textBuffer.getContent());
		this.applicationView.updateBufferIndex(this.textBuffer.getCaretPosition());
		this.applicationView.updateBufferStartSelectionIndex(this.textBuffer.getStartSelectionIndex());
		this.applicationView.updateBufferEndSelectionIndex(this.textBuffer.getEndSelectionIndex());
	}
	
	public void appendToTextBuffer(String text) {
		this.textBuffer.append(text);
		this.applicationView.updateBufferContent(this.textBuffer.getContent());
		this.applicationView.updateBufferIndex(this.textBuffer.getCaretPosition());
	}

	public void moveTextBufferCaretLeft() {
		assert(this.textBuffer.getCaretPosition() - 1 >= 0);
		this.textBuffer.setCaretPosition(this.textBuffer.getCaretPosition() - 1);
		this.applicationView.updateBufferIndex(this.textBuffer.getCaretPosition());
		this.applicationView.updateBufferContent(this.textBuffer.getContent());
	}

	public void moveTextBufferCaretRight() {
		assert(this.textBuffer.getCaretPosition() + 1 < this.textBuffer.getLenght());
		this.textBuffer.setCaretPosition(this.textBuffer.getCaretPosition() + 1);
		this.applicationView.updateBufferIndex(this.textBuffer.getCaretPosition());
		this.applicationView.updateBufferContent(this.textBuffer.getContent());
	}
	
	public int getTextBufferCaretPosition() {
		return this.textBuffer.getCaretPosition();
	}
	
	public boolean isTextBufferSelectionSet() {
		return this.textBuffer.isSelectionSet();
	}
	
	public String getTextBufferSelectionContent() {
		return this.textBuffer.getSelectionContent();
	}
	
	public void setTextBufferStartSelectionIndex(int startSelectionIndex) {
		this.textBuffer.setStartSelectionIndex(startSelectionIndex);
		this.applicationView.updateBufferStartSelectionIndex(startSelectionIndex);
	}

	public void setTextBufferEndSelectionIndex(int endSelectionIndex) {
		this.textBuffer.setEndSelectionIndex(endSelectionIndex);
		this.applicationView.updateBufferEndSelectionIndex(endSelectionIndex);
	}
	
	public int getTextBufferStartSelectionIndex() {
		return this.textBuffer.getStartSelectionIndex();
	}

	public int getTextBufferEndSelectionIndex() {
		return this.textBuffer.getEndSelectionIndex();
	}

	public void deleteContentFromTextBuffer(int begin, int end) {
		System.out.println("positions : " + begin + " " + end);
		this.textBuffer.delete(begin, end);
		this.applicationView.updateBufferContent(this.textBuffer.getContent());
	}

	public void copy(int begin, int end) {

	}

	public void cut(int begin, int end) {

	}

	public void paste(int begin, int end) {

	}
	
	public int getTextBufferLength() {
		return this.textBuffer.getLenght();
	}

	public HashSet<Command> getCommands() {
		return this.commands;
	}

	public void addCommand(Command commandToAdd) {
		this.commands.add(commandToAdd);
	}

	public void removeCommand(Command commandToRemove) {
		this.commands.remove(commandToRemove);
	}

	public ApplicationView getApplicationView() {
		return this.applicationView;
	}

	public void setApplicationView(ApplicationView newApplicationView) {
		if(newApplicationView != this.applicationView) {
			if(this.applicationView != null) {
				this.applicationView.setApplicationController();
				
			}

			this.applicationView = newApplicationView;
			this.applicationView.setApplicationController(this);
			
		}
	}
	
	public void setApplicationView() {
		this.applicationView = null;
	}

	public void resetTextBufferSelection() {
		this.textBuffer.resetSelection();
		this.applicationView.updateBufferStartSelectionIndex(this.textBuffer.getStartSelectionIndex());
		this.applicationView.updateBufferEndSelectionIndex(this.textBuffer.getEndSelectionIndex());		
	}

}
