package uk.ac.ucl.cs.gc01.tutorial4.whackamolegame;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;

public class MoleGame extends JFrame {
	private int counter = 15;
	private Timer timer, timer2, timer3, timer4;
	private static Random random = new Random();
	private JButton[] buttons;
	private JButton btnStart;
	private JLabel lblTimeRemaining, lblScore;
	private int iteration = 0;
	private int[] value = new int[2000];
	private int difficulty;
	private JComboBox comboBox;
	private int score;
	private String[] levels = { "Easy", "Medium", "Hard" };
	private double difficultyModifier;
	private MoleGame frame;
	private String name;
	JOptionPane userInput;
	private int delay2 =1250; 
	private int delay3 =900;
	private int delay4 =500;
	private int num=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MoleGame frame = new MoleGame();
					JPanel top = new JPanel(new GridLayout(1, 1));
					JPanel left = new JPanel();
					JPanel right = new JPanel();
					top.add(left);
					top.add(right);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MoleGame() {
		ImageIcon mole = new ImageIcon("newmole.png");
		ImageIcon hole = new ImageIcon("hole.png");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 560);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(24, 129, 731, 351);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(4, 4, 0, 0));

		// create the actionlistener to count the score!
		// checks if the button being pressed is valid.
		ActionListener actionListener3 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 16; i++) {
					if (e.getSource() == buttons[i]) {
						if (counter > 0) {
							if (buttons[i].getIcon() == mole) {
								score = (int) (score + 100 * difficultyModifier);
								lblScore.setText("Score: " + score);
								buttons[i].setIcon(hole);
								;

							}
						}
					}
				}
			}
		};

		buttons = new JButton[16];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setIcon(hole);
			// buttons[i].setBackground(Color.BLACK);
			panel.add(buttons[i]);
			buttons[i].addActionListener(actionListener3);

		}
		btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.start();
				if (comboBox.getSelectedItem() == "Easy") {
					difficultyModifier = 1;
					timer2.start();
				} else if (comboBox.getSelectedItem() == "Medium") {
					difficultyModifier = 1.25;
					timer3.start();
				} else {
					difficultyModifier = 1.5;
					timer4.start();
				}
			}
		});
		btnStart.setBounds(565, 42, 115, 43);
		getContentPane().add(btnStart);
		
		comboBox = new JComboBox();
		comboBox.setBounds(223, 74, 73, 28);
		getContentPane().add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(levels));

		lblScore = new JLabel("Score: 0");
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblScore.setForeground(Color.BLACK);
		lblScore.setBounds(332, 44, 107, 14);
		getContentPane().add(lblScore);

		lblTimeRemaining = new JLabel("Time remaining:");
		lblTimeRemaining.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTimeRemaining.setBounds(106, 37, 138, 28);
		getContentPane().add(lblTimeRemaining);

		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				if (counter < 1) {
					lblTimeRemaining.setText("Out of time!");
					timer.stop();
					timer2.stop();
					timer3.stop();
					timer4.stop();
					name = JOptionPane.showInputDialog(frame,"New High Score! What is your name?", null);
					//store the input as the users name
					disableButtons();
					HighScore(name);
				} else {
					lblTimeRemaining.setText("Time remaining: " + counter);
					counter--;
				}
			}
		};

		ActionListener actionListener2 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// set first iteration as green then change it back to black and
				// make the next random value green
				if (iteration == 0) {
					value[iteration] = random.nextInt(16);
					buttons[value[iteration]].setIcon(mole);
					// buttons[value[iteration]].setBackground(Color.green);
					iteration++;
				} else {
					value[iteration] = random.nextInt(16);
					// buttons[value[iteration - 1]].setBackground(Color.black);
					buttons[value[iteration-1]].setIcon(hole);
					buttons[value[iteration]].setIcon(mole);
					// buttons[value[iteration]].setBackground(Color.green);
					iteration++;
					//make the delay for each mole appearance get shorter over time.
					delay2=(int) 8.5*delay2/10;
					delay3=(int) 8.5*delay3/10;
					delay4=(int) 8.5*delay4/10;
				}

			}
		};

		timer = new Timer(1000, actionListener);
		timer2 = new Timer(delay2, actionListener2);
		timer3 = new Timer(delay3, actionListener2);
		timer4 = new Timer(delay4, actionListener2);

	}

	private void disableButtons() {
		for (int j = 0; j < 16; j++) {
			buttons[j].setEnabled(false);
		}
	}
	
	public void HighScore(String name){
		try{
			FileWriter write = new FileWriter("HighScores.txt");
			PrintWriter text = new PrintWriter(write);
			List<Score> people = new ArrayList<Score>();
			people.add( new Score("Nick", 3000) );
			people.add( new Score("Jay", 1000) );
			people.add( new Score("Brian", 800) );
			people.add( new Score("Brian", 600) );
			people.add( new Score("Abbie", 500) );
			people.add( new Score("Brian", 400) );
			people.add( new Score("Abbie", 1300) );
			people.add( new Score("Bill", 1500) );
			people.add( new Score("Fred", 1900) );
			people.add( new Score(name, score) );
			Collections.sort(people, new ScoreComparator());
			text.println(people);
			write.close();
		}
		catch(Exception e){
			System.out.println("Problem reading High Scores");
			
		}
	}
}
