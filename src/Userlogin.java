import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;

public class Userlogin extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Userlogin frame = new Userlogin();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					//	UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Userlogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 710, 503);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.windowText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 694, 81);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("                 TOYOYA SHOWROOM\r\n");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(137, 11, 405, 59);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 383, 694, 81);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("         TOYOYA SHOWROOM\r\n");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(191, 11, 360, 59);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(25, 108, 218, 171);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\t1.jfif"));
		
		JLabel lblNewLabel_3 = new JLabel("Username :");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(329, 152, 132, 28);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(329, 205, 132, 28);
		contentPane.add(lblPassword);
		
		user = new JTextField("Username");
		user.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (user.getText().equals("Username")) {
		            user.setText("");
		            user.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (user.getText().isEmpty()) {
		            user.setForeground(Color.GRAY);
		            user.setText("Username");
		        }
		    }
		    });
		
		user.setBounds(407, 153, 150, 28);
		contentPane.add(user);
		user.setColumns(10);
		DatabaseConnect DataCon = new DatabaseConnect();
		JButton btnLogin = new JButton("Login");
		btnLogin.addAncestorListener(new RequestFocusListener(false));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = user.getText();
                String password = String.valueOf(pass.getPassword());
                
              if((DataCon.checkUserLogin(username, password))){
            	  System.out.println("Login Successfull");
					//Second Frame Called
            	  dashboard dash=new dashboard();
					dispose();
					dash.setLocationRelativeTo(null);
					dash.setVisible(true);
              }
              else{
            	  System.out.println("Invalid Login ID/Password");
              }
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.setBounds(432, 265, 89, 23);
		contentPane.add(btnLogin);
		
		pass = new JPasswordField();
		pass.setBounds(407, 208, 150, 28);
		contentPane.add(pass);
		
		JLabel lblNewLabel_4 = new JLabel("Contact us : 1800 425 0001 ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(518, 89, 166, 23);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("TOYOTA");
		lblNewLabel_5.setBackground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setBounds(93, 290, 150, 28);
		contentPane.add(lblNewLabel_5);
	}
}
