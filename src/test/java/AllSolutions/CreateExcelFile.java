package AllSolutions;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CreateExcelFile {
	
	@Test
	public void create() throws IOException {
		
		Faker f=new Faker();
	
	
	  try (Workbook work = new XSSFWorkbook()) {
		Sheet sheet = work.createSheet("SendLogs");

		  Row header = sheet.createRow(0);
		  
		  header.createCell(0).setCellValue("Name");
		  header.createCell(1).setCellValue("Drink");
		  
		  int rownum=1;
		  int i;
		  
		  for(i=1;i<=10;i++)
		  {
			  	String a=f.name().firstName();
			  	String b=f.beer().name();
			  	
			  	Row row=sheet.createRow(rownum++);
			  	
			  	row.createCell(0).setCellValue(a);
			  	row.createCell(1).setCellValue(b);
		  }
		  
		  FileOutputStream out=new FileOutputStream("NewFile.xlsx");
		  work.write(out);
		  out.close();
		  work.close();
	  }
}
}