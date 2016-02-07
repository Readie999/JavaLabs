package uk.ac.ucl.cs.gc01.tutorial4.jframeandlistener;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class Frame4 {

	private JFrame frame;
	private int Xcoord;
	private int Ycoord;
	private int myX;
	private int myY;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame4 window = new Frame4();
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
	public Frame4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1138, 682);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel details = new JLabel("");
		details.setBounds(196, 530, 587, 105);
		frame.getContentPane().add(details);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myX = e.getX(); // save x coord of click
		        myY = e.getY(); // save y coord of click
		        if(myX >=38 && myX<=178 &&myY>=81 &&myY<=155){
				Xcoord=e.getXOnScreen();
				Ycoord=e.getYOnScreen();
		        }
		        else{
		        }
			}
		});
		btnNewButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int newX =e.getXOnScreen()-Xcoord;
				int newY =e.getYOnScreen()-Ycoord;
				btnNewButton.setLocation(myX+newX, myY+newY);
				details.setText("New button, new coordinates: (" +newX+", "+newY+")");
				
			
			}
		});
		btnNewButton.setBounds(38, 81, 140, 74);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ex) {

				Xcoord=ex.getXOnScreen();
				Ycoord=ex.getYOnScreen();
				
				myX = ex.getX(); // save x coord of click
		        myY = ex.getY(); // save y coord of click
			}
		});
		lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent ex) {
				int newX =ex.getXOnScreen()-Xcoord;
				int newY =ex.getYOnScreen()-Ycoord;
				lblNewLabel.setLocation(myX+newX, myY+newY);
				details.setText("New Label, new coordinates: (" +newX+", "+newY+")");
			}
		});
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setBounds(399, 153, 140, 118);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(643, 81, 179, 74);
		frame.getContentPane().add(comboBox);
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ex) {

				Xcoord=ex.getXOnScreen();
				Ycoord=ex.getYOnScreen();
				
				myX = ex.getX(); // save x coord of click
		        myY = ex.getY(); // save y coord of click
			}
		});
		comboBox.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent ex) {
				int newX =ex.getXOnScreen()-Xcoord;
				int newY =ex.getYOnScreen()-Ycoord;
				comboBox.setLocation(myX+newX, myY+newY);
				details.setText("comboBox, new coordinates: (" +newX+", "+newY+")");
			}
		});
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rdbtnNewRadioButton.setBounds(311, 87, 244, 89);
		frame.getContentPane().add(rdbtnNewRadioButton);
	
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ex) {

				Xcoord=ex.getXOnScreen();
				Ycoord=ex.getYOnScreen();
				
				myX = ex.getX(); // save x coord of click
		        myY = ex.getY(); // save y coord of click
			}
		});
		rdbtnNewRadioButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent ex) {
				int newX =ex.getXOnScreen()-Xcoord;
				int newY =ex.getYOnScreen()-Ycoord;
				rdbtnNewRadioButton.setLocation(myX+newX, myY+newY);
				details.setText("Radio button, new coordinates: (" +newX+", "+newY+")");
			}
		});
	}

}
