package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	//instant variable
	   public static WebDriver driver;
	//browser launch--Chrome
	   public static WebDriver chromeBrowser() {
	       WebDriverManager.chromedriver().setup();
	       driver=new ChromeDriver();
	       return driver;
	}
	//browser launch--friefox
		public static WebDriver firefoxBrowser() {
		       WebDriverManager.firefoxdriver().setup();
		       return driver=new FirefoxDriver();
	}
	//browser launch--edge
		public static WebDriver edgeBrowser() {
		       WebDriverManager.edgedriver().setup();
		       driver=new EdgeDriver();
		       return driver;
	}
//alternative methods for browser
		//if condition
		public static WebDriver browserLaunch(String bname) {
			if(bname.equalsIgnoreCase("chrome")) {
				 WebDriverManager.chromedriver().setup();
			       driver=new ChromeDriver();
			}
			else if(bname.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
			else if(bname.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}
			return driver;
		}
		//switch case
		public static WebDriver browserLaunch2(String bname) {
			
			switch(bname) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
			       driver=new ChromeDriver();
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			default:
				System.out.println("Invalid Browser name");
				
			}
			return driver;
		}
	//url launch
		public static void urlLaunch(String url) {
			driver.get(url);
			driver.manage().window().maximize();
		}
	//wait
		public static void implicitlyWait(int a) {
			driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
		}
	//sendkeys
		public static void sendkeys(WebElement e,String a) {
			e.sendKeys(a);
		}
	//click
		public static void click(WebElement e) {
			e.click();
		}
	//refresh
		public static void refresh() {
			driver.navigate().refresh();

		}
	//clear
		public static void clear(WebElement e) {
			e.clear();
		}
	//get current url
		public static String getCurrentUrl() {
			String currentUrl = driver.getCurrentUrl();
			return currentUrl;
		}
	//get current title
		public static String getCurrentTitle() {
			String title = driver.getTitle();
			return title;
		}
	//quit
		public static void quit() {
			driver.quit();
		}
	//close
		public static void close() {
			driver.close();
		}
	//get text
		public static String getText(WebElement e) {
			String text = e.getText();
			return text;
		}
	//getAttribute value
		public static String getAttributeValue(WebElement e) {
			String attribute = e.getAttribute("value");
			return attribute;
		}
	//getAttribute innertext
		public static String getAttributeInnerText(WebElement e) {
			String attribute = e.getAttribute("InnerText");
			return attribute;
		}
	//Actions
	//movetoelement
		public static void moveToElement(WebElement target) {
			Actions a=new Actions(driver);
			a.moveToElement(target).perform();
		}
	//draganddrop
		public static void dragAndDrop(WebElement source,WebElement target) {
			Actions a=new Actions(driver);
			a.dragAndDrop(source, target).perform();
		}
	//ContextClick
		public static void contextClick(WebElement target) {
			Actions a=new Actions(driver);
			a.contextClick(target).perform();
		}
	//doubleClick
		public static void doubleClick(WebElement target) {
			Actions a=new Actions(driver);
			a.doubleClick(target).perform();
		}
	//click in action class
		public static void click() {
			Actions a=new Actions(driver);
			a.click().perform();
		}
	//click and Hold
		public static void clickAndHold(WebElement target) {
			Actions a=new Actions(driver);
			a.clickAndHold(target).perform();
		}		
	//release
		public static void release(WebElement target) {
			Actions a=new Actions(driver);
			a.release(target).perform();
		}
//	//key down ----press the key by using action class
//		public static void keydown(WebElement key) {
//			Actions a=new Actions(driver);
//			a.keyDown(key).per

//		}
	//robot class
	//keypress
		public static void keypress(int a) throws AWTException {
			Robot r=new Robot();
			r.keyPress(a);
		}
	//keyrelease
		public static void keyRelease(int a) throws AWTException {
			Robot r=new Robot();
			r.keyRelease(a);
		}
	//drop down
	//selectbyindex
		public static void selectByIndex(WebElement element,int index) {
			Select s=new Select(element);
		    s.selectByIndex(index);
		}
	//selectbyvalue
		public static void selectByValue(WebElement element,String arg0) {
			Select s=new Select(element);
			s.selectByValue(arg0);
		}
	//selectbyvisibletext
		public static void selectByVisibleText(WebElement element,String a) {
			Select s=new Select(element);
            s.selectByVisibleText(a);
		}
	//get options
		public static WebElement getOptions(WebElement element) {
			Select s=new Select(element);
			List<WebElement> e = s.getOptions();
			return element;
		}
	//get all selected options
		public static WebElement getAllSelectedOptions(WebElement element) {
			Select s=new Select(element);
            List<WebElement> e = s.getAllSelectedOptions();
			return element;
		}
	//get first selected options
		public static WebElement getFirstSelectedOptions(WebElement element) {
			Select s=new Select(element);
			WebElement e = s.getFirstSelectedOption();
			return e;
		}
	//is multiple
		public static boolean isMultiple(WebElement element) {
			Select s=new Select(element);
			boolean multiple = s.isMultiple();
			return multiple;
		}
	//de select by index
		public static void deSelectByIndex(WebElement element,int index) {
			Select s=new Select(element);
			s.deselectByIndex(index);
		}
	// deselect by value
		public static void deSelectByValue(WebElement element,String arg0) {
			Select s=new Select(element);
			s.deselectByValue(arg0);
		}
	//deselect by visibletext
		public static void deSelectByVisibleText(WebElement element,String a) {
			Select s=new Select(element);
			s.deselectByVisibleText(a);
		}
	//deselect all
		public static void deSelectAll(WebElement element) {
			Select s=new Select(element);
			s.deselectAll();
		}
	//Alert
	//accept
		public static void accept() {
			Alert a = driver.switchTo().alert();
			a.accept();
		}
	//dismiss
		public static void dismiss() {
			Alert a = driver.switchTo().alert();
			a.dismiss();
		}
	//sendkeys in alert 
		public static void sendkeys(String arg0) {
			Alert a = driver.switchTo().alert();
			a.sendKeys(arg0);
		}
	//get text in alert
		public static String gettext() {
			Alert a = driver.switchTo().alert();
			String text = a.getText();
			return text;
		}
	//Excel Read--maven--data driven framework
			
		public static String readExcel(String filename,String sheet,int row,int cell) throws IOException {
			File f=new File("C:\\Users\\91637\\eclipse-workspace\\Maven_sep_29\\src\\test\\resources\\Excel\\"+filename+".xlsx");
			FileInputStream st=new FileInputStream(f);
			Workbook w=new XSSFWorkbook(st);
			Sheet s = w.getSheet(sheet);
			Row r = s.getRow(row);
			Cell c = r.getCell(cell);
			//to find type
			int cellType = c.getCellType();
			String value=null;
			//type--1--String
			//type--0--numbers , date
			
			if(cellType==1) {
				 value = c.getStringCellValue();
			}
			else {
				if(DateUtil.isCellDateFormatted(c)) {
					Date dateCellValue = c.getDateCellValue();
					//
					SimpleDateFormat sd=new SimpleDateFormat("dd-mmm-yyyy");
					 value = sd.format(dateCellValue);
				}
				else {
					double numericCellValue = c.getNumericCellValue();
					//covert double into long by type casting
					long num=(long)numericCellValue;
				     value = String.valueOf(num);
				}
			}
			return value;
		}
	
}	
		
	
	

