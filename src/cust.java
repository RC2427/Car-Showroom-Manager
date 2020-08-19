import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.JComboBox;

public class cust extends JFrame {

	private JPanel contentPane;
	private JTextField custname3;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField emailfield;
	public String x;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private String a,b,c;

			public void run() {
				try {
					cust frame = new cust(a,b,c);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public cust(String car,String color,String rate) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setResizable(false);
		setBounds(100, 100, 710, 503);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlShadow);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\toyota.png"));
		lblNewLabel_1.setBounds(427, 104, 270, 205);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CUSTOMER DETAILS");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_2.setBounds(256, 11, 288, 55);
		contentPane.add(lblNewLabel_2);
		
		JLabel label_1 = new JLabel("TOYOTA");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		label_1.setBounds(503, 320, 113, 28);
		contentPane.add(label_1);
		
		JLabel lblNewLabel_3 = new JLabel("Customer Name :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(23, 63, 128, 28);
		contentPane.add(lblNewLabel_3);
		
		custname3 = new JTextField();
		custname3.setBounds(216, 65, 179, 28);
		contentPane.add(custname3);
		custname3.setColumns(10);
		
		
		
		//System.out.println(test);
		//System.out.println(custname3.getText());
		//String test= "Dinesh";
		
		
		
		
		
		
		
		JLabel lblPhoneNumber = new JLabel("Contact no :");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPhoneNumber.setBounds(23, 188, 113, 28);
		contentPane.add(lblPhoneNumber);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(216, 190, 179, 28);
		contentPane.add(textField_1);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddress.setBounds(23, 120, 113, 28);
		contentPane.add(lblAddress);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(216, 114, 179, 44);
		contentPane.add(textField_2);
		
		JLabel lblCardNumber = new JLabel("Expected Delivery Date :");
		lblCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCardNumber.setBounds(23, 299, 167, 28);
		contentPane.add(lblCardNumber);
		
		JLabel lblPin = new JLabel("Mode of Payment :");
		lblPin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPin.setBounds(25, 353, 148, 28);
		contentPane.add(lblPin);
		
		JLabel lblEmailId = new JLabel("Email id :");
		lblEmailId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmailId.setBounds(23, 240, 89, 28);
		contentPane.add(lblEmailId);
		
		emailfield = new JTextField();
		emailfield.setBounds(216, 242, 179, 28);
		contentPane.add(emailfield);
		emailfield.setColumns(10);
		
		JRadioButton rdbtncash = new JRadioButton("Cash");
		rdbtncash.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtncash.setBackground(SystemColor.activeCaptionBorder);
		rdbtncash.setBounds(189, 356, 75, 23);
		contentPane.add(rdbtncash);
		
		JRadioButton rdbtnCredit = new JRadioButton("Credit");
		rdbtnCredit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnCredit.setBackground(SystemColor.activeCaptionBorder);
		rdbtnCredit.setBounds(285, 356, 82, 23);
		contentPane.add(rdbtnCredit);
		
		JRadioButton rdbtnDebit = new JRadioButton("Debit");
		rdbtnDebit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnDebit.setBackground(SystemColor.activeCaptionBorder);
		rdbtnDebit.setBounds(391, 356, 75, 23);
		contentPane.add(rdbtnDebit);
		
		JRadioButton rdbtnNetBanking = new JRadioButton("Net Banking");
		rdbtnNetBanking.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNetBanking.setBackground(SystemColor.activeCaptionBorder);
		rdbtnNetBanking.setBounds(485, 356, 113, 23);
		contentPane.add(rdbtnNetBanking);
		
		JRadioButton rdbtnCheque = new JRadioButton("Cheque");
		rdbtnCheque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnCheque.setBackground(SystemColor.activeCaptionBorder);
		rdbtnCheque.setBounds(615, 355, 73, 23);
		contentPane.add(rdbtnCheque);
		
		ButtonGroup bg =new ButtonGroup();
		bg.add(rdbtncash);
		bg.add(rdbtnCredit);
		bg.add(rdbtnDebit);
		bg.add(rdbtnNetBanking);
		bg.add(rdbtnCheque);
		
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(216, 301, 179, 28);
		contentPane.add(comboBox);
		
		comboBox.addItem("One Week");
		comboBox.addItem("Two Weeks");
		comboBox.addItem("Three Weeks");
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String selected=(String) comboBox.getSelectedItem();
				
				System.out.println("You selected "+selected);
				x=selected;
			}
		});
		
		
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con=null;
		        Statement stmt=null;
		        
				   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				   String date = sdf.format(new Date());
				   System.out.println(date);
		        
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            System.out.println("\nDriver loaded");
		            
		            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
		            System.out.print("Connection Successful");

		           // System.out.println("You selected "+x);
		            System.out.println("\nInserting record....");
		            stmt=(Statement) con.createStatement();
		           
		    		
		    		String t = custname3.getText();
		    		System.out.print(t);
		    		
		    		String test= custname3.getText();
		    		
		   
		    		String t1 = textField_1.getText();
		    		System.out.print(t1);
		    		
		    		String t2 = textField_2.getText();
		    		System.out.print(t2);
		    		
		    		
		    		String t6 = emailfield.getText();
		    		
		            System.out.print(car);
		            
		            System.out.print(car);
		            System.out.print(color);
		            
		            //String query=("INSERT INTO customer (name,number,address,car,color,price,date)" +" values ('"+t+"','"+t1+"','"+t2+"','"+car+"','"+color+"','"+rate+"')");
		            String radioButt = new String();
		            
		            if(rdbtncash.isSelected()) {
		            	radioButt = rdbtncash.getText();
		            }
		            else if(rdbtnCredit.isSelected()) {
		            	radioButt =rdbtnCredit.getText();
		            }
		            else if(rdbtnDebit.isSelected()) {
		            	radioButt = rdbtnDebit.getText();
		            }
		            else if(rdbtnNetBanking.isSelected()) {
		            	radioButt = rdbtnNetBanking.getText();
		            }
		            else if(rdbtnCheque.isSelected()) {
		            	radioButt = rdbtnCheque.getText();
		            }
		            System.out.println("You Selected : " + radioButt);
		           // String query=("INSERT INTO customer (name,address,car,color,price,date)" +" values ('"+t+"','"+t2+"','"+car+"','"+color+"','"+rate+"','"+date+"')");	            
		            
		            
		            String deldate=x;
		  
		            String payment=radioButt;
		            
		            String query=("INSERT INTO customer (name,contactno,address,email,car,color,price,date,deldate,payment)" +" values ('"+t+"','"+t1+"','"+t2+"','"+t6+"','"+car+"','"+color+"','"+rate+"','"+date+"','"+deldate+"','"+payment+"')");
		            
		            
		            
		            
		          if(t.isEmpty() || t1.isEmpty() || t2.isEmpty() )
		           {
		        	   JOptionPane.showMessageDialog(null, "FILL UP ALL DETAILS");
		           }
		           
		          
		          else if(test.matches("(.*)[0-9](.*)"))
		        		  {
		        	  
		        	  JOptionPane.showMessageDialog(null, "Numbers Not Allowed in name");
		        		  }
		          
		          else if(!t1.matches("^[0-9]{10}$"))  {
		        	  JOptionPane.showMessageDialog(null, "Contact no is not valid");
		          }
		          
		          else if(!t6.matches("^[a-z0-9_-]+@[a-z0-9]+(\\.[a-z]+){1,2}$")) {
		        	JOptionPane.showMessageDialog(null,"Inavlid email id");  
		          }
		          
		           else
		           {
		        	   String q1 ="DELETE FROM store WHERE quantity ="+"'"+0+"'"+";";
		        	   
		        	   
			        	stmt.executeUpdate(q1);
			        	String q ="Update store set quantity = quantity-1 where model ="+"'"+car+"'"+ "and color="+"'"+color+"'"+";" ;
			        	stmt.executeUpdate(q);
			        	
		              stmt.executeUpdate(query);
		           
		           JOptionPane.showMessageDialog(null, "THANK YOU FOR CHOOSING US");
		           
		           dashboard dash=new dashboard();
					dispose();
					dash.setLocationRelativeTo(null);
					dash.setVisible(true);
		           
		           
		           
		           
		           
		           }
		           
		        }
		
		        catch(ClassNotFoundException e1)
		        {
		            System.out.print("Exception "+e1.getMessage());
		        }
		        
		        
		        catch(SQLException se){
		            //Handle errors for JDBC
		            se.printStackTrace();
		        }
		      
		        catch(Exception e3)
		        {
		        	 JOptionPane.showMessageDialog(null, "Insertion Not Successfull");
		        }

			
			}
		});
		btnNewButton.setBounds(419, 419, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("HOME");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboard d =new dashboard();
				dispose();
				d.setLocationRelativeTo(null);
				d.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(133, 419, 89, 23);
		contentPane.add(btnNewButton_1);
		
	
	}
}
