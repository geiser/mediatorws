package br.usp.ime.lapessc.mediator.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.usp.ime.lapessc.mediator.dao.UserDao;
import br.usp.ime.lapessc.mediator.model.User;
import br.usp.ime.lapessc.mediator.model.UserInfo;

@Resource
@RequestScoped
public class LoginController {

	private final UserDao dao;
	private final UserInfo info;
	private final Result result;
	
	public LoginController(Result result, UserInfo info, UserDao dao) {
		this.dao = dao;
		this.info = info;
		this.result = result;
	}
	
	@Post
	@Path("/login")
	public void login(User user) {
		User found = this.dao.find(user.getEmail());
		if (found != null && user.getPassword().equals(found.getPassword())) {
			this.info.login(user);
			this.result.redirectTo(RepositoryController.class).list();
		} else {
			this.result.redirectTo("/");
		}
	}
	
	@Path("/logout")
	public void logout() {
		this.info.logout();
		this.result.redirectTo("/");
	}
	
	@Post
	@Path("/users")
	public void add(User user, String password) {
		if (password.equals(user.getPassword())) {
			this.dao.save(user);
			this.info.login(user);
			this.result.redirectTo(RepositoryController.class).list();
		} else {
			this.result.redirectTo("/");
		}
	}

}
