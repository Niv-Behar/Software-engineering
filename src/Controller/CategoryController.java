package Controller;

import java.util.List;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Model.Category;
import Model.CategoryService;
import Model.ExpenseService;
import Model.UserService;

public class CategoryController extends Observable{
	// Injection:
	CategoryService categoryService = CategoryService.getInstance();
	UserService userService = UserService.getInstance();
	ExpenseService expenseService=ExpenseService.getInstance();

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
			triggerObservers();
			UtilitiesController.swapPages(currentPanel, nextPanel);
		}
	}
	
	public void deleteCategory(String title,JPanel currentPanel,JPanel nextPanel) {
		Category cat=categoryService.findCategory(title);
		if(cat==null) {
			JOptionPane.showMessageDialog(null,"Category doesn't exist");
			return;
		}
		else {
			this.expenseService.deleteAllExpensesInCategory(title);
			this.categoryService.deleteCategory(cat.getId(), userService.getToken());
			triggerObservers();
			UtilitiesController.swapPages(currentPanel, nextPanel);
		}
	}
	
	public void deleteAll(JPanel currentPanel,JPanel nextPanel) {
	  categoryService.deleteAllByUser(userService.getToken());
	  expenseService.deleteAllByUser(userService.getToken());

	  triggerObservers();
	  UtilitiesController.swapPages(currentPanel, nextPanel);
	}
	
	public void triggerObservers() {
		this.setChanged();
		this.notifyObservers(toString());
		
	}
	
	public String toString() {
		return categoryService.toString();
	}
}
