package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.CategoryController;
import Controller.ExpenseController;
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
import java.util.Observable;
import java.util.Observer;
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
import javax.swing.DropMode;
import java.awt.List;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JList;

public class swINTER extends JFrame {
    //Controllers:
	private UserController userController = new UserController();
	private CategoryController categoryController = new CategoryController();
	private ExpenseController expenseController=new ExpenseController();
	
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
	
	
	//Labels:
	private JLabel userMonthlyRevenue=new JLabel("userMonthlyRevenue");//Going to Display the updated userMonthlyRevenue
	private JLabel userWantedSaveAmount=new JLabel("userWantedSaveAmount");//Going to Display the updated userWantedSaveAmount
	private JLabel userTotalSaved=new JLabel("userTotalSaved");//Going to Display the total saved so far amount
	private JLabel userTotalSpendMonthly=new JLabel("userTotalSpendMonthly");//Going to display total monthly spend so far !
	private TextArea previewArea=new TextArea("previewArea");//Going to Display the preview of the categories
	private TextArea categoriesDisplay=new TextArea("Display Categories");//Display categories on homePanel
	private JPanel expensePanel;
	private JTextField categoryNameField;
	private JTextField expenseNameField;
	private JTextField expenseAmountField;
	private TextArea expensesPreview=new TextArea("Display Expenses");
	private JLabel userLeftToSpend=new JLabel("userLeftToSpend");//Display how much left to spend!

	

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
		setTitle("Money Saver");
		//Creating my Observers:
		ConfigObserver configObserver=new ConfigObserver(this.userMonthlyRevenue,this.userWantedSaveAmount,this.userTotalSaved,this.userTotalSpendMonthly,this.userLeftToSpend);
		CategoryObserver categoryObserverSettingPanel=new CategoryObserver(this.previewArea);
		CategoryObserver categoryObserverHomePanel=new CategoryObserver(this.categoriesDisplay);
		ExpenseObserver expenseObserver=new ExpenseObserver(this.expensesPreview);
		//-----------
		//Adding Observer to Observable:
		userController.addObserver(configObserver);
		userController.addObserver(categoryObserverSettingPanel);
		userController.addObserver(categoryObserverHomePanel);
		categoryController.addObserver(categoryObserverSettingPanel);
		categoryController.addObserver(categoryObserverHomePanel);
	    expenseController.addObserver(expenseObserver);
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
		loginPanel.setBackground(Color.DARK_GRAY);
		layeredPane.add(loginPanel, "name_1044684755738000");
		loginPanel.setLayout(null);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(10, 52, 676, 75);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 40));
		loginPanel.add(lblLogin);

		JLabel lblSwithToSign = new JLabel("Still not registered?");
		lblSwithToSign.setForeground(Color.RED);
		lblSwithToSign.setBounds(357, 17, 197, 31);
		lblSwithToSign.setFont(new Font("Tahoma", Font.PLAIN, 20));
		loginPanel.add(lblSwithToSign);

		signupPanel = new JPanel();
		signupPanel.setBackground(Color.DARK_GRAY);
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

		JLabel lblEmailLogin = new JLabel("Email:");
		lblEmailLogin.setForeground(Color.WHITE);
		lblEmailLogin.setBounds(15, 196, 671, 20);
		lblEmailLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		loginPanel.add(lblEmailLogin);

		JLabel lblPasswordLogin = new JLabel("Password:");
		lblPasswordLogin.setForeground(Color.WHITE);
		lblPasswordLogin.setBounds(15, 282, 671, 20);
		lblPasswordLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		loginPanel.add(lblPasswordLogin);

		loginPassword = new JPasswordField();
		loginPassword.setBounds(15, 313, 671, 44);
		loginPanel.add(loginPassword);

		homePanel = new JPanel();
		homePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		homePanel.setBackground(Color.DARK_GRAY);
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
		lblNewLabel_12.setForeground(Color.WHITE);
		lblNewLabel_12.setBounds(10, 52, 676, 69);
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 40));
		signupPanel.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("Email:");
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setBounds(10, 192, 454, 20);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 20));
		signupPanel.add(lblNewLabel_13);

		JTextField signupEmail = new JTextField();
		signupEmail.setBounds(10, 223, 676, 44);
		signupEmail.setColumns(10);
		signupPanel.add(signupEmail);

		JLabel lblNewLabel_14 = new JLabel("Password:");
		lblNewLabel_14.setForeground(Color.WHITE);
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
		homePanelTitle.setForeground(Color.WHITE);
		homePanelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		homePanelTitle.setFont(new Font("Tahoma", Font.BOLD, 40));
		homePanelTitle.setBounds(-126, 0, 676, 75);
		homePanel.add(homePanelTitle);

		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogout.setForeground(Color.RED);
		btnLogout.setBounds(577, 11, 109, 39);
		homePanel.add(btnLogout);
		//Logout from homePanel!
		btnLogout.addActionListener(mouseClicked->{
			userController.logout(homePanel,loginPanel,loginEmail,loginPassword);
		});

		JButton btnEditMonthlyConfig = new JButton("Edit Monthly Settings");
		btnEditMonthlyConfig.setFont(new Font("Tahoma", Font.PLAIN, 20));
        //Page swap	
		btnEditMonthlyConfig.addActionListener(mouseClicked->{
			UtilitiesController.swapPages(homePanel, monthlySettingsPanel);
		});
		btnEditMonthlyConfig.setForeground(Color.BLUE);
		btnEditMonthlyConfig.setBackground(UIManager.getColor("Button.background"));
		btnEditMonthlyConfig.setBounds(10, 396, 267, 46);
		homePanel.add(btnEditMonthlyConfig);
		userMonthlyRevenue.setForeground(Color.WHITE);

	
		userMonthlyRevenue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		userMonthlyRevenue.setBounds(10, 83, 255, 39);
		homePanel.add(userMonthlyRevenue);
		userWantedSaveAmount.setForeground(Color.WHITE);
		
	
		userWantedSaveAmount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		userWantedSaveAmount.setBounds(10, 117, 255, 39);
		homePanel.add(userWantedSaveAmount);
		userTotalSaved.setForeground(Color.WHITE);
		
		
		userTotalSaved.setFont(new Font("Tahoma", Font.PLAIN, 20));
		userTotalSaved.setBounds(10, 326, 255, 39);
		homePanel.add(userTotalSaved);
		
		JButton btnFinishMonth = new JButton("End Current Month");
		
		btnFinishMonth.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFinishMonth.setBounds(419, 462, 267, 47);
		homePanel.add(btnFinishMonth);
		btnFinishMonth.addActionListener(mouseClicked->{
			boolean result=UtilitiesController.writeReport();
			if(result==true) {
				categoryController.deleteAll(homePanel,monthlySettingsPanel);
			}
		     
		});
		
		JTextArea txtrResetsMonthlySettings = new JTextArea();
		txtrResetsMonthlySettings.setForeground(Color.WHITE);
		txtrResetsMonthlySettings.setBackground(Color.DARK_GRAY);
		txtrResetsMonthlySettings.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrResetsMonthlySettings.setText("Resets Monthly Settings And\r\nconducts a monthly report !");
		txtrResetsMonthlySettings.setBounds(419, 410, 267, 46);
		homePanel.add(txtrResetsMonthlySettings);
		
		JButton btnSwitchToExpenses = new JButton("Manage My Expenses");
		btnSwitchToExpenses.setBackground(UIManager.getColor("Button.background"));
		btnSwitchToExpenses.setForeground(Color.BLACK);
		btnSwitchToExpenses.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSwitchToExpenses.setBounds(10, 462, 267, 47);
		homePanel.add(btnSwitchToExpenses);
		btnSwitchToExpenses.addActionListener(mouseClicked->{
			expenseController.init();
			UtilitiesController.swapPages(homePanel, expensePanel);
		});
		
		categoriesDisplay.setForeground(Color.WHITE);
		categoriesDisplay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
		
		
		categoriesDisplay.setBackground(Color.DARK_GRAY);
		categoriesDisplay.setBounds(340, 128, 346, 276);
		homePanel.add(categoriesDisplay);
		
		JLabel lblDisplayCategories = new JLabel("My Categories:");
		lblDisplayCategories.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDisplayCategories.setForeground(Color.WHITE);
		lblDisplayCategories.setBounds(340, 83, 346, 39);
		homePanel.add(lblDisplayCategories);
		
		
		userTotalSpendMonthly.setForeground(Color.WHITE);
		userTotalSpendMonthly.setFont(new Font("Tahoma", Font.PLAIN, 20));
		userTotalSpendMonthly.setBounds(10, 152, 324, 39);
		homePanel.add(userTotalSpendMonthly);
		
	//	userLeftToSpend = new JLabel("New label");
		userLeftToSpend.setFont(new Font("Tahoma", Font.PLAIN, 20));
		userLeftToSpend.setForeground(Color.WHITE);
		userLeftToSpend.setBounds(10, 202, 255, 39);
		homePanel.add(userLeftToSpend);

		expensePanel = new JPanel();
		expensePanel.setBackground(Color.DARK_GRAY);
		layeredPane.add(expensePanel, "name_1061712366015000");
		expensePanel.setLayout(null);
		
		JButton btnBackFromExpensePanel = new JButton("Back");
		btnBackFromExpensePanel.setForeground(Color.RED);
		btnBackFromExpensePanel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBackFromExpensePanel.setBounds(10, 11, 89, 23);
		expensePanel.add(btnBackFromExpensePanel);
		btnBackFromExpensePanel.addActionListener(mouseClicked->{
			userController.triggerObservers();
			categoryController.triggerObservers();
			UtilitiesController.swapPages(expensePanel, homePanel);
		});
		
		categoryNameField = new JTextField();
		categoryNameField.setBounds(10, 153, 263, 37);
		expensePanel.add(categoryNameField);
		categoryNameField.setColumns(10);
		
		expenseNameField = new JTextField();
		expenseNameField.setBounds(10, 237, 263, 37);
		expensePanel.add(expenseNameField);
		expenseNameField.setColumns(10);
		
		expenseAmountField = new JTextField();
		expenseAmountField.setBounds(10, 320, 263, 37);
		expensePanel.add(expenseAmountField);
		expenseAmountField.setColumns(10);
		expensesPreview.setForeground(Color.WHITE);
		expensesPreview.setFont(new Font("Tahoma", Font.PLAIN, 18));
		expensesPreview.setBackground(Color.DARK_GRAY);
		
	
		expensesPreview.setBounds(306, 116, 380, 394);
		expensePanel.add(expensesPreview);
		
		JLabel lblMyExpenses = new JLabel("My Expenses");
		lblMyExpenses.setForeground(Color.WHITE);
		lblMyExpenses.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblMyExpenses.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyExpenses.setBounds(10, 11, 676, 86);
		expensePanel.add(lblMyExpenses);
		
		JLabel lblCategoryName = new JLabel("Category Name:");
		lblCategoryName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCategoryName.setForeground(Color.WHITE);
		lblCategoryName.setBounds(10, 116, 215, 37);
		expensePanel.add(lblCategoryName);
		
		JLabel lblExpenseName = new JLabel("Expense Name:");
		lblExpenseName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblExpenseName.setForeground(Color.WHITE);
		lblExpenseName.setBounds(10, 201, 215, 37);
		expensePanel.add(lblExpenseName);
		
		JLabel lblExpenseAmount = new JLabel("Amount Spent:");
		lblExpenseAmount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblExpenseAmount.setForeground(Color.WHITE);
		lblExpenseAmount.setBounds(10, 285, 215, 37);
		expensePanel.add(lblExpenseAmount);
		
		JButton btnAddExpense = new JButton("Add Expense");
		btnAddExpense.setForeground(Color.BLACK);
		btnAddExpense.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddExpense.setBounds(10, 403, 263, 37);
		expensePanel.add(btnAddExpense);
		btnAddExpense.addActionListener(mouseClicked->{
			expenseController.addExpense(categoryNameField.getText(), expenseNameField.getText(), expenseAmountField.getText());
		});
		
		JButton btnRemoveExpense = new JButton("Delete Expense");
		btnRemoveExpense.setForeground(Color.RED);
		btnRemoveExpense.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRemoveExpense.setBounds(10, 451, 263, 37);
		expensePanel.add(btnRemoveExpense);
		btnRemoveExpense.addActionListener(mouseClicked->{
			expenseController.deleteExpense(categoryNameField.getText(), expenseNameField.getText(), expenseAmountField.getText());
		});
		
		
		
		
		
		

		JPanel emptyPanel2 = new JPanel();
		emptyPanel2.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(emptyPanel2, "name_1062012735486200");
		emptyPanel2.setLayout(null);

		JPanel emptyPanel3 = new JPanel();
		emptyPanel3.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(emptyPanel3, "name_1062091668281100");
		emptyPanel3.setLayout(null);

		addCategoryPanel = new JPanel();
		addCategoryPanel.setBackground(Color.DARK_GRAY);
		layeredPane.add(addCategoryPanel, "name_1061941618251600");
		addCategoryPanel.setLayout(null);

		JLabel addCategoryPanelTitleLabel = new JLabel("Title:");
		addCategoryPanelTitleLabel.setForeground(Color.WHITE);
		addCategoryPanelTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addCategoryPanelTitleLabel.setBounds(10, 73, 676, 26);
		addCategoryPanel.add(addCategoryPanelTitleLabel);

		JTextPane addCategoryTitle = new JTextPane();
		addCategoryTitle.setBounds(10, 110, 676, 43);
		addCategoryPanel.add(addCategoryTitle);

		JTextPane addCategoryAmount = new JTextPane();
		addCategoryAmount.setBounds(10, 201, 676, 43);
		addCategoryPanel.add(addCategoryAmount);

		JPanel emptyPanel4 = new JPanel();
		emptyPanel4.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(emptyPanel4, "name_1062095649858400");
		emptyPanel4.setLayout(null);

		

		JButton btnBackAddCategoryPanel = new JButton("Back");
		btnBackAddCategoryPanel.setForeground(Color.RED);
		btnBackAddCategoryPanel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBackAddCategoryPanel.setBounds(554, 471, 132, 38);
		addCategoryPanel.add(btnBackAddCategoryPanel);
		// TODO Back button listener
		btnBackAddCategoryPanel.addActionListener(mouseClicked -> {
			UtilitiesController.swapPages(addCategoryPanel, monthlySettingsPanel);
		});

		JLabel editCategoryLabel = new JLabel("Edit Category:");
		editCategoryLabel.setForeground(Color.WHITE);
		editCategoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		editCategoryLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		editCategoryLabel.setBounds(10, 16, 676, 49);
		addCategoryPanel.add(editCategoryLabel);

		JLabel addCategoyPanelAmountLabel = new JLabel("Amount:");
		addCategoyPanelAmountLabel.setForeground(Color.WHITE);
		addCategoyPanelAmountLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addCategoyPanelAmountLabel.setBounds(10, 164, 676, 26);
		addCategoryPanel.add(addCategoyPanelAmountLabel);

		JButton btnAddCategoryPanel = new JButton("ADD");
		btnAddCategoryPanel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnAddCategoryPanel.setForeground(UIManager.getColor("ToolBar.dockingForeground"));
		btnAddCategoryPanel.setBounds(10, 266, 676, 56);
		addCategoryPanel.add(btnAddCategoryPanel);
		
		JButton btnRemoveCategory = new JButton("Remove");
		btnRemoveCategory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRemoveCategory.setBounds(10, 357, 236, 58);
		addCategoryPanel.add(btnRemoveCategory);
		btnRemoveCategory.addActionListener(mouseClicked->{
			categoryController.deleteCategory(addCategoryTitle.getText(), addCategoryPanel, monthlySettingsPanel);
		});
		
		JTextArea txtrRemovesTheCategory = new JTextArea();
		txtrRemovesTheCategory.setForeground(Color.WHITE);
		txtrRemovesTheCategory.setBackground(Color.DARK_GRAY);
		txtrRemovesTheCategory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtrRemovesTheCategory.setTabSize(2);
		txtrRemovesTheCategory.setRows(3);
		txtrRemovesTheCategory.setText("Removes the category with \r\nthe choosen title and\r\ndeletes all the expenses \r\nrelated to that category!");
		txtrRemovesTheCategory.setBounds(10, 417, 236, 92);
		addCategoryPanel.add(txtrRemovesTheCategory);
		btnAddCategoryPanel.addActionListener(mouseClicked -> {
			// Setting Listener to addCategoryBtn
			categoryController.addCategory(addCategoryTitle.getText(), addCategoryAmount.getText(), addCategoryPanel,
					monthlySettingsPanel);
		});

		monthlySettingsPanel = new JPanel();
		monthlySettingsPanel.setForeground(Color.LIGHT_GRAY);
		monthlySettingsPanel.setBackground(Color.DARK_GRAY);
		layeredPane.add(monthlySettingsPanel, "name_1062105994166900");

		JLabel monthlySettingsTitle = new JLabel("Monthly Configurations");
		monthlySettingsTitle.setForeground(Color.WHITE);
		monthlySettingsTitle.setBackground(SystemColor.activeCaption);
		monthlySettingsTitle.setBounds(10, 11, 676, 86);
		monthlySettingsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		monthlySettingsTitle.setFont(new Font("Tahoma", Font.BOLD, 40));

		JLabel revenueLabel = new JLabel("Insert Monthly Revenue:");
		revenueLabel.setForeground(Color.WHITE);
		revenueLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		revenueLabel.setBounds(10, 108, 308, 26);

		JLabel createCategoriesLabel = new JLabel("Set Your Expense Categories:");
		createCategoriesLabel.setForeground(Color.WHITE);
		createCategoriesLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		createCategoriesLabel.setBounds(10, 292, 308, 37);

		JLabel saveOptionLabel = new JLabel("Insert Monthly Saving Preference:");
		saveOptionLabel.setForeground(Color.WHITE);
		saveOptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		saveOptionLabel.setBounds(10, 199, 308, 43);

		inputRevenue = new JTextField();
		inputRevenue.setBounds(10, 145, 308, 43);
		inputRevenue.setColumns(10);

		inputWantedSaving = new JTextField();
		inputWantedSaving.setBounds(10, 240, 308, 45);
		inputWantedSaving.setColumns(10);

		JRadioButton rdbtnPrecents = new JRadioButton("%");
		rdbtnPrecents.setForeground(Color.WHITE);
		rdbtnPrecents.setBackground(Color.DARK_GRAY);
		buttonGroup.add(rdbtnPrecents);
		rdbtnPrecents.setBounds(324, 262, 49, 23);

		JRadioButton rdbtnMoney = new JRadioButton("ILS");
		rdbtnMoney.setForeground(Color.WHITE);
		rdbtnMoney.setSelected(true);
		rdbtnMoney.setBackground(Color.DARK_GRAY);
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

		JLabel previewLabel = new JLabel("Categories Preview:");
		previewLabel.setForeground(Color.WHITE);
		previewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		previewLabel.setBounds(366, 107, 308, 29);
		monthlySettingsPanel.add(previewLabel);

		JButton btnSwitchToAddCategory = new JButton("Manage Categories");
		btnSwitchToAddCategory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSwitchToAddCategory.setBounds(10, 340, 308, 37);
		monthlySettingsPanel.add(btnSwitchToAddCategory);

		JButton btnSubmitConfigurations = new JButton("Submit Configurations");
		btnSubmitConfigurations.setForeground(Color.DARK_GRAY);
		btnSubmitConfigurations.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnSubmitConfigurations.setBounds(10, 430, 308, 65);
		monthlySettingsPanel.add(btnSubmitConfigurations);
		btnSubmitConfigurations.addActionListener(mouseClicked -> {
			userController.submitConfiguration(inputRevenue.getText(), inputWantedSaving.getText(), rdbtnPrecents,
					monthlySettingsPanel, homePanel);
		});
		previewArea.setBackground(Color.DARK_GRAY);
		previewArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		previewArea.setForeground(Color.WHITE);


		previewArea.setBounds(379, 145, 308, 350);
		monthlySettingsPanel.add(previewArea);
		previewArea.setText("this is my preview");
		
		JButton btnLogoutMonthlyConfig = new JButton("Logout");
		btnLogoutMonthlyConfig.setBackground(UIManager.getColor("textHighlight"));
		btnLogoutMonthlyConfig.setForeground(Color.RED);
		btnLogoutMonthlyConfig.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogoutMonthlyConfig.setBounds(570, 11, 116, 37);
		monthlySettingsPanel.add(btnLogoutMonthlyConfig);
		
		JButton btnBackMonthlySettings = new JButton("Back");
		btnBackMonthlySettings.setForeground(Color.RED);
		btnBackMonthlySettings.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBackMonthlySettings.setBounds(7, 8, 89, 23);
		monthlySettingsPanel.add(btnBackMonthlySettings);
		btnBackMonthlySettings.addActionListener(mouseClicked->{
		     if(userController.getConfigStatus()) {
		    	 userController.triggerObservers();
		    	 UtilitiesController.swapPages(monthlySettingsPanel, homePanel);
		     }else {
		    	 JOptionPane.showMessageDialog(null,"First Finish Your Configuration!");
		     }
		});
        
		btnLogoutMonthlyConfig.addActionListener(mouseClicked->{
			userController.logout(monthlySettingsPanel, loginPanel);
		});

		btnSwitchToAddCategory.addActionListener(mouseClicked -> {
			UtilitiesController.swapPages(monthlySettingsPanel, addCategoryPanel);
		});

	}
}
