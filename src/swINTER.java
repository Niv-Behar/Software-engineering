import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class swINTER extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swINTER frame = new swINTER();
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
	public swINTER() {
		/*//Creating the service classes!
		UserService userService=UserService.getInstance();
		CategoryService categoryService=CategoryService.getInstance();
		//----------------
		userService.login("1111@1111", "1111");
		categoryService.getCategories(userService.getToken());
		//categoryService.addCategory("Gas", 800, 0, userService.getUserId(), userService.getToken());
		categoryService.printCategories();
		System.out.println("////////////////");
		Category updatedCat=categoryService.findCategory("Shoshi");
		updatedCat.amountUsed=201;
		updatedCat.title="Oz";
		categoryService.updateCategory(updatedCat, userService.getToken());
		categoryService.getCategories(userService.getToken());
		categoryService.printCategories();
<<<<<<< HEAD
		*/
=======
		categoryService.deleteCategory(updatedCat._id, userService.getToken());
		categoryService.getCategories(userService.getToken());
		categoryService.printCategories();
		
>>>>>>> e7c3121e0d9cdeb64f97038bc8526953b833fb46
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 474, 498);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel logIn = new JPanel();
		logIn.setBackground(new Color(165, 42, 42));
		layeredPane.add(logIn, "name_1044684755738000");
		logIn.setLayout(null);
		
		JLabel lblNewLabel_12_1 = new JLabel("LogIn");
		lblNewLabel_12_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_12_1.setBounds(15, 16, 193, 44);
		logIn.add(lblNewLabel_12_1);
		
		JLabel lblNewLabel_17 = new JLabel("new user?");
		lblNewLabel_17.setBounds(292, 16, 81, 20);
		logIn.add(lblNewLabel_17);
		
		JPanel signIn = new JPanel();
		signIn.setBackground(new Color(165, 42, 42));
		layeredPane.add(signIn, "name_1044689499709500");
		signIn.setLayout(null);
		
		JButton btnNewButton_9 = new JButton("sign in");
		btnNewButton_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logIn.setVisible(false);
				signIn.setVisible(true);
			}
		});
		btnNewButton_9.setBounds(373, 16, 86, 20);
		logIn.add(btnNewButton_9);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(15, 101, 146, 26);
		logIn.add(textField);
		
		JLabel lblNewLabel = new JLabel("user name:");
		lblNewLabel.setBounds(15, 78, 113, 20);
		logIn.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("password:");
		lblNewLabel_1.setBounds(15, 150, 131, 20);
		logIn.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(15, 175, 146, 26);
		logIn.add(passwordField);
		
		JPanel choose_activity = new JPanel();
		choose_activity.setBackground(new Color(165, 42, 42));
		layeredPane.add(choose_activity, "name_1044691011849800");
		choose_activity.setLayout(null);
		
		JButton btnlogin = new JButton("log in");
		btnlogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				logIn.setVisible(false);
				choose_activity.setVisible(true);
				JOptionPane.showMessageDialog(null, "login successfully!");
			}
		});
		btnlogin.setBounds(344, 453, 115, 29);
		logIn.add(btnlogin);
		
		
		
		JLabel lblNewLabel_12 = new JLabel("SingIn");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_12.setBounds(15, 16, 193, 44);
		signIn.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("email:");
		lblNewLabel_13.setBounds(15, 76, 69, 20);
		signIn.add(lblNewLabel_13);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(15, 102, 176, 26);
		signIn.add(textField_1);
		
		JLabel lblNewLabel_14 = new JLabel("password:");
		lblNewLabel_14.setBounds(15, 144, 86, 20);
		signIn.add(lblNewLabel_14);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(15, 169, 176, 26);
		signIn.add(passwordField_1);
		
		JLabel lblNewLabel_15 = new JLabel("verify password:");
		lblNewLabel_15.setBounds(15, 211, 123, 20);
		signIn.add(lblNewLabel_15);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(15, 236, 176, 26);
		signIn.add(passwordField_2);
		
		JButton btnNewButton_7 = new JButton("sign in");
		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				signIn.setVisible(false);
				choose_activity.setVisible(true);
				JOptionPane.showMessageDialog(null, "signin successfully!");
			}
		});
		btnNewButton_7.setBounds(344, 453, 115, 29);
		signIn.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("log in");
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				signIn.setVisible(false);
				logIn.setVisible(true);
			}
		});
		btnNewButton_8.setBounds(373, 16, 86, 20);
		signIn.add(btnNewButton_8);
		
		JLabel lblNewLabel_16 = new JLabel("user exist?");
		lblNewLabel_16.setBounds(288, 16, 86, 20);
		signIn.add(lblNewLabel_16);
		

		
		JLabel lblNewLabel_2 = new JLabel("Choose activity");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_2.setBounds(21, 16, 212, 47);
		choose_activity.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("welcome");
		lblNewLabel_3.setBounds(216, 16, 122, 20);
		choose_activity.add(lblNewLabel_3);
		
		JButton btnNewButton_3 = new JButton("log out");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				choose_activity.setVisible(false);
				textField.setText("");
				passwordField.setText("");
				logIn.setVisible(true);
				JOptionPane.showMessageDialog(null, "logout successfully!");
			}
		});
		btnNewButton_3.setBounds(368, 16, 83, 20);
		choose_activity.add(btnNewButton_3);
		
		JPanel revenue = new JPanel();
		revenue.setBackground(new Color(165, 42, 42));
		layeredPane.add(revenue, "name_1044692808216200");
		
		JButton btnNewButton = new JButton("Revenue");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				choose_activity.setVisible(false);
				revenue.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(66, 99, 142, 29);
		choose_activity.add(btnNewButton);
		
		JPanel expense = new JPanel();
		expense.setBackground(new Color(165, 42, 42));
		layeredPane.add(expense, "name_1044694229249400");
		expense.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Expesne");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				choose_activity.setVisible(false);
				expense.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(66, 156, 142, 29);
		choose_activity.add(btnNewButton_1);
		
		JPanel monthly_budget = new JPanel();
		monthly_budget.setBackground(new Color(165, 42, 42));
		layeredPane.add(monthly_budget, "name_1044711729512100");
		monthly_budget.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Monthly budget");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				choose_activity.setVisible(false);
				monthly_budget.setVisible(true);			
			}
		});
		btnNewButton_2.setBounds(66, 213, 142, 29);
		choose_activity.add(btnNewButton_2);
		revenue.setLayout(null);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("Revenue");
		lblNewLabel_4.setBounds(15, 16, 146, 32);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 26));
		revenue.add(lblNewLabel_4);
		
		JPanel update_revenue = new JPanel();
		update_revenue.setBackground(new Color(165, 42, 42));
		layeredPane.add(update_revenue, "name_1061712366015000");
		update_revenue.setLayout(null);
		
		JButton btnNewButton_10 = new JButton("update revenue");
		btnNewButton_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				revenue.setVisible(false);
				update_revenue.setVisible(true);
			}
		});
		btnNewButton_10.setBounds(15, 77, 192, 29);
		revenue.add(btnNewButton_10);
		
		JPanel display_revenue = new JPanel();
		display_revenue.setBackground(new Color(165, 42, 42));
		layeredPane.add(display_revenue, "name_1062012735486200");
		display_revenue.setLayout(null);
		
		JButton btnNewButton_11 = new JButton("display revenue");
		btnNewButton_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				revenue.setVisible(false);
				display_revenue.setVisible(true);
			}
		});
		btnNewButton_11.setBounds(15, 122, 192, 29);
		revenue.add(btnNewButton_11);
		
		JPanel monthly_revenue = new JPanel();
		monthly_revenue.setBackground(new Color(165, 42, 42));
		layeredPane.add(monthly_revenue, "name_1062091668281100");
		monthly_revenue.setLayout(null);
		
		JButton btnNewButton_12 = new JButton("monthly revenue");
		btnNewButton_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				revenue.setVisible(false);
				monthly_revenue.setVisible(true);
			}
		});
		btnNewButton_12.setBounds(15, 167, 192, 29);
		revenue.add(btnNewButton_12);
		
		JLabel lblNewLabel_19_1 = new JLabel("for display revenue by category name,");
		lblNewLabel_19_1.setBounds(15, 212, 287, 20);
		revenue.add(lblNewLabel_19_1);
		
		JLabel lblNewLabel_18_1 = new JLabel("enter the category name and press 'display':");
		lblNewLabel_18_1.setBounds(15, 232, 325, 20);
		revenue.add(lblNewLabel_18_1);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(15, 260, 177, 26);
		revenue.add(formattedTextField_1);
		
		JPanel revenue_by_name = new JPanel();
		revenue_by_name.setBackground(new Color(165, 42, 42));
		layeredPane.add(revenue_by_name, "name_1062093560155000");
		revenue_by_name.setLayout(null);
		
		JButton btnNewButton_17_1 = new JButton("display");
		btnNewButton_17_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				revenue.setVisible(false);
				revenue_by_name.setVisible(true);
			}
		});
		btnNewButton_17_1.setBounds(207, 263, 81, 20);
		revenue.add(btnNewButton_17_1);
		
		JButton btnNewButton_4 = new JButton("back");
		btnNewButton_4.setBounds(344, 453, 115, 29);
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				revenue.setVisible(false);
				choose_activity.setVisible(true);
			}
		});
		revenue.add(btnNewButton_4);
		
		JPanel delete_revenue = new JPanel();
		delete_revenue.setBackground(new Color(165, 42, 42));
		layeredPane.add(delete_revenue, "name_1062089755934099");
		delete_revenue.setLayout(null);
		
		JButton btnNewButton_14 = new JButton("delete revenue");
		btnNewButton_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				revenue.setVisible(false);
				delete_revenue.setVisible(true);
			}
		});
		btnNewButton_14.setBounds(253, 122, 192, 29);
		revenue.add(btnNewButton_14);
		
		JPanel add_revenue = new JPanel();
		add_revenue.setBackground(new Color(165, 42, 42));
		layeredPane.add(add_revenue, "name_1061941618251600");
		add_revenue.setLayout(null);
		
		JButton btnNewButton_13 = new JButton("add revenue");
		btnNewButton_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				revenue.setVisible(false);
				add_revenue.setVisible(true);
			}
		});
		btnNewButton_13.setBounds(253, 77, 192, 29);
		revenue.add(btnNewButton_13);
		
		
		
		JLabel lblNewLabel_5 = new JLabel("Expense");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_5.setBounds(15, 16, 165, 37);
		expense.add(lblNewLabel_5);
		
		JPanel update_expense = new JPanel();
		update_expense.setBackground(new Color(165, 42, 42));
		layeredPane.add(update_expense, "name_1062095649858400");
		update_expense.setLayout(null);
		
		JButton btnNewButton_10_1 = new JButton("update expense");
		btnNewButton_10_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				expense.setVisible(false);
				update_expense.setVisible(true);
			}
		});
		btnNewButton_10_1.setBounds(15, 69, 177, 29);
		expense.add(btnNewButton_10_1);
		
		JPanel display_expense = new JPanel();
		display_expense.setBackground(new Color(165, 42, 42));
		layeredPane.add(display_expense, "name_1062100244445700");
		display_expense.setLayout(null);
		
		JButton btnNewButton_11_1 = new JButton("display expense");
		btnNewButton_11_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				expense.setVisible(false);
				display_expense.setVisible(true);
			}
		});
		btnNewButton_11_1.setBounds(15, 114, 177, 29);
		expense.add(btnNewButton_11_1);
		
		JPanel delete_expense = new JPanel();
		delete_expense.setBackground(new Color(165, 42, 42));
		layeredPane.add(delete_expense, "name_1062102111016999");
		delete_expense.setLayout(null);
		
		JButton btnNewButton_14_1 = new JButton("delete expense");
		btnNewButton_14_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				expense.setVisible(false);
				delete_expense.setVisible(true);
			}
		});
		btnNewButton_14_1.setBounds(268, 114, 177, 29);
		expense.add(btnNewButton_14_1);
		
		JPanel add_expense = new JPanel();
		add_expense.setBackground(new Color(165, 42, 42));
		layeredPane.add(add_expense, "name_1062098214779899");
		add_expense.setLayout(null);
		
		JButton btnNewButton_13_1 = new JButton("add expense");
		btnNewButton_13_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				expense.setVisible(false);
				add_expense.setVisible(true);
			}
		});
		btnNewButton_13_1.setBounds(268, 69, 177, 29);
		expense.add(btnNewButton_13_1);
		
		JButton btnNewButton_15_1 = new JButton("future expense");
		btnNewButton_15_1.setBounds(268, 159, 177, 29);
		expense.add(btnNewButton_15_1);
		
		JPanel monthly_expense = new JPanel();
		monthly_expense.setBackground(new Color(165, 42, 42));
		layeredPane.add(monthly_expense, "name_1062103848720199");
		monthly_expense.setLayout(null);
		
		JButton btnNewButton_12_1 = new JButton("monthly expense");
		btnNewButton_12_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				expense.setVisible(false);
				monthly_expense.setVisible(true);
			}
		});
		btnNewButton_12_1.setBounds(15, 159, 177, 29);
		expense.add(btnNewButton_12_1);
		
		JPanel display_new_expense = new JPanel();
		display_new_expense.setBackground(new Color(165, 42, 42));
		layeredPane.add(display_new_expense, "name_1062108454233500");
		display_new_expense.setLayout(null);
		
		JButton btnNewButton_16 = new JButton("display new expense");
		btnNewButton_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				expense.setVisible(false);
				display_new_expense.setVisible(true);
			}
		});
		btnNewButton_16.setBackground(Color.WHITE);
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
		
		JPanel expense_by_name = new JPanel();
		expense_by_name.setBackground(new Color(165, 42, 42));
		layeredPane.add(expense_by_name, "name_1062110671012800");
		expense_by_name.setLayout(null);
		
		JButton btnNewButton_17 = new JButton("display");
		btnNewButton_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				expense.setVisible(false);
				expense_by_name.setVisible(true);
			}
		});
		btnNewButton_17.setBounds(207, 300, 81, 20);
		expense.add(btnNewButton_17);
		
		JButton btnNewButton_5 = new JButton("back");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				expense.setVisible(false);
				choose_activity.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(344, 453, 115, 29);
		expense.add(btnNewButton_5);
		
		
		
		JLabel lblNewLabel_6 = new JLabel("Monthly budget");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_6.setBounds(15, 16, 251, 47);
		monthly_budget.add(lblNewLabel_6);
		
		JLabel lblNewLabel_20 = new JLabel("Your monthly budget is:");
		lblNewLabel_20.setForeground(Color.BLACK);
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_20.setBounds(15, 69, 251, 34);
		monthly_budget.add(lblNewLabel_20);
		
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
		
		
		JLabel lblNewLabel_4_1 = new JLabel("update revenue:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_4_1.setBounds(15, 16, 264, 32);
		update_revenue.add(lblNewLabel_4_1);
		
		JButton btnNewButton_4_1 = new JButton("back");
		btnNewButton_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				update_revenue.setVisible(false);
				revenue.setVisible(true);
			}
		});
		btnNewButton_4_1.setBounds(344, 453, 115, 29);
		update_revenue.add(btnNewButton_4_1);
		
		
		JButton btnNewButton_4_2 = new JButton("back");
		btnNewButton_4_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				add_revenue.setVisible(false);
				revenue.setVisible(true);
			}
		});
		btnNewButton_4_2.setBounds(344, 453, 115, 29);
		add_revenue.add(btnNewButton_4_2);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("add revenue:");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_4_1_1.setBounds(15, 16, 264, 32);
		add_revenue.add(lblNewLabel_4_1_1);
		
		
		JLabel lblNewLabel_4_1_2 = new JLabel("display revenue:");
		lblNewLabel_4_1_2.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_4_1_2.setBounds(15, 16, 264, 32);
		display_revenue.add(lblNewLabel_4_1_2);
		
		JButton btnNewButton_4_2_1 = new JButton("back");
		btnNewButton_4_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				display_revenue.setVisible(false);
				revenue.setVisible(true);
			}
		});
		btnNewButton_4_2_1.setBounds(344, 453, 115, 29);
		display_revenue.add(btnNewButton_4_2_1);
		
		
		JButton btnNewButton_4_2_2 = new JButton("back");
		btnNewButton_4_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				delete_revenue.setVisible(false);
				revenue.setVisible(true);
			}
		});
		btnNewButton_4_2_2.setBounds(344, 453, 115, 29);
		delete_revenue.add(btnNewButton_4_2_2);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("delete revenue:");
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_4_1_1_1.setBounds(15, 16, 264, 32);
		delete_revenue.add(lblNewLabel_4_1_1_1);
		
		
		JLabel monthly_revenueBTN = new JLabel("monthly revenue:");
		monthly_revenueBTN.setFont(new Font("Tahoma", Font.BOLD, 26));
		monthly_revenueBTN.setBounds(15, 16, 264, 32);
		monthly_revenue.add(monthly_revenueBTN);
		
		JButton btnNewButton_4_2_1_1 = new JButton("back");
		btnNewButton_4_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				monthly_revenue.setVisible(false);
				revenue.setVisible(true);
			}
		});
		btnNewButton_4_2_1_1.setBounds(344, 453, 115, 29);
		monthly_revenue.add(btnNewButton_4_2_1_1);
		
		JButton btnNewButton_4_2_1_2 = new JButton("back");
		btnNewButton_4_2_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				revenue_by_name.setVisible(false);
				revenue.setVisible(true);
			}
		});
		btnNewButton_4_2_1_2.setBounds(344, 453, 115, 29);
		revenue_by_name.add(btnNewButton_4_2_1_2);
		
		JLabel monthly_revenueBTN_1 = new JLabel("revenue by name:");
		monthly_revenueBTN_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		monthly_revenueBTN_1.setBounds(15, 16, 264, 32);
		revenue_by_name.add(monthly_revenueBTN_1);
		
		
		JLabel monthly_revenueBTN_2 = new JLabel("update expense:");
		monthly_revenueBTN_2.setFont(new Font("Tahoma", Font.BOLD, 26));
		monthly_revenueBTN_2.setBounds(15, 16, 264, 32);
		update_expense.add(monthly_revenueBTN_2);
		
		JButton btnNewButton_4_2_1_2_1 = new JButton("back");
		btnNewButton_4_2_1_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				update_expense.setVisible(false);
				expense.setVisible(true);
			}
		});
		btnNewButton_4_2_1_2_1.setBounds(344, 453, 115, 29);
		update_expense.add(btnNewButton_4_2_1_2_1);
		
		
		JButton btnNewButton_4_2_1_2_2 = new JButton("back");
		btnNewButton_4_2_1_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				add_expense.setVisible(false);
				expense.setVisible(true);
			}
		});
		btnNewButton_4_2_1_2_2.setBounds(344, 453, 115, 29);
		add_expense.add(btnNewButton_4_2_1_2_2);
		
		JLabel monthly_revenueBTN_2_1 = new JLabel("add expense:");
		monthly_revenueBTN_2_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		monthly_revenueBTN_2_1.setBounds(15, 16, 264, 32);
		add_expense.add(monthly_revenueBTN_2_1);
		
		
		JLabel monthly_revenueBTN_2_2 = new JLabel("display expense:");
		monthly_revenueBTN_2_2.setFont(new Font("Tahoma", Font.BOLD, 26));
		monthly_revenueBTN_2_2.setBounds(15, 16, 264, 32);
		display_expense.add(monthly_revenueBTN_2_2);
		
		JButton btnNewButton_4_2_1_2_2_1 = new JButton("back");
		btnNewButton_4_2_1_2_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				display_expense.setVisible(false);
				revenue.setVisible(true);
			}
		});
		btnNewButton_4_2_1_2_2_1.setBounds(344, 453, 115, 29);
		display_expense.add(btnNewButton_4_2_1_2_2_1);
		
		
		JButton btnNewButton_4_2_1_2_2_2 = new JButton("back");
		btnNewButton_4_2_1_2_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				delete_expense.setVisible(false);
				expense.setVisible(true);
			}
		});
		btnNewButton_4_2_1_2_2_2.setBounds(344, 453, 115, 29);
		delete_expense.add(btnNewButton_4_2_1_2_2_2);
		
		JLabel monthly_revenueBTN_2_2_1 = new JLabel("delete expense:");
		monthly_revenueBTN_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		monthly_revenueBTN_2_2_1.setBounds(15, 16, 264, 32);
		delete_expense.add(monthly_revenueBTN_2_2_1);
		
		
		JLabel monthly_revenueBTN_2_2_2 = new JLabel("monthly expense:");
		monthly_revenueBTN_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 26));
		monthly_revenueBTN_2_2_2.setBounds(15, 16, 264, 32);
		monthly_expense.add(monthly_revenueBTN_2_2_2);
		
		JButton btnNewButton_4_2_1_2_2_2_1 = new JButton("back");
		btnNewButton_4_2_1_2_2_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				monthly_expense.setVisible(false);
				expense.setVisible(true);
			}
		});
		btnNewButton_4_2_1_2_2_2_1.setBounds(344, 453, 115, 29);
		monthly_expense.add(btnNewButton_4_2_1_2_2_2_1);
		
		JPanel future_expense = new JPanel();
		future_expense.setBackground(new Color(165, 42, 42));
		layeredPane.add(future_expense, "name_1062105994166900");
		future_expense.setLayout(null);
		
		JButton btnNewButton_4_2_1_2_2_2_2 = new JButton("back");
		btnNewButton_4_2_1_2_2_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				future_expense.setVisible(false);
				expense.setVisible(true);
			}
		});
		btnNewButton_4_2_1_2_2_2_2.setBounds(344, 453, 115, 29);
		future_expense.add(btnNewButton_4_2_1_2_2_2_2);
		
		JLabel monthly_revenueBTN_2_2_2_1 = new JLabel("future expense:");
		monthly_revenueBTN_2_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		monthly_revenueBTN_2_2_2_1.setBounds(15, 16, 264, 32);
		future_expense.add(monthly_revenueBTN_2_2_2_1);
		
		
		JLabel monthly_revenueBTN_2_2_2_2 = new JLabel("display new expense:");
		monthly_revenueBTN_2_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 26));
		monthly_revenueBTN_2_2_2_2.setBounds(15, 16, 290, 32);
		display_new_expense.add(monthly_revenueBTN_2_2_2_2);
		
		JButton btnNewButton_4_2_1_2_2_2_2_1 = new JButton("back");
		btnNewButton_4_2_1_2_2_2_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				display_new_expense.setVisible(false);
				expense.setVisible(true);
			}
		});
		btnNewButton_4_2_1_2_2_2_2_1.setBounds(344, 453, 115, 29);
		display_new_expense.add(btnNewButton_4_2_1_2_2_2_2_1);
		
		
		JButton btnNewButton_4_2_1_2_2_2_2_2 = new JButton("back");
		btnNewButton_4_2_1_2_2_2_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				expense_by_name.setVisible(false);
				expense.setVisible(true);
			}
		});
		btnNewButton_4_2_1_2_2_2_2_2.setBounds(344, 453, 115, 29);
		expense_by_name.add(btnNewButton_4_2_1_2_2_2_2_2);
		
		JLabel monthly_revenueBTN_2_2_2_2_1 = new JLabel("expense by name");
		monthly_revenueBTN_2_2_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		monthly_revenueBTN_2_2_2_2_1.setBounds(15, 16, 290, 32);
		expense_by_name.add(monthly_revenueBTN_2_2_2_2_1);
	}


}
