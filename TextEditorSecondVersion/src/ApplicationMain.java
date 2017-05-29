import java.awt.EventQueue;

public class ApplicationMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationView view = new GuiView();
					ApplicationController controller = new ApplicationController(view);	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}

}
