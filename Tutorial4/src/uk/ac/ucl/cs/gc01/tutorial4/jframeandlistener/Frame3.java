	package uk.ac.ucl.cs.gc01.tutorial4.jframeandlistener;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import java.awt.Font;

public class Frame3 {
	private String focus="";
	private JFrame frame;
	JTextArea display;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame3 window = new Frame3();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame3() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 835, 483);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				
		JButton btnNewButton = new JButton("Button");
		btnNewButton.setBounds(468, 24, 97, 25);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addFocusListener(focusListener);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setBounds(84, 24, 25, 25);
		frame.getContentPane().add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addFocusListener(focusListener);
		rdbtnNewRadioButton.setSelected(true);
	
		JTextArea txtrTextArea = new JTextArea();
		txtrTextArea.setText("Text Area");
		txtrTextArea.setBounds(234, 25, 106, 25);
		frame.getContentPane().add(txtrTextArea);
		txtrTextArea.addFocusListener(focusListener);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(480, 74, 97, 22);
		frame.getContentPane().add(comboBox);
		comboBox.addFocusListener(focusListener);
		
		JToggleButton tglbtnToggleButton = new JToggleButton("Toggle Button");
		tglbtnToggleButton.setBounds(154, 73, 137, 25);
		frame.getContentPane().add(tglbtnToggleButton);
		tglbtnToggleButton.addFocusListener(focusListener);
		
		display = new JTextArea();
		display.setBounds(68, 109, 628, 286);
		frame.getContentPane().add(display);
		display.setVisible(true);
		

	}
	FocusListener focusListener = new FocusListener() {
	@Override
	public void focusGained(FocusEvent e) {
		focus = focus + "Focus gained. "+ e.getComponent().getClass().getName();
	display.setText(focus);
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		focus = focus + " \t Focus lost. \n";
		display.setText(focus);
	}

	};
}
