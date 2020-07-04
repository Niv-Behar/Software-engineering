package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Model.CategoryService;
import Model.ExpenseService;
import Model.UserService;

class DeleteExpenseTest {

	UserService userService = UserService.getInstance();

	@Before
	public void setup() {
		userService.login("test@test", "test");
		System.out.println("BeforeAll");
	}

	@After
	public void finish() {
		userService.logout();
	}

	@Test
	public void deleteExpenseFailsWhenCategoryDoenstExist() {
		ExpenseService expenseService = ExpenseService.getInstance();
		boolean result = expenseService.deleteExpense("test", 1, "NotExists");
		if (result)
			Assertions.fail("deleteCategory success but should have failed!");
		Assertions.assertEquals(false, result);
	}

	@Test
	public void deleteExpenseFailsWhenExpenseDontExist() {
		ExpenseService expenseService = ExpenseService.getInstance();
		boolean result = expenseService.deleteExpense("NotExists", 1, "Test");
		if (result)
			Assertions.fail("deleteCategory success but should have failed!");
		Assertions.assertEquals(false, result);
	}

	@Test
	public void deleteExpenseFailsWhenAmountNotMatching() {
		ExpenseService expenseService = ExpenseService.getInstance();
		boolean result = expenseService.deleteExpense("test", 11, "Test");
		if (result)
			Assertions.fail("deleteCategory success but should have failed!");
		Assertions.assertEquals(false, result);
	}

}
