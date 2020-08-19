import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sell extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sell frame = new sell();
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
	public sell() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 710, 503);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
    

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("\nDriver loaded");
            String s="Select * from store ";
       
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
            
            System.out.print("Connection Successful");
            stmt=con.createStatement(); 
           rs=stmt.executeQuery(s);
           while(rs.next())  
        	  System.out.println("  " +rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(7)); 
            System.out.print(stmt.executeQuery(s));

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

		
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			/*	
				cust c1=new cust("Etios Cross");
				dispose();
				c1.setLocationRelativeTo(null);
				c1.setVisible(true);
			*/	
				
				details d1=new details("Etios Cross");
				dispose();
				d1.setLocationRelativeTo(null);
				d1.setVisible(true);
				
				
				
			}
		});
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\toyo.jfif"));
		lblNewLabel.setBounds(0, 0, 290, 130);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/*cust c1=new cust("Fortuner");
				dispose();
				c1.setLocationRelativeTo(null);
				c1.setVisible(true);*/
				
				
				
				details d1=new details("Fortuner");
				dispose();
				d1.setLocationRelativeTo(null);
				d1.setVisible(true);
				
				
				
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\fortune.jfif"));
		lblNewLabel_1.setBounds(381, 0, 303, 130);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				/*cust c1=new cust("Glanza");
				dispose();
				c1.setLocationRelativeTo(null);
				c1.setVisible(true);
				*/
				
				details d1=new details("Glanza");
				dispose();
				d1.setLocationRelativeTo(null);
				d1.setVisible(true);
				
				
			}
			
			
		});
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\glaza.jfif"));
		lblNewLabel_2.setBounds(234, 143, 240, 147);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/*cust c1=new cust("Innova Crysta");
				dispose();
				c1.setLocationRelativeTo(null);
				c1.setVisible(true);
				*/
				
				details d1=new details("Innova Crysta");
				dispose();
				d1.setLocationRelativeTo(null);
				d1.setVisible(true);
				
				
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\innova.jfif"));
		lblNewLabel_3.setBounds(0, 312, 290, 152);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/*
				cust c1=new cust("Corolla Altis");
				dispose();
				c1.setLocationRelativeTo(null);
				c1.setVisible(true);*/
				
				details d1=new details("Corolla Altis");
				dispose();
				d1.setLocationRelativeTo(null);
				d1.setVisible(true);
				
				
			}
		});
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\atlis.jfif"));
		lblNewLabel_4.setBounds(423, 312, 271, 168);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Etios Cross");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(115, 141, 85, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblFortuner = new JLabel("Fortuner");
		lblFortuner.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFortuner.setBounds(507, 141, 65, 14);
		contentPane.add(lblFortuner);
		
		JLabel lblNewLabel_6 = new JLabel("Glanza");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(335, 292, 67, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblInnovaCrysta = new JLabel("Innova Crysta");
		lblInnovaCrysta.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInnovaCrysta.setBounds(115, 287, 109, 14);
		contentPane.add(lblInnovaCrysta);
		
		JLabel lblEtiosCross = new JLabel("Corolla Altis");
		lblEtiosCross.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEtiosCross.setBounds(507, 292, 85, 14);
		contentPane.add(lblEtiosCross);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dashboard d=new dashboard();
				dispose();
				d.setLocationRelativeTo(null);
				d.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(313, 414, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
	
		
	}
}
