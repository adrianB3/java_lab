import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

import com.mysql.jdbc.Driver;

public class MainWindow extends JFrame {
    private JPanel panel;
    private JToolBar toolBar;
    private DefaultTableModel tableModel;
    public JTable personsListTable;

    private String url = "jdbc:mysql://localhost:3306/facultate";
    private Connection con;

    private ArrayList<Persoana> listaPersoaneDb = new ArrayList<Persoana>();

    private void dbConnect() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = DriverManager.getConnection(url);
    }

    private void dbCloseConnection() throws SQLException {
        con.close();
    }

    private void populateListFromDb() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        dbConnect();

        ResultSet rs;
        Statement sql = con.createStatement();
        rs = sql.executeQuery("select * from persoane");

        while(rs.next()){
            listaPersoaneDb.add(new Persoana(rs.getInt(0), rs.getString(1), rs.getInt(2)));
        }

        sql.close();
        rs.close();
        dbCloseConnection();
    }

    public void populateTable(){
        tableModel = new DefaultTableModel();
        personsListTable.setModel(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("Nume");
        tableModel.addColumn("Varsta");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DbaAdmin");
        frame.setContentPane(new MainWindow().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setBounds(50,50,640,480);
        frame.setVisible(true);
    }
}
