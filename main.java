package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;

public class main {

	private JFrame frame;
	private JTextField textcname;
	private JTextField textcphno;
	private JTextField textitemprice;
String namee;
int phone1;
String status1;
String item1;
String itemcode1;
String itemprice1;
String drinks1;
String tax1;
String chatss;
private JTextField textField;
private JTextField textField_1;
private JTextField textField_2;
private JTextField textField_3;
private JTextField textField_4;
private JTextField textField_5;
private JTextField textField_6;
private JTextField textField_7;
private JTextField textField_8;
private JTable table;
private JTextField t1;
private JTextField t9;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
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
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 952, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RESTAURENT MANAGEMENT SYSTEM");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(228, 11, 340, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCustamername = new JLabel("CUST NAME");
		lblCustamername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCustamername.setBounds(10, 59, 129, 14);
		frame.getContentPane().add(lblCustamername);
		
		textcname = new JTextField();
		textcname.addFocusListener(new FocusAdapter() {
			/*@Override
			public void focusLost(FocusEvent arg0) {
					String CNAME_PATTERN="^[a-zA-Z]{1,20}.[a-zA-Z]{1,2}$";
    			Pattern p1=Pattern.compile(CNAME_PATTERN);
    			Matcher regexMatcher=p1.matcher(textcname.getText());
    				if(!regexMatcher.matches())
    				{
    					JOptionPane.showMessageDialog(null, "Enter  charachters only");
                           textcname.setText(" ");
    					frame.setVisible(false);
    					main window = new main();
    					window.frame.setVisible(true);	
    				}
    				}*/
		});
		textcname.setBounds(162, 53, 86, 20);
		frame.getContentPane().add(textcname);
		textcname.setColumns(10);
		
		JLabel lblCustPhno = new JLabel("CUST PHNO");
		lblCustPhno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCustPhno.setBounds(10, 92, 78, 14);
		frame.getContentPane().add(lblCustPhno);
		
