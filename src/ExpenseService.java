import java.util.ArrayList;
import java.util.List;

public class ExpenseService {
	List<Expense> expenses;
	private static final String restURL="http://schoolproject-env.eba-qp6e4y82.us-east-2.elasticbeanstalk.com/" + "api/expense";
    
	
	//Singleton-
	private ExpenseService() {
		expenses=new ArrayList<>();
	}
	private static ExpenseService INSTANCE=new ExpenseService();
	public static ExpenseService getInstance() {
		return INSTANCE;
	}
	//---------
	
	public boolean addExpense() {
		return true;
	}
	public boolean getExpenses() {
		return true;
	}
	public boolean updateExpense() {
		return true;
	}
	public boolean deleteExpense() {
		return true;
	}
}
