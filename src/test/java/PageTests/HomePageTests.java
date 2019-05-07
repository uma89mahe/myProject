package PageTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import homePageObjects.BasePage;
import homePageObjects.HomePageObjects;

public class HomePageTests {
	HomePageObjects homePage;
	BasePage bp;

	public HomePageTests() {
		homePage = new HomePageObjects();
		bp = new BasePage();
	}

	@Test(enabled=false)
	public void tab() {
		Assert.assertTrue(homePage.elementFound(homePage.women()));
		Assert.assertTrue(homePage.elementFound(homePage.dresses()));
		Assert.assertTrue(homePage.elementFound(homePage.tshirts()));
	}
	
	@Test(enabled=false)
	public void PageHeader() {	
		homePage.clickWomenTab();
		Assert.assertTrue(homePage.getPageHeader().equals("WOMEN"));	
		homePage.clickDressTab();
		Assert.assertTrue(homePage.getPageHeader().equals("DRESSES"));	
		homePage.clickTshirtTab();
		Assert.assertTrue(homePage.getTshirtHeader().equals("CATALOG"));
	}
	
	@Test(enabled=false)
	public void newsletterTest() {
		homePage.clickNewsletter();
		homePage.newsletterSend();
		homePage.clickNewsbutton();
		
		}
	
	@Test(enabled=false)
	public void verifyAddtoCartButtonDisplay() {
		homePage.homeUrl();
		homePage.mouseHover();		
	}
	
	@Test(enabled=false)
	public void verifyWebTable() {
		homePage.webtableReading();
	}
	
	@Test
	public void verifyToolsQA() {
		homePage.toolsQAWebtable();
	}

}
