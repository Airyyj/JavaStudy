package getCookie;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class CookieInfo {


		// TODO Auto-generated method stub
		public static void main(String[] args) {

	        WebDriver driver = new ChromeDriver();
	        driver.get("http://weibo.com/");
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        WebElement login = driver.findElement(By.xpath("//*[@id='pl_login_form']/div[2]/div[1]/div/a[2]"));
	        ////*[@id="pl_login_form"]/div[2]/div[1]/div/a[2]
	        WebElement user = driver
	                .findElement(By.name("username"));//("//*[@id='pl_login_form']/div[2]/div[3]/div[1]/div/input"));
	        user.clear();
	        user.sendKeys("meicaitest@sina.cn");
	        WebElement password = driver.findElement(By
	                .xpath("//*[@id='pl_login_form']/div[2]/div[3]/div[2]/div/input"));
	        password.clear();
	        password.sendKeys("Meicai@2016");

	        WebElement submit = driver.findElement(By
	                .xpath("//*[@id='pl_login_form']/div[2]/div[3]/div[6]/a"));
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
		