		textcphno = new JTextField();
		textcphno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char d= arg0.getKeyChar();
				if(!(Character.isDigit(d))){
					arg0.consume();
					JOptionPane.showMessageDialog(null, "enter no only");
				}
			}
		});
		
			
		
		textcphno.setBounds(162, 84, 86, 20);
		frame.getContentPane().add(textcphno);
		textcphno.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("STATUS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 117, 86, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"permanent", "no permanentn"}));
		comboBox.setBounds(162, 111, 86, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblItem = new JLabel("ITEM");
		lblItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblItem.setBounds(10, 142, 78, 14);
		frame.getContentPane().add(lblItem);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"ROTI", "RICE", "PURI", "CHAPATHI", "DOSE", "MEALS", "PALAU"}));
		comboBox_1.setBounds(162, 136, 86, 20);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("ITEM CODE");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 167, 78, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"101", "102", "103", "104", "105", "106"}));
		comboBox_2.setBounds(162, 166, 86, 20);
		frame.getContentPane().add(comboBox_2);
		
		JLabel lblItemPrice = new JLabel("ITEM PRICE");
		lblItemPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblItemPrice.setBounds(10, 193, 86, 14);
		frame.getContentPane().add(lblItemPrice);
		
		textitemprice = new JTextField();
		textitemprice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
		
				char d= e.getKeyChar();
				if(!(Character.isDigit(d))){
					e.consume();
					JOptionPane.showMessageDialog(null, "enter no only");
				}
			}
		
		});
		textitemprice.setBounds(162, 192, 86, 20);
		frame.getContentPane().add(textitemprice);
		textitemprice.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("DRINKS");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 224, 111, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"LASSY", "SPRIT", "GRAPE", "LEMON", "POMOGRANET"}));
		comboBox_3.setBounds(162, 223, 86, 20);
		frame.getContentPane().add(comboBox_3);
		
		textField = new JTextField();
		textField.setBounds(269, 58, 174, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(269, 77, 174, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(269, 92, 174, 23);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(269, 115, 174, 23);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(269, 136, 174, 27);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(269, 161, 174, 31);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(269, 187, 174, 31);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(269, 218, 174, 20);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblTax = new JLabel("TAX");
		lblTax.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTax.setBounds(10, 255, 86, 14);
		frame.getContentPane().add(lblTax);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"12", "10", "11", "14", "05", "03", "04"}));
		comboBox_4.setBounds(162, 254, 86, 20);
		frame.getContentPane().add(comboBox_4);
		
		JLabel lblChats = new JLabel("CHATS");
		lblChats.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChats.setBounds(10, 276, 78, 14);
		frame.getContentPane().add(lblChats);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"PANIPURI", "MASALA PURI", "RASMA", ""}));
		comboBox_5.setBounds(162, 275, 86, 20);
		frame.getContentPane().add(comboBox_5);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String value=(String)comboBox.getSelectedItem();
				String value1=(String)comboBox_1.getSelectedItem();
				String value2=(String)comboBox_2.getSelectedItem();
				String value3=(String)comboBox_3.getSelectedItem();
				String value4=(String)comboBox_4.getSelectedItem();
				String value5=(String)comboBox_5.getSelectedItem();
				
				 try{
  	            	 System.out.println("entered b1 button");
  	            	if(textcname.getText().equals(" ")||textcphno.getText().equals(" ")||textitemprice.getText().equals(" ")||value.equals("  ")||value1.equals("  ")||value2.equals("  ")||value3.equals("  ")||value4.equals("  ")||value5.equals("  "))
  	            			{
  		        			JOptionPane.showInternalMessageDialog(null, "some details are missing");
  		        		}	
  	            
				 else
				 {

   	            	 System.out.println("I am here");
   	                 
   	                 Class.forName("oracle.jdbc.driver.OracleDriver");
   	                 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "system", "admin");
   	              String query = "insert into rest (cname, cphno, status, item, itemcode, itemprice, drink, tax, chats)" + " values (?,?,?,?,?,?,?,?,?)";
   	           PreparedStatement ps = con.prepareStatement(query);
   	         ps.setString (1,textcname .getText());
   	         ps.setString (2, textcphno.getText());
   	         ps.setString (3, value);
   	         ps.setString (4, value1);
   	         ps.setString (5, value2);
   	         ps.setString (6, textitemprice.getText());
   	         ps.setString (7, value3);
   	         ps.setString (8, value4);
   	         ps.setString (9, value5);
   	         ps.execute();
             System.out.println("Submited");
             con.close();
             
			
             
				 }
				 }
			
				 catch (Exception ex){
  	            	 ex.printStackTrace();
  	            	 System.out.println("end");
  	             }

       
  	    	 }	
			
		});
		btnSave.setBounds(10, 442, 89, 23);
		frame.getContentPane().add(btnSave);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textcname.setText(null);	
				textcphno.setText(null);
				textitemprice.setText(null);
				comboBox.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);
				comboBox_2.setSelectedIndex(0);
				comboBox_3.setSelectedIndex(0);
				comboBox_4.setSelectedIndex(0);
				comboBox_5.setSelectedIndex(0);
				
			}
		});
		btnReset.setBounds(112, 442, 89, 23);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		btnExit.setBounds(211, 442, 89, 23);
		frame.getContentPane().add(btnExit);
		
		JButton btnNewButton = new JButton("PRINT BILL");
		btnNewButton.addActionListener(new ActionListener() {
		//	@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
				
				String str=(textcname.getText());
				textField.setText(str);
				
				String str1=textcphno.getText();
				textField_2.setText(str1);
				
				String str2=(String)comboBox.getSelectedItem();
				textField_2.setText(str2);
				
				String str3=(String)comboBox_1.getSelectedItem();
				textField_3.setText(str3);
				
				String str4=(String)comboBox_2.getSelectedItem();
				textField_4.setText(str4);
				 
				String str5=(textitemprice.getText());
				textField_5.setText(str5);
				  
				String str6=(String)comboBox_3.getSelectedItem();
				textField_6.setText(str6);
				
				String str7=(String)comboBox_4.getSelectedItem();
				textField_7.setText(str7);
				
				String str8=(String)comboBox_5.getSelectedItem();
				textField_8.setText(str8);
				
				
		/*
				try{
					 Class.forName("oracle.jdbc.driver.OracleDriver");
   	                 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "system", "admin");
   	                 String query = "select * from rest";
   	                
   	              Statement st = con.createStatement();
   	                	        
     	        
               System.out.println("Submited");
               
               
   	        ResultSet rs= st.executeQuery(query);
   	          
   	        while(rs.next())
   	        {
   	        String name=rs.getString("name");
   	        int phno=rs.getInt("phno");
   	        String status=rs.getString("status");
   	        String item=rs.getString(" item");
   	        String itemcode=rs.getString("itemcode");
   	        String itemprice=rs.getString("itemprice");
  	        String drinks=rs.getString("drinks");
  	        String tax=rs.getString("tax");
  	        String chats=rs.getString("chats");
  	        
  	      textArea.append("cust name     : "+name+"\n"
  	    		          +"cust phno    : "+phno+"\n"
  	    		          +"ststus       : "+status+"\n"
  	    		          +"item         : "+item+"\n"
  	    		          +"itemcode     : "+itemcode+"\n"
  	    		          +"itemprice    : "+itemprice+"\n"
  	    		          +"drinks       : "+drinks+"\n"
  	    		          +"tax          : "+tax+"\n"
  	    		          +"chats        : "+chats+"\n" );
   	    
  	     
  	  // 	System.out.println("phno         ="+phno);
  	//  phone1=phno;
  	  
  	   
  	
  //	textField.setText(name);
  
  	//textField_2.setText(status);
  //	textField_3.setText(item);
  	///textField_4.setText(itemcode);
 // 	textField_5.setText(itemprice);
  //textField_6.setText(drinks);
  	//textField_7.setText(tax);
  	//textField_8.setText(chats);

  	   	
  
  	 
   	  }
   	        
				 }
				 catch (Exception ex){
					 System.out.println(ex);
			*/		 
				 }
				
		
		});
		btnNewButton.setBounds(310, 442, 118, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton b1 = new JButton("REPORT");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Search window = new Search();
				Search.main(null);
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
		b1.setBounds(442, 442, 89, 23);
		frame.getContentPane().add(b1);
		
		/*JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(467, 80, 409, 315);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_4 = new JLabel("STATUS");
		lblNewLabel_4.setBounds(509, 56, 67, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		t1 = new JTextField(); 
		t1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try{
	                Class.forName("oracle.jdbc.driver.OracleDriver");
	                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "admin");
	                String query="select cname,cphno, item, itemcode, itemprice, drink, tax, chats from rest where status=?";
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
		t1.setBounds(634, 53, 86, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);*/
		
		JLabel lblNewLabel_6 = new JLabel("DELET");
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_6.setToolTipText("DELETE USING ID");
		lblNewLabel_6.setBounds(10, 313, 78, 23);
		frame.getContentPane().add(lblNewLabel_6);
		
		t9 = new JTextField();
		t9.setBounds(162, 314, 86, 20);
		frame.getContentPane().add(t9);
		t9.setColumns(10);
		
		JButton btnDelet = new JButton("DELET");
		btnDelet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try{
  	            	 System.out.println("entered delete button");
  	            	 String id=t9.getText();
  		        

   	            	 System.out.println("I am here");
   	                 
   	                 Class.forName("oracle.jdbc.driver.OracleDriver");
   	                 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "system", "admin");
   	              String query = "select cname from rest where cname=?";
   	           PreparedStatement ps = con.prepareStatement(query);
   	           ps.setString(1, id);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					System.out.println("database");
					String st=rs.getString("cname");
					System.out.println("cname"+st);
					if(st.equals(id))
					{
						String query1="DELETE FROM rest WHERE cname=?";
						PreparedStatement pst=con.prepareStatement(query1);
						pst.setString(1, t9.getText());
						pst.execute();
						JOptionPane.showMessageDialog(null,"successfull");					
				}
			}
				else
				{
					JOptionPane.showMessageDialog(null,"invalid");
					t9.setText(" ");
				}
				 }
				catch(Exception e){
					JOptionPane.showMessageDialog(null,e);
				}
					
				}
		});
		btnDelet.setBounds(544, 442, 89, 23);
		frame.getContentPane().add(btnDelet);
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(240, 240, 240));
		label.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\general_bg.jpg"));
		label.setBounds(0, 0, 936, 490);
		frame.getContentPane().add(label);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			}
		}

