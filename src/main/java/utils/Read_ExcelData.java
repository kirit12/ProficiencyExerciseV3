package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_ExcelData 
{
	//Configuration_Details dbConfig= new Configuration_Details();
	private static String fileSeperator = System.getProperty("file.separator");
	static int totalRowsExcel;
	static String  url = System.getProperty("user.dir")+fileSeperator+"src"+fileSeperator+"test"+fileSeperator+"resources"+fileSeperator+"TestData.xlsx";
	static Logger log = Logger.getLogger(Read_ExcelData.class.getName());
	  

	
	public List<String> readFromExcel() throws IOException{
		List<String> login_list = new ArrayList<String>();
        XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(url));
        XSSFSheet myExcelSheet = myExcelBook.getSheet("TestData_Login");
        //XSSFRow row = myExcelSheet.getRow(0);
        
        int rowCount = myExcelSheet.getLastRowNum()-myExcelSheet.getFirstRowNum();

        //Create a loop over all the rows of excel file to read it

        for (int i = 1; i < rowCount+1; i++) {

            Row row = myExcelSheet.getRow(i);

            //Create a loop to print cell values in a row

            for (int j = 0; j < row.getLastCellNum(); j++) {

                //Print Excel data in console
            	login_list.add(row.getCell(j).getStringCellValue());
                //System.out.print(row.getCell(j).getStringCellValue()+"|| ");

            }
        } 

        
        myExcelBook.close();
        return login_list;
    }

	
}

