package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Search {

	private JFrame frame;
	private JTextField t1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search window = new Search();
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
	public Search() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 703, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton b1 = new JButton("GENERAT REPORT");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("I am here");
                try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "admin");
                String query="Select * from rest";
                PreparedStatement pst= con.prepareStatement(query);
                ResultSet rs=pst.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));
                       }
                
			catch(Exception ex){
                ex.printStackTrace(); 
                
           }
		
			}
		});
		b1.setBounds(44, 71, 173, 23);
		frame.getContentPane().add(b1);
		
		JLabel l1 = new JLabel("NAME");
		l1.setBounds(43, 136, 46, 14);
		frame.getContentPane().add(l1);
		
		t1 = new JTextField();
		t1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try{
	                Class.forName("oracle.jdbc.driver.OracleDriver");
	                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "admin");
	                String query="select cphno,status, itemprice,item, itemcode, drink, tax, chats from rest where   cname=?";
	                PreparedStatement pst= con.prepareStatement(query);
	                pst.setString(1, t1.getText());
	                ResultSet rs=pst.executeQuery();
	                
	                table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}
				catch(Exception ex){
					JOptionPane.showMessageDialog(frame,ex);
	                
	           }
			
			
			}
		});
		t1.setBounds(96, 133, 86, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 213, 575, 124);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(227, 71, 148, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
