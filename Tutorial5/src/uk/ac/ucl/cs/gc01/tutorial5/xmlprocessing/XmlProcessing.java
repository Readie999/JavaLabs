package uk.ac.ucl.cs.gc01.tutorial5.xmlprocessing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import uk.ac.ucl.cs.gc01.tutorial5.javaloggingapis.Logging;

public class XmlProcessing {
	private final JFileChooser fc = new JFileChooser();
	private File file;
	private BufferedReader in;
	private String line;
	private JFrame frame;
	private String xml;
	private static final String outputEncoding = "UTF-8";
	private Logger LOGGER = Logger.getLogger(Logging.class.getName());
	private PrintStream standardOut = System.out;
	private PrintStream standardErr = System.err;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XmlProcessing window = new XmlProcessing();
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
	public XmlProcessing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1448, 1041);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML files (*.xml)", "xml");
		fc.setFileFilter(filter);
		fc.setAcceptAllFileFilterUsed(false);
		// sets the filter to the file chooser and turns off the all files
		// option!!
		
		SimpleFormatter fmt = new SimpleFormatter();
		 StreamHandler sh = new StreamHandler(standardErr, fmt);
		 LOGGER.addHandler(sh);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(58, 79, 480, 902);
		frame.getContentPane().add(textArea);

		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setForeground(Color.RED);
		textArea_1.setBounds(688, 197, 657, 269);
		JButton btnOpenAFile = new JButton("Open a file");
		btnOpenAFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int returnVal = fc.showOpenDialog(btnOpenAFile);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					file = fc.getSelectedFile();
				}
				try {
					in = new BufferedReader(new FileReader(file));
					line = in.readLine();
					while (line != null) {
						textArea.append(line + "\n");
						line = in.readLine();
					}
				} catch (Exception e) {
					LOGGER.fine("File not selected");
				}
			}
		});
		btnOpenAFile.setBounds(58, 42, 97, 25);
		frame.getContentPane().add(btnOpenAFile);

		JButton btnVerify = new JButton("Verify");
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				dbf.setNamespaceAware(true);
				DocumentBuilder db;
				try {
					db = dbf.newDocumentBuilder();
					xml = textArea.getText();
					Document doc = db.parse(new InputSource(new ByteArrayInputStream(xml.getBytes(outputEncoding))));
					OutputStreamWriter errorWriter = new OutputStreamWriter(System.err, outputEncoding);
					db.setErrorHandler(new MyErrorHandler(new PrintWriter(errorWriter, true)));
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block

				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block

				} catch (SAXException e) {
					textArea_1.append(e.getMessage());
					LOGGER.fine(e.getMessage());

				} catch (IOException e) {
					// TODO Auto-generated catch block

				}
			}
		});
		btnVerify.setBounds(252, 41, 97, 25);
		frame.getContentPane().add(btnVerify);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				dbf.setNamespaceAware(true);
				DocumentBuilder db;
				try {
					db = dbf.newDocumentBuilder();
					xml = textArea.getText();
					Document doc = db.parse(new InputSource(new ByteArrayInputStream(xml.getBytes(outputEncoding))));
					OutputStreamWriter errorWriter = new OutputStreamWriter(System.err, outputEncoding);
					db.setErrorHandler(new MyErrorHandler(new PrintWriter(errorWriter, true)));
					FileWriter fooStream = new FileWriter(file, false); 
					// false to overwrite
					fooStream.write(textArea.getText());
					fooStream.close();
				} catch (ParserConfigurationException e) {
					LOGGER.fine(e.getMessage());

				} catch (UnsupportedEncodingException e) {
					LOGGER.fine(e.getMessage());

				} catch (SAXException e) {
					LOGGER.fine(e.getMessage());

				} catch (IOException e) {
					LOGGER.fine(e.getMessage());

				}
			}
		});
		btnSave.setBounds(441, 41, 97, 25);
		frame.getContentPane().add(btnSave);

		frame.getContentPane().add(textArea_1);

		JLabel lblErrors = new JLabel("Errors:");
		lblErrors.setForeground(Color.RED);
		lblErrors.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblErrors.setBounds(840, 156, 88, 16);
		frame.getContentPane().add(lblErrors);

	}
}
