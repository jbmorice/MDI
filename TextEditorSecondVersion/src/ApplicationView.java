public interface ApplicationView {

	public void updateBufferContent(String bufferContent);

	public void updateClipboardContent(String clipboardContent);

	public void updateBufferStartSelectionIndex(int index);

	public void updateBufferEndSelectionIndex(int index);

	public void updateBufferIndex(int index);

	public void setApplicationController(ApplicationController controller);

}
