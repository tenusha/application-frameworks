package com.sliit.af.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "courses")
@EntityListeners(AuditingEntityListener.class)
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer id;
	@Column(name = "name")
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private List<Subject> CourseLogs;

	public List<Subject> getCourseLogs() {
		return CourseLogs;
	}

	public void setCourseLogs(List<Subject> CourseLogs) {
		this.CourseLogs = CourseLogs;
	}

	public Course() {
	}

	public Integer getId() {
		return id;
	}

	public Course setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Course setName(String name) {
		this.name = name;
		return this;
	}

}
