package SqlQuery;

import java.sql.*;

import com.mysql.jdbc.PreparedStatement;

public class InsertRow {

   
   private String f1,f2,f3,f4,f5,f6,f7,f8,f9,f10;
	
   public InsertRow(String f1, String f2, String f3, String f4, String f5, String f6, String f7, String f8, String f9, String f10) {
	
	   

	this.f1 = f1;
	this.f2 = f2;
	this.f3 = f3;
	this.f4 = f4;
	this.f5 = f5;
	this.f6 = f6;
	this.f7 = f7;
	this.f8 = f8;
	this.f9 = f9;
	this.f10 = f10;
	
	
	Connection conn = null;
	PreparedStatement Stmt = null;
	
	try {
	String myDriver = "org.gjt.mm.mysql.Driver";
    String myUrl = "jdbc:mysql://127.0.0.1:3306/Feedback";
    Class.forName(myDriver);
	  conn = DriverManager.getConnection(myUrl, "root", "zing77");
	  String sql= " insert into feedback_2 (date, what_excited_me, job_skills_gathered , concepts_learned, questions_asked, how_challenged, what_i_would_like_to_see, research_needed, employer_discussions, help_offered)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	   Stmt = (PreparedStatement) conn.prepareStatement(sql);	  
	   Stmt.setString (1, f1);
	   Stmt.setString (2, f2);
	   Stmt.setString (3, f3);
	   Stmt.setString (4, f4);
	   Stmt.setString (5, f5);
	   Stmt.setString (6, f6);
	   Stmt.setString (7, f7);
	   Stmt.setString (8, f8);
	   Stmt.setString (9, f9);
	   Stmt.setString (10,f10);
		
	     
	     Stmt.executeUpdate();
	     conn.close();
		
		
		System.out.println("Inserted records into the table...");
		
		}catch(SQLException se){
		//Handle errors for JDBC
		se.printStackTrace();
		}catch(Exception e){
		//Handle errors for Class.forName
		e.printStackTrace();
		}finally{
		//finally block used to close resources
		try{
		  if(Stmt!=null)
		     conn.close();
		}catch(SQLException se){
		}// do nothing
		try{
		  if(conn!=null)
		     conn.close();
		}catch(SQLException se){
		  se.printStackTrace();
		}//end finally try
		}//end try
		System.out.println("Goodbye!");
		}
		}
