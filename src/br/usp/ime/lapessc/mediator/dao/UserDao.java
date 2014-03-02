package br.usp.ime.lapessc.mediator.dao;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.usp.ime.lapessc.mediator.model.User;

@Component
public class UserDao {

	private final Session session;

	public UserDao(Session session) {
		this.session = session;
	}

	public User find(String email) {
		return (User) this.session.get(User.class, email);
	}
	
	public void save(User user) {
		this.session.saveOrUpdate(user);
	}
	
}