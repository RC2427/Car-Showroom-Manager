import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.SystemColor;

public class search extends JFrame {

	private JPanel contentPane;
	private JTable table;
    public String x,y;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					search frame = new search();
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
	public search() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 503);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(110, 104, 154, 29);
		contentPane.add(comboBox);
		
		comboBox.addItem("Etios Cross");
		comboBox.addItem("Fortuner");
		comboBox.addItem("Glanza");
		comboBox.addItem("Innova Crysta");
		comboBox.addItem("Corolla Altis");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(421, 104, 154, 29);
		contentPane.add(comboBox_1);
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String selected=(String) comboBox.getSelectedItem();
				
				System.out.println("You selected "+selected);
				x=selected;
			}
		});
		
		
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String selected=(String) comboBox_1.getSelectedItem();
				
				System.out.println("You selected "+selected);
				y=selected;
			}
		});
		
		
		
		
		
		comboBox_1.addItem("Red");
		comboBox_1.addItem("Blue");
		comboBox_1.addItem("Black");
		comboBox_1.addItem("Green");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(83, 231, 542, 184);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Search");
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
	               // stmt=con.createStatement();

	                DefaultTableModel model=new DefaultTableModel();
	                
	               
	                model.addColumn("Model Name");
	                model.addColumn("Price (In lakhs)");
	                model.addColumn("Color");
	                model.addColumn("Quantity");
	                
	                
	                //String q ="Update store set quantity = quantity-1 where model ="+"'"+car+"'"+ "and color="+"'"+color+"'"+";" ;
	                String query="select * from store where model="+"'"+x+"'"+" and color="+"'"+y+"'"+";";
	                
	                stmt=con.createStatement();
	                rs=stmt.executeQuery(query);
	                
	               while(rs.next())
	               {
	            	   model.addRow(new Object[]
	            	   {
	            		   rs.getString("model"),
	            		   rs.getString("price"),
	            		   rs.getString("color"),
	            		   rs.getString("quantity"),
	            		
	            		     
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
	
	            }
	     

	            catch(Exception e1)
	            {
	            	JOptionPane.showMessageDialog(null, e1);
	            }

					
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(313, 156, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblSearchACar = new JLabel("Search a Car");
		lblSearchACar.setForeground(Color.BLACK);
		lblSearchACar.setFont(new Font("Sitka Display", Font.BOLD, 37));
		lblSearchACar.setBackground(Color.WHITE);
		lblSearchACar.setBounds(251, 26, 247, 39);
		contentPane.add(lblSearchACar);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dashboard dash=new dashboard();
				dispose();
				dash.setLocationRelativeTo(null);
				dash.setVisible(true);
			}
		});
		btnHome.setBounds(313, 430, 89, 23);
		contentPane.add(btnHome);
		
		
	}
}
