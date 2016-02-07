package uk.ac.ucl.cs.gc01.tutorial5.java2dapi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

class Circles extends JPanel {
	int x = 10, dx = 1, y = 10, x2 = 80, y2 = 80, dy = 1, x3 = 500, y3 = 500;
	private ActionListener actionlistener;
	private JLabel lblGreenBallCoords, lblRedBallCoords, lblBlueBallCoords;

	Random random = new Random();

	public Circles() {
		repaint();
		lblBlueBallCoords = new JLabel();
		lblBlueBallCoords.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBlueBallCoords.setForeground(Color.BLUE);
		lblBlueBallCoords.setBounds(737, 653, 154, 16);
		add(lblBlueBallCoords);

		lblRedBallCoords = new JLabel();
		lblRedBallCoords.setForeground(Color.RED);
		lblRedBallCoords.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRedBallCoords.setBounds(737, 682, 154, 16);
		add(lblRedBallCoords);

		lblGreenBallCoords = new JLabel();
		lblGreenBallCoords.setForeground(Color.GREEN);
		lblGreenBallCoords.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGreenBallCoords.setBounds(737, 707, 300, 16);
		add(lblGreenBallCoords);
	}

	private void doDrawing(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(Color.RED);
		Ellipse2D circle1 = new Ellipse2D.Double(x, y, 50, 50);

		g2.fill(circle1);
		Ellipse2D circle2 = new Ellipse2D.Double(x2, y2, 50, 50);
		g2.setColor(Color.BLUE);
		g2.fill(circle2);

		Ellipse2D circle3 = new Ellipse2D.Double(x3, y3, 50, 50);
		g2.setColor(Color.GREEN);
		g2.fill(circle3);

		//create the action listener for the movement of the circles
		actionlistener = new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				x += dx;
				y2 += dy;
				//if red ball reaches the edge of the frame, direction is reversed, same with blue ball
				if (x >= 1000) {
					dx = -dx;
				}
				if (x < 0) {
					dx = -dx;
				}
				if (y2 < 0) {
					dy = -dy;
				}
				if (y2 > 700) {
					dy = -dy;
				}
				//make the green ball coords take random numbers which fit on the frame 
				x3 = random.nextInt(1000);
				y3 = random.nextInt(700);
				repaint();
				//change the text on the labels
				lblRedBallCoords.setText("Red Ball " + "(" + (x+25) + "," + (y+25) + ")");
				lblBlueBallCoords.setText("Blue Ball " + "(" + (x2+25) + "," + (y2+25) + ")");
				lblGreenBallCoords.setText("Green Ball " + "(" + (x3+25) + "," + (y3+25) + ")");
			}// plus half the diameter of the ball to give the centre coords.
		};
		Timer timer = new Timer(500, actionlistener);
		timer.start();
		
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		doDrawing(g);
	}
}
