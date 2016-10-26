package net.oschina.excel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetCookie {


	// TODO Auto-generated method stub
	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.oschina.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement login = driver.findElement(By.xpath("//*[@id='OSC_Userbar']/a[1]"));
		login.click();
		//// *[@id="pl_login_form"]/div[2]/div[1]/div/a[2]
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// 调用getparameters()方法获取相应参数
		List<String> infoList = getParameters();
		int cellNum = infoList.size();
		int num[] = new int[cellNum];
		for (int i = 0; i < num.length; i++) {
			num[i] = i;
			System.out.println(num[i]);
			System.out.println("+++++++++---------+++++++++");
			System.out.println(infoList.get(i));
		}

		WebElement user = driver.findElement(By.id("f_email"));// ("//*[@id='pl_login_form']/div[2]/div[3]/div[1]/div/input"));
		user.clear();
		user.sendKeys(infoList.get(0));
		WebElement password = driver.findElement(By.id("f_pwd"));
		password.clear();
		password.sendKeys(infoList.get(1));

		WebElement submit = driver.findElement(By.xpath("//*[@id='login_osc']/table/tbody/tr[7]/td/input"));
		submit.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File file = new File("D:\\broswer.data");
		try {
			// delete file if exists
			file.delete();
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			for (Cookie ck : driver.manage().getCookies()) {
				bw.write(ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";"
						+ ck.getExpiry() + ";" + ck.isSecure());
				bw.newLine();
			}
			bw.flush();
			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("cookie write to file");
		}
		// writeExcel();
		loginStatus(driver, infoList);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.quit();
	}

	// 创建获取参数的方法
	public static List<String> getParameters() throws IOException {

		FileInputStream inputStream = new FileInputStream(
				"D:\\WorkSpace\\SeleniumCookie\\src\\net\\oschina\\excel\\info.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		int sheetNum = workbook.getNumberOfSheets();
		System.out.println(sheetNum);
		List<String> infoList = new ArrayList<String>();
		for (int sheetIndex = 0; sheetIndex < sheetNum; sheetIndex++) {
			XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
			for (int rowIndex = 1; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
				XSSFRow row = sheet.getRow(rowIndex);
				if (row == null) {
					continue;
				}
				for (int cellnum = 0; cellnum < row.getLastCellNum(); cellnum++) {
					XSSFCell cell = row.getCell(cellnum);
					if (cell != null) {
						System.out.println("第" + rowIndex + "行      第" + cellnum + "列    内容为："
								+ cell.getRichStringCellValue().getString());
						infoList.add(cell.getRichStringCellValue().getString());
						System.out.println(infoList.get(cellnum) + " " + infoList.size());

					}
				}
			}
		}

		/*
		 * Workbook workbook = null; workbook = new XSSFWorkbook(instream); int
		 * numberOfSheets = workbook.getNumberOfSheets();
		 */
		workbook.close();
		inputStream.close();
		return infoList;

		// return 1;

	}


	public static void writeExcel(List<String> infoList, String result) throws IOException {
		FileOutputStream inputStream = new FileOutputStream(
				"D:\\WorkSpace\\SeleniumCookie\\src\\net\\oschina\\excel\\info_report.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.getSheet("result");
		// XSSFSheet sheet = workbook.getSheetAt(1);
		// int cellrows = sheet.getLastRowNum();

		int cellrows = sheet.getPhysicalNumberOfRows();

		System.out.println("write");
		System.out.println(cellrows);

		for (int i = 0; i < cellrows; i++) {
			XSSFRow row = sheet.getRow(i);
			System.out.println("********");
			int cellnums = row.getLastCellNum();
			//System.out.println(row.getLastCellNum());
//			if (row != null){
//				continue;
//			}
			for (int cellnum = 0; cellnum < cellnums; cellnum++) {
					System.out.println(cellnum);			
				switch (cellnum) {
				case 0:
					XSSFCell cell = row.getCell(cellnum);
					cell.setCellValue(infoList.get(cellnum));
					System.out.println("dddddd");
					System.out.println(infoList.get(cellnum));
					break;
				case 1:
					XSSFCell cell1 = row.getCell(cellnum);
					cell1.setCellValue(infoList.get(cellnum));
					break;
				case 2:
					XSSFCell cell2 = row.getCell(cellnum);
					cell2.setCellValue(result);
					break;
				case 3:
					XSSFCell cell3 = row.getCell(cellnum);
					Date date = new Date();
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String dateString = simpleDateFormat.format(date);
					cell3.setCellValue(dateString);
					break;
				default:
					break;
				}
			}
			}
		workbook.write(inputStream);
		inputStream.flush();
		inputStream.close();
		}


	public static void loginStatus(WebDriver driverStatus, List<String> infoList) throws IOException {
		String username;
		username = driverStatus.findElement(By.xpath("//*[@id='OSC_Userbar']/em")).getText();
		System.out.println(username);
		if (username.equals("BuleSkyyj")) {
			System.out.println("你好，"+username+"登陆成功！");
			String result = "登陆成功！";
			writeExcel(infoList, result);
		} else {
			System.out.println("你好，" + username + "登陆失败！");
			String result = "登陆成功！";
			writeExcel(infoList, result);
		}

	}
}
