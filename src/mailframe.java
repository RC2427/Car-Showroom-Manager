import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

import java.io.File;
//import com.sun.java.util.jar.pack.Package.File;

import javax.swing.JButton;
import javax.swing.JColorChooser; 	
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.SystemColor;

public class mailframe extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private String path;
	public String loc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mailframe frame = new mailframe();
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
	public mailframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 503);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textField = new JTextField();
		textField.setBounds(84, 66, 443, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		
		
		JButton btnChooseFile = new JButton("Choose file\r\n");
		btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser jfile = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int returnvalue = jfile.showOpenDialog(null);
				if(returnvalue == JFileChooser.APPROVE_OPTION) {
					File selectedfile = jfile.getSelectedFile();
					 
					//System.out.println(selectedfile.getAbsolutePath());
					 path=selectedfile.getAbsolutePath();
					textField.setText(path);
					Send.setpath(path);
					loc=path;
					
				}
			}
		});
		
		
		
		
		btnChooseFile.setBounds(537, 66, 142, 29);
		contentPane.add(btnChooseFile);
		
		
		
		
		
		JButton btnNewButton = new JButton("Send Mail");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(loc==null)
				{
					JOptionPane.showMessageDialog(null,"File Not Selected");
				}
				else
				{
				
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

	                
	                String query="select email from customer";
	         
	              
	                stmt=con.createStatement();
	                rs=stmt.executeQuery(query);
	                String email=new String();
	                ArrayList<String> arr = new ArrayList<String>();
	                
	               while(rs.next())
	               {
	            	  
	            		  email=rs.getString("email");
	            		  arr.add(email);
	            
	               }
	               
	               
	               System.out.print(arr);
	               
	               int i=0;
	               for(i=0;i<arr.size();i++)
	               {
	            	   Send.sendMail(arr.get(i));
	               }
	              
	                
	                stmt=con.createStatement();
	                rs=stmt.executeQuery(query);
	               
	                
	                
	                
	                
	                DefaultTableModel model=new DefaultTableModel();
	                
	                
	                model.addColumn("Name");
	                model.addColumn("Email");
	                model.addColumn("Contact no");
	                
	                
	                String query1="select name,email,contactno from customer";
	                
	                stmt=con.createStatement();
	                rs=stmt.executeQuery(query1);
	                
	               while(rs.next())
	               {
	            	   model.addRow(new Object[]
	            	   {
	            		   rs.getString("name"),
	            		   rs.getString("email"),
	            		   rs.getString("contactno"),
	            		       
	            	   });
	               }
	               
	                
	                
	         
	               rs.close();
	               stmt.close();
	               con.close();
	                
	               
	               
	               table.setModel(model);
	               table.setAutoResizeMode(0);
	               table.getColumnModel().getColumn(0).setPreferredWidth(150);
	               table.getColumnModel().getColumn(1).setPreferredWidth(225);
	               table.getColumnModel().getColumn(2).setPreferredWidth(150);
	               
	             
	            }
				

	            catch(Exception e1)
	            {
	            	JOptionPane.showMessageDialog(null, e1);
	            }

				}
			}
		});
	
		btnNewButton.setBounds(537, 124, 142, 29);
		contentPane.add(btnNewButton);
		
		
	
		
		
		JLabel lblNewLabel = new JLabel("File Path :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 64, 79, 29);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(78, 167, 567, 228);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  dashboard dash=new dashboard();
					dispose();
					dash.setLocationRelativeTo(null);
					dash.setVisible(true);
				
				
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnHome.setBounds(326, 430, 89, 23);
		contentPane.add(btnHome);
		
		JLabel lblMailsSentTo = new JLabel("Mails Sent To");
		lblMailsSentTo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMailsSentTo.setBounds(304, 138, 223, 29);
		contentPane.add(lblMailsSentTo);
		
		
		
		
	}
}
