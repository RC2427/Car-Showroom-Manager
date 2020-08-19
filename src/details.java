import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class details extends JFrame {

	private JPanel contentPane;
	public String x,y;
	private JTextField textField;
	public String rate;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			private String a;
			public void run() {
				try {
					details frame = new details(a);
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
	public details(String detail) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 503);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_1.setBounds(425, 255, 140, 33);
		contentPane.add(comboBox_1);
		
		comboBox_1.addItem("Red");
		comboBox_1.addItem("Blue");
		comboBox_1.addItem("Black");
		comboBox_1.addItem("Green");
		
		

	/*	comboBox_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
					String color=(String) comboBox_1.getSelectedItem();
				
				System.out.println("You selected "+color);
				y=color;
				
			}
		});
	*/
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String color=(String) comboBox_1.getSelectedItem();
				
				
				System.out.println("You selected "+color);
				y=color;
			}
		});
		
		
		
		
	
		
	
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sell s=new sell();
				dispose();
				s.setLocationRelativeTo(null);
				s.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(45, 414, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_14 = new JLabel("Price in Lakhs : ");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_14.setBounds(425, 338, 114, 33);
		contentPane.add(lblNewLabel_14);
		
		
		
	
		
		
		System.out.println(detail);
		
		if(detail=="Etios Cross")
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\etiosinterior.jfif"));
			lblNewLabel.setBounds(343, 0, 341, 202);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\toyo.jfif"));
			lblNewLabel_1.setBounds(10, 29, 298, 148);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblMileagekml = new JLabel("Mileage: 20Km/l");
			lblMileagekml.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblMileagekml.setBounds(82, 255, 125, 29);
			contentPane.add(lblMileagekml);
			
			JLabel lblFuelTankCapacity = new JLabel("Fuel tank capacity: 45 L");
			lblFuelTankCapacity.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblFuelTankCapacity.setBounds(82, 332, 162, 29);
			contentPane.add(lblFuelTankCapacity);
			
			
			JLabel lblColor = new JLabel("Color: ");
			lblColor.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblColor.setBounds(379, 255, 125, 29);
			contentPane.add(lblColor);
			/*
			JLabel lblCostlakh = new JLabel("Cost: 8 lakh");
			lblCostlakh.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblCostlakh.setBounds(379, 332, 125, 29);
			contentPane.add(lblCostlakh);*/
		}
		
		
		else if(detail=="Fortuner")
				{
			
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\fortune.jfif"));
			lblNewLabel_2.setBounds(10, 11, 287, 186);
			contentPane.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("New label");
			lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\forinterior.jfif"));
			lblNewLabel_3.setBounds(361, 32, 323, 169);
			contentPane.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Mileage : 17km/l");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_4.setBounds(119, 255, 146, 33);
			contentPane.add(lblNewLabel_4);
			
			JLabel lblFuelTankCapacity_1 = new JLabel("Fuel Tank Capacity: 60L");
			lblFuelTankCapacity_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblFuelTankCapacity_1.setBounds(119, 343, 166, 33);
			contentPane.add(lblFuelTankCapacity_1);
		/*	
			JLabel lblPrice = new JLabel("Price : 35 lakh");
			lblPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblPrice.setBounds(425, 343, 166, 33);
			contentPane.add(lblPrice);
		*/
			
				}
		
		else if(detail=="Glanza")
		{
			
			
			JLabel lblNewLabel_5 = new JLabel("New label");
			lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\glaza.jfif"));
			lblNewLabel_5.setBounds(24, 48, 255, 106);
			contentPane.add(lblNewLabel_5);
			
			JLabel lblNewLabel_6 = new JLabel("New label");
			lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\glazainter.jfif"));
			lblNewLabel_6.setBounds(369, 37, 300, 128);
			contentPane.add(lblNewLabel_6);
			
			JLabel lblNewLabel_7 = new JLabel("Mileage : 22km/l");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_7.setBounds(92, 255, 120, 33);
			contentPane.add(lblNewLabel_7);
			
			JLabel lblFuelTankCapacity_2 = new JLabel("Fuel Tank Capacity : 37L");
			lblFuelTankCapacity_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblFuelTankCapacity_2.setBounds(92, 339, 164, 33);
			contentPane.add(lblFuelTankCapacity_2);
			
			/*
			JLabel lblPrice_1 = new JLabel("Price : 8 lakh");
			lblPrice_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblPrice_1.setBounds(425, 339, 140, 33);
			contentPane.add(lblPrice_1);
		*/
			
		}
	
		else if(detail=="Innova Crysta")
		{


			JLabel lblNewLabel_8 = new JLabel("New label");
			lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\innova.jfif"));
			lblNewLabel_8.setBounds(32, 40, 266, 146);
			contentPane.add(lblNewLabel_8);
			
			JLabel lblNewLabel_9 = new JLabel("New label");
			lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\innovainte.jfif"));
			lblNewLabel_9.setBounds(382, 33, 302, 146);
			contentPane.add(lblNewLabel_9);
			
			JLabel lblNewLabel_10 = new JLabel("Mileage: 16Km/l");
			lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_10.setBounds(89, 255, 127, 33);
			contentPane.add(lblNewLabel_10);
			
			JLabel lblFuelTankCapacity_3 = new JLabel("Fuel tank capacity: 50 L");
			lblFuelTankCapacity_3.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblFuelTankCapacity_3.setBounds(89, 351, 183, 33);
			contentPane.add(lblFuelTankCapacity_3);
			
	
			
		}
		
		
		
		else if(detail=="Corolla Altis")
		{
			
			JLabel lblNewLabel_11 = new JLabel("s");
			lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\atlis.jfif"));
			lblNewLabel_11.setBounds(27, 35, 280, 125);
			contentPane.add(lblNewLabel_11);
			
			JLabel lblNewLabel_12 = new JLabel("New label");
			lblNewLabel_12.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\atlisinter.jfif"));
			lblNewLabel_12.setBounds(364, 11, 299, 149);
			contentPane.add(lblNewLabel_12);
			
			JLabel lblNewLabel_13 = new JLabel("Mileage: 25km/l");
			lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_13.setBounds(94, 255, 132, 33);
			contentPane.add(lblNewLabel_13);
			
			JLabel lblFuelTankCapacity_4 = new JLabel("Fuel Tank Capacity: 30L");
			lblFuelTankCapacity_4.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblFuelTankCapacity_4.setBounds(94, 352, 178, 33);
			contentPane.add(lblFuelTankCapacity_4);
	
			
		}
			 String cost=null;
	    		
	    		textField = new JTextField();
	    		textField.setBounds(527, 345, 86, 20);
	    		contentPane.add(textField);
	    		textField.setColumns(10);
	    		
	    		 
		          
	    		
	    		
	    		Connection con=null;
		        Statement stmt=null;
		        ResultSet rs=null;
		       

		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            System.out.println("\nDriver loaded");

     	            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
		            System.out.print("Connection Successful");
		            System.out.println("\nInserting record....");
		            stmt=con.createStatement();
		            
		          String q="Select price from store where model ="+"'"+detail+"'"+";";
		          
		            
		           // String q="Select price from store where id=1";
		            rs=stmt.executeQuery(q);
		            
		           
		            
		            while(rs.next())
		               {
		            		textField.setText(rs.getString("price"));
		               }
		          
		            
		            
		            System.out.print(textField.getText());
		            
		        
		            rate=textField.getText();
		            
		            if(textField.getText().equals(""))
		            {
		            	JOptionPane.showMessageDialog(null, "Car Currently Not Available");
		            	
		            }
		            
		            
		          
		            JButton btnNewButton = new JButton("Buy");
		    		btnNewButton.addActionListener(new ActionListener() {
		    			public void actionPerformed(ActionEvent e) {
		    			     

			 		            	cust c =new cust(detail,y,rate);
			        				 System.out.print("\n\n"+rate+"\n\n");
			        				 System.out.print("\n\n"+rate+"\n\n");
			        				dispose();
			        				c.setLocationRelativeTo(null);
			        				c.setVisible(true);
		 		           
		 		            
		    			    
		    			}
		    		});   
		    		btnNewButton.setBounds(553, 414, 89, 23);
		    		contentPane.add(btnNewButton);
		            

		    	
		            }
		        
		        
		        catch(Exception e3)
		        {
		        	 JOptionPane.showMessageDialog(null, "Insertion Not Successfull");
		        }
		           
		            
		        }
		 
		      
		       
	    		
		
	
		
			
		
		
	}
