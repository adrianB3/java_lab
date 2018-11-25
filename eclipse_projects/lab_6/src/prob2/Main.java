package prob2;

import javax.swing.*;
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
		
		JScrollPane scrollPane = new JScrollPane(lista);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    scrollPane.setPreferredSize(new Dimension(30,30));
	    	    
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
		
		mainFrame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
	    mainFrame.add(scrollPane, BorderLayout.CENTER);
		mainFrame.add(input,BorderLayout.NORTH);
		//mainFrame.add(lista, BorderLayout.CENTER); // not needed anymore because of scroll pane
		mainFrame.add(b_stergere, BorderLayout.SOUTH);
		
		
	}

	private void initialize() {
        mainFrame = new JFrame();
        mainFrame.setBounds(100, 100, 320, 500);
        mainFrame.setTitle("Muzica");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
