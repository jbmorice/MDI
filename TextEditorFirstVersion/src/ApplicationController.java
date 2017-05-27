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

	public TextBuffer textBuffer;
	public HashSet<Command> commands = new HashSet<Command>();
	public ApplicationView applicationView;

	
	public ApplicationController() {
		super();
		this.textBuffer = new TextBuffer();
	}
	
	public ApplicationController(ApplicationView view) {
		this();
		this.setApplicationView(view);
	}

	public void moveCursorLeft() {
		this.textBuffer.setCursorIndex(this.textBuffer.getCursorIndex() - 1);
	}

	public void moveCursorRight() {
		this.textBuffer.setCursorIndex(this.textBuffer.getCursorIndex() + 1);
	}

	public void beginSelection(int startSelectionIndex) {

	}

	public void endSelection(int endSelectionIndex) {

	}

	public void append(String text) {
		this.getTextBuffer().append(text);
		this.applicationView.updateBufferContent(this.textBuffer.getCharacters());
	}

	public void delete(int begin, int end) {

	}

	public void copy(int begin, int end) {

	}

	public void cut(int begin, int end) {

	}

	public void paste(int begin, int end) {

	}

	public TextBuffer getTextBuffer() {
		return this.textBuffer;
	}

	public void setTextBuffer(TextBuffer newTextBuffer) {
		this.textBuffer = newTextBuffer;
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

}
