package Controller;

import java.util.Observable;

import javax.swing.JOptionPane;

import Model.ExpenseService;

public class ExpenseController extends Observable{
    //Services:
	ExpenseService expenseService=ExpenseService.getInstance();
	
	
	public void addExpense(String categoryName,String expenseName,String amount) {
		if(categoryName.equalsIgnoreCase("")||expenseName.equalsIgnoreCase("")||amount.equalsIgnoreCase("")) {
			//Not valid
			JOptionPane.showMessageDialog(null, "Please fill all the fields!");
			return;
		}else {
			int amountNumber=Integer.parseInt(amount);
			boolean result=expenseService.addExpenseToCategory(expenseName, amountNumber, categoryName);
			if(!result) {
				JOptionPane.showMessageDialog(null, "Category doesn't exist!");
				return;
			}
			triggerObservers();
			
		}
	}
	public void deleteExpense(String categoryName,String expenseName,String amount) {
		if(categoryName.equalsIgnoreCase("")||expenseName.equalsIgnoreCase("")||amount.equalsIgnoreCase("")) {
			//Not valid
			JOptionPane.showMessageDialog(null, "Please fill all the fields!");
			return;
		}else {
			int amountNumber=Integer.parseInt(amount);
			boolean result=expenseService.deleteExpense(expenseName, amountNumber, categoryName);
			if(!result) {
				JOptionPane.showMessageDialog(null, "Category doesn't exist!");
				return;
			}
			triggerObservers();
		}
	}
	
	
	public void init() {
		triggerObservers();
	}
	
	public void triggerObservers() {
		this.setChanged();
		this.notifyObservers(expenseService.toString());
	}
	
	
}
