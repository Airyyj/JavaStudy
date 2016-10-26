package net.oschina.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readxls {

	public static void read(InputStream inputStream) throws IOException {

		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		HSSFSheet sheet = workbook.getSheetAt(0);
		HSSFRow row0 = sheet.getRow(0);
		HSSFCell cell = row0.getCell(0);
		System.out.println(cell.getRichStringCellValue().getString());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File("E:\\workbook.xls"));
			System.out.println(inputStream);
			read(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
