package br.usp.ime.lapessc.mediator.dao;

import java.util.Set;

import br.usp.ime.lapessc.mediator.model.Metadata;
import br.usp.ime.lapessc.mediator.model.Repository;

public interface IQueryDao {

	public Metadata find(String id, Repository rep);

	public Set<String> searchById(Metadata metadata, Repository rep);

	public Set<String> searchTypes(String id, Repository rep);

	public Set<String> searchPropertyValues(String id, String name, Repository rep);

	public Set<String> searchRelated(String id, String name, Repository rep);
	
	public boolean buildElement(Metadata metadata, Repository rep);

}
