package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
String url="jdbc:mysql://localhost:3306/kl";
String dbuser="root";
String dbpwd="1634";

Connection con = null;
PreparedStatement ps=null;
public List<Student> readData() throws Exception
{
	con =DriverManager.getConnection(url,dbuser,dbpwd);
	ps = con.prepareStatement("select * from student");
	ResultSet rs= ps.executeQuery();
	List<Student> L = new ArrayList<Student>();
	while(rs.next()) {
		Student S = new Student();
		S.setStudentid(rs.getInt(1));
		S.setName(rs.getString(2));
		S.setCgpa(rs.getDouble(3));
		L.add(S);
	}
	con.close();
	return L;
 	
}
}
