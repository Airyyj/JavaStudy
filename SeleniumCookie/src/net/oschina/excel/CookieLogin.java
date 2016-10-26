package net.oschina.excel;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
 

import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.os.WindowsUtils;

public class CookieLogin {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //Cookies.addCookies();
    	 WebDriver driver = new ChromeDriver();
	        driver.get("http://www.oschina.net/");
	        //browser最大化
	        driver.manage().window().maximize();
	        //智能等待10s
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try 
        {
            File file=new File("D:\\broswer.data");
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            String line;
            while((line=br.readLine())!= null)
            {
                StringTokenizer str=new StringTokenizer(line,";");
                while(str.hasMoreTokens())
                {
                    String name=str.nextToken();
                    String value=str.nextToken();
                    String domain=str.nextToken();
                    String path=str.nextToken();
                    Date expiry=null;
                    String dt;
                    if(!(dt=str.nextToken()).equals(null))
                    {
                        //expiry=new Date(dt);
                        System.out.println(dt);
                    }
                    boolean isSecure=new Boolean(str.nextToken()).booleanValue();
                    Cookie ck=new Cookie(name,value,domain,path,expiry,isSecure);
                    driver.manage().addCookie(ck);
                }
            }         
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        driver.get("http://www.oschina.net/");
        	loginStatus(driver);
        
       // System.out.println("登陆成功！");
    }
    
    public static void loginStatus(WebDriver driverStatus) {
    	String username;
    	username = driverStatus.findElement(By.xpath("//*[@id='OSC_Userbar']/em")).getText();
    	System.out.println(username);
    	if (username.equals("BuleSkyyj")) {
    		System.out.println("你好，"+username+"登陆成功！");
		}
    	else{
    		System.out.println("你好，"+username+"登陆失败！");
    	}
    	
    	
    	
		
	}
    
    
    
    
    
    
    
    
}








