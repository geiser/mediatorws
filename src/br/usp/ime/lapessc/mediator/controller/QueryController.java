package br.usp.ime.lapessc.mediator.controller;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.usp.ime.lapessc.mediator.dao.IQueryDao;
import br.usp.ime.lapessc.mediator.dao.RepositoryDao;
import br.usp.ime.lapessc.mediator.model.Metadata;
import br.usp.ime.lapessc.mediator.model.Property;
import br.usp.ime.lapessc.mediator.model.Relation;
import br.usp.ime.lapessc.mediator.model.Repository;
import br.usp.ime.lapessc.mediator.model.UserInfo;

@Resource
@RequestScoped
public class QueryController {

	private final Result result; 
	private final IQueryDao dao;
	private final Set<Repository> repositories;

	public QueryController(Result result, RepositoryDao repDao, IQueryDao dao, UserInfo info) {
		this.dao = dao;
		this.result = result;
		this.repositories = repDao.search(info.getUser());
	}

	@Get
	@Path(value = "/query")
	public void getInfo(String function,
			Collection<String> type, Collection<Property> property,
			Collection<Relation> relation, String id, String name) {

		Collection<String> presult = new HashSet<String>();

		if ("GetElement".equals(function)) {
			for (Repository rep : this.repositories) {
				Metadata metadata = new Metadata();
				if (type != null && !type.isEmpty()) {
					metadata.setTypes(new HashSet<String>(type));
				}
				if (property != null && !property.isEmpty()) {
					for (Property pro : property) {
						metadata.addProperty(pro);
					}
				}
				if (relation != null && !relation.isEmpty()) {
					for (Relation rel : relation) {
						metadata.addRelation(rel);
					}
				}
				presult.addAll(this.dao.searchById(metadata, rep));
			}
		} else if ("GetType".equals(function)) {
			for (Repository rep : this.repositories) {
				presult.addAll(this.dao.searchTypes(id, rep));
			}
		} else if ("GetPropertyValue".equals(function)) {
			for (Repository rep : this.repositories) {
				presult.addAll(this.dao.searchPropertyValues(id, name, rep));
			}
		} else if ("GetRelated".equals(function)) {
			for (Repository rep : this.repositories) {
				presult.addAll(this.dao.searchRelated(id, name, rep));
			}
		} else if ("BuildElement".equals(function)) {
			this.updateInfo(id, property, relation);
		} else {
			// TODO throw exception, doesn't exist this function 
		}
		this.result.include("result", presult);
	}

	@Post
	@Path(value = "/query")
	public void updateInfo(String id, Collection<Property> property, Collection<Relation> relation) {
		Metadata metadata = new Metadata(); metadata.setId(id);
		for (Property prop : property) { metadata.addProperty(prop); }
		for (Relation rel : relation) { metadata.addRelation(rel); }

		Iterator<Repository> it = this.repositories.iterator();
		boolean isUpdate = false;
		while (it.hasNext() && !isUpdate) {
			isUpdate = this.dao.buildElement(metadata, it.next());
		}
	}

}