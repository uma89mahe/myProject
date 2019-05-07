package pageObjects;


	import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;



	public class BasePage {

		public static WebDriver driver;
		public String browser = "chrome";

		public BasePage() {
			if (driver == null) {
				if (browser.equals("chrome")) {
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\u.dayalamurthy\\Desktop\\sel\\chromedriver_win32 (2)\\chromedriver.exe");
							
					driver = new ChromeDriver();
				} else if (browser.equals("firefox")) {
					System.setProperty("webdriver.gecko.driver", "C:\\Users\\u.dayalamurthy\\Documents\\Uma\\Selenium\\geckodriver.exe");
					driver = new FirefoxDriver();
				}
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				//driver.get("http://automationpractice.com/index.php");
				driver.get("http://demo.automationtesting.in/WebTable.html");
			}
		}
		
		public void readExcel() throws IOException {
			File location = new File ( "C://Users//u.dayalamurthy//Documents//Uma//Selenium//TestData.xlsx");
			FileInputStream reader = new FileInputStream(location);
			Workbook wb = new XSSFWorkbook(reader);
			Sheet sheet = wb.getSheet("Sheet1");
			
			for( int i=0;i<sheet.getPhysicalNumberOfRows();i++) {
				Row eachrow = sheet.getRow(i);
				
				for(int j=0;j<eachrow.getPhysicalNumberOfCells();j++) {
					Cell currentcell = eachrow.getCell(j);
					
					String text = currentcell.getStringCellValue();
					System.out.println(text);
				}
			}
			
			
		}

		public boolean elementFound(WebElement element) {
			boolean res = false;
			try {
				res = element.isDisplayed();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return res;
		}

		public void setText(WebElement element, String name) {
			if (name != null) {
				element.click();
				element.clear();
				element.sendKeys(name);
			}
		}

		public String getTxtAttribute(WebElement element) {
			return element.getAttribute("value");
		}
		
		public String getTxt(WebElement element) {
			return element.getText();
		}

		public String selectFromDropDown(WebElement element, String option) {
			Select obj = new Select(element);
			obj.selectByValue(option);
			return obj.getFirstSelectedOption().getText();
		}

		public boolean isElementVisible(WebElement element) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 90);
				wait.until(ExpectedConditions.visibilityOf(element));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		
		public void pageScroll(WebElement element) {
			JavascriptExecutor js= (JavascriptExecutor)driver;
			 js.executeScript("arguments[0].scrollIntoView(true)", element);
			}
		
		

		public String getTitlte() {
			return driver.getTitle();
		}	
		
		public void quitDriver() {
			driver.quit();
		}
	}



