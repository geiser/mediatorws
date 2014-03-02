package br.usp.ime.lapessc.mediator.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Metadata {
	
	private String id;
	
	private Set<String> types = new HashSet<String>();
	
	private Map<String, Set<Property>> properties = new HashMap<String, Set<Property>>();
	
	private Map<String, Set<Relation>> relations = new HashMap<String, Set<Relation>>();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, Set<Property>> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Set<Property>> properties) {
		this.properties = properties;
	}

	public Map<String, Set<Relation>> getRelations() {
		return relations;
	}

	public void setRelations(Map<String, Set<Relation>> relations) {
		this.relations = relations;
	}

	public Set<String> getTypes() {
		return types;
	}

	public void setTypes(Set<String> types) {
		this.types = types;
	}

	public void addProperty(Property property) {
		Set<Property> props = new HashSet<Property>();
		if (this.properties.containsKey(property.getName())) {
			props = this.properties.get(property.getName());
		}
		props.add(property);
		this.properties.put(property.getName(), props);
	}

	public void addRelation(Relation relation) {
		Set<Relation> rels = new HashSet<Relation>();
		if (this.relations.containsKey(relation.getName())) {
			rels = this.relations.get(relation.getName());
		}
		rels.add(relation);
		this.relations.put(relation.getName(), rels);
	}
	
}