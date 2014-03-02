package br.usp.ime.lapessc.mediator.model;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class UserInfo {

    private User user;

	public User getUser() {
		return user;
	}

	public void login(User user) {
		this.user = user;
	}

	public void logout() {
		this.user = null;
	}
	
}