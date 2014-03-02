package br.usp.ime.lapessc.mediator.model;

public class Property {
	
	private Metadata src;
	
	private String name;
	
	private String value;

	public String getId() {
		return src.getId();
	}

	public void setId(String id) {
		this.src.setId(id);
	}
	
	public Metadata getSrc() {
		return this.src;
	}
	
	public void setSrc(Metadata src) {
		this.setSrc(src);
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
	 * (property ?id ?name ?value) or
	 * (property ?id ?name (?destination ?value))
	 */
	@Override
	public String toString() {
		String var = (this.value != null ? this.value : "nil");
		return "(property " + (this.src.getId() != null ? this.src.getId() : "nil") + " " + this.name + " " + var + ")";
	}
	
}