package br.usp.ime.lapessc.mediator.model;

public class Relation{
	
	private Metadata src;
	
	private String name;
	
	private String value;
	
	public String getId() {
		return this.src.getId();
	}
	
	public void setId(String id) {
		this.src.setId(id);
	}
	
	public Metadata getSrc() {
		return this.src;
	}
	
	public void setSrc(Metadata src) {
		this.src = src;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * (relation ?id ?name ?value)
	 */
	@Override
	public String toString() {
		return "(relation " + (this.getId() != null ? this.getId() : "nil") + " " +
			this.name + " " + (this.value != null ? this.value : "nil") + ")";
	}
	
}