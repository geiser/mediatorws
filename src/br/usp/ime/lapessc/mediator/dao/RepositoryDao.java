package br.usp.ime.lapessc.mediator.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.usp.ime.lapessc.mediator.model.Repository;
import br.usp.ime.lapessc.mediator.model.User;

@Component
public class RepositoryDao {
	
	private final Session session;

	public RepositoryDao(Session session) {
		this.session = session;
	}

	public void save(Repository repository) {
		this.session.saveOrUpdate(repository);
	}
	
	@SuppressWarnings("unchecked")
	public Set<Repository> search(User user) {
		String hql = "from Repository r where r.user.email = :email";
		Query query = this.session.createQuery(hql)
				.setParameter("email", user.getEmail());
		return new HashSet<Repository>(query.list());
	}

	public Repository find(String id) {
		return (Repository) this.session.get(Repository.class, id);
	}

	public void delete(String id) {
		this.session.delete(this.find(id));
	}

}