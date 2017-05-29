import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.xml.soap.Text;

public class GuiView implements ApplicationView {
	
	private ApplicationController applicationController;

	private JFrame frame;
	private JTextField txtfldTextBufferContent;
	private JTextField txtfldTextBufferAppend;
	private JTextField txtfldClipboardContent;

	private JButton btnMoveCursorLeft;
	private JButton btnMoveCursorRight;
	
	private JButton btnStartSelection;
	private JButton btnEndSelection;
	private JButton btnResetSelection;
	private JTextField txtfldSelectionContent;
	
	private JButton btnDelete;
	private JButton btnCopy;
	private JButton btnCut;
	private JButton btnPaste;
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 630, 237);
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
//		txtfldTextBufferContent.setSelectionColor(new Color(0, 0, 1));
		
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
		
		JButton btnTextBufferAppend = new JButton("Append");
		btnTextBufferAppend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				applicationController.appendToTextBuffer(txtfldTextBufferAppend.getText());
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
		
		btnMoveCursorLeft = new JButton("Left");
		btnMoveCursorLeft.setEnabled(false);
		btnMoveCursorLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				applicationController.moveTextBufferCaretLeft();
				if(applicationController.isTextBufferSelectionSet()) {
					applicationController.resetTextBufferSelection();
				}
			}
		});
		cursorControlButtonsPanel.add(btnMoveCursorLeft);
		
		btnMoveCursorRight = new JButton("Right");
		btnMoveCursorRight.setEnabled(false);
		btnMoveCursorRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				applicationController.moveTextBufferCaretRight();
				if(applicationController.isTextBufferSelectionSet()) {
					applicationController.resetTextBufferSelection();
				}
			}
		});
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
		
		btnStartSelection = new JButton("Start");
		btnStartSelection.setEnabled(false);
		btnStartSelection.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				applicationController.setTextBufferStartSelectionIndex(applicationController.getTextBufferCaretPosition());
				
			}
		});
		selectionControlButtonsPanel.add(btnStartSelection);
		
		btnEndSelection = new JButton("End");
		btnEndSelection.setEnabled(false);
		btnEndSelection.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				applicationController.setTextBufferEndSelectionIndex(applicationController.getTextBufferCaretPosition());
				
			}
		});
		selectionControlButtonsPanel.add(btnEndSelection);
		
		btnResetSelection = new JButton("Reset");
		btnResetSelection.setEnabled(false);
		btnResetSelection.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				applicationController.resetTextBufferSelection();
			}
		});
		
		JLabel lblSelectionContent = new JLabel("Content : ");
		selectionControlButtonsPanel.add(lblSelectionContent);
		
		txtfldSelectionContent = new JTextField();
		txtfldSelectionContent.setEditable(false);
		selectionControlButtonsPanel.add(txtfldSelectionContent);
		txtfldSelectionContent.setColumns(10);
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
		
		btnCopy = new JButton("Copy");
		btnCopy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				applicationController.copySelectionFromTextBuffer();				
			}
		});
		btnCopy.setEnabled(false);
		actionButtonsPanel.add(btnCopy);
		
		btnCut = new JButton("Cut");
		btnCut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				applicationController.cutSelectionFromTextBuffer();				
			}
		});
		btnCut.setEnabled(false);
		actionButtonsPanel.add(btnCut);
		
		btnPaste = new JButton("Paste");
		btnPaste.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				applicationController.pasteClipboardIntoTextBuffer();				
			}
		});
		btnPaste.setEnabled(false);
		actionButtonsPanel.add(btnPaste);
		
		btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				applicationController.deleteContentFromTextBuffer(applicationController.getTextBufferStartSelectionIndex(), applicationController.getTextBufferEndSelectionIndex());
				applicationController.resetTextBufferSelection();
			}
		});
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
	
	/**
	 * @wbp.parser.constructor
	 */
	public GuiView(ApplicationController controller) {
		this();
		this.setApplicationController(controller);
	}
	
	public void updateBufferContent(String bufferContent) {
		this.txtfldTextBufferContent.setText(bufferContent);
	}
	
	public void updateBufferIndex(int index) {
		System.out.println("new index " + index + "/" + (this.applicationController.getTextBufferLength() - 1));
		if(index > 0){
			this.btnMoveCursorLeft.setEnabled(true);
		}
		else {
			this.btnMoveCursorLeft.setEnabled(false);			
		}
		
		if(index < this.applicationController.getTextBufferLength() - 1) {
			this.btnMoveCursorRight.setEnabled(true);			
		}
		else {
			this.btnMoveCursorRight.setEnabled(false);
		}
	}

	public void updateBufferStartSelectionIndex(int index) {
		if(index == TextBuffer.UNSET_INDEX) {
			this.btnStartSelection.setEnabled(true);
			this.btnEndSelection.setEnabled(false);
			this.btnResetSelection.setEnabled(false);
			this.txtfldSelectionContent.setText("");
		}
		else {
			this.btnStartSelection.setEnabled(false);
			this.btnEndSelection.setEnabled(true);
		}
		
	}

	public void updateBufferEndSelectionIndex(int index) {
		if(index == TextBuffer.UNSET_INDEX) {
			this.btnStartSelection.setEnabled(true);
			this.btnEndSelection.setEnabled(false);
			this.btnResetSelection.setEnabled(false);
			this.txtfldSelectionContent.setText("");
			
			this.btnDelete.setEnabled(false);
			this.btnCopy.setEnabled(false);
			this.btnCut.setEnabled(false);
		}
		else {
			this.btnStartSelection.setEnabled(false);
			this.btnEndSelection.setEnabled(false);
			this.btnResetSelection.setEnabled(true);
			this.txtfldSelectionContent.setText(this.applicationController.getTextBufferSelectionContent());
			
			this.btnDelete.setEnabled(true);
			this.btnCopy.setEnabled(true);
			this.btnCut.setEnabled(true);
		}
	}
	
	public void updateClipboardContent(String clipboardContent) {
		this.txtfldClipboardContent.setText(clipboardContent);
		if(!clipboardContent.equals("")) {
			btnPaste.setEnabled(true);
		}
		else {
			btnPaste.setEnabled(false);
		}
	}
	
	public ApplicationController getApplicationController() {
		return this.applicationController;
	}
	
	public void setApplicationController(ApplicationController newApplicationController) {
		if(newApplicationController != this.applicationController) {
			if(this.applicationController != null) {
				this.applicationController = null;
				
			}

			this.applicationController = newApplicationController;
			newApplicationController.setApplicationView(this);
			
		}
	}

}
