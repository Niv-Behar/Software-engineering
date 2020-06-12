package Controller;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Model.CategoryService;
import Model.UserService;

public class CategoryController {
	// Injection:
	CategoryService categoryService = CategoryService.getInstance();
	UserService userService = UserService.getInstance();

	public void addCategory(String title, String amount, JPanel currentPanel, JPanel nextPanel) {
		boolean err = false;
		if (title.equalsIgnoreCase("") || amount.equalsIgnoreCase(""))
			err = true;

		if (!err) {
			boolean result = this.categoryService.addCategory(title, Integer.parseInt(amount), 0,
					this.userService.getUserId(), this.userService.getToken());
			if (!result)
				err = true;
		}
		if (err) {
			JOptionPane.showMessageDialog(null, "An Error Occured");
		}else {
			UtilitiesController.swapPages(currentPanel, nextPanel);
		}
	}
}
