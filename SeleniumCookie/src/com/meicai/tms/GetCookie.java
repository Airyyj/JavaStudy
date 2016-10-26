package com.meicai.tms;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class GetCookie {


		// TODO Auto-generated method stub
		public static void main(String[] args) {

	        WebDriver driver = new ChromeDriver();
	        driver.get("http://sso.test.yunshanmeicai.com/");
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement user = driver
	                .findElement(By.name("email"));//("//*[@id='pl_login_form']/div[2]/div[3]/div[1]/div/input"));
	        user.clear();
	        user.sendKeys("yangyaojun");
	        WebElement password = driver.findElement(By
	                .name("password"));//xpath("//*[@id='pl_login_form']/div[2]/div[3]/div[2]/div/input"));
	        password.clear();
	        password.sendKeys("Meicai@2016");
	        
	       WebElement yan =driver.findElement(By.name("code"));
	       yan.clear();
	       yan.sendKeys("9527");
/*	       WebElement submit = driver.findElement(By
	                .xpath("/html/body/div/div/div[2]/form/div[4]/div/div/button"));
	        submit.click();*/
	       	Actions action = new Actions(driver); 
			action.sendKeys(Keys.ENTER).perform();
			
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        WebElement dianyidian =driver.findElement(By.xpath("/html/body/div/div/div[2]/a[3]"));
	        System.out.println(dianyidian.getText());
	        dianyidian.click();
	        try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        File file = new File("D:\\TmsCookie.data");
	        try {
	            // delete file if exists
	            file.delete();
	            file.createNewFile();
	            FileWriter fw = new FileWriter(file);
	            BufferedWriter bw = new BufferedWriter(fw);
	            for (Cookie ck : driver.manage().getCookies()) {
	                bw.write(ck.getName() + ";" + ck.getValue() + ";"
	                        + ck.getDomain() + ";" + ck.getPath() + ";"
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
	    }
	}
		


