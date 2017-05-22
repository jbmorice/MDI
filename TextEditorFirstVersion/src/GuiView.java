/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JTextField;
// End of user code

/**
 * Description of GuiView.
 * 
 * @author jean-baptiste
 */
public class GuiView implements ApplicationView {
	// Start of user code (user defined attributes for GuiView)
	private JFrame frame;
	private JTextField textField;
	// End of user code

	/**
	 * The constructor.
	 * Create the application.
	 */
	public GuiView() {
		// Start of user code constructor for GuiView)
		super();
		initialize();
		// End of user code
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		textField = new JTextField();
		frame.getContentPane().add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
	}

	/**
	 * Description of the method moveCursorLeft.
	 */
	public void moveCursorLeft() {
		// Start of user code for method moveCursorLeft
		// End of user code
	}

	/**
	 * Description of the method moveCursorRight.
	 */
	public void moveCursorRight() {
		// Start of user code for method moveCursorRight
		// End of user code
	}

	/**
	 * Description of the method beginSelection.
	 * @return 
	 */
	public Integer beginSelection() {
		// Start of user code for method beginSelection
		Integer beginSelection = Integer.valueOf(0);
		return beginSelection;
		// End of user code
	}

	/**
	 * Description of the method endSelection.
	 * @return 
	 */
	public Integer endSelection() {
		// Start of user code for method endSelection
		Integer endSelection = Integer.valueOf(0);
		return endSelection;
		// End of user code
	}

	/**
	 * Description of the method append.
	 * @param newChar 
	 */
	public void append(char newChar) {
		// Start of user code for method append
		// End of user code
	}

	/**
	 * Description of the method copy.
	 */
	public void copy() {
		// Start of user code for method copy
		// End of user code
	}

	/**
	 * Description of the method cut.
	 */
	public void cut() {
		// Start of user code for method cut
		// End of user code
	}

	/**
	 * Description of the method paste.
	 */
	public void paste() {
		// Start of user code for method paste
		// End of user code
	}

	// Start of user code (user defined methods for GuiView)
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiView window = new GuiView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// End of user code

}
