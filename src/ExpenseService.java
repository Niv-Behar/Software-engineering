import java.util.ArrayList;
import java.util.List;

public class ExpenseService {
	List<Expense> expenses;
	private static final String restURL="http://schoolproject-env.eba-qp6e4y82.us-east-2.elasticbeanstalk.com/" + "api/expense";
    //Injection of services:
	private final CategoryService categoryService=CategoryService.getInstance();
	private final UserService userService=UserService.getInstance();
	
	//Singleton-
	private ExpenseService() {
		expenses=new ArrayList<>();
	}
	private static ExpenseService INSTANCE=new ExpenseService();
	public static ExpenseService getInstance() {
		return INSTANCE;
	}
	//---------
	
	//returns an array of expenses that belong to a certain category of choice
	public Expense[] findExpensesByCategory(String title) {
		String categoryId=categoryService.findCategory(title).get_id();
		ArrayList<Expense> foundExpenses=new ArrayList<>();
		for(Expense exp:expenses) {
			if(exp.get_id().contentEquals(categoryId)) {
				foundExpenses.add(exp);
			}
		}
		
		return (Expense[]) foundExpenses.toArray();
		
	}
	
	//Adding an expense and updating the amountUsed in that category!
	public boolean addExpenseToCategory(String title,int amount,String categoryName) {
		Category cat=categoryService.findCategory(categoryName);
		if(cat==null) {
			return false;//Category doesn't exist!
		}
		//TODO
		return true;
	}
	//Fetching all expenses from a certain creator !
	public boolean initExpenses() {
		//TODO
		return true;
	}
	
	//Updating a certain expense!
	public boolean updateExpense(String title,int amount, String newTitle,int newAmount ) {
		//TODO
		return true;
	}
	
	//Deleting a certain expense!
	public boolean deleteExpense(String title,int amount) {
		//TODO
		return true;
	}
}
