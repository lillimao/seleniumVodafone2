package it.lutech.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	public static final String VODAFONEFILE = "/home/lisa/vodafone_selenium/vodafone-selenium-form/src/main/resources/excelVodafone.xlsx";

	public Workbook workbook = null;

	public Workbook creaWorkbook(){
		if(workbook == null){
			// Creating a Workbook from an Excel file (.xls or .xlsx)
			try {
				workbook = WorkbookFactory.create(new File(VODAFONEFILE));
			} catch (InvalidFormatException | IOException e) {
				e.printStackTrace();
			}
			return workbook;
		}
		else return workbook;
	}
	
	public Workbook creaWorkbook(File file){
		if(workbook == null){
			// Creating a Workbook from an Excel file (.xls or .xlsx)
			try {
				workbook = WorkbookFactory.create(file);
			} catch (InvalidFormatException | IOException e) {
				e.printStackTrace();
			}
			return workbook;
		}
		else return workbook;
	}
	
	public void scriviValore(String valore, int row, int column){
		Sheet sheet = workbook.getSheetAt(0);
		Row thisRow = sheet.getRow(row);
		Cell cell = thisRow.getCell(column);
		if(cell == null){
			cell = thisRow.createCell(column);
		}
		cell.setCellType(Cell.CELL_TYPE_STRING);
		cell.setCellValue(valore);
		
		try {
			FileOutputStream fileOut = new FileOutputStream("excelVodafoneOutPut.xlsx");
			workbook.write(fileOut);
			fileOut.close();
			workbook = WorkbookFactory.create(new FileInputStream("excelVodafoneOutPut.xlsx"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
	}
	
	public int numeroRighe(){
		int numeroRigheCompilate = 0;
		int numeroTotRighe = creaWorkbook().getSheetAt(0).getLastRowNum(); //TODO modificare per usare con app
		DataFormatter dataFormatter = new DataFormatter();
		for(int i = 2; i <= numeroTotRighe; i++){
			Cell cell;
			try {
				cell = workbook.getSheetAt(0).getRow(i).getCell(0);
			} catch (Exception e) {
				break;
			}
			String cellString = dataFormatter.formatCellValue(cell);
			if(!cellString.equals("") | cellString != null){
				numeroRigheCompilate++;
			}
			else {
				break;
			}
		}
		return numeroRigheCompilate;
//		return workbook.getSheetAt(0).getLastRowNum();
	}
	
	public String stampaCelle (int indiceRow, int indiceColumn) {

		// Retrieving the number of sheets in the Workbook
//		System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

		// Getting the Sheet at index zero
		Sheet sheet = workbook.getSheetAt(0);

		// Create a DataFormatter to format and get each cell's value as String
		DataFormatter dataFormatter = new DataFormatter();
		
//		System.out.println(sheet.getRow(1).getCell(0));

//		System.out.println("\n\nIterating over Rows and Columns\n");
//		sheet.forEach(row -> {
//			row.forEach(cell -> {
//				String cellValue = dataFormatter.formatCellValue(cell);
//				System.out.print(cellValue + "\t");
//			});
//			System.out.println();
//		});
		
		Cell cell = sheet.getRow(indiceRow).getCell(indiceColumn);
		String cellString = dataFormatter.formatCellValue(cell);
		return cellString;

        // Closing the workbook???
        
    }


	}

