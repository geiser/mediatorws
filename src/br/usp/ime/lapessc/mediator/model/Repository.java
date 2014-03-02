package br.usp.ime.lapessc.mediator.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Repository {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	
	private String type;
	
	private String url;
	
	private String mapGetType;
	
	private String mapGetPropertyValue;
	
	private String mapGetRelated;
	
	private String mapGetElement;
	
	private String mapBuildElement;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private User user;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMapGetType() {
		return mapGetType;
	}

	public void setMapGetType(String mapGetType) {
		this.mapGetType = mapGetType;
	}

	public String getMapGetPropertyValue() {
		return mapGetPropertyValue;
	}

	public void setMapGetPropertyValue(String mapGetPropertyValue) {
		this.mapGetPropertyValue = mapGetPropertyValue;
	}

	public String getMapGetRelated() {
		return mapGetRelated;
	}

	public void setMapGetRelated(String mapGetRelated) {
		this.mapGetRelated = mapGetRelated;
	}

	public String getMapGetElement() {
		return mapGetElement;
	}

	public void setMapGetElement(String mapGetElement) {
		this.mapGetElement = mapGetElement;
	}

	public String getMapBuildElement() {
		return mapBuildElement;
	}

	public void setMapBuildElement(String mapBuildElement) {
		this.mapBuildElement = mapBuildElement;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}