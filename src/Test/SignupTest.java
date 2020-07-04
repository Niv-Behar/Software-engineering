package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Model.UserService;

class SignupTest {

	@Test
	public void SignupFailsWhenEmailIsEmpty() {
		UserService userService = UserService.getInstance();
		boolean result = userService.signup("", "test");
		if(result) Assertions.fail("Signup success but should have failed!");
		Assertions.assertEquals(false, result);
		
	}
	@Test
	public void SignupFailsWhenPasswordIsEmpty() {
		UserService userService = UserService.getInstance();
		boolean result = userService.signup("test@test", "");
		if(result) Assertions.fail("Signup success but should have failed!");
		Assertions.assertEquals(false, result);
	}
	@Test
	public void SignupFailsWhenEmailAlreadyRegistered() {
		UserService userService = UserService.getInstance();
		boolean result = userService.signup("test@test", "test");
		if(result) Assertions.fail("Signup success but should have failed!");
		Assertions.assertEquals(false, result);
	}
	@Test
	public void SignupFailsWhenEmailNotValidEmail() {
		UserService userService = UserService.getInstance();
		boolean result = userService.signup("testtest", "test");
		if(result) Assertions.fail("Signup success but should have failed!");
		Assertions.assertEquals(false, result);
	}

}
