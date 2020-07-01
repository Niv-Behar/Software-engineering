package Controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Model.Category;
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

	public static boolean writeReport() {
		UserService userService = UserService.getInstance();
		CategoryService categoryService = CategoryService.getInstance();
		ExpenseService expenseService = ExpenseService.getInstance();
		ConfigService configService = ConfigService.getInstance();
		
		boolean result=true;

		try {
			Date date=new Date();
			
			FileWriter myWriter = new FileWriter("Reports\\" +"Month#"+date.getMonth() +"_"+userService.getEmail()+
					+date.getTime()+".md");
			
			myWriter.write("Month Number"+date.getMonth()+" Report:\n\n\n");
            myWriter.write(configService.configReport(categoryService.spentThisMonth()));
            
            myWriter.write("\nCategories:\n");
            myWriter.write(categoryService.toString());
            
            myWriter.write("\nDetailed Expenses:\n");
            myWriter.write(expenseService.toString());
			myWriter.close();
			
			configService.endMonth();
			configService.updateConfig(userService.getToken());
					
			
		
			JOptionPane.showMessageDialog(null, "Monthly Report Successfully Conducted!");
			
			
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
			result=false;
		}
		return result;
	}

}
