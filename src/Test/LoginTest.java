package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Model.UserService;

class LoginTest {
	@Test
	public void loginFailedWhenUsernameIsEmpty() {
		UserService userService = UserService.getInstance();
		boolean result = userService.login("", "1111");
		if(result) Assertions.fail("Login success but should have failed!");
		Assertions.assertEquals(false, result);
        
		
	}

	@Test
	public void loginFailedWhenPasswordIsEmpty() {
		UserService userService = UserService.getInstance();
		boolean result = userService.login("test@test", "");
		if(result) Assertions.fail("Login success but should have failed!");
		Assertions.assertEquals(false, result);
	}
	
	@Test
	public void loginFailedWhenUserDontExist() {
		UserService userService = UserService.getInstance();
		boolean result = userService.login("check@check", "1111");
		if(result) Assertions.fail("Login success but should have failed!");
		Assertions.assertEquals(false, result);
	}

}
