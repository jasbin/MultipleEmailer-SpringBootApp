package com.emailer.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import com.emailer.domain.User;

public class DBQuery {
	
	public static HashMap<Integer, User> getEmailList() {
		Connection con = DBHelper.getConnection();
		HashMap<Integer,User> map = new HashMap<Integer,User>();
		User u;
		try {
			//new user added remove if error occur
			
			String query = "SELECT * FROM email_list";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String course = rs.getString("course");
                u = new User(id,name,email,course);
                
				map.put(id,u);
			}
		}catch(Exception ex) {
			// TODO Auto-generated catch block
						ex.printStackTrace();
		}
		return map;
	}

}
