package loginTestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenUsingPoI{

		
		public void readexcel() throws IOException {
		FileInputStream excel=new FileInputStream("C:\\Users\\Divakar\\Documents\\Testdata2.xlsx");
		Workbook workbook=new XSSFWorkbook(excel);
		Sheet sheet= (Sheet) workbook.getSheetAt(0);
		Iterator<Row> rowiterator=sheet.iterator();
		while(rowiterator.hasNext()) {
			Row rowvalue=rowiterator.next();
			
			Iterator<Cell> columniterator=rowvalue.iterator();
			while(columniterator.hasNext()) {
				Cell cellvalue=columniterator.next();
				System.out.println(cellvalue);
			}
		}
		
		

		}
 

		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub 
			DataDrivenUsingPoI usingPOI= new DataDrivenUsingPoI();
			usingPOI.readexcel();

}
}