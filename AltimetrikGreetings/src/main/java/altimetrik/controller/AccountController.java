package altimetrik.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import altimetrik.greetings.domain.Status;
import altimetrik.greetings.domain.User;
import altimetrik.service.AccountService;

@RestController
@RequestMapping("api/account")
public class AccountController {

	@Autowired
	AccountService accountService;

	@RequestMapping(method = RequestMethod.POST, path = "/sign-up")
	public Status signUp(@RequestBody User user) {

		Status status = null;
		if (null != user) {
			if (null == accountService.findUser(user.getUsername())) {
				accountService.signUp(user);
				status = new Status();
				status.setStatus("OK");
				status.setMessage("Account Creted");
			} else {
				status = new Status();
				status.setStatus("OK");
				status.setMessage("Account Already Exist");
			}

		}

		return status;

	}

	@RequestMapping(method = RequestMethod.POST, path = "/sign-in")
	public Status signIn(@RequestParam("username") String username, @RequestParam("password") String password) {
		User user = accountService.findUser(username);
		Status status = null;
		if (null != user) {

			if (StringUtils.isNotBlank(user.getPassword()) && user.getPassword().equals(password)) {

				status = new Status();
				status.setStatus("OK");
				status.setMessage("SignIn successful");
				status.setToken("token123");
			}else {
				status = new Status();
				status.setStatus("OK");
				status.setMessage("Password not matching");
			}
		} else {
			status = new Status();
			status.setStatus("OK");
			status.setMessage("Account doesn't exist");
		}
		return status;

	}
}
