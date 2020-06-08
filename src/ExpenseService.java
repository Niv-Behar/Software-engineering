import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class ExpenseService {
	List<Expense> expenses;
//	private static final String restURL="http://schoolproject-env.eba-qp6e4y82.us-east-2.elasticbeanstalk.com/" + "api/expense";
	private static final String restURL = "http://localhost:3000/api/expense";
	// Injection of services:
	private final CategoryService categoryService = CategoryService.getInstance();
	private final UserService userService = UserService.getInstance();

	// Singleton-
	private ExpenseService() {
		expenses = new ArrayList<>();
	}

	private static ExpenseService INSTANCE = new ExpenseService();

	public static ExpenseService getInstance() {
		return INSTANCE;
	}
	// ---------

	// returns an array of expenses that belong to a certain category of choice
	public Expense[] findExpensesByCategory(String title) {
		String categoryId = categoryService.findCategory(title).getId();
		ArrayList<Expense> foundExpenses = new ArrayList<>();
		for (Expense exp : expenses) {
			if (exp.getId().contentEquals(categoryId)) {
				foundExpenses.add(exp);
			}
		}

		return (Expense[]) foundExpenses.toArray();

	}
	public void printExpensesByCategory() {
		for(Category cat:categoryService.categories) {
			System.out.println(cat);
			for(Expense exp:this.expenses) {
				if(exp.getCategoryId().equals(cat._id)) {
					System.out.println(exp);
				}
			}
		}
	}

	// Adding an expense and updating the amountUsed in that category!
	public boolean addExpenseToCategory(String title, int amount, String categoryName) {
		Category foundCategory = categoryService.findCategory(categoryName);
		if (foundCategory == null) {
			return false;// Category doesn't exist!
		}
		// TODO

		String query_url = restURL;
		boolean result = true;
		try {
			JSONObject JSON = new JSONObject().put("title", title).put("amount", amount).put("categoryId",
					foundCategory.getId());
			String json = JSON.toString();
			URL url = new URL(query_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			// Setting header: for authorization
			conn.setRequestProperty("Authorization", "Bearer " + userService.getToken());
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");
			OutputStream os = conn.getOutputStream();
			os.write(json.getBytes("UTF-8"));
			os.close();
			// read the response
			InputStream in = new BufferedInputStream(conn.getInputStream());
			String response = IOUtils.toString(in, "UTF-8");
			// Parsing the json object from response :
			JSONObject myResponse = new JSONObject(response);
			String _id = myResponse.getString("_id");
			Expense expense = new Expense(title, amount, userService.getUserId(), _id, foundCategory.getId());
			this.expenses.add(expense);
			foundCategory.amountUsed += amount;
			this.categoryService.updateCategory(foundCategory, userService.getToken());
			// Closing connection
			in.close();
			conn.disconnect();
		} catch (Exception e) {
			// In case of unsuccessful response with status of other then 200/201....
			System.out.println("Authentication failed");
			result = false;
		}
		return result;

	}

	// Fetching all expenses from a certain creator !
	public boolean initExpenses() {
		String query_url = restURL;
		boolean result = true;
		try {
			URL url = new URL(query_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			// Setting header: for authorization
			conn.setRequestProperty("Authorization", "Bearer " + userService.getToken());
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("GET");
			// read the response
			InputStream in = new BufferedInputStream(conn.getInputStream());
			String response = IOUtils.toString(in, "UTF-8");
			// Parsing the json object from response :
			JSONObject myResponse = new JSONObject(response);
			JSONArray expJSONS = myResponse.getJSONArray("expenses");
			int size = expJSONS.length();
			this.expenses.clear();
			for (int i = 0; i < size; i++) {
				JSONObject obj = expJSONS.getJSONObject(i);
				Expense expense = new Expense(obj.getString("title"), obj.getInt("amount"), obj.getString("creator"),
						obj.getString("_id"), obj.getString("categoryId"));
				this.expenses.add(expense);
			}
			// Closing connection
			in.close();
			conn.disconnect();
		} catch (Exception e) {
			// In case of unsuccessful response with status of other then 200/201....
			System.out.println("Authentication failed");
			result = false;
		}
		return result;
	}

	// Updating a certain expense!
	public boolean updateExpense(String title, int amount, String newTitle, int newAmount) {
		// TODO
		return true;
	}

	
	//Returns foundExpense or null if not exists!
	public Expense findExpense(String title, int amount, String categoryId) {
		for (Expense exp : this.expenses) {
			if (exp.title.equalsIgnoreCase(title) && exp.amount == amount
					&& exp.getCategoryId().equalsIgnoreCase(categoryId)) {
              return exp;
			}
		}
		return null;
}

	// Deleting a certain expense!
	public boolean deleteExpense(String title, int amount,String categoryTitle) {
		 Category foundCategory=categoryService.findCategory(categoryTitle);
		 if(foundCategory==null) {return false;}
		 Expense foundExpense=findExpense(title,amount,foundCategory._id);
		 String query_url = restURL+"/"+foundExpense.getId();
         boolean result = true;
         try {
             URL url = new URL(query_url);
             HttpURLConnection conn = (HttpURLConnection) url.openConnection();
             conn.setConnectTimeout(5000);
             //Setting header: for authorization
             conn.setRequestProperty("Authorization", "Bearer " + userService.getToken());
             conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
             conn.setDoOutput(true);
             conn.setDoInput(true);
             conn.setRequestMethod("DELETE");
             // read the response
             this.expenses.removeIf(exp->{
            	 return exp.getId().equals(foundCategory._id);
             });
             foundCategory.amountUsed-=amount;
             categoryService.updateCategory(foundCategory, userService.getToken());

             //Closing connection
             conn.disconnect();
         } catch (Exception e) {
             //In case of unsuccessful response with status of other then 200/201....
             System.out.println("Error");
             result = false;
         }
         return result;
    }
	
	public boolean deleteAllExpensesInCategory(String categoryTitle) {
		String categoryId=categoryService.findCategory(categoryTitle).getId();
		 String query_url = restURL+"/"+categoryId;
         boolean result = true;
         try {
             URL url = new URL(query_url);
             HttpURLConnection conn = (HttpURLConnection) url.openConnection();
             conn.setConnectTimeout(5000);
             //Setting header: for authorization
             conn.setRequestProperty("Authorization", "Bearer " + userService.getToken());
             conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
             conn.setDoOutput(true);
             conn.setDoInput(true);
             conn.setRequestMethod("DELETE");
             //---------------
             //TODO?
             //Update the category amountUsed to 0 ?
             //Closing connection
             conn.disconnect();
         } catch (Exception e) {
             //In case of unsuccessful response with status of other then 200/201....
             System.out.println("Error");
             result = false;
         }
         return result;
	}

}
