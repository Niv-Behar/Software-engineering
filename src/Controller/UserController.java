package Controller;

import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Model.CategoryService;
import Model.ConfigService;
import Model.ExpenseService;
import Model.UserService;

public class UserController extends Observable {

	// Injection of services:
	UserService userService = UserService.getInstance();
	ConfigService configService = ConfigService.getInstance();
	CategoryService categoryService = CategoryService.getInstance();
	ExpenseService expenseService = ExpenseService.getInstance();
	// ---------

	public void login(String email, String password, JPanel currentPanel, JPanel nextPanel, JPanel ifNoConfig) {
		if (email.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Please insert valid credentials!");
			return;
		}
		if (userService.login(email, password)) {
			// Upon success:
			categoryService.initCategories(userService.getToken());
			expenseService.initExpenses(userService.getToken());
			configService.fetchConfig(userService.getToken());
			// Triggering the Observers that are listening to that Observable !
			triggerObservers();
			// --------------------------------

			if (configService.getConfigStatus()) {
				UtilitiesController.swapPages(currentPanel, nextPanel);
			} else {
				UtilitiesController.swapPages(currentPanel, ifNoConfig);
			}
			JOptionPane.showMessageDialog(null, "login successfully!");

		} else {
			JOptionPane.showMessageDialog(null, "login fail!");

		}
	}

	public void signup(String email, String password, JPanel currentPanel, JPanel nextPanel, JPanel ifNoConfig) {
		if (email.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Please insert valid credentials!");
			return;
		}
		if (userService.signup(email, password)) {
			// Upon success:
			userService.login(email, password);
			configService.createConfig(userService.getUserId(), userService.getToken());
			configService.fetchConfig(userService.getToken());
			// Triggering the Observers that are listening to that Observable !
			triggerObservers();
			// --------------------------------

			if (configService.getConfigStatus()) {
				UtilitiesController.swapPages(currentPanel, nextPanel);
			} else {
				UtilitiesController.swapPages(currentPanel, ifNoConfig);
			}
			JOptionPane.showMessageDialog(null, "Account created successfully!");
		} else {
			JOptionPane.showMessageDialog(null, "Email already exists!");
		}
	}

	public void logout(JPanel currentPanel, JPanel nextPanel, JTextField email, JPasswordField password) {

		email.setText("");
		password.setText("");
		UtilitiesController.swapPages(currentPanel, nextPanel);
		userService.logout();
	}

	public void logout(JPanel currentPanel, JPanel nextPanel) {
		UtilitiesController.swapPages(currentPanel, nextPanel);
		userService.logout();
	}

	public void submitConfiguration(String monthlyRevenue, String wantedSaving, JRadioButton precents,
			JPanel currentPanel, JPanel nextPanel) {
		if (monthlyRevenue.equalsIgnoreCase("") || wantedSaving.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Please fill all the configuration fields !\n"
					+ "You Have to add your revenue and the amount you want to save !");
			return;
		}
		Integer revenue = null;
		Integer wantedSave = null;
		boolean precentSelected = precents.isSelected();
		try {
			revenue = Integer.parseInt(monthlyRevenue);
			if (precentSelected) {
				Integer precent = Integer.parseInt(wantedSaving);
				if (!(precent > 100 || precent < 0)) {
					wantedSave = revenue / 100 * precent;
				}
			} else {
				Integer ILS = Integer.parseInt(wantedSaving);
				if (!(ILS < 0)) {
					wantedSave = ILS;
				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Please Enter Valid Values !");
		}
		if (revenue == null || wantedSave == null) {
			return;
		}
		configService.setMonthlyRevenue(revenue);
		configService.setWantedSaveValue(wantedSave);
		configService.setConfigStatus(true);
		configService.updateConfig(userService.getToken());
		//
		triggerObservers();
		//
		UtilitiesController.swapPages(currentPanel, nextPanel);

	}

	public void triggerObservers() {
		this.setChanged();
		this.notifyObservers(categoryService.toString());
	}

}
