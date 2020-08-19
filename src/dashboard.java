import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class dashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard frame = new dashboard();
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
	public dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 710, 503);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\toyota(1).png"));
		lblNewLabel.setBounds(30, 21, 157, 88);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\toyota(1).png"));
		lblNewLabel_1.setBounds(533, 21, 139, 88);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dash Board");
		lblNewLabel_2.setForeground(UIManager.getColor("InternalFrame.activeTitleForeground"));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 31));
		lblNewLabel_2.setBounds(265, 65, 234, 44);
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("TOYOTA");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(53, 120, 98, 28);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("TOYOTA");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(555, 120, 98, 28);
		contentPane.add(label_1);
		
		JButton btnNewButton = new JButton("ADD CAR TO SHOWROOM");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				importcar d1=new importcar();
				dispose();
				d1.setLocationRelativeTo(null);
				
				d1.setVisible(true);
			
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(107, 159, 195, 44);
		contentPane.add(btnNewButton);
		
		JButton btnSellACar = new JButton("SELL A CAR");
		btnSellACar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sell s=new sell();
				dispose();
				s.setLocationRelativeTo(null);
				s.setVisible(true);
			}
		});
		btnSellACar.setBackground(SystemColor.activeCaption);
		btnSellACar.setBounds(374, 159, 195, 44);
		contentPane.add(btnSellACar);
		
		JButton btnAllCarsIn = new JButton("ALL CARS IN SHOWROOM");
		btnAllCarsIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tables t=new tables();
				dispose();
				t.setLocationRelativeTo(null);
				t.setVisible(true);
			}
		});
		btnAllCarsIn.setBackground(SystemColor.activeCaption);
		btnAllCarsIn.setBounds(107, 252, 195, 44);
		contentPane.add(btnAllCarsIn);
		
		JButton btnNewButton_1 = new JButton("LogOut");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
				Userlogin u=new Userlogin();
				dispose();
				u.setLocationRelativeTo(null);
				u.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(564, 430, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnSoldDetails = new JButton("TRANSACTION DETAILS");
		btnSoldDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cust_table t=new cust_table();
				dispose();
				t.setLocationRelativeTo(null);
				t.setVisible(true);
			}
		});
		btnSoldDetails.setBackground(SystemColor.activeCaption);
		btnSoldDetails.setBounds(374, 252, 195, 44);
		contentPane.add(btnSoldDetails);
		
		JButton btnDetailsByDate = new JButton("DETAILS BY DATE");
		btnDetailsByDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dates d=new dates();
				dispose();
				d.setLocationRelativeTo(null);
				d.setVisible(true);
				
			}
		});
		btnDetailsByDate.setBackground(SystemColor.activeCaption);
		btnDetailsByDate.setBounds(107, 344, 195, 44);
		contentPane.add(btnDetailsByDate);
		
		JButton btnSearch = new JButton("SEARCH A PARTICULAR CAR");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				search s=new search();
				dispose();
				s.setLocationRelativeTo(null);
				s.setVisible(true);
				try {
					Send.sendMail("dchoudhary442000@gmail.com");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSearch.setBackground(SystemColor.activeCaption);
		btnSearch.setBounds(374, 344, 195, 44);
		contentPane.add(btnSearch);
		
		JButton btnSendMailsRegarding = new JButton("SEND MAILS REGARDING SCHEMES");
		btnSendMailsRegarding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			      
		           mailframe m=new mailframe();
					dispose();
					m.setLocationRelativeTo(null);
					m.setVisible(true);
		           
		           
				
				
			}
		});
		btnSendMailsRegarding.setBackground(SystemColor.activeCaption);
		btnSendMailsRegarding.setBounds(224, 409, 234, 44);
		contentPane.add(btnSendMailsRegarding);
	}
}
