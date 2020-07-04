package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Model.ExpenseService;
import Model.UserService;

class AddExpenseTest {

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
	public void addExpenseFailsWhenCategoryNameDontExist() {
		ExpenseService expenseService = ExpenseService.getInstance();
		boolean result = expenseService.addExpenseToCategory("test", 1, "NotExists");
		if (result)
			Assertions.fail("deleteCategory success but should have failed!");
		Assertions.assertEquals(false, result);
	}
	
	
}
