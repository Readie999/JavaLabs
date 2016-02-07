package uk.ac.ucl.cs.gc01.tutorial4.jframeandlistener;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame2 {
	String[] options = { "Option 1", "Option 2", "Option 3", "Option 4" };
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame2 window = new Frame2();
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
	public Frame2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(options));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "You have selected: " +comboBox.getSelectedItem());
			}
		});
		comboBox.setBounds(135, 71, 88, 30);
		frame.getContentPane().add(comboBox);
		
		JLabel lblSelectAValue = new JLabel("Select a value from the list.");
		lblSelectAValue.setBounds(100, 13, 235, 30);
		frame.getContentPane().add(lblSelectAValue);
	}

	
}
