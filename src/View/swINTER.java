package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.CategoryController;
import Controller.UserController;
import Controller.UtilitiesController;
import Model.Category;
import Model.CategoryService;
import Model.Expense;
import Model.ExpenseService;
import Model.UserService;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import javax.swing.JEditorPane;
import javax.swing.JMenuBar;
import javax.swing.border.LineBorder;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Checkbox;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JTextArea;
import java.awt.TextArea;
import javax.swing.JTable;

public class swINTER extends JFrame {

	private JTextField loginEmail;
	private JPasswordField loginPassword;

	private JPanel loginPanel;
	private JPanel signupPanel;
	private JPanel homePanel;
	private JPanel monthlySettingsPanel;
	private JTextField inputRevenue;
	private JTextField inputWantedSaving;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel addCategoryPanel;

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
		setBackground(Color.ORANGE);
		setForeground(Color.LIGHT_GRAY);
		setTitle("Money Saver");
		// Creating the Services:
		UserService userService = UserService.getInstance();
		CategoryService categoryService = CategoryService.getInstance();
		ExpenseService expenseService = ExpenseService.getInstance();
		// ----------
		UserController userController = new UserController();
		CategoryController categoryController = new CategoryController();
		// --------------
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 559);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel layeredPane = new JPanel();
		layeredPane.setBounds(0, 0, 696, 520);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		loginPanel = new JPanel();
		loginPanel.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(loginPanel, "name_1044684755738000");
		loginPanel.setLayout(null);

		JLabel lblNewLabel_12_1 = new JLabel("Login");
		lblNewLabel_12_1.setBounds(10, 52, 676, 75);
		lblNewLabel_12_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		loginPanel.add(lblNewLabel_12_1);

		JLabel lblNewLabel_17 = new JLabel("Still not registered?");
		lblNewLabel_17.setForeground(Color.RED);
		lblNewLabel_17.setBounds(357, 17, 197, 31);
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 20));
		loginPanel.add(lblNewLabel_17);

		signupPanel = new JPanel();
		signupPanel.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(signupPanel, "name_1044689499709500");

		JButton btnSwitchToSignup = new JButton("Sign Up");
		btnSwitchToSignup.setForeground(Color.RED);
		btnSwitchToSignup.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSwitchToSignup.setBounds(553, 16, 133, 32);
		loginPanel.add(btnSwitchToSignup);
		// Swap pages - login to signup
		btnSwitchToSignup.addActionListener(mouseClicked -> {
			UtilitiesController.swapPages(loginPanel, signupPanel);
		});

		loginEmail = new JTextField();
		loginEmail.setBounds(10, 227, 671, 44);
		loginEmail.setColumns(10);
		loginPanel.add(loginEmail);

		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setBounds(15, 196, 671, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		loginPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(15, 282, 671, 20);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		loginPanel.add(lblNewLabel_1);

		loginPassword = new JPasswordField();
		loginPassword.setBounds(15, 313, 671, 44);
		loginPanel.add(loginPassword);

		homePanel = new JPanel();
		homePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		homePanel.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(homePanel, "name_1044691011849800");
		homePanel.setLayout(null);

		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(UIManager.getColor("ToolBar.dockingForeground"));
		btnLogin.setBounds(15, 387, 671, 62);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 26));
		loginPanel.add(btnLogin);
		// Login
		btnLogin.addActionListener(mouseClicked -> {
			userController.login(loginEmail.getText(), loginPassword.getText(), loginPanel, homePanel,
					monthlySettingsPanel);
		});

		signupPanel.setLayout(null);

		JLabel lblNewLabel_12 = new JLabel("Sign Up");
		lblNewLabel_12.setForeground(Color.BLACK);
		lblNewLabel_12.setBounds(10, 52, 676, 69);
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 40));
		signupPanel.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("Email:");
		lblNewLabel_13.setBounds(10, 192, 454, 20);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 20));
		signupPanel.add(lblNewLabel_13);

		JTextField signupEmail = new JTextField();
		signupEmail.setBounds(10, 223, 676, 44);
		signupEmail.setColumns(10);
		signupPanel.add(signupEmail);

		JLabel lblNewLabel_14 = new JLabel("Password:");
		lblNewLabel_14.setBounds(10, 289, 449, 20);
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 20));
		signupPanel.add(lblNewLabel_14);

		JPasswordField signupPassword = new JPasswordField();
		signupPassword.setBounds(10, 320, 676, 44);
		signupPanel.add(signupPassword);

		JButton btnSignup = new JButton("Sign Up");
		btnSignup.setForeground(UIManager.getColor("ToolBar.dockingForeground"));
		btnSignup.setBounds(10, 399, 676, 56);
		btnSignup.setFont(new Font("Tahoma", Font.PLAIN, 30));
		signupPanel.add(btnSignup);
		// Signup MouseClick:
		btnSignup.addActionListener(mouseClicked -> {
			userController.signup(signupEmail.getText(), signupPassword.getText(), signupPanel, homePanel,
					monthlySettingsPanel);
		});

		JButton btnSwitchToLogin = new JButton("Login");
		btnSwitchToLogin.setForeground(Color.RED);
		btnSwitchToLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSwitchToLogin.setBounds(558, 18, 128, 36);
		signupPanel.add(btnSwitchToLogin);
		// Swap from signup to login panel
		btnSwitchToLogin.addActionListener(mouseClicked -> {
			UtilitiesController.swapPages(signupPanel, loginPanel);
		});

		JLabel lblNewLabel_16 = new JLabel("Already Signed ?");
		lblNewLabel_16.setForeground(Color.RED);
		lblNewLabel_16.setBounds(399, 17, 163, 38);
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 20));
		signupPanel.add(lblNewLabel_16);

		JLabel homePanelTitle = new JLabel("Ongoing Operations");
		homePanelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		homePanelTitle.setFont(new Font("Tahoma", Font.BOLD, 40));
		homePanelTitle.setBounds(10, 40, 676, 75);
		homePanel.add(homePanelTitle);

		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogout.setForeground(Color.RED);
		btnLogout.setBounds(577, 11, 109, 39);
		homePanel.add(btnLogout);
		//Logout from homePanel!
		btnLogout.addActionListener(mouseClicked->{
			userController.logout(homePanel,loginPanel,loginEmail,loginPassword);
//			loginEmail.setText("");
//			loginPassword.setText("");
//			UtilitiesController.swapPages(homePanel, loginPanel);
		});


		JPanel categoryPanel = new JPanel();
		categoryPanel.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(categoryPanel, "name_1044692808216200");

		JButton btnShowCategories = new JButton("Show Categories");
		btnShowCategories.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				homePanel.setVisible(false);
				monthlySettingsPanel.setVisible(true);
			}
		});
		btnShowCategories.setForeground(Color.BLACK);
		btnShowCategories.setBackground(UIManager.getColor("Button.background"));
		btnShowCategories.setBounds(10, 391, 142, 29);
		homePanel.add(btnShowCategories);

		JPanel expense = new JPanel();
		expense.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(expense, "name_1044694229249400");
		expense.setLayout(null);

		JButton btnShowExpenses = new JButton("Show Expenses");
		btnShowExpenses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				homePanel.setVisible(false);
				expense.setVisible(true);
			}
		});
		btnShowExpenses.setBounds(10, 351, 142, 29);
		homePanel.add(btnShowExpenses);

		JPanel monthly_budget = new JPanel();
		monthly_budget.setBackground(new Color(165, 42, 42));
		layeredPane.add(monthly_budget, "name_1044711729512100");
		monthly_budget.setLayout(null);

		JButton btnNewButton_2 = new JButton("Monthly budget");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				homePanel.setVisible(false);
				monthly_budget.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(10, 300, 142, 29);
		homePanel.add(btnNewButton_2);

		JButton btnAddCategory = new JButton("Add Category");
		btnAddCategory.addActionListener(mouseClicked -> {
			userController.logout(addCategoryPanel,loginPanel);
		});
		btnAddCategory.setBounds(10, 431, 142, 29);
		homePanel.add(btnAddCategory);

		JLabel lblTEST = new JLabel("");
		lblTEST.setBounds(391, 192, 255, 66);
		homePanel.add(lblTEST);
		lblTEST.setText("Some Random Text !");

		JButton btnTEST = new JButton("Change text");
		btnTEST.setBounds(470, 252, 109, 39);
		homePanel.add(btnTEST);
		btnTEST.addActionListener(mouseClicked -> {
			String testing = lblTEST.getText();
			if (testing.equalsIgnoreCase("Shoshi is zona")) {
				lblTEST.setText("Some random text !");
			} else {
				lblTEST.setText("Shoshi is Zona");
			}
		});

		categoryPanel.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Categories:");
		lblNewLabel_4.setBounds(15, 16, 177, 32);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 26));
		categoryPanel.add(lblNewLabel_4);

		JPanel update_category = new JPanel();
		update_category.setBackground(new Color(165, 42, 42));
		layeredPane.add(update_category, "name_1061712366015000");
		update_category.setLayout(null);

		JButton btnNewButton_10 = new JButton("update category");
		btnNewButton_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				categoryPanel.setVisible(false);
				update_category.setVisible(true);
			}
		});
		btnNewButton_10.setBounds(15, 77, 192, 29);
		categoryPanel.add(btnNewButton_10);

		JPanel display_revenue = new JPanel();
		display_revenue.setBackground(new Color(165, 42, 42));
		layeredPane.add(display_revenue, "name_1062012735486200");
		display_revenue.setLayout(null);

		JButton btnNewButton_11 = new JButton("delete all");
		btnNewButton_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				categoryPanel.setVisible(false);
				display_revenue.setVisible(true);
			}
		});
		btnNewButton_11.setBounds(15, 122, 192, 29);
		categoryPanel.add(btnNewButton_11);

		JPanel monthly_revenue = new JPanel();
		monthly_revenue.setBackground(new Color(165, 42, 42));
		layeredPane.add(monthly_revenue, "name_1062091668281100");
		monthly_revenue.setLayout(null);

		JButton btnNewButton_12 = new JButton("monthly revenue");
		btnNewButton_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				categoryPanel.setVisible(false);
				monthly_revenue.setVisible(true);
			}
		});
		btnNewButton_12.setBounds(15, 167, 192, 29);
		categoryPanel.add(btnNewButton_12);

		JLabel lblNewLabel_19_1 = new JLabel("for display revenue by category name,");
		lblNewLabel_19_1.setBounds(15, 212, 287, 20);
		categoryPanel.add(lblNewLabel_19_1);

		JLabel lblNewLabel_18_1 = new JLabel("enter the category name and press 'display':");
		lblNewLabel_18_1.setBounds(15, 232, 325, 20);
		categoryPanel.add(lblNewLabel_18_1);

		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(15, 260, 177, 26);
		categoryPanel.add(formattedTextField_1);

		JPanel revenue_by_name = new JPanel();
		revenue_by_name.setBackground(new Color(165, 42, 42));
		layeredPane.add(revenue_by_name, "name_1062093560155000");
		revenue_by_name.setLayout(null);

		JButton btnNewButton_17_1 = new JButton("display");
		btnNewButton_17_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				categoryPanel.setVisible(false);
				revenue_by_name.setVisible(true);
			}
		});
		btnNewButton_17_1.setBounds(207, 263, 81, 20);
		categoryPanel.add(btnNewButton_17_1);

		JButton btnNewButton_4 = new JButton("back");
		btnNewButton_4.setBounds(344, 453, 115, 29);
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				categoryPanel.setVisible(false);
				homePanel.setVisible(true);
			}
		});
		categoryPanel.add(btnNewButton_4);

		JPanel delete_caterogy = new JPanel();
		delete_caterogy.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(delete_caterogy, "name_1062089755934099");
		delete_caterogy.setLayout(null);

		JButton btnNewButton_14 = new JButton("delete category");
		btnNewButton_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				categoryPanel.setVisible(false);
				delete_caterogy.setVisible(true);
			}
		});
		btnNewButton_14.setBounds(253, 122, 192, 29);
		categoryPanel.add(btnNewButton_14);

		addCategoryPanel = new JPanel();
		addCategoryPanel.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(addCategoryPanel, "name_1061941618251600");
		addCategoryPanel.setLayout(null);

		JLabel addCategoryPanelTitleLabel = new JLabel("Title:");
		addCategoryPanelTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addCategoryPanelTitleLabel.setBounds(10, 73, 676, 26);
		addCategoryPanel.add(addCategoryPanelTitleLabel);

		JTextPane addCategoryTitle = new JTextPane();
		addCategoryTitle.setBounds(10, 110, 676, 43);
		addCategoryPanel.add(addCategoryTitle);

		JTextPane addCategoryAmount = new JTextPane();
		addCategoryAmount.setBounds(10, 219, 676, 43);
		addCategoryPanel.add(addCategoryAmount);

		JButton btbAdd_Categoty = new JButton("add category");
		btbAdd_Categoty.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				categoryPanel.setVisible(false);
				addCategoryPanel.setVisible(true);
			}
		});
		btbAdd_Categoty.setBounds(253, 77, 192, 29);
		categoryPanel.add(btbAdd_Categoty);

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
		btnNewButton_11_1.setBounds(268, 204, 177, 29);
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
				homePanel.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(344, 453, 115, 29);
		expense.add(btnNewButton_5);

		JPanel expense_delete_all = new JPanel();
		expense_delete_all.setBackground(new Color(165, 42, 42));
		expense_delete_all.setForeground(new Color(0, 0, 0));
		layeredPane.add(expense_delete_all, "name_1473791526164100");
		expense_delete_all.setLayout(null);

		JButton btnNewButton_18 = new JButton("delete all");
		btnNewButton_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				expense.setVisible(false);
				expense_delete_all.setVisible(true);
			}
		});
		btnNewButton_18.setBounds(15, 114, 177, 29);
		expense.add(btnNewButton_18);

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
				homePanel.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(330, 439, 115, 29);
		monthly_budget.add(btnNewButton_6);

		JLabel lblNewLabel_4_1 = new JLabel("update revenue:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_4_1.setBounds(15, 16, 264, 32);
		update_category.add(lblNewLabel_4_1);

		JButton btnNewButton_4_1 = new JButton("back");
		btnNewButton_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				update_category.setVisible(false);
				categoryPanel.setVisible(true);
			}
		});
		btnNewButton_4_1.setBounds(344, 453, 115, 29);
		update_category.add(btnNewButton_4_1);

		JLabel lblNewLabel_10 = new JLabel("choose category");
		lblNewLabel_10.setBounds(15, 64, 127, 20);
		update_category.add(lblNewLabel_10);

		JTextPane textUpdateCat = new JTextPane();
		textUpdateCat.setBounds(15, 89, 144, 26);
		update_category.add(textUpdateCat);

		JLabel lblNewLabel_10_1 = new JLabel("category name");
		lblNewLabel_10_1.setBounds(15, 198, 127, 20);
		update_category.add(lblNewLabel_10_1);

		JTextPane textUpCatName = new JTextPane();
		textUpCatName.setBounds(15, 223, 144, 26);
		update_category.add(textUpCatName);

		JLabel lblNewLabel_10_2 = new JLabel("category amount");
		lblNewLabel_10_2.setBounds(15, 265, 127, 20);
		update_category.add(lblNewLabel_10_2);

		JTextPane textUpCatAmount = new JTextPane();
		textUpCatAmount.setBounds(15, 290, 144, 26);
		update_category.add(textUpCatAmount);

		JLabel lblNewLabel_10_3 = new JLabel("amount used");
		lblNewLabel_10_3.setBounds(15, 332, 127, 20);
		update_category.add(lblNewLabel_10_3);

		JTextPane textUpCatAmountUsed = new JTextPane();
		textUpCatAmountUsed.setBounds(15, 357, 144, 26);
		update_category.add(textUpCatAmountUsed);

		JLabel lblNewLabel_11 = new JLabel("new details");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_11.setBounds(15, 170, 264, 20);
		update_category.add(lblNewLabel_11);

		JButton btnNewButton_15 = new JButton("update");
		btnNewButton_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Category updateCat = categoryService.findCategory(textUpdateCat.getText());
				if (!textUpCatName.getText().equalsIgnoreCase("")) {
					updateCat.setTitle(textUpCatName.getText());
				}
				if (!textUpCatAmount.getText().equalsIgnoreCase("")) {
					updateCat.setAmount(Integer.parseInt(textUpCatAmount.getText()));
				}
				if (!textUpCatAmountUsed.getText().equalsIgnoreCase("")) {
					updateCat.amountUsed = Integer.parseInt(textUpCatAmountUsed.getText());
				}
				categoryService.updateCategory(updateCat, userService.getToken());
				categoryService.printCategories();
			}
		});
		btnNewButton_15.setBounds(214, 453, 115, 29);
		update_category.add(btnNewButton_15);

		JButton btnBackAddCategoryPanel = new JButton("Back");
		btnBackAddCategoryPanel.setForeground(Color.RED);
		btnBackAddCategoryPanel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBackAddCategoryPanel.setBounds(554, 471, 132, 38);
		addCategoryPanel.add(btnBackAddCategoryPanel);
		// TODO Back button listener
		btnBackAddCategoryPanel.addActionListener(mouseClicked -> {
			UtilitiesController.swapPages(addCategoryPanel, monthlySettingsPanel);
		});

		JLabel addCategoryLabel = new JLabel("Add Category:");
		addCategoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addCategoryLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		addCategoryLabel.setBounds(10, 16, 676, 49);
		addCategoryPanel.add(addCategoryLabel);

		JLabel addCategoyPanelAmountLabel = new JLabel("Amount:");
		addCategoyPanelAmountLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addCategoyPanelAmountLabel.setBounds(10, 182, 676, 26);
		addCategoryPanel.add(addCategoyPanelAmountLabel);

		JButton btnAddCategoryPanel = new JButton("ADD");
		btnAddCategoryPanel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnAddCategoryPanel.setForeground(UIManager.getColor("ToolBar.dockingForeground"));
		btnAddCategoryPanel.setBounds(10, 319, 676, 56);
		addCategoryPanel.add(btnAddCategoryPanel);
		btnAddCategoryPanel.addActionListener(mouseClicked -> {
			// Setting Listener to addCategoryBtn
			categoryController.addCategory(addCategoryTitle.getText(), addCategoryAmount.getText(), addCategoryPanel,
					monthlySettingsPanel);
		});

		JLabel lblNewLabel_4_1_2 = new JLabel("display revenue:");
		lblNewLabel_4_1_2.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_4_1_2.setBounds(15, 16, 264, 32);
		display_revenue.add(lblNewLabel_4_1_2);

		JButton btnNewButton_4_2_1 = new JButton("back");
		btnNewButton_4_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				display_revenue.setVisible(false);
				categoryPanel.setVisible(true);
			}
		});
		btnNewButton_4_2_1.setBounds(344, 453, 115, 29);
		display_revenue.add(btnNewButton_4_2_1);

		JButton btnNewButton_4_2_2 = new JButton("Back");
		btnNewButton_4_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_4_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				delete_caterogy.setVisible(false);
				categoryPanel.setVisible(true);
			}
		});
		btnNewButton_4_2_2.setBounds(344, 453, 115, 29);
		delete_caterogy.add(btnNewButton_4_2_2);

		JLabel lblNewLabel_4_1_1_1 = new JLabel("Delete Category");
		lblNewLabel_4_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_4_1_1_1.setBounds(25, 16, 422, 32);
		delete_caterogy.add(lblNewLabel_4_1_1_1);

		JLabel lblNewLabel_9 = new JLabel("Category Title:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(25, 77, 422, 20);
		delete_caterogy.add(lblNewLabel_9);

		JTextPane inputDeleteCategory = new JTextPane();
		inputDeleteCategory.setBounds(23, 109, 424, 47);
		delete_caterogy.add(inputDeleteCategory);

		JButton btnDeleteCategory = new JButton("DELETE");
		btnDeleteCategory.setForeground(Color.BLACK);
		btnDeleteCategory.setBackground(Color.ORANGE);
		btnDeleteCategory.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnDeleteCategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Category deletedCat = categoryService.findCategory(inputDeleteCategory.getText());
				if (deletedCat != null) {
					categoryService.deleteCategory(deletedCat.getId(), userService.getToken());
					categoryService.printCategories();
				} else {
					// TODO
					// ERROR IF deletedCat doesn't exists!
				}
			}
		});
		btnDeleteCategory.setBounds(25, 205, 422, 47);
		delete_caterogy.add(btnDeleteCategory);

		TextField textField = new TextField();
		textField.setBounds(28, 288, 408, 159);
		delete_caterogy.add(textField);
		textField.setText(categoryService.toString());

		JLabel monthly_revenueBTN = new JLabel("monthly revenue:");
		monthly_revenueBTN.setFont(new Font("Tahoma", Font.BOLD, 26));
		monthly_revenueBTN.setBounds(15, 16, 264, 32);
		monthly_revenue.add(monthly_revenueBTN);

		JButton btnNewButton_4_2_1_1 = new JButton("back");
		btnNewButton_4_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				monthly_revenue.setVisible(false);
				categoryPanel.setVisible(true);
			}
		});
		btnNewButton_4_2_1_1.setBounds(344, 453, 115, 29);
		monthly_revenue.add(btnNewButton_4_2_1_1);

		JButton btnNewButton_4_2_1_2 = new JButton("back");
		btnNewButton_4_2_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				revenue_by_name.setVisible(false);
				categoryPanel.setVisible(true);
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

		JLabel lblNewLabel_10_4 = new JLabel("choose expense");
		lblNewLabel_10_4.setBounds(15, 131, 127, 20);
		update_expense.add(lblNewLabel_10_4);

		JTextPane textUpExChooseExpense = new JTextPane();
		textUpExChooseExpense.setBounds(15, 156, 144, 26);
		update_expense.add(textUpExChooseExpense);

		JLabel lblNewLabel_11_1 = new JLabel("new details");
		lblNewLabel_11_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_11_1.setBounds(15, 219, 264, 20);
		update_expense.add(lblNewLabel_11_1);

		JLabel lblNewLabel_10_1_1 = new JLabel("expense name");
		lblNewLabel_10_1_1.setBounds(15, 247, 127, 20);
		update_expense.add(lblNewLabel_10_1_1);

		JTextPane textUpExpenseName = new JTextPane();
		textUpExpenseName.setBounds(15, 272, 144, 26);
		update_expense.add(textUpExpenseName);

		JLabel lblNewLabel_10_2_1 = new JLabel("expense amount");
		lblNewLabel_10_2_1.setBounds(15, 314, 127, 20);
		update_expense.add(lblNewLabel_10_2_1);

		JTextPane textUpExpenseAmount = new JTextPane();
		textUpExpenseAmount.setBounds(15, 339, 144, 26);
		update_expense.add(textUpExpenseAmount);

		JTextPane textUpExChooseCat = new JTextPane();
		textUpExChooseCat.setBounds(15, 89, 144, 26);
		update_expense.add(textUpExChooseCat);

		JButton btnNewButton_19 = new JButton("update");
		btnNewButton_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Expense updateExpense = expenseService.findExpense(textUpExChooseExpense.getText(), 0,
						textUpExChooseCat.getText()); // amount 0, cat_id
				if (!textUpExpenseName.getText().equalsIgnoreCase("")) {
					updateExpense.setTitle(textUpExpenseName.getText());
				}
				if (!textUpExpenseAmount.getText().equalsIgnoreCase("")) {
					updateExpense.setAmount(Integer.parseInt(textUpExpenseAmount.getText()));
				}
				expenseService.printExpensesByCategory();
			}
		});
		btnNewButton_19.setBounds(214, 453, 115, 29);
		update_expense.add(btnNewButton_19);

		JLabel lblNewLabel_10_4_1 = new JLabel("choose category");
		lblNewLabel_10_4_1.setBounds(15, 64, 127, 20);
		update_expense.add(lblNewLabel_10_4_1);

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

		JLabel lblNewLabel_7_1 = new JLabel("title");
		lblNewLabel_7_1.setBounds(15, 64, 69, 20);
		add_expense.add(lblNewLabel_7_1);

		JTextPane textAddExpenseTitle = new JTextPane();
		textAddExpenseTitle.setBounds(15, 87, 187, 26);
		add_expense.add(textAddExpenseTitle);

		JLabel lblNewLabel_8_1 = new JLabel("amount");
		lblNewLabel_8_1.setBounds(15, 137, 69, 20);
		add_expense.add(lblNewLabel_8_1);

		JTextPane textAddExpenseAmount = new JTextPane();
		textAddExpenseAmount.setBounds(15, 161, 187, 26);
		add_expense.add(textAddExpenseAmount);

		JTextPane textAddExpenseCatName = new JTextPane();
		textAddExpenseCatName.setBounds(15, 234, 187, 26);
		add_expense.add(textAddExpenseCatName);

		JButton btnAdd_1 = new JButton("add");
		btnAdd_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				expenseService.addExpenseToCategory(textAddExpenseTitle.getText(),
						Integer.parseInt(textAddExpenseAmount.getText()), textAddExpenseCatName.getText());
				expenseService.printExpensesByCategory();
			}
		});
		btnAdd_1.setBounds(210, 453, 115, 29);
		add_expense.add(btnAdd_1);

		JLabel lblNewLabel_8_1_1 = new JLabel("category name");
		lblNewLabel_8_1_1.setBounds(15, 210, 127, 20);
		add_expense.add(lblNewLabel_8_1_1);

		JLabel monthly_revenueBTN_2_2 = new JLabel("display expense:");
		monthly_revenueBTN_2_2.setFont(new Font("Tahoma", Font.BOLD, 26));
		monthly_revenueBTN_2_2.setBounds(15, 16, 264, 32);
		display_expense.add(monthly_revenueBTN_2_2);

		JButton btnNewButton_4_2_1_2_2_1 = new JButton("back");
		btnNewButton_4_2_1_2_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				display_expense.setVisible(false);
				categoryPanel.setVisible(true);
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

		JLabel lblNewLabel_21 = new JLabel("category name");
		lblNewLabel_21.setBounds(15, 64, 109, 20);
		delete_expense.add(lblNewLabel_21);

		JTextPane textDeleteCatName = new JTextPane();
		textDeleteCatName.setBounds(15, 87, 149, 26);
		delete_expense.add(textDeleteCatName);

		JLabel lblNewLabel_21_1 = new JLabel("expense name");
		lblNewLabel_21_1.setBounds(15, 129, 109, 20);
		delete_expense.add(lblNewLabel_21_1);

		JTextPane textDeleteExName = new JTextPane();
		textDeleteExName.setBounds(15, 152, 149, 26);
		delete_expense.add(textDeleteExName);

		JButton btnNewButton_20 = new JButton("delete");
		btnNewButton_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Expense deleteEx = expenseService.findExpense(textDeleteExName.getText(), 0,
						textDeleteCatName.getText()); // amount 0, cat_id
				if (deleteEx != null) {
					expenseService.deleteExpense(deleteEx.getTitle(), 0, textDeleteCatName.getText());
					expenseService.printExpensesByCategory();
				} else {
					// TODO
					// ERROR IF deleteEX DOESN'T EXISTS!
				}
			}
		});
		btnNewButton_20.setBounds(214, 453, 115, 29);
		delete_expense.add(btnNewButton_20);

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

		monthlySettingsPanel = new JPanel();
		monthlySettingsPanel.setForeground(Color.LIGHT_GRAY);
		monthlySettingsPanel.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(monthlySettingsPanel, "name_1062105994166900");

		JLabel monthlySettingsTitle = new JLabel("Monthly Configurations");
		monthlySettingsTitle.setBounds(10, 11, 676, 86);
		monthlySettingsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		monthlySettingsTitle.setFont(new Font("Tahoma", Font.BOLD, 40));

		JLabel revenueLabel = new JLabel("Insert Monthly Revenue:");
		revenueLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		revenueLabel.setBounds(10, 108, 308, 26);

		JLabel createCategoriesLabel = new JLabel("Create Categories:");
		createCategoriesLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		createCategoriesLabel.setBounds(10, 292, 308, 37);

		JLabel saveOptionLabel = new JLabel("Insert Monthly Saving Preference:");
		saveOptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		saveOptionLabel.setBounds(10, 199, 308, 43);

		inputRevenue = new JTextField();
		inputRevenue.setBounds(10, 145, 308, 43);
		inputRevenue.setColumns(10);

		inputWantedSaving = new JTextField();
		inputWantedSaving.setBounds(10, 240, 308, 45);
		inputWantedSaving.setColumns(10);

		JRadioButton rdbtnPrecents = new JRadioButton("%");
		rdbtnPrecents.setBackground(Color.LIGHT_GRAY);
		buttonGroup.add(rdbtnPrecents);
		rdbtnPrecents.setBounds(324, 262, 49, 23);

		JRadioButton rdbtnMoney = new JRadioButton("ILS");
		rdbtnMoney.setSelected(true);
		rdbtnMoney.setBackground(Color.LIGHT_GRAY);
		buttonGroup.add(rdbtnMoney);
		rdbtnMoney.setBounds(324, 239, 48, 23);

		monthlySettingsPanel.setLayout(null);
		monthlySettingsPanel.add(monthlySettingsTitle);
		monthlySettingsPanel.add(revenueLabel);
		monthlySettingsPanel.add(createCategoriesLabel);
		monthlySettingsPanel.add(saveOptionLabel);
		monthlySettingsPanel.add(inputRevenue);
		monthlySettingsPanel.add(inputWantedSaving);
		monthlySettingsPanel.add(rdbtnPrecents);
		monthlySettingsPanel.add(rdbtnMoney);

		JLabel previewLabel = new JLabel("Preview:");
		previewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		previewLabel.setBounds(378, 140, 82, 29);
		monthlySettingsPanel.add(previewLabel);

		JButton btnSwitchToAddCategory = new JButton("Add Category");
		btnSwitchToAddCategory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSwitchToAddCategory.setBounds(10, 340, 308, 37);
		monthlySettingsPanel.add(btnSwitchToAddCategory);

		JButton btnSubmitConfigurations = new JButton("Submit Configurations");
		btnSubmitConfigurations.setForeground(Color.PINK);
		btnSubmitConfigurations.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnSubmitConfigurations.setBounds(17, 419, 301, 65);
		monthlySettingsPanel.add(btnSubmitConfigurations);
		btnSubmitConfigurations.addActionListener(mouseClicked -> {
			userController.submitConfiguration(inputRevenue.getText(), inputWantedSaving.getText(), rdbtnPrecents,
					monthlySettingsPanel, homePanel);
		});

		TextArea previewArea = new TextArea();
		previewArea.setBounds(378, 175, 308, 335);
		monthlySettingsPanel.add(previewArea);
		previewArea.setText("this is my preview");

		JButton btnLoadPreview = new JButton("Load Preview");
		btnLoadPreview.setForeground(UIManager.getColor("ToolBar.dockingForeground"));
		btnLoadPreview.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLoadPreview.setBounds(459, 145, 144, 23);
		monthlySettingsPanel.add(btnLoadPreview);
		btnLoadPreview.addActionListener(mouseClicked -> {
			// TODO
			// LOAD PREVIEW !
		});

		btnSwitchToAddCategory.addActionListener(mouseClicked -> {
			UtilitiesController.swapPages(monthlySettingsPanel, addCategoryPanel);
		});

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

		JLabel monthly_revenueBTN_2_2_1_1 = new JLabel("delete all expense:");
		monthly_revenueBTN_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		monthly_revenueBTN_2_2_1_1.setBounds(15, 16, 264, 32);
		expense_delete_all.add(monthly_revenueBTN_2_2_1_1);

		JLabel lblNewLabel_21_2 = new JLabel("category name");
		lblNewLabel_21_2.setBounds(15, 64, 109, 20);
		expense_delete_all.add(lblNewLabel_21_2);

		JTextPane textExDeleteAllCatName = new JTextPane();
		textExDeleteAllCatName.setBounds(15, 87, 149, 26);
		expense_delete_all.add(textExDeleteAllCatName);

		JButton btnNewButton_21 = new JButton("back");
		btnNewButton_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				expense_delete_all.setVisible(false);
				expense.setVisible(true);
			}
		});
		btnNewButton_21.setBounds(344, 453, 115, 29);
		expense_delete_all.add(btnNewButton_21);

		JButton btnNewButton_22 = new JButton("delete");
		btnNewButton_22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Category deleteAllEx = categoryService.findCategory(textExDeleteAllCatName.getText());
				if (deleteAllEx != null) {
					expenseService.deleteAllExpensesInCategory(deleteAllEx.getTitle());
					expenseService.printExpensesByCategory();
				} else {
					// TODO
					// ERROR IF deleteAllEx DOESN'T EXISTS
				}
			}
		});
		btnNewButton_22.setBounds(214, 453, 115, 29);
		expense_delete_all.add(btnNewButton_22);

	}
}
