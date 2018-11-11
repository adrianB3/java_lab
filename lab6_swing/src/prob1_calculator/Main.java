package prob1_calculator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

public class Main extends JFrame{
	private JFrame frame;
	private JLabel op1;
	private JLabel op2, resultText;
	private JTextField op1Text, op2Text;
	private JButton add, sub, mul, div, del;
	private double result = 0;
	
	public static void main(String[] args) {
			try {
	            Main window = new Main();
	            window.frame.setVisible(true);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}

    public Main() {
        initialize();
        
        Toolkit t = Toolkit.getDefaultToolkit(); 
        
        op1 = new JLabel("Operand 1");
        op2 = new JLabel("Operand 2");
        op1Text = new JTextField(10);
        op2Text = new JTextField(10);
        resultText = new JLabel("Result");
        
        add = new JButton("Adunare");
        sub = new JButton("Scadere");
        mul = new JButton("Inmultire");
        div = new JButton("Impartire");
        del = new JButton("Sterge");
        
        add.addActionListener(new Adunare());
        sub.addActionListener(new Scadere());
        mul.addActionListener(new Inmultire());
        div.addActionListener(new Impartire());
        del.addActionListener(new Stergere());
        
        FlowLayout fl = new FlowLayout();
        frame.setLayout(fl);
        frame.add(op1);
        frame.add(op1Text);
        frame.add(op2);
        frame.add(op2Text);
        
        frame.add(add);
        frame.add(sub);
        frame.add(mul);
        frame.add(div);
        
        
        frame.add(resultText);
        frame.add(del);
    } 

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 220, 300);
        frame.setTitle("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public class Adunare implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			result = Double.parseDouble(op1Text.getText()) + Double.parseDouble(op2Text.getText());
			resultText.setText(new Double(result).toString());
		}
    	
    }
    
    public class Scadere implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			result = Double.parseDouble(op1Text.getText()) - Double.parseDouble(op2Text.getText());
			resultText.setText(new Double(result).toString());
		}
    	
    }
    
    public class Inmultire implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			result = Double.parseDouble(op1Text.getText()) * Double.parseDouble(op2Text.getText());
			resultText.setText(new Double(result).toString());
		}
    	
    }
    
    public class Impartire implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				result = Double.parseDouble(op1Text.getText()) / Double.parseDouble(op2Text.getText());
			}
			catch(Exception ex) {
				ex.getCause();
			}
			resultText.setText(new Double(result).toString());
		}
    	
    }
    
    public class Stergere implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			op1Text.setText("");
			op2Text.setText("");
			resultText.setText("");			
		}
    	
    }
}
