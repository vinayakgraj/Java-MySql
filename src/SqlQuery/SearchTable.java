package SqlQuery;

import java.sql.*;

import com.mysql.jdbc.PreparedStatement;

public class SearchTable {
	
	private String lookup_string ;
	private int sno;

	public SearchTable(int sno, String lookup_string) {
		
		this.lookup_string = lookup_string ;
		this.sno = sno ;
		Connection conn = null;
		Statement Stmt = null;
		
		try {
			String myDriver = "org.gjt.mm.mysql.Driver";
		    String myUrl = "jdbc:mysql://127.0.0.1:3306/Feedback";
		    Class.forName(myDriver);
			  conn = DriverManager.getConnection(myUrl, "root", "zing77");
			  String output = String.format("select %s from feedback_2 where sno = %d", lookup_string, sno);
			  System.out.println(output);
			   Stmt = conn.createStatement();	  
			    ResultSet rs =  Stmt.executeQuery(output);
			     
			    while(rs.next()) {
			   /// int last = rs.getInt(sno);
			    String first = rs.getString(lookup_string);
		       
			    
			    System.out.print("Requested Query :"+first+" where sno is "+ sno);
			    
			    }
			    
			    
			    conn.close();
				
				
				System.out.println("\ndone");
				
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
	}	
	
}