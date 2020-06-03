import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sun.security.pkcs.SigningCertificateInfo;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
//import User;

public class GUIsw extends JFrame {

	private JPanel contentPane;
	private JTextField user_nameTXT;
	private JPasswordField passwordTXT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIsw frame = new GUIsw();
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
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	public GUIsw() {
		String user;
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 460, 484);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel logIn = new JPanel();
		logIn.setBackground(new Color(165, 42, 42));
		layeredPane.add(logIn, "name_786349748922400");
		logIn.setLayout(null);
		
		JPanel signIn = new JPanel();
		signIn.setBackground(new Color(165, 42, 42));
		layeredPane.add(signIn, "name_864755397340300");
		signIn.setLayout(null);
		
		JButton btnNewButton_9 = new JButton("sign in");
		btnNewButton_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				logIn.setVisible(false);
				signIn.setVisible(true);
			}
		});
		
		JButton btnNewButton_8 = new JButton("log in");
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				signIn.setVisible(false);
				logIn.setVisible(true);
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		user_nameTXT = new JTextField();
		user_nameTXT.setBounds(15, 101, 146, 26);
		logIn.add(user_nameTXT);
		user_nameTXT.setColumns(10);
		
		//System.out.print(user_nameTXT.getText());
		
		passwordTXT = new JPasswordField();
		passwordTXT.setBounds(15, 175, 146, 26);
		logIn.add(passwordTXT);
		
		JLabel lblNewLabel = new JLabel("user name:");
		lblNewLabel.setBounds(15, 78, 113, 20);
		logIn.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("password:");
		lblNewLabel_1.setBounds(15, 150, 131, 20);
		logIn.add(lblNewLabel_1);
		
		JPanel choose_activity = new JPanel();
		choose_activity.setBackground(new Color(165, 42, 42));
		layeredPane.add(choose_activity, "name_786697182826900");
		choose_activity.setLayout(null);
		
		JPanel revenue = new JPanel();
		revenue.setBackground(new Color(165, 42, 42));
		layeredPane.add(revenue, "name_788136659292800");
		revenue.setLayout(null);
		
		JPanel expense = new JPanel();
		expense.setBackground(new Color(165, 42, 42));
		layeredPane.add(expense, "name_788156332542700");
		expense.setLayout(null);
		
		JPanel monthly_budget = new JPanel();
		monthly_budget.setBackground(new Color(165, 42, 42));
		layeredPane.add(monthly_budget, "name_788170547439400");
		monthly_budget.setLayout(null);
		
		JButton btnlogin = new JButton("log in");
		btnlogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				logIn.setVisible(false);
				
				User.login(user_nameTXT.getText(), passwordTXT.getText(), User.restURL);
								
				choose_activity.setVisible(true);
				JOptionPane.showMessageDialog(null, "login successfully!");
			}
		});
		btnlogin.setBounds(330, 439, 115, 29);
		logIn.add(btnlogin);
		
		JLabel lblNewLabel_17 = new JLabel("new user?");
		lblNewLabel_17.setBounds(278, 16, 81, 20);
		logIn.add(lblNewLabel_17);
		
		JLabel lblNewLabel_12 = new JLabel("SingIn");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_12.setBounds(15, 16, 193, 44);
		signIn.add(lblNewLabel_12);
		
		btnNewButton_8.setBounds(359, 16, 86, 20);
		signIn.add(btnNewButton_8);
		
		btnNewButton_9.setBounds(359, 16, 86, 20);
		logIn.add(btnNewButton_9);
		
		JLabel lblNewLabel_12_1 = new JLabel("LogIn");
		lblNewLabel_12_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_12_1.setBounds(15, 16, 193, 44);
		logIn.add(lblNewLabel_12_1);
		
		JLabel lblNewLabel_2 = new JLabel("Choose activity");
		lblNewLabel_2.setBounds(15, 16, 212, 47);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 26));
		choose_activity.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Revenue");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				choose_activity.setVisible(false);
				revenue.setVisible(true);
			}
		});
		btnNewButton.setBounds(60, 99, 142, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		choose_activity.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Expesne");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				choose_activity.setVisible(false);
				expense.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(60, 156, 142, 29);
		choose_activity.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Monthly budget");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				choose_activity.setVisible(false);
				monthly_budget.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(60, 213, 142, 29);
		choose_activity.add(btnNewButton_2);
		
		
		JLabel lblNewLabel_3 = new JLabel("welcome");
		lblNewLabel_3.setBounds(210, 16, 122, 20);
		choose_activity.add(lblNewLabel_3);
		
		
		JButton btnNewButton_3 = new JButton("log out");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				choose_activity.setVisible(false);
				user_nameTXT.setText("");
				passwordTXT.setText("");
				logIn.setVisible(true);
				JOptionPane.showMessageDialog(null, "logout successfully!");
			}
		});
		btnNewButton_3.setBounds(362, 16, 83, 20);
		choose_activity.add(btnNewButton_3);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(9, 148, 50, 47);
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\\u05D3\u05D5\u05E8\\Desktop\\\u05D4\u05E0\u05D3\u05E1\u05EA \u05EA\u05D5\u05DB\u05E0\u05D4\\expense (1).png"));
		choose_activity.add(lblNewLabel_8);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(15, 92, 44, 47);
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\\u05D3\u05D5\u05E8\\Desktop\\\u05D4\u05E0\u05D3\u05E1\u05EA \u05EA\u05D5\u05DB\u05E0\u05D4\\revenue (1).png"));
		choose_activity.add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\\u05D3\u05D5\u05E8\\Desktop\\\u05D4\u05E0\u05D3\u05E1\u05EA \u05EA\u05D5\u05DB\u05E0\u05D4\\budget (1).png"));
		lblNewLabel_9.setBounds(15, 187, 128, 78);
		choose_activity.add(lblNewLabel_9);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\\u05D3\u05D5\u05E8\\Desktop\\\u05D4\u05E0\u05D3\u05E1\u05EA \u05EA\u05D5\u05DB\u05E0\u05D4\\logout (1).png"));
		lblNewLabel_11.setBounds(323, 16, 44, 29);
		choose_activity.add(lblNewLabel_11);
		
		JButton btnNewButton_4 = new JButton("back");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				revenue.setVisible(false);
				choose_activity.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(330, 439, 115, 29);
		revenue.add(btnNewButton_4);
		
		JLabel lblNewLabel_4 = new JLabel("Revenue");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_4.setBounds(15, 16, 146, 32);
		revenue.add(lblNewLabel_4);
		
		JButton btnNewButton_10 = new JButton("update revenue");
		btnNewButton_10.setBounds(15, 77, 192, 29);
		revenue.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("display revenue");
		btnNewButton_11.setBounds(15, 122, 192, 29);
		revenue.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("monthly revenue");
		btnNewButton_12.setBounds(15, 167, 192, 29);
		revenue.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("add revenue");
		btnNewButton_13.setBounds(253, 77, 192, 29);
		revenue.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("delete revenue");
		btnNewButton_14.setBounds(253, 122, 192, 29);
		revenue.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("New button");
		btnNewButton_15.setBounds(253, 167, 192, 29);
		revenue.add(btnNewButton_15);
		
		JLabel lblNewLabel_19_1 = new JLabel("for display revenue by category name,");
		lblNewLabel_19_1.setBounds(15, 212, 287, 20);
		revenue.add(lblNewLabel_19_1);
		
		JLabel lblNewLabel_18_1 = new JLabel("enter the category name and press 'display':");
		lblNewLabel_18_1.setBounds(15, 232, 325, 20);
		revenue.add(lblNewLabel_18_1);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(15, 260, 177, 26);
		revenue.add(formattedTextField_1);
		
		JButton btnNewButton_17_1 = new JButton("display");
		btnNewButton_17_1.setBounds(207, 263, 81, 20);
		revenue.add(btnNewButton_17_1);
		
		JLabel lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setIcon(new ImageIcon("C:\\Users\\\u05D3\u05D5\u05E8\\Desktop\\\u05D4\u05E0\u05D3\u05E1\u05EA \u05EA\u05D5\u05DB\u05E0\u05D4\\revenue (1).png"));
		lblNewLabel_21.setBounds(134, 0, 50, 57);
		revenue.add(lblNewLabel_21);
		
		JButton btnNewButton_5 = new JButton("back");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				expense.setVisible(false);
				choose_activity.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(330, 439, 115, 29);
		expense.add(btnNewButton_5);
		
		JLabel lblNewLabel_5 = new JLabel("Expense");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_5.setBounds(15, 16, 165, 37);
		expense.add(lblNewLabel_5);
		
		JButton btnNewButton_10_1 = new JButton("update expense");
		btnNewButton_10_1.setBounds(15, 69, 177, 29);
		expense.add(btnNewButton_10_1);
		
		JButton btnNewButton_11_1 = new JButton("display expense");
		btnNewButton_11_1.setBounds(15, 114, 177, 29);
		expense.add(btnNewButton_11_1);
		
		JButton btnNewButton_12_1 = new JButton("monthly expense");
		btnNewButton_12_1.setBounds(15, 159, 177, 29);
		expense.add(btnNewButton_12_1);
		
		JButton btnNewButton_13_1 = new JButton("add expense");
		btnNewButton_13_1.setBounds(268, 69, 177, 29);
		expense.add(btnNewButton_13_1);
		
		JButton btnNewButton_14_1 = new JButton("delete expense");
		btnNewButton_14_1.setBounds(268, 114, 177, 29);
		expense.add(btnNewButton_14_1);
		
		JButton btnNewButton_15_1 = new JButton("future expense");
		btnNewButton_15_1.setBounds(268, 159, 177, 29);
		expense.add(btnNewButton_15_1);
		
		JButton btnNewButton_16 = new JButton("display new expense");
		btnNewButton_16.setBounds(15, 204, 177, 29);
		expense.add(btnNewButton_16);
		
		JLabel lblNewLabel_19 = new JLabel("for display expense by category name,");
		lblNewLabel_19.setBounds(15, 247, 287, 20);
		expense.add(lblNewLabel_19);
		
		JLabel lblNewLabel_18 = new JLabel("enter the category name and press 'display':");
		lblNewLabel_18.setBounds(15, 267, 325, 20);
		expense.add(lblNewLabel_18);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(15, 297, 177, 26);
		expense.add(formattedTextField);
		
		JButton btnNewButton_17 = new JButton("display");
		btnNewButton_17.setBounds(207, 300, 81, 20);
		expense.add(btnNewButton_17);
		
		JLabel lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setIcon(new ImageIcon("C:\\Users\\\u05D3\u05D5\u05E8\\Desktop\\\u05D4\u05E0\u05D3\u05E1\u05EA \u05EA\u05D5\u05DB\u05E0\u05D4\\expense (1).png"));
		lblNewLabel_22.setBounds(123, 0, 59, 53);
		expense.add(lblNewLabel_22);
		
		JButton btnNewButton_6 = new JButton("back");
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				monthly_budget.setVisible(false);
				choose_activity.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(330, 439, 115, 29);
		monthly_budget.add(btnNewButton_6);
		
		JLabel lblNewLabel_6 = new JLabel("Monthly budget");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_6.setBounds(15, 16, 251, 47);
		monthly_budget.add(lblNewLabel_6);
		
		JLabel lblNewLabel_20 = new JLabel("Your monthly budget is:");
		lblNewLabel_20.setForeground(Color.BLACK);
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_20.setBounds(15, 69, 251, 34);
		monthly_budget.add(lblNewLabel_20);
		
		JLabel lblNewLabel_23 = new JLabel("");
		lblNewLabel_23.setIcon(new ImageIcon("C:\\Users\\\u05D3\u05D5\u05E8\\Desktop\\\u05D4\u05E0\u05D3\u05E1\u05EA \u05EA\u05D5\u05DB\u05E0\u05D4\\budget (1).png"));
		lblNewLabel_23.setBounds(225, 16, 57, 47);
		monthly_budget.add(lblNewLabel_23);
		
		
		JLabel lblNewLabel_13 = new JLabel("email:");
		lblNewLabel_13.setBounds(15, 76, 69, 20);
		signIn.add(lblNewLabel_13);
		
		textField = new JTextField();
		textField.setBounds(15, 102, 176, 26);
		signIn.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("password:");
		lblNewLabel_14.setBounds(15, 144, 86, 20);
		signIn.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("verify password:");
		lblNewLabel_15.setBounds(15, 211, 123, 20);
		signIn.add(lblNewLabel_15);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(15, 169, 176, 26);
		signIn.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(15, 236, 176, 26);
		signIn.add(passwordField_1);
		
		JButton btnNewButton_7 = new JButton("sign in");
		btnNewButton_7.setBounds(330, 439, 115, 29);
		signIn.add(btnNewButton_7);
		
		JLabel lblNewLabel_16 = new JLabel("user exist?");
		lblNewLabel_16.setBounds(272, 16, 86, 20);
		signIn.add(lblNewLabel_16);
		
	}
}
