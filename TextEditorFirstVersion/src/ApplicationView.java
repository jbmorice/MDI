/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of ApplicationView.
 * 
 * @author jean-baptiste
 */
public abstract class ApplicationView {

	public ApplicationController applicationController;

	public ApplicationView() {
		super();
	}
	
	public ApplicationView(ApplicationController controller) {
		this();
		this.setApplicationController(controller);
	}

	public void updateBufferContent(String bufferContent) {}

	public void updateClipboardContent(String clipboardContent) {}

	public void updateBufferStartSelectionIndex(int index) {}

	public void updateBufferEndSelectionIndex(int index) {}

	public void updateBufferIndex(int index) {}

	public ApplicationController getApplicationController() {
		return this.applicationController;
	}
	
	public void setApplicationController(ApplicationController newApplicationController) {
		if(newApplicationController != this.applicationController) {
			if(this.applicationController != null) {
				this.applicationController.setApplicationView();
				
			}

			this.applicationController = newApplicationController;
			newApplicationController.setApplicationView(this);
			
		}
	}

	public void setApplicationController() {
		this.applicationController = null;
	}
	
}
