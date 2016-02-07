package uk.ac.ucl.cs.gc01.tutorial4.currencyconverter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class CurrencyConverter {
private double[] rate={0,0,0,0};
	private JFrame frame;
	String[] currencies = { "GBP", "USD", "YEN", "EU" };
	// SET THE RATES FROM GDP TO THE OTHER CURRENCIES
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrencyConverter window = new CurrencyConverter();
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
	public CurrencyConverter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 486, 323);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane);

		JButton btnPressMe = new JButton("Go");
		btnPressMe.setForeground(Color.BLACK);
		layeredPane.setLayer(btnPressMe, 0);
		btnPressMe.setBackground(Color.GREEN);
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(currencies));
		comboBox.setBounds(79, 121, 56, 22);
		layeredPane.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(currencies));
		comboBox_1.setBounds(265, 121, 56, 22);
		layeredPane.add(comboBox_1);

		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(313, 60, 109, 18);
		layeredPane.add(formattedTextField);

		btnPressMe.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {


				try {
					readFile();
					// set the value in the text field to be a double
					double value = Double.valueOf(formattedTextField.getText());
					System.out.printf("%.2f", value);
					System.out.print(comboBox.getSelectedItem() + " is: ");
					for (int j = 0; j < 4; j++) {

						// above %.2f ensures we have 2 decimal places
						if (comboBox.getSelectedItem() == "GBP" && comboBox_1.getSelectedIndex() == j) {
							System.out.printf("%.2f", value * rate[j]);
						} else if (comboBox.getSelectedItem() == "EU" && comboBox_1.getSelectedIndex() == j) {
							System.out.printf("%.2f", value * rate[j] / rate[3]);
						} else if (comboBox.getSelectedItem() == "USD" && comboBox_1.getSelectedIndex() == j) {
							System.out.printf("%.2f", value * rate[j] / rate[1]);
						} else if (comboBox.getSelectedItem() == "YEN" && comboBox_1.getSelectedIndex() == j) {
							System.out.printf("%.2f", value * rate[j] / rate[2]);
						}
					}
					// print out the currency that we have converted to
					System.out.println(comboBox_1.getSelectedItem());

				} catch (Exception e) {
					System.out.println("Error occured due to: " + e);

				}
			}
		});
		btnPressMe.setBounds(155, 185, 116, 33);
		layeredPane.add(btnPressMe);

		JLabel lblEnter = new JLabel("Enter the value to be converted:");
		lblEnter.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnter.setBounds(12, 60, 300, 16);
		layeredPane.add(lblEnter);

		JLabel lblFrom = new JLabel("From:");
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFrom.setBounds(79, 89, 56, 16);
		layeredPane.add(lblFrom);

		JLabel lblTo = new JLabel("To:");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTo.setBounds(265, 89, 56, 16);
		layeredPane.add(lblTo);

		JLabel lblCurrencyConversion = new JLabel("Currency Conversion:");
		lblCurrencyConversion.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblCurrencyConversion.setBounds(98, 0, 223, 35);
		layeredPane.add(lblCurrencyConversion);

		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(113, 124, 1, 1);
		layeredPane.add(layeredPane_1);

	}
public void readFile(){
	//this method allows the conversion rates from GBP to whatever currencies to be edited in 1 text file
	 String line=null;
		double[] rate={0,0,0,0};
	 int i=0;
	 //finds the file named rates, must use buffered reader
		try {
			FileReader fileReader = new FileReader("rates.txt");
			//always wrap filereader in buffered reader
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while((line=bufferedReader.readLine())!=null){
				//so each line takes the double value of the text file
				this.rate[i]=Double.valueOf(line);
				i++;
			}
         bufferedReader.close(); 
         //close the reader
		}catch(FileNotFoundException ex) {
             System.out.println(
                 "Unable to open file");                
         }
         catch(IOException ex) {
             System.out.println(
                 "Error reading file" );                  
         }
}
}

