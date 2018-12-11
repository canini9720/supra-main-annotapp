package com.supra.annot.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SYSTEM_PROPERTIES")
public class ApplicationPropertyEntity {

	@Id
	@Column(name="ID")
	public Long id;
	
	@Column(name="NAME")
	public String name;
	
	@Column(name="VALUE")
	public String value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	
}
