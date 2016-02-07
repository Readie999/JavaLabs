package uk.ac.ucl.cs.gc01.tutorial5.java2dapi;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class CircleFrame extends JFrame {

    public CircleFrame() {

        initUI();
    }
    
    private void initUI() {
        
        Circles circles = new Circles();
        getContentPane().add(circles);
        circles.setLayout(null);
        
        setSize(1064, 800);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
        
            @Override
            public void run() {
            	CircleFrame ex = new CircleFrame();
                ex.setVisible(true);
            }
        });
    }
}