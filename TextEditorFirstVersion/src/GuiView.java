import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/

/**
 * Description of GuiView.
 * 
 * @author jean-baptiste
 */
public class GuiView extends ApplicationView {

	private JFrame frame;
	private JTextField txtfldTextBufferContent;
	private JTextField txtfldTextBufferAppend;
	private JTextField txtfldClipboardContent;
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 513, 224);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{152, 213, 80, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblTextBufferContent = new JLabel("TextBuffer content :");
		GridBagConstraints gbc_lblTextBufferContent = new GridBagConstraints();
		gbc_lblTextBufferContent.insets = new Insets(0, 0, 5, 5);
		gbc_lblTextBufferContent.gridx = 0;
		gbc_lblTextBufferContent.gridy = 0;
		frame.getContentPane().add(lblTextBufferContent, gbc_lblTextBufferContent);
		
		txtfldTextBufferContent = new JTextField();
		txtfldTextBufferContent.setEditable(false);
		GridBagConstraints gbc_txtfldTextBufferContent = new GridBagConstraints();
		gbc_txtfldTextBufferContent.gridwidth = 2;
		gbc_txtfldTextBufferContent.insets = new Insets(0, 0, 5, 0);
		gbc_txtfldTextBufferContent.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfldTextBufferContent.gridx = 1;
		gbc_txtfldTextBufferContent.gridy = 0;
		frame.getContentPane().add(txtfldTextBufferContent, gbc_txtfldTextBufferContent);
		txtfldTextBufferContent.setColumns(10);
		
		JLabel lblTextBufferAppend = new JLabel("Type something :");
		GridBagConstraints gbc_lblTextBufferAppend = new GridBagConstraints();
		gbc_lblTextBufferAppend.insets = new Insets(0, 0, 5, 5);
		gbc_lblTextBufferAppend.gridx = 0;
		gbc_lblTextBufferAppend.gridy = 1;
		frame.getContentPane().add(lblTextBufferAppend, gbc_lblTextBufferAppend);
		
		txtfldTextBufferAppend = new JTextField();
		GridBagConstraints gbc_txtfldTextBufferAppend = new GridBagConstraints();
		gbc_txtfldTextBufferAppend.insets = new Insets(0, 0, 5, 5);
		gbc_txtfldTextBufferAppend.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfldTextBufferAppend.gridx = 1;
		gbc_txtfldTextBufferAppend.gridy = 1;
		frame.getContentPane().add(txtfldTextBufferAppend, gbc_txtfldTextBufferAppend);
		txtfldTextBufferAppend.setColumns(10);
		
		JButton btnTextBufferAppend = new JButton("Add");
		btnTextBufferAppend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				applicationController.append(txtfldTextBufferAppend.getText());
				txtfldTextBufferAppend.setText("");
				
			}
		});
		GridBagConstraints gbc_btnTextBufferAppend = new GridBagConstraints();
		gbc_btnTextBufferAppend.insets = new Insets(0, 0, 5, 0);
		gbc_btnTextBufferAppend.gridx = 2;
		gbc_btnTextBufferAppend.gridy = 1;
		frame.getContentPane().add(btnTextBufferAppend, gbc_btnTextBufferAppend);
		
		JPanel controlPanel = new JPanel();
		GridBagConstraints gbc_controlPanel = new GridBagConstraints();
		gbc_controlPanel.insets = new Insets(0, 0, 5, 0);
		gbc_controlPanel.gridwidth = 3;
		gbc_controlPanel.fill = GridBagConstraints.BOTH;
		gbc_controlPanel.gridx = 0;
		gbc_controlPanel.gridy = 2;
		frame.getContentPane().add(controlPanel, gbc_controlPanel);
		controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel cursorControlPanel = new JPanel();
		controlPanel.add(cursorControlPanel);
		cursorControlPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCursor = new JLabel("Move cursor");
		lblCursor.setHorizontalAlignment(SwingConstants.CENTER);
		cursorControlPanel.add(lblCursor, BorderLayout.NORTH);
		
		JPanel cursorControlButtonsPanel = new JPanel();
		cursorControlPanel.add(cursorControlButtonsPanel, BorderLayout.SOUTH);
		cursorControlButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnMoveCursorLeft = new JButton("Left");
		cursorControlButtonsPanel.add(btnMoveCursorLeft);
		
		JButton btnMoveCursorRight = new JButton("Right");
		cursorControlButtonsPanel.add(btnMoveCursorRight);
		
		JPanel selectionControlPanel = new JPanel();
		controlPanel.add(selectionControlPanel);
		selectionControlPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSelection = new JLabel("Selection");
		lblSelection.setHorizontalAlignment(SwingConstants.CENTER);
		selectionControlPanel.add(lblSelection, BorderLayout.NORTH);
		
		JPanel selectionControlButtonsPanel = new JPanel();
		selectionControlPanel.add(selectionControlButtonsPanel, BorderLayout.SOUTH);
		selectionControlButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnStartSelection = new JButton("Start");
		selectionControlButtonsPanel.add(btnStartSelection);
		
		JButton btnEndSelection = new JButton("End");
		selectionControlButtonsPanel.add(btnEndSelection);
		
		JButton btnResetSelection = new JButton("Reset");
		selectionControlButtonsPanel.add(btnResetSelection);
		
		JPanel actionPanel = new JPanel();
		GridBagConstraints gbc_actionPanel = new GridBagConstraints();
		gbc_actionPanel.insets = new Insets(0, 0, 5, 0);
		gbc_actionPanel.gridwidth = 3;
		gbc_actionPanel.fill = GridBagConstraints.BOTH;
		gbc_actionPanel.gridx = 0;
		gbc_actionPanel.gridy = 3;
		frame.getContentPane().add(actionPanel, gbc_actionPanel);
		actionPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lbActionPanel = new JLabel("Actions");
		lbActionPanel.setHorizontalAlignment(SwingConstants.CENTER);
		actionPanel.add(lbActionPanel, BorderLayout.NORTH);
		
		JPanel actionButtonsPanel = new JPanel();
		actionPanel.add(actionButtonsPanel, BorderLayout.CENTER);
		actionButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnCopy = new JButton("Copy");
		actionButtonsPanel.add(btnCopy);
		
		JButton btnCut = new JButton("Cut");
		actionButtonsPanel.add(btnCut);
		
		JButton btnPaste = new JButton("Paste");
		actionButtonsPanel.add(btnPaste);
		
		JButton btnDelete = new JButton("Delete");
		actionButtonsPanel.add(btnDelete);
		
		JLabel lblClipboardContent = new JLabel("Clipboard content :");
		GridBagConstraints gbc_lblClipboardContent = new GridBagConstraints();
		gbc_lblClipboardContent.insets = new Insets(0, 0, 0, 5);
		gbc_lblClipboardContent.gridx = 0;
		gbc_lblClipboardContent.gridy = 4;
		frame.getContentPane().add(lblClipboardContent, gbc_lblClipboardContent);
		
		txtfldClipboardContent = new JTextField();
		txtfldClipboardContent.setEditable(false);
		GridBagConstraints gbc_txtfldClipboardContent = new GridBagConstraints();
		gbc_txtfldClipboardContent.gridwidth = 2;
		gbc_txtfldClipboardContent.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfldClipboardContent.gridx = 1;
		gbc_txtfldClipboardContent.gridy = 4;
		frame.getContentPane().add(txtfldClipboardContent, gbc_txtfldClipboardContent);
		txtfldClipboardContent.setColumns(10);
	}

	public GuiView() {
		super();
		initialize();
		this.frame.setVisible(true);
	}
	
	public void updateBufferContent(String bufferContent) {
		this.txtfldTextBufferContent.setText(bufferContent);
	}
	
	public void updateClipboardContent(String clipboardContent) {
		this.txtfldClipboardContent.setText(clipboardContent);
	}

	public void updateBufferStartSelectionIndex(int index) {
		this.txtfldTextBufferContent.setSelectionStart(index);
	}

	public void updateBufferEndSelectionIndex(int index) {
		this.txtfldTextBufferContent.setSelectionEnd(index);
	}

	public void updateBufferIndex(int index) {
		this.txtfldTextBufferContent.setCaretPosition(index);
	}


}
