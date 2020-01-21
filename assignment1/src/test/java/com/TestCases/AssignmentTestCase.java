package com.TestCases;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.FlipkartHomePage;
import com.pages.FlipkartProductDetailPage;
import com.pages.FlipkartSearchPage;
import com.pages.HomePage;
import com.pages.ProductDetailPage;
import com.pages.SearchPage;

public class AssignmentTestCase extends TestBase {
	HomePage homePage;
	SearchPage searchPage;
	ProductDetailPage productDetailPage;
	
	FlipkartHomePage fhp;
	FlipkartSearchPage fsp;
	FlipkartProductDetailPage fpdp;
	
	public int amazonPrice;
	public int flipkartPrice;
	
	public AssignmentTestCase() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		init();
	}
	
	@Test
	public void LoginTest() throws InterruptedException {
		
		homePage = new HomePage();
		searchPage = new SearchPage();
		productDetailPage = new ProductDetailPage();
		
		
		
		homePage.setSearchBarText("iPhone XR 64GB Yellow");
		homePage.clickOnSerach();
		searchPage.searchAndSelectProduct();
		
		
		String MainWindow=driver.getWindowHandle();
		Set<String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();		
        
        while(i1.hasNext()) {		
            String ChildWindow=i1.next();	
            if(!MainWindow.equalsIgnoreCase(ChildWindow)){		// Switching to Child window
            	driver.switchTo().window(ChildWindow);
            	amazonPrice = productDetailPage.getPrice();
            	amazonPrice /= 100;
                driver.close();		
            }		
        }		
        driver.switchTo().window(MainWindow);
        
        
        driver.get(prop.getProperty("url2"));
        fhp = new FlipkartHomePage();
        fsp = new FlipkartSearchPage();
        fpdp = new FlipkartProductDetailPage();
        
        
        fhp.closePopup();
        fhp.setSearchBarText("iPhone XR 64GB Yellow");
        fhp.clickOnSerach();
        fsp.searchAndSelectProduct();
        
        String FMainWindow=driver.getWindowHandle();
		Set<String> s2=driver.getWindowHandles();		
        Iterator<String> i2=s2.iterator();		
        
        while(i2.hasNext()) {		
            String ChildWindow=i2.next();	
            if(!FMainWindow.equalsIgnoreCase(ChildWindow)){		// Switching to Child window
            	driver.switchTo().window(ChildWindow);
            	flipkartPrice = fpdp.getPrice();
                driver.close();		
            }		
        }		
        
		System.out.println( "Amazon Price: " + amazonPrice + "------- Flipkart Price: " + flipkartPrice);
		Assert.assertTrue(true);
	}
	
	@AfterMethod
	public void cleanUp() {
		driver.quit();
	}
}
