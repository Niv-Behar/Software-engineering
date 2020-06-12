package Controller;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Model.ConfigService;
import Model.UserService;

public class UserController {

	// Injection of services:
	UserService userService = UserService.getInstance();
	ConfigService configService=ConfigService.getInstance();
	// ---------

	public void login(String email, String password, JPanel currentPanel, JPanel nextPanel,JPanel ifNoConfig) {
		if (email.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Please insert valid credentials!");
			return;
		}
		if (userService.login(email, password)) {
			// Upon success:
	
			JOptionPane.showMessageDialog(null, "login successfully!");
			configService.fetchConfig(userService.getToken());
			if(configService.getConfigStatus()) {
				UtilitiesController.swapPages(currentPanel, nextPanel);
			}else {
				UtilitiesController.swapPages(currentPanel, ifNoConfig);
			}
			

		} else {
			JOptionPane.showMessageDialog(null, "login fail!");

		}
	}

	public void signup(String email, String password, JPanel currentPanel, JPanel nextPanel,JPanel ifNoConfig) {
		if (email.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Please insert valid credentials!");
			return;
		}
		if (userService.signup(email, password)) {
			// Upon success:
			userService.login(email, password);
			System.out.println(userService.getUserId());
			configService.createConfig(userService.getUserId(), userService.getToken());
		   
			JOptionPane.showMessageDialog(null, "Account created successfully!");
			configService.fetchConfig(userService.getToken());
			if(configService.getConfigStatus()) {
				  UtilitiesController.swapPages(currentPanel, nextPanel);
			}else {
				UtilitiesController.swapPages(currentPanel, ifNoConfig);
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "Email already exists!");
		}
	}

	public void logout() {
         userService.logout();
	}
}
