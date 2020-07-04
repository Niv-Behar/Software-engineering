package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Model.CategoryService;
import Model.UserService;

class DeleteCategoryTest {
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
	public void deleteFailsWhenIdDontExist() {
		CategoryService categoryService=CategoryService.getInstance();
		boolean result=categoryService.deleteCategory("randomID", userService.getToken());
		if(result)  Assertions.fail("deleteCategory success but should have failed!");
		Assertions.assertEquals(false, result);
	}
	
	@Test
	public void deleteFailsWhenTokenNotValid() {
		CategoryService categoryService=CategoryService.getInstance();
		boolean result=categoryService.deleteCategory("5f00e8b23155771faca109f8", userService.getToken()+"F");
		if(result)  Assertions.fail("deleteCategory success but should have failed!");
		Assertions.assertEquals(false, result);
	}

}
