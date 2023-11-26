package testdata;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingExcel {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file=new FileOutputStream("C:\\Users\\Jairo\\eclipse-workspace\\SeleniumPractice\\testdata\\DogsRaze.xlsx");
		
		XSSFWorkbook workbook= new XSSFWorkbook();
		
		XSSFSheet sheet =workbook.createSheet();
		
		//Creating rows, cells and update data without loop
		/*
		XSSFRow row1=sheet.createRow(0);
		
		row1.createCell(1).setCellValue("Welcome");
		row1.createCell(2).setCellValue("Selenium");
		row1.createCell(3).setCellValue("Driver");
	
		XSSFRow row2=sheet.createRow(1);

		row2.createCell(1).setCellValue("Bienvenido");
		row2.createCell(2).setCellValue("Cypress");
		row2.createCell(3).setCellValue("IO");
		*/
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("Writing is done !!");
		
		//Creating rows, cells and update data with loop
		
		for(int r=0; r<=5; r++) {
			XSSFRow currentRow=sheet.createRow(r);
			
			for(int c=0; c<3; c++) {
				currentRow.createCell(c).setCellValue("Welcome");
				
			}
		}
		

	}

}
