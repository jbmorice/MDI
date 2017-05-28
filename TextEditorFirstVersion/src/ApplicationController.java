import java.util.HashMap;
import java.util.HashSet;

public class ApplicationController {

	private TextBuffer textBuffer;
	private HashMap<String, Command> commands = new HashMap<String, Command>();
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
		this.applicationView.updateBufferStartSelectionIndex(this.textBuffer.getStartSelectionPosition());
		this.applicationView.updateBufferEndSelectionIndex(this.textBuffer.getEndSelectionPosition());
		
		this.commands.put("copy", new Copy(this.textBuffer));
		this.commands.put("cut", new Cut(this.textBuffer));
		this.commands.put("paste", new Paste(this.textBuffer));
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
		this.textBuffer.setStartSelectionPosition(startSelectionIndex);
		this.applicationView.updateBufferStartSelectionIndex(startSelectionIndex);
	}

	public void setTextBufferEndSelectionIndex(int endSelectionIndex) {
		this.textBuffer.setEndSelectionPosition(endSelectionIndex);
		this.applicationView.updateBufferEndSelectionIndex(endSelectionIndex);
	}
	
	public int getTextBufferStartSelectionIndex() {
		return this.textBuffer.getStartSelectionPosition();
	}

	public int getTextBufferEndSelectionIndex() {
		return this.textBuffer.getEndSelectionPosition();
	}

	public void deleteContentFromTextBuffer(int begin, int end) {
		System.out.println("positions : " + begin + " " + end);
		this.textBuffer.delete(begin, end);
		this.applicationView.updateBufferContent(this.textBuffer.getContent());
	}

	public void copySelectionFromTextBuffer() {
		this.commands.get("copy").execute();
		this.applicationView.updateClipboardContent(this.textBuffer.getClipboard().getContent());
	}

	public void cutSelectionFromTextBuffer() {
		this.commands.get("cut").execute();
		this.applicationView.updateBufferContent(this.textBuffer.getContent());
		this.applicationView.updateBufferStartSelectionIndex(this.getTextBufferStartSelectionIndex());
		this.applicationView.updateBufferEndSelectionIndex(this.getTextBufferEndSelectionIndex());
		this.applicationView.updateClipboardContent(this.textBuffer.getClipboard().getContent());
	}

	public void pasteClipboardIntoTextBuffer() {
		this.commands.get("paste").execute();
		this.applicationView.updateBufferContent(this.textBuffer.getContent());
		this.applicationView.updateBufferStartSelectionIndex(this.getTextBufferStartSelectionIndex());
		this.applicationView.updateBufferEndSelectionIndex(this.getTextBufferEndSelectionIndex());
		this.applicationView.updateClipboardContent(this.textBuffer.getClipboard().getContent());
	}
	
	public int getTextBufferLength() {
		return this.textBuffer.getLenght();
	}

	public ApplicationView getApplicationView() {
		return this.applicationView;
	}

	public void setApplicationView(ApplicationView newApplicationView) {
		if(newApplicationView != this.applicationView) {
			if(this.applicationView != null) {
				this.applicationView = null;
				
			}

			this.applicationView = newApplicationView;
			this.applicationView.setApplicationController(this);
			
		}
	}

	public void resetTextBufferSelection() {
		this.textBuffer.resetSelection();
		this.applicationView.updateBufferStartSelectionIndex(this.textBuffer.getStartSelectionPosition());
		this.applicationView.updateBufferEndSelectionIndex(this.textBuffer.getEndSelectionPosition());		
	}

}
