package prob1_b;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame{
	private JFrame mainFrame;
	public static void main(String[] args) {
		try {
            Main window = new Main();
            window.mainFrame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public Main() {
		initialize();
		
		
	}
	
	private void initialize() {
        mainFrame = new JFrame();
        mainFrame.setBounds(100, 100, 320, 500);
        mainFrame.setTitle("Calculator2");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
