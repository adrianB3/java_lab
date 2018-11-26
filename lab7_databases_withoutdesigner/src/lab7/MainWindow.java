package lab7;
import javax.imageio.ImageIO;
import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainWindow extends JFrame{
	private JPanel mainPanel;
	private JButton btnFirst = new JButton();
	private JButton btnPrevious = new JButton();
	private JButton btnNext = new JButton();
	private JButton btnLast = new JButton();
	private JTextField txtField = new JTextField();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	private JButton btnSearch = new JButton();
	private JButton btnSave = new JButton();
	private JButton btnReset = new JButton();
	private JTextField txtId = new JTextField();
	private JTextField txtNume = new JTextField();
	private JTextField txtVarsta = new JTextField();
	private int state = 0;
	private int currentSel = 0;
	private ResultSet rs;
	private ArrayList<Persoana> persoane = new ArrayList<Persoana>();
	
	public MainWindow() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		JFrame frame = new JFrame("DbaAdmin");
		frame.setBounds(20, 20, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel = new JPanel(new BorderLayout());
		addToolBar(mainPanel);
		addContent(mainPanel);
		try {
			retriveAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		manageState();
		frame.add(mainPanel);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	private void addToolBar(JPanel panel) throws IOException {
		JToolBar toolBar = new JToolBar();
		panel.add(toolBar, BorderLayout.NORTH);
		
		btnFirst.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("Imagini/MoveFirst.png"))));
		btnPrevious.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("Imagini/MovePrevious.png"))));
		btnNext.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("Imagini/MoveNext.png"))));
		btnLast.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("Imagini/MoveLast.png"))));
		btnAdd.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("Imagini/Add.png"))));
		btnEdit.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("Imagini/Edit.png"))));
		btnDelete.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("Imagini/Delete.png"))));
		btnSearch.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("Imagini/find.JPG"))));
		btnSave.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("Imagini/save.JPG"))));
		btnReset.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("Imagini/undo.JPG"))));
		txtField.setPreferredSize(new Dimension(110,20));
		txtField.disable();
		
		btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(currentSel < persoane.size() - 1) {
					currentSel++;
					txtField.setText(currentSel + "/" + (persoane.size()-1));
					txtId.setText(Integer.toString(persoane.get(currentSel).getId()));
					txtNume.setText(persoane.get(currentSel).getNume());
					txtVarsta.setText(Integer.toString(persoane.get(currentSel).getVarsta()));
				}
			}
		});
		
		btnPrevious.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(currentSel > 0) {
					currentSel--;
					txtField.setText(currentSel + "/" + (persoane.size()-1));
					txtId.setText(Integer.toString(persoane.get(currentSel).getId()));
					txtNume.setText(persoane.get(currentSel).getNume());
					txtVarsta.setText(Integer.toString(persoane.get(currentSel).getVarsta()));
				}
			}
		});
		
		btnFirst.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currentSel = 0;
				txtField.setText(currentSel + "/" + (persoane.size()-1));
				txtId.setText(Integer.toString(persoane.get(0).getId()));
				txtNume.setText(persoane.get(0).getNume());
				txtVarsta.setText(Integer.toString(persoane.get(0).getVarsta()));
			}
		});
		
		btnLast.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currentSel = persoane.size() - 1;
				txtField.setText(currentSel + "/" + (persoane.size()-1));
				txtId.setText(Integer.toString(persoane.get(persoane.size()-1).getId()));
				txtNume.setText(persoane.get(persoane.size()-1).getNume());
				txtVarsta.setText(Integer.toString(persoane.get(persoane.size()-1).getVarsta()));
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				state = 1;
				manageState();
				txtId.setText("");
				txtNume.setText("");
				txtVarsta.setText("");
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				state = 1;
				manageState();
				txtId.setEditable(false);
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int opt = JOptionPane.showConfirmDialog(panel, "Esti sigur ca vrei sa stergi pers. cu id-ul: " + persoane.get(currentSel).getId() + " ?");
				if(opt == JOptionPane.YES_OPTION) {
					try {
						PreparedStatement pr = (PreparedStatement) DbContext.conn.prepareStatement("delete from persoane where id=?");
						pr.setInt(1, Integer.parseInt(txtId.getText()));
						
						pr.executeUpdate();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					state = 0;
					manageState();
					try {
						DbContext.disconnect();
						persoane.clear();
						retriveAll();
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				}
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nameToBeFound = JOptionPane.showInputDialog(panel, "Nume: ");
				boolean isFound = false;
				for (int i = 0; i < persoane.size(); i++) {
					if(persoane.get(i).getNume().equals(nameToBeFound)) {
						isFound = true;
						currentSel = i;
						txtField.setText(currentSel + "/" + (persoane.size()-1));
						txtId.setText(Integer.toString(persoane.get(i).getId()));
						txtNume.setText(persoane.get(i).getNume());
						txtVarsta.setText(Integer.toString(persoane.get(i).getVarsta()));
						break;
					}
				}
				if(!isFound) {
					JOptionPane.showMessageDialog(panel, "Persoana cu numele " + nameToBeFound + " nu a fost gasita.");
				}
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement pr = (PreparedStatement) DbContext.conn.prepareStatement("insert into persoane values(?, ?, ?) on duplicate key update nume=?, varsta=?");
					pr.setInt(1, Integer.parseInt(txtId.getText()));
					pr.setString(2, txtNume.getText());
					pr.setInt(3, Integer.parseInt(txtVarsta.getText()));
					
					pr.setString(4, txtNume.getText());
					pr.setInt(5, Integer.parseInt(txtVarsta.getText()));
					
					pr.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				state = 0;
				manageState();
				try {
					DbContext.disconnect();
					persoane.clear();
					retriveAll();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				state = 0;
				manageState();
			}
		});
		
		toolBar.add(btnFirst);
		toolBar.add(btnPrevious);
		toolBar.add(txtField);
		toolBar.add(btnNext);
		toolBar.add(btnLast);
		toolBar.add(btnAdd);
		toolBar.add(btnEdit);
		toolBar.add(btnDelete);
		toolBar.add(btnSearch);
		toolBar.add(btnSave);
		toolBar.add(btnReset);
	}
	
	private void addContent(JPanel panel) {
		JPanel content = new JPanel();
		GridLayout grid = new GridLayout(3,2,10,10);
		
		content.setLayout(grid);
		content.setPreferredSize(new Dimension(100,80));
		
		JLabel labelNume = new JLabel("Nume");
		labelNume.setHorizontalAlignment(JLabel.RIGHT);
		JLabel labelId = new JLabel("Id");
		labelId.setHorizontalAlignment(JLabel.RIGHT);
		JLabel labelVarsta = new JLabel("Varsta");
		labelVarsta.setHorizontalAlignment(JLabel.RIGHT);
		
		content.add(labelId);
		content.add(txtId);
		content.add(labelNume);
		content.add(txtNume);
		content.add(labelVarsta);
		content.add(txtVarsta);
		
		panel.add(content, BorderLayout.CENTER);
	}
	
	private void retriveAll() throws SQLException {
		try {
			DbContext.connect();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		Statement sql;
		sql = (Statement) DbContext.conn.createStatement();
		rs = sql.executeQuery("select * from persoane");
		while(rs.next()) {
			persoane.add(new Persoana(rs.getInt(1), rs.getString(2), rs.getInt(3)));
		}
		txtField.setText(currentSel + "/" + (persoane.size()-1));
		txtId.setText(Integer.toString(persoane.get(currentSel).getId()));
		txtNume.setText(persoane.get(currentSel).getNume());
		txtVarsta.setText(Integer.toString(persoane.get(currentSel).getVarsta()));
	}
	
	private void manageState() {
		if(state == 0) {
			btnSave.setEnabled(false);
			btnReset.setEnabled(false);
			txtId.setEditable(false);
			txtNume.setEditable(false);
			txtVarsta.setEditable(false);
			
			btnFirst.setEnabled(true);
			btnLast.setEnabled(true);
			btnNext.setEnabled(true);
			btnPrevious.setEnabled(true);
			btnAdd.setEnabled(true);
			btnEdit.setEnabled(true);
			btnDelete.setEnabled(true);
			btnSearch.setEnabled(true);
		}
		if(state == 1) {
			btnSave.setEnabled(true);
			btnReset.setEnabled(true);
			
			btnFirst.setEnabled(false);
			btnLast.setEnabled(false);
			btnNext.setEnabled(false);
			btnPrevious.setEnabled(false);
			btnAdd.setEnabled(false);
			btnEdit.setEnabled(false);
			btnDelete.setEnabled(false);
			btnSearch.setEnabled(false);
				
			txtId.setEditable(true);
			txtNume.setEditable(true);
			txtVarsta.setEditable(true);
		}
	}
}
