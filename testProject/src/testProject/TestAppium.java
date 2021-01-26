package testProject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;

public class TestAppium {

 AndroidDriver dr;
  @Test
  public void testApp() throws MalformedURLException {
	  DesiredCapabilities capability=new DesiredCapabilities();
	  capability.setCapability("platformVersion","10");
	  capability.setCapability("platformName","Android");
	  //File file=new File("C:\\Users\\LENOVO\\eclipse-workspace\\testProject\\apk\\WhatsApp Messenger_v2.20.206.24_apkpure.com.apk");
	  File file=new File(System.getProperty("user.dir")+"apk\\WhatsApp Messenger_v2.20.206.24_apkpure.com.apk");
	  capability.setCapability("app",file.getAbsolutePath());
	  dr=new AndroidDriver(new URL("http://192.168.99.223:4723/wd/hub"), capability);
	  //for Native app-like settings in mobile
	  //capability.setCapability("appPackage","com.android.settings");
	  //capability.setCapability("appActivity","com.android.settings.Settings");
	  dr.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	  List<WebElement> buttons=dr.findElements(By.className("android.widget.button"));
  for(int i=1;i<=buttons.size();i++) {
	  System.out.println(buttons.get(i).getText());
	  if(buttons.get(i).getText().equals("Test")) {
		  buttons.get(i).click();
	  }
  }
  
  }
  
  @AfterTest
  public void afterTest() throws Exception {
	  dr.quit();
  }
  
  
  

}
