package SqlQuery;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PopTable {
	
	private static final String FILE_NAME = "/home/vin/Downloads/IoT.xlsx";


	public static void main(String[] args) {

		{

	    try
	    {
	    	//FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(FILE_NAME));
	    	XSSFSheet datatypeSheet = workbook.getSheetAt(0);
	    	Iterator <Row> RowIterator = datatypeSheet.iterator();
	    	
	    	while (RowIterator.hasNext()) {

	           
	           // Iterator<Cell> cellIterator = currentRow.iterator();
	            
	           while (RowIterator.hasNext()) 
	            {
	        	   
	        	   XSSFRow row =(XSSFRow)RowIterator.next();
	        	   
	            	XSSFSheet sheet = workbook.getSheet("Sheet1");
	            	//cellIterator.next();
	            	//XSSFRow row = sheet.getRow(0);
					XSSFCell cell1 = row.getCell((short)0);
					XSSFCell cell2 = row.getCell((short)1);
					XSSFCell cell3 = row.getCell((short)2);
					XSSFCell cell4 = row.getCell((short)3);
					XSSFCell cell5 = row.getCell((short)4);
					XSSFCell cell6 = row.getCell((short)5);
					XSSFCell cell7 = row.getCell((short)6);
					XSSFCell cell8 = row.getCell((short)7);
					XSSFCell cell9 = row.getCell((short)8);
					XSSFCell cell10 = row.getCell((short)9);
					
					
					System.out.println("this is ");

	                String myDriver = "org.gjt.mm.mysql.Driver";
	                String myUrl = "jdbc:mysql://127.0.0.1:3306/Feedback";//jdbc:oracle:thin:@localhost:1521:Feedback";//jdbc:mysql://127.0.0.1:3306/Feedback";
	                Class.forName(myDriver);
	                Connection conn = DriverManager.getConnection(myUrl, "root", "zing77");
	    
	                String query = " insert into feedback_2 (date, what_excited_me, job_skills_gathered , concepts_learned, questions_asked, how_challenged, what_i_would_like_to_see, research_needed, employer_discussions, help_offered)"
	                				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      
	      preparedStmt.setString (1, cell1.getStringCellValue());
	      preparedStmt.setString (2, cell2.getStringCellValue());
	      preparedStmt.setString (3, cell3.getStringCellValue());
	      preparedStmt.setString (4, cell4.getStringCellValue());
	      preparedStmt.setString (5, cell5.getStringCellValue());
	      preparedStmt.setString (6, cell6.getStringCellValue());
	      preparedStmt.setString (7, cell7.getStringCellValue());
	      preparedStmt.setString (8, cell8.getStringCellValue());
	      preparedStmt.setString (9, cell9.getStringCellValue());
	      preparedStmt.setString (10, cell10.getStringCellValue());
		
	      preparedStmt.execute(); 
	      
	     
	            }
	      // execute the preparedstatement
	     
	      
	      //conn.close();
	    }
	   
	    	 InsertRow r = new InsertRow("1","1","1","1","1","1","1","1","1","1") ;
	    	// DeleteRow d = new DeleteRow(5);
	    }
	 
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
	  }
	 }

}
