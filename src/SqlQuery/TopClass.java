package SqlQuery;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
public class TopClass {
	
	public static void main(String[] args) throws IOException
	{
		while(true) {
		System.out.println("The options are :");
		System.out.println("1. Populate Table");
		System.out.println("2. Insert Row");
		System.out.println("3. Delete Row");
		System.out.println("4. Search table");
		System.out.println("Select option");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int opt = Integer.parseInt(input.readLine());
		System.out.println(opt);
		try {
		switch(opt) {
		
		case 1 : 
			System.out.println("inside case 1");
			PopTable p = new PopTable();
					break;
		
		case 2 :String sCurrentLine;
		 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 		//while ((
		 						sCurrentLine = br.readLine();//) != null)
		 			{
				String[] parts = sCurrentLine.split(" ", 10); 
				InsertRow r = new InsertRow(parts[0],parts[1],parts[2],parts[3],parts[4],parts[5],parts[6],parts[7],parts[8],parts[9]) ;
				}	
				break;
		
		case 3 :BufferedReader sno_ip = new BufferedReader(new InputStreamReader(System.in));
				int sno = Integer.parseInt(sno_ip.readLine()); 
				DeleteRow d = new DeleteRow(sno);
				break;
		
		case 4 :BufferedReader st_ip = new BufferedReader(new InputStreamReader(System.in));
				int search = Integer.parseInt(st_ip.readLine());
				BufferedReader st_fp = new BufferedReader(new InputStreamReader(System.in));
				//String st_fd= System.console().readLine();
				String st = st_fp.readLine();
				SearchTable s = new SearchTable(search,st);
				break;
		default : break ;
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
	}		
	}
		
	}


