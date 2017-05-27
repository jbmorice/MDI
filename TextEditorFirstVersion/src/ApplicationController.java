import java.util.HashSet;

/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/

/**
 * Description of ApplicationController.
 * 
 * @author jean-baptiste
 */
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
		this.applicationView.updateBufferIndex(this.textBuffer.getCursorIndex());
		this.applicationView.updateBufferStartSelectionIndex(this.textBuffer.getStartSelectionIndex());
		this.applicationView.updateBufferEndSelectionIndex(this.textBuffer.getEndSelectionIndex());
	}
	
	public void append(String text) {
		this.textBuffer.append(text);
		this.applicationView.updateBufferContent(this.textBuffer.getContent());
		this.applicationView.updateBufferIndex(this.textBuffer.getCursorIndex());
	}

	public void moveCursorLeft() {
		assert(this.textBuffer.getCursorIndex() - 1 >= 0);
		this.textBuffer.setCursorIndex(this.textBuffer.getCursorIndex() - 1);
		this.applicationView.updateBufferIndex(this.textBuffer.getCursorIndex());
		this.applicationView.updateBufferContent(this.textBuffer.getContent());
	}

	public void moveCursorRight() {
		assert(this.textBuffer.getCursorIndex() + 1 < this.textBuffer.getLenght());
		this.textBuffer.setCursorIndex(this.textBuffer.getCursorIndex() + 1);
		this.applicationView.updateBufferIndex(this.textBuffer.getCursorIndex());
		this.applicationView.updateBufferContent(this.textBuffer.getContent());
	}

	public void beginSelection(int startSelectionIndex) {

	}

	public void endSelection(int endSelectionIndex) {

	}
	
	public boolean isSelectionSet() {
		return this.textBuffer.isSelectionSet();
	}

	public void delete(int begin, int end) {
		
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
/*
	public TextBuffer getTextBuffer() {
		return this.textBuffer;
	}

	public void setTextBuffer(TextBuffer newTextBuffer) {
		this.textBuffer = newTextBuffer;
	}
*/

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

}
