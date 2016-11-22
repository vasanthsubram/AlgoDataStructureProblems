package utils;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
	private Employee secretary;
	private List<Employee> directReports=new ArrayList<Employee>();	
	
	public Manager() {
	}
	public Manager(String n, double s, int year, int month, int day) {
		super(n, s, year, month, day);
		secretary = null;
	}

	public void setSecretary(Employee s) {
		secretary = s;
	}

	public Employee getSecretary() {
		return secretary;
	}

	
	public String toString() {
		return super.toString() + "[secretary=" + secretary + "]";
	}
	
	public List<Employee> getDirectReports() {
		return directReports;
	}

	public void setDirectReports(List<Employee> directReports) {
		this.directReports = directReports;
	}
	
	public void addDirectRport(Employee e){
		directReports.add(e);
	}

}

