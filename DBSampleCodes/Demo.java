package com.ntc;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeDataAccess eda = new EmployeeDataAccess();
		eda.insert();
		//eda.update();
		eda.getEmployeeByID(6);
	}

}
