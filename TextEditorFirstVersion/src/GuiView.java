/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.text.DefaultCaret;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JToggleButton;
import javax.swing.DropMode;
import javax.swing.JTextArea;
// End of user code

/**
 * Description of GuiView.
 * 
 * @author jean-baptiste
 */
public class GuiView implements ApplicationView {
	private JFrame frame;
	private ApplicationController controller;

	/**
	 * The constructor.
	 * Create the application.
	 */
	public GuiView() {
		super();
		controller = new ApplicationController();
		initialize();
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
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_3);
		
		JButton btn_prev = new JButton("<-");
		toolBar.add(btn_prev);
		
		JButton btn_next = new JButton("->");
		toolBar.add(btn_next);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_2);
		
		JToggleButton btn_select = new JToggleButton("Select");
		toolBar.add(btn_select);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_1);
		
		JButton btn_copy = new JButton("Copy");
		toolBar.add(btn_copy);
		
		JButton btn_paste = new JButton("Paste");
		toolBar.add(btn_paste);
		
		JButton btn_cut = new JButton("Cut");
		toolBar.add(btn_cut);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut);
		
		JTextPane textPane = new JTextPane();
		textPane.setDropMode(DropMode.ON);
		frame.getContentPane().add(textPane, BorderLayout.CENTER);
	}

	/**
	 * Description of the method moveCursorLeft.
	 */
	public void moveCursorLeft() {

	}

	/**
	 * Description of the method moveCursorRight.
	 */
	public void moveCursorRight() {

	}

	/**
	 * Description of the method beginSelection.
	 * @return 
	 */
	public Integer beginSelection() {
		Integer beginSelection = Integer.valueOf(0);
		return beginSelection;
	}

	/**
	 * Description of the method endSelection.
	 * @return 
	 */
	public Integer endSelection() {
		Integer endSelection = Integer.valueOf(0);
		return endSelection;
	}

	/**
	 * Description of the method append.
	 * @param newChar 
	 */
	public void append(char newChar) {
	
	}

	/**
	 * Description of the method copy.
	 */
	public void copy() {
	
	}

	/**
	 * Description of the method cut.
	 */
	public void cut() {
	
	}

	/**
	 * Description of the method paste.
	 */
	public void paste() {
	
	}

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
}
