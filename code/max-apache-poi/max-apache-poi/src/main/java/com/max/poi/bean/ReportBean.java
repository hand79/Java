package com.max.poi.bean;

import java.util.Date;

public class ReportBean {
	
	private Date date;
	private String week;
	private String workProjects;
	
	public ReportBean() {
	}
	
	public ReportBean(Date date, String week, String workProjects) {
		this.date = date;
		this.week = week;
		this.workProjects = workProjects;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getWorkProjects() {
		return workProjects;
	}
	public void setWorkProjects(String workProjects) {
		this.workProjects = workProjects;
	}
	
	@Override
	public String toString() {
		return "ReportBean [date=" + date + ", week=" + week + ", workProjects=" + workProjects + "]";
	}
	
}
