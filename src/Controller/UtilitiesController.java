package Controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Observer;

import javax.swing.JPanel;

import Model.CategoryService;
import Model.ConfigService;
import Model.ExpenseService;
import Model.UserService;

public class UtilitiesController {

	// Service Injections:

	public static void swapPages(JPanel currentPanel, JPanel nextPanel) {
		currentPanel.setVisible(false);
		nextPanel.setVisible(true);

	}

	public static void writeReport() {
		UserService userService = UserService.getInstance();
		CategoryService categoryService = CategoryService.getInstance();
		ExpenseService expenseService = ExpenseService.getInstance();
		ConfigService configService = ConfigService.getInstance();

		try {
			Date date=new Date();
			
			FileWriter myWriter = new FileWriter("Reports\\" +"Month#"+date.getMonth() +"_"+userService.getEmail()+ ".md");
			myWriter.write("Month Number"+date.getMonth()+" Report:\n\n\n");
            myWriter.write(configService.configReport(categoryService.spentThisMonth()));
            
            myWriter.write("\nCategories:\n");
            myWriter.write(categoryService.toString());
            
            myWriter.write("\nDetailed Expenses:\n");
            myWriter.write(expenseService.toString());
			myWriter.close();
			
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
