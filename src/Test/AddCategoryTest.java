package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.Test;

import Model.CategoryService;
import Model.UserService;

class AddCategoryTest {
    
	UserService userService=UserService.getInstance();
	

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
	public void AddCategoryFailsWhenCategoryAlreadyExistsForThisUser() {
		CategoryService categoryService=CategoryService.getInstance();
		boolean result=categoryService.addCategory("Test", 1, 1, userService.getUserId(), userService.getToken());
		if(result)  Assertions.fail("AddCategory success but should have failed!");
		Assertions.assertEquals(false, result);
}
	
	@Test
	public void AddCategoryFailsWhenTokenIsInvalid() {
		CategoryService categoryService=CategoryService.getInstance();
		boolean result=categoryService.addCategory("Test1", 1, 1, userService.getUserId(), "Some Random Token!");
		
		if(result)  Assertions.fail("AddCategory success but should have failed!");
		Assertions.assertEquals(false, result);
		
		
	}
	

}
