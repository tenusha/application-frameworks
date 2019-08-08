package com.sliit.af.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="courses")
public class Course {
	@Id
	String id;
	String name;
	String code;
	int passMark;
	String lecturereInCharge;
	List<Subject> subjects;
	
	public Course(String name, String code, int passMark, String lecturereInCharge, List<Subject> subjects) {
		super();
		this.name = name;
		this.code = code;
		this.passMark = passMark;
		this.lecturereInCharge = lecturereInCharge;
		this.subjects = subjects;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getPassMark() {
		return passMark;
	}

	public void setPassMark(int passMark) {
		this.passMark = passMark;
	}

	public String getLecturereInCharge() {
		return lecturereInCharge;
	}

	public void setLecturereInCharge(String lecturereInCharge) {
		this.lecturereInCharge = lecturereInCharge;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", code=" + code + ", passMark=" + passMark
				+ ", lecturereInCharge=" + lecturereInCharge + ", subjects=" + subjects + "]";
	}
	
}
