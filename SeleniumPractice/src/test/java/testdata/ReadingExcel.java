package testdata;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//File-->Workbook-Sheets->rows-->cells

public class ReadingExcel {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file=new FileInputStream("C:\\Users\\Jairo\\eclipse-workspace\\SeleniumPractice\\testdata\\DogsRaze.xlsx");
		
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet sheet= workbook.getSheet("Hoja 1");
		int totalRows=sheet.getLastRowNum();
		int totalCells=sheet.getRow(1).getLastCellNum();
		
		System.out.println("Number of rows: "+totalRows);
		System.out.println("Number of cells: "+totalCells);
		
		for (int i=0; i<totalRows; i++) {
			
			XSSFRow currentRow=sheet.getRow(i);
			
			
			for(int j=0; j<totalCells; j++) {
				
				XSSFCell cell=currentRow.getCell(j);
				
				String value=cell.toString();
				System.out.print(value+"   ");
				
			}
			System.out.println();
		}
		workbook.close();
		file.close();
	}

}
