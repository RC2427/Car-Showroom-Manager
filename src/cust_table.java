import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class cust_table extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton button;
	private JLabel lblNewLabel;
	private JLabel totalsum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cust_table frame = new cust_table();
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
	public cust_table() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 503);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(95, 130, 554, 258);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	
				
	    		Connection con=null;
	            Statement stmt=null;
	            ResultSet rs=null;

	            try {
	                Class.forName("com.mysql.cj.jdbc.Driver");
	                System.out.println("\nDriver loaded");

	                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
	                System.out.print("Connection Successful");

	    		
	                System.out.println("\nInserting record....");
	             

	                DefaultTableModel model=new DefaultTableModel();
	                
	                model.addColumn("Name");
	                model.addColumn("Number");
	                model.addColumn("Address");
	                model.addColumn("Car");
	                model.addColumn("Color");
	                model.addColumn("Price");
	                model.addColumn("Date");
	              
	                
	                String query="select * from customer";
	         
	              
	              
	                
	                
	                stmt=con.createStatement();
	                rs=stmt.executeQuery(query);
	                
	               while(rs.next())
	               {
	            	   model.addRow(new Object[]
	            	   {
	            		   rs.getString("name"),
	            		   rs.getString("contactno"),
	            		   rs.getString("address"),
	            		   rs.getString("car"),
	            		   rs.getString("color"),
	            		  rs.getString("price"),
	            		  rs.getString("date")
	            		     
	            	   });
	               }
	               
	              
	                
	                stmt=con.createStatement();
	                rs=stmt.executeQuery(query);
	               
	               
	               
	               rs.close();
	               stmt.close();
	               con.close();
	                
	               table.setModel(model);
	               table.setAutoResizeMode(0);
	               table.getColumnModel().getColumn(0).setPreferredWidth(150);
	               table.getColumnModel().getColumn(1).setPreferredWidth(150);
	               table.getColumnModel().getColumn(2).setPreferredWidth(120);
	               table.getColumnModel().getColumn(3).setPreferredWidth(150);
	               table.getColumnModel().getColumn(4).setPreferredWidth(120);
	               table.getColumnModel().getColumn(5).setPreferredWidth(120);
	               table.getColumnModel().getColumn(6).setPreferredWidth(120);
	               
	               
	               
	               double total=0;
		              for(int i=0;i<model.getRowCount();i++)
		              {
		            	  int amount=Integer.parseInt((String) model.getValueAt(i,5));
		            	  total=total+amount;
		              }
		              
		              totalsum.setText(String.valueOf(total+" Lakhs"));
	               
	               
	            }
	     

	            catch(Exception e1)
	            {
	            	JOptionPane.showMessageDialog(null, e1);
	            }

					
				
				
			
			}
		});
		btnNewButton.setBounds(303, 94, 119, 23);
		contentPane.add(btnNewButton);
		
	            
	            
		button = new JButton("HOME");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboard d =new dashboard();
				dispose();
				d.setLocationRelativeTo(null);
				d.setVisible(true);
				
			}
		});
		button.setBounds(323, 430, 89, 23);
		contentPane.add(button);
		
		lblNewLabel = new JLabel("Total Sales:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(436, 399, 107, 23);
		contentPane.add(lblNewLabel);
		
		totalsum = new JLabel("");
		totalsum.setForeground(Color.RED);
		totalsum.setFont(new Font("Tahoma", Font.BOLD, 17));
		totalsum.setBounds(532, 399, 94, 23);
		contentPane.add(totalsum);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\toyota(1).png"));
		lblNewLabel_1.setBounds(28, 0, 150, 106);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\toyota(1).png"));
		label.setBounds(515, 0, 150, 106);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("TOYOTA");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(54, 98, 98, 28);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("TOYOTA");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_2.setBounds(541, 98, 98, 28);
		contentPane.add(label_2);
		
		JLabel lblCustomerDetails = new JLabel("Customer Details");
		lblCustomerDetails.setForeground(Color.BLACK);
		lblCustomerDetails.setFont(new Font("Sitka Display", Font.BOLD, 37));
		lblCustomerDetails.setBackground(Color.WHITE);
		lblCustomerDetails.setBounds(200, 11, 293, 39);
		contentPane.add(lblCustomerDetails);
	}
}
