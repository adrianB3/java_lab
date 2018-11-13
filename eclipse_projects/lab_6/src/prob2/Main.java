package prob2;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame{
	private JFrame mainFrame;
	private JTextField input;
	private JList<String> lista;
	private JButton b_stergere;
	
	public static void main(String[] args) {
			try {
				Main window = new Main();
				window.mainFrame.setVisible(true);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public Main() {
		initialize();
		
		mainFrame.setLayout(new BorderLayout());
		input = new JTextField(20);
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		lista = new JList<String>(listModel);
		JScrollPane scrollPane1 = new JScrollPane(lista);
	    mainFrame.add(scrollPane1);
	    
	    
		b_stergere = new JButton("Sterge");
		b_stergere.setBackground(new Color(20, 20, 120, 5));
		b_stergere.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for (String value : lista.getSelectedValuesList()) {
					listModel.removeElement(value);
				}		
			}
		});
		
		input.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listModel.addElement(input.getText());
				input.setText("");
			}
		});
		
		mainFrame.add(input,BorderLayout.NORTH);
		mainFrame.add(lista, BorderLayout.CENTER);
		mainFrame.add(b_stergere, BorderLayout.SOUTH);
		
		
	}

	private void initialize() {
        mainFrame = new JFrame();
        mainFrame.setBounds(100, 100, 320, 500);
        mainFrame.setTitle("Muzica");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
