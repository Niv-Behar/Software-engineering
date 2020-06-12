package Controller;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Model.UserService;

public class UserController {

	// Injection of services:
	UserService userService = UserService.getInstance();
	// ---------

	public void login(String email, String password, JPanel currentPanel, JPanel nextPanel) {
		if (userService.login(email, password)) {
			// Upon success:
			currentPanel.setVisible(false);
			nextPanel.setVisible(true);
			JOptionPane.showMessageDialog(null, "login successfully!");

		} else {
			JOptionPane.showMessageDialog(null, "login fail!");
			
			
		}
	}

	public void signup(String email, String password,JPanel currentPanel,JPanel nextPanel) {
       if(userService.signup(email, password)) {
    	   //Upon success:
    	   currentPanel.setVisible(false);
    	   nextPanel.setVisible(true);
    	   JOptionPane.showMessageDialog(null, "Acount created successfully!");
    	   userService.login(email, password);
       }
       else {
    	   JOptionPane.showMessageDialog(null, "Email already exists!");
       }
	}

	public void logout() {
        
	}
}
