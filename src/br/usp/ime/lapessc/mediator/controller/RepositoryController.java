package br.usp.ime.lapessc.mediator.controller;

import java.util.Set;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.usp.ime.lapessc.mediator.dao.RepositoryDao;
import br.usp.ime.lapessc.mediator.model.Repository;
import br.usp.ime.lapessc.mediator.model.UserInfo;

@Resource
@RequestScoped
public class RepositoryController {
	
	private final Result result;
	private final UserInfo info;
	private final RepositoryDao dao;

	public RepositoryController(Result result, RepositoryDao dao, UserInfo info) {
		this.dao = dao;
		this.info = info;
		this.result = result;
	}
	
    @Get
    @Path(value = "/repositories")
    public void list() {
    	Set<Repository> repositories = this.dao.search(this.info.getUser());
    	this.result.include("repositories", repositories);
    }
    
    @Post
    @Path(value = "/repositories")
    public void save(Repository repository) {
    	repository.setUser(this.info.getUser());
    	this.dao.save(repository);
    	this.result.redirectTo(RepositoryController.class).list();
    }
    
    @Get
    @Path(value = "/repositories/{id}")
    public void show(String id) {
    	Repository rep = this.dao.find(id);
    	this.result.include("repository", rep);
    }
    
    @Delete
    @Path(value = "/repositories/{id}")
    public void remove(String id) {
    	this.dao.delete(id);
    	this.result.redirectTo(RepositoryController.class).list();
    }
    
}