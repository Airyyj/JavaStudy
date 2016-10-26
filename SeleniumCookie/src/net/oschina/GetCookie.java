package net.oschina;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GetCookie {


		// TODO Auto-generated method stub
		public static void main(String[] args) {

	        WebDriver driver = new ChromeDriver();
	        driver.get("http://www.oschina.net/");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        WebElement login = driver.findElement(By.xpath("//*[@id='OSC_Userbar']/a[1]"));
	        login.click();
	        ////*[@id="pl_login_form"]/div[2]/div[1]/div/a[2]
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement user = driver
	                .findElement(By.id("f_email"));//("//*[@id='pl_login_form']/div[2]/div[3]/div[1]/div/input"));
	        user.clear();
	        user.sendKeys("272981562@qq.com");
	        WebElement password = driver.findElement(By
	                .id("f_pwd"));
	        password.clear();
	        password.sendKeys("CHINA927yyjgon");

	        WebElement submit = driver.findElement(By
	                .xpath("//*[@id='login_osc']/table/tbody/tr[7]/td/input"));
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
		



