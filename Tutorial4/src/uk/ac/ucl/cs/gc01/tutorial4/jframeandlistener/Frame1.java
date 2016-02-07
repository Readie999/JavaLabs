package uk.ac.ucl.cs.gc01.tutorial4.jframeandlistener;
/** Creates a frame where the label is updated as soon as anything is entered in the text field
 * 
 */
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Frame1 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();

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
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.getContentPane().setLayout(null);
			
		JLabel lblNewLabel = new JLabel("Enter text below:");
		lblNewLabel.setBounds(120, 13, 122, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(63, 161, 314, 79);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String text = textField.getText();
				label.setText(text);
			}
		});
		textField.setBounds(50, 41, 299, 48);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

	}
}
