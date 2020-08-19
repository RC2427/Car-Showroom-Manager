import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class dates extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	public String s_date1,s_date2;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dates frame = new dates();
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
	public dates() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 503);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("From\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(196, 111, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField("YYYY-MM-DD");
		
		textField.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (textField.getText().equals("YYYY-MM-DD")) {
		            textField.setText("");
		            textField.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (textField.getText().isEmpty()) {
		            textField.setForeground(Color.GRAY);
		            textField.setText("YYYY-MM-DD");
		        }
		    }
		    });
		
		
		textField_1 = new JTextField("YYYY-MM-DD");
		
		
		
		textField_1.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (textField_1.getText().equals("YYYY-MM-DD")) {
		            textField_1.setText("");
		            textField_1.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (textField_1.getText().isEmpty()) {
		            textField_1.setForeground(Color.GRAY);
		            textField_1.setText("YYYY-MM-DD");
		        }
		    }
		    });
		
		
		
		textField_1.setColumns(10);
		textField_1.setBounds(400, 136, 122, 20);
		contentPane.add(textField_1);
		
		
		textField.setBounds(172, 136, 122, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel totalsum = new JLabel("");
		totalsum.setForeground(Color.RED);
		totalsum.setFont(new Font("Tahoma", Font.BOLD, 17));
		totalsum.setBounds(529, 412, 94, 23);
		contentPane.add(totalsum);
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 205, 597, 204);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		s_date1=textField.getText();
		System.out.print(s_date1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addAncestorListener(new RequestFocusListener(false));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				s_date1=textField.getText();
				System.out.print(s_date1);
				
				
				s_date2=textField_1.getText();
				System.out.print(s_date2);
				
			
				Connection con=null;
	            Statement stmt=null;
	            ResultSet rs=null;
	            
	            

	            try {
	                Class.forName("com.mysql.cj.jdbc.Driver");
	                System.out.println("\nDriver loaded");

	                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
	                System.out.print("Connection Successful");

	    		
	                System.out.println("\nInserting record....");
	               // stmt=con.createStatement();

	                DefaultTableModel model=new DefaultTableModel();
	                
	                model.addColumn("Name");
	            //    model.addColumn("Number");
	                model.addColumn("Address");
	                model.addColumn("Car");
	               // model.addColumn("Color");
	                model.addColumn("Price");
	                model.addColumn("Date");
	                
	              //  String query="select * from customer where date="+"'"+s_date+"'"+";";;
	                
	                
	                String query="select * from customer where date between "+"'"+s_date1+"'"+" and "+"'"+s_date2+"'"+";";;
	                
	                
	                stmt=con.createStatement();
	                rs=stmt.executeQuery(query);
	                
	               while(rs.next())
	               {
	            	   model.addRow(new Object[]
	            	   {
	            		   rs.getString("name"),
	            		 //  rs.getString("number"),
	            		   rs.getString("address"),
	            		   rs.getString("car"),
	            		 //  rs.getString("color"),
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
	               table.getColumnModel().getColumn(0).setPreferredWidth(85);
	           //    table.getColumnModel().getColumn(1).setPreferredWidth(100);
	               table.getColumnModel().getColumn(1).setPreferredWidth(200);
	               table.getColumnModel().getColumn(2).setPreferredWidth(100);
	            //   table.getColumnModel().getColumn(4).setPreferredWidth(80);
	               table.getColumnModel().getColumn(3).setPreferredWidth(100);
	             table.getColumnModel().getColumn(4).setPreferredWidth(110);
	             
	             
	             
	             double total=0;
	              for(int i=0;i<model.getRowCount();i++)
	              {
	            	  int amount=Integer.parseInt((String) model.getValueAt(i,3));
	            	  total=total+amount;
	              }
	              
	              totalsum.setText(String.valueOf(total+" Lakhs"));
	             
	             
	              
	              if(!s_date1.matches("^2([0-9]{3})-(0[0-9]|1[0-2])-([012][0-9]|3[0-1])$") ||  !s_date2.matches("^2([0-9]{3})-(0[0-9]|1[0-2])-([012][0-9]|3[0-1])$"))
		          {
		        	  JOptionPane.showMessageDialog(null, "Date Format is Wrong");
		          }
	              
	              
	              
	              
	              
	             
	             
	            }
	     

	            catch(Exception e1)
	            {
	            	JOptionPane.showMessageDialog(null, e1);
	            }

					
				
	            
	            
				
				
				
			}
		});
		
		btnNewButton.setBounds(298, 164, 99, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblEnterDateOf = new JLabel("Select Two Dates to Search History");
		lblEnterDateOf.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblEnterDateOf.setBounds(167, 23, 420, 39);
		contentPane.add(lblEnterDateOf);
		
		JLabel label = new JLabel("Total Sales:");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(440, 412, 107, 23);
		contentPane.add(label);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dashboard d=new dashboard();
				dispose();
				d.setLocationRelativeTo(null);
				d.setVisible(true);
				
				
			}
			
			
		});
		btnNewButton_1.setBounds(34, 420, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTo.setBounds(428, 112, 46, 14);
		contentPane.add(lblTo);
		
	
		
	
		
		
	}
}
